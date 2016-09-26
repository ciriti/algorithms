package it.car.wayfair.array;

import java.util.Arrays;

import static android.R.attr.max;
import static android.os.Build.VERSION_CODES.M;

/**
 * Created by ciriti on 25/09/16.
 */

public class WiggleSubsequence {

    /**
     * LINK - https://leetcode.com/problems/wiggle-subsequence/
     * @param nums
     * @return
     */

    public static int wiggleMaxLength(int[] nums) {
        int res = 0;

        int[] subN = new int[nums.length];
        int[] subP = new int[nums.length];

        Arrays.fill(subN, 1);
        Arrays.fill(subP, 1);

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] - nums[i] < 0){
                    subN[i] = Math.max(subN[i], subP[j] + 1);
                }else if(nums[j] - nums[i] > 0){
                    subP[i] = Math.max(subP[i], subN[j] + 1);
                }
            }
        }

        Arrays.sort(subN);
        Arrays.sort(subP);

        return Math.max(subP[nums.length-1], subN[nums.length-1]);
    }

    public static void main(String args[]){
        /** RES: [2, 3, 7, 101] */
        System.out.println(wiggleMaxLength(new int[]{0, 0}) == 1?"SUCCES":"ERROR");
        System.out.println(wiggleMaxLength(new int[]{1,7,4,9,2,5}) == 6?"SUCCES":"ERROR");
        System.out.println(wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}) == 7?"SUCCES":"ERROR");
        System.out.println(wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}) == 2?"SUCCES":"ERROR");
    }

}
