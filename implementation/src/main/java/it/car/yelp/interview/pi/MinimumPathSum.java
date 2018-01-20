package it.car.yelp.intrw.pi;


/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * 
 * LINK - https://leetcode.com/problems/minimum-path-sum/
 * @author ciriti
 *
 */
public class MinimumPathSum {
	
	public int minPathSum(int[][] grid) {
       
       // creo la matrice di supporto e la inizializzo
       int[][] tmp = new int[grid.length][grid[0].length];
       tmp[0][0] = grid[0][0];
       
       //calcolo tutti i valori per la prima colonna
       for(int i = 1; i< grid.length; i++){
    	   tmp[i][0] = tmp[i-1][0] + grid[i][0];
       }
       
       //calcolo tutti i valori pre la prima riga
       for(int i = 1; i<grid[0].length; i++){
    	   tmp[0][i] = tmp[0][i-1]+grid[0][i];
       }
       
       // calcolo tuti i valori interni alla matrice
       for(int i = 1; i< grid.length; i++){
    	   for(int j = 1; j<grid[0].length; j++){
    		   tmp[i][j] = Math.min(tmp[i][j-1], tmp[i-1][j]);
    	   }
       }
       
       return tmp[grid.length-1][grid[0].length-1];
	}

}
