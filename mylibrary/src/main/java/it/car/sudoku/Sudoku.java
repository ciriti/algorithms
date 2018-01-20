package it.car.sudoku;

public class Sudoku {
	
	public static int[][] matrix= new int[][]{
		
	 //  0  1  2  3  4  5  6  7  8
		{9, 5, 0, 0, 3, 2, 1, 0, 6}, // 0
		{0, 8, 2, 0, 0, 0, 0, 0, 9}, // 1
		{0, 1, 0, 4, 9, 0, 2, 0, 0}, // 2
		{0, 9, 0, 0, 5, 1, 6, 0, 4}, // 3
		{0, 0, 0, 0, 0, 0, 0, 0, 0}, // 4
		{4, 0, 1, 9, 2, 0, 0, 3, 0}, // 5
		{0, 0, 9, 0, 8, 6, 0, 1, 0}, // 6
		{1, 0, 0, 0, 0, 0, 3, 6, 0}, // 7
		{6, 0, 7, 2, 1, 0, 0, 9, 8}, // 8
		};
	
	public static int[][] matrixSquare= new int[][]{
		{0, 1, 2},
		{3, 4, 5},
		{6, 7, 8},
	};
	
	
	public static void main(String args[]){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				int square = getSquare(i, j);
				
			}
		}
	}
	
	public static int getSquare(int row, int col){
		
		int rowSq = 0;
		int colSq = 0;
		
		if(row >= 0 && row <= 2){
			rowSq = 0;
		}else if(row >= 3 && row <= 5){
			rowSq = 1;
		}else{
			rowSq = 2;
		}
		
		if(col >= 0 && col <= 2){
			colSq = 0;
		}else if(col >= 3 && col <= 5){
			colSq = 1;
		}else{
			colSq = 2;
		}
		
		return matrixSquare[rowSq][colSq];
	}
	
	public static boolean existInCol(int num, int col){
		for(int i = 0; i < 9; i++){
			if(num == matrix[i][col])
				return true;
		}
		return false;
	}
	
	public static boolean existInRow(int num, int row){
		for(int i = 0; i < 9; i++){
			if(num == matrix[row][i])
				return true;
		}
		return false;
	}
	
	public static boolean existInSquare(int num, int square){
		
		SquareIndex sIndex = null;
		
		switch(square){
		
		case 0:
			sIndex = new SquareIndex(0, 2, 0, 2);
			break;
		case 1:
			sIndex = new SquareIndex(0, 2, 3, 5);
			break;
		case 2:
			sIndex = new SquareIndex(0, 2, 6, 8);
			break;
		case 3:
			sIndex = new SquareIndex(3, 5, 0, 2);
			break;
		case 4:
			sIndex = new SquareIndex(3, 5, 3, 5);
			break;
		case 5:
			sIndex = new SquareIndex(3, 5, 6, 8);
			break;
		case 6:
			sIndex = new SquareIndex(6, 8, 0, 2);
			break;
		case 7:
			sIndex = new SquareIndex(6, 8, 3, 5);
			break;
		case 8:
			sIndex = new SquareIndex(6, 8, 6, 8);
			break;
		
		}
		return find(sIndex, num);
	}

	private static boolean find(SquareIndex sIndex, int num) {
		for(int i = sIndex.rMin; i <= sIndex.rMax; i++){
			for(int j = sIndex.cMin; j <= sIndex.cMax; j++){
				if(matrix[i][j] == num){
					return true;
				}
			}
		}
		return false;
	}

}
