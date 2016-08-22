package it.car.matrix;

/**
 * Created by carmeloiriti, 08/08/16.
 * LINK - https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class NumMatrix {

    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for(int i = row1; i <= row2; i++){
            for(int j = col1; j <= col2; j++){
                res += matrix[i][j];
            }
        }
        return res;
    }

    public static void main(String args[]){
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        int[][] matrix1 = new int[][]{
                {3, 0, 1},
                {5, 6, 3},
                {1, 2, 0}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); //-> 8
//        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); //-> 8
//        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); //-> 11
//        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); //-> 12
    }

}
