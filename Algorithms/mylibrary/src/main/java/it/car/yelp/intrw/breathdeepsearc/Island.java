package it.car.yelp.intrw.breathdeepsearc;

public class Island {

	/**
	 * https://leetcode.com/problems/number-of-islands/
	 */

	public static void main(String args[]){
		System.out.println(numIslands(new char[][]{{'0'}}));
	}

	public static int numIslands(char[][] grid) {

		int count = 0;

		for(int row = 0; row < grid.length; row++){
			for(int col = 0; col < grid[0].length; col++){
				if(grid[row][col] == '1' 
						&& right(grid, row, col) 
						&& left(grid, row, col) 
						&& up(grid, row, col) 
						&& down(grid, row, col)){
					count++;
				}
			}
		}

		return count;

	}

	public static boolean right(char[][] grid, int row, int col){

		if( col== grid[0].length-1 || grid[row][col+1] == '0')
			return true;

		return false;
	}

	public static boolean left(char[][] grid, int row, int col){
		if(col== 0 || grid[row][col-1] == '0')
			return true;
		return false;
	}

	public static boolean up(char[][] grid, int row, int col){
		if(row == 0 || grid[row-1][col] == '0')
			return true;
		return false;
	}

	public static boolean down(char[][] grid, int row, int col){

		if(row == grid.length-1 || grid[row+1][col] == '0')
			return true;

		return false;
	}

}
