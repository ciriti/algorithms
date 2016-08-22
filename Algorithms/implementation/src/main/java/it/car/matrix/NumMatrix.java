package it.car.matrix;

/**
 * Created by carmeloiriti, 08/08/16.
 * LINK - https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class NumMatrix {

    int[][] sum;
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if(matrix.length>0 && matrix[0].length>0){
            this.sum = new int[matrix.length][matrix[0].length];
            for(int i = 0; i < matrix.length; i++){
                int temp = 0;
                for(int j = 0; j < matrix[0].length; j++){
                    temp += matrix[i][j];
                    sum[i][j] = temp + ((i - 1)>=0?sum[i - 1][j] : 0);
                }
            }
        }
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

    public int sumRegionCool(int row1, int col1, int row2, int col2) {
        if(matrix.length==0 && matrix[0].length==0) return 0;
        return sum[row2][col2] - ((row1-1)>=0?sum[row1-1][col2]:0) - ((col1-1)>=0?sum[row2][col1-1]:0) + (((row1-1)>=0&&(col1-1)>=0)?sum[row1-1][col1-1]:0);
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
        NumMatrix numMatrix = new NumMatrix(new int[0][0]);
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2) == numMatrix.sumRegionCool(1, 1, 2, 2)); //-> 8
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)  == numMatrix.sumRegionCool(2, 1, 4, 3)); //-> 8
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)  == numMatrix.sumRegionCool(1, 1, 2, 2)); //-> 11
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)  == numMatrix.sumRegionCool(1, 2, 2, 4)); //-> 12
    }

}
