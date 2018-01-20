package it.car.dynamic;

/**
 * Created by carmeloiriti, 26/08/16.
 */
public class RangeSumQuery {

    /**
     * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
     *
     * Example:
     * Given nums = [-2, 0, 3, -5, 2, -1]
     *
     * sumRange(0, 2) -> 1
     * sumRange(2, 5) -> -1
     * sumRange(0, 5) -> -3
     */

    public static void main(String args[]){
        RangeSumQuery rangeSumQuery;

        rangeSumQuery = new RangeSumQuery(new int[]{-2, 0, 3, -5, 2, -1});

        System.out.println(rangeSumQuery.sumRange(0, 2) == 1?"SUCCESS":"ERROR");
        System.out.println(rangeSumQuery.sumRange(2, 5) == -1?"SUCCESS":"ERROR");
        System.out.println(rangeSumQuery.sumRange(0, 5) == -3?"SUCCESS":"ERROR");

        rangeSumQuery = new RangeSumQuery(new int[]{2, 2, 2, 2, 2, 2});

        System.out.println(rangeSumQuery.sumRange(0, 2) == 6?"SUCCESS":"ERROR");
    }

    int[] sum;
    public RangeSumQuery(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i< sum.length; i++){
            sum[i] = nums[i-1] + sum[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }

}
