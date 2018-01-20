package it.car.yelp.intrw.backtracking;

public class WordSearch {
	
	/**
	 * Given a 2D board and a word, find if the word exists in the grid. 
	 * 
	 * The word can be constructed from letters of sequentially adjacent cell, 
	 * where "adjacent" cells are those horizontally or vertically neighboring. 
	 * The same letter cell may not be used more than once.
	 */
	
	 public static boolean exist(char[][] board, String word) {
			int dim1 = board.length;
			int dim2 = board[0].length;
			
			// support structure to track if a cell is already visited
			boolean[][] boardVisited = new boolean[dim1][dim2];
			
			boolean res = false;
			
			for(int i = 0; i < dim1; i++){
				for(int j = 0; j < dim2; j++){
					if(recursive(board, word, 0, i, j, boardVisited)) return true;
				}
			}

			return res;
		}

		public static boolean recursive(char[][] board, String word, int start, int i, int j, boolean[][] boardVisited){

			if((start == word.length())){
				return true;
			}
			
			if(i>=board.length || j >= board[0].length || i < 0 || j < 0)
	            return false;
			
			if(boardVisited[i][j]) return false;
				
			if(board[i][j] != word.charAt(start))
				return false;
			
			// flag curren cell as visited before recursion
			boardVisited[i][j] = true;

			// 
			boolean bool1 = recursive(board, word, start +1, i + 1, j, boardVisited) || recursive(board, word, start +1, i, j - 1, boardVisited)||recursive(board, word, start +1, i - 1, j, boardVisited) ||recursive(board, word, start +1, i, j + 1, boardVisited);
			
			// flag curren cell as NOT visited after recursion
			boardVisited[i][j] = false;
			
			return bool1 ;

		}
		
		/**
		 * test class
		 */
		
		public static void main(String args[]){
			char[][] test = new char[][]{
					{'A','B','C','D','E'},
					{'F','G','H','I','L'},
					{'M','N','O','P','Q'},};
			
			System.out.println("exist:" + exist(test, "HOP"));
		}

}
