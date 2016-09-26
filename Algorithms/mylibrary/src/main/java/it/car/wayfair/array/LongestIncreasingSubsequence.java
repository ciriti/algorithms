package it.car.wayfair.array;

/**
 * Created by ciriti on 25/09/16.
 */

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {

        if(nums.length <= 1) return nums.length;

        int max = 0;

        int[] support = new int[nums.length];
        support[0] = 1;

        for(int i = 1; i < nums.length; i ++){
            for(int j = 0; j<i; j++){
                int numI = nums[i];
                int numJ = nums[j];
                if( numJ < numI){
                    support[i] = Math.max(support[i], support[j]);
                }
            }
            support[i]++;
            max = Math.max(support[i], max);
        }

        return max;
    }

    public static void main(String args[]){
        /** RES: [2, 3, 7, 101] */
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,4}) == 3?"SUCCES":"ERROR");
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}) == 4?"SUCCES":"ERROR");
    }

}
