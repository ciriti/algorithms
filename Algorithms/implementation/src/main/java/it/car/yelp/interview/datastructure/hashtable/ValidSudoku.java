package it.car.yelp.intrw.datastructure.hashtable;

import java.util.HashMap;

public class ValidSudoku {

	/**
	 * Valid Sudoku
	 * 
	 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules. 
	 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
	 * 
	 * LINK - https://leetcode.com/problems/valid-sudoku/
	 */

	public static boolean isValidSudoku(char[][] board) {

		//to track if a character already exists in all row
		HashMap<Character, Character> row = new HashMap<>();

		//to track if a character already exists in all col
		HashMap<Character, Character> col = new HashMap<>();

		//to track if a character already exists in the sub square 3X3
		HashMap<Character, Character> rect = new HashMap<>();

		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){


				if(board[i][j] != '.' /*se non � una cella vuota*/ && /* e se il numero � minore di 1 o maggiore di 9 nella RIGA*/ (Character.getNumericValue(board[i][j])<1 ||  Character.getNumericValue(board[i][j]) > 9 ) || 
						board[j][i] != '.' /*se non � una cella vuota*/ && /* e se il numero � minore di 1 o maggiore di 9 nell COLONNA*/ (Character.getNumericValue(board[j][i])<1 ||  Character.getNumericValue(board[j][i]) > 9 ) ||
								board[i][j] != '.' && row.containsKey(board[i][j]) || /* se lo stesso valore gi� esiste nella riga */
								board[j][i] != '.' && col.containsKey(board[j][i])){/* se lo stesso valore gi� esiste nella riga */
					return false;
				}

				if(board[i][j] != '.')
					row.put(board[i][j], board[i][j]);
				if(board[j][i] != '.')
					col.put(board[j][i], board[j][i]);

			}

			row.clear();
			col.clear();
		}

		/* controllo ogni sotto matrice 3x3*/
		for(int k = 0; k < 9; k+=3){
			for(int y = 0; y < 9; y+=3){

				for(int i = k; i < k + 3; i++){
					for(int j = y; j < y + 3; j++){

						if(board[i][j] != '.' && rect.containsKey(board[i][j])) {
							return false;
						}
						if(board[i][j] != '.')
							rect.put(board[i][j], board[i][j]);
					}
				}
				rect.clear();
			}
		}

		return true;
	}

}
