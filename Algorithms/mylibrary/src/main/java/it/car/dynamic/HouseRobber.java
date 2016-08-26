package it.car.dynamic;

/**
 * Created by carmeloiriti, 26/08/16.
 */
public class HouseRobber {

    /**
     *
     * LINK - https://leetcode.com/problems/house-robber/
     *
     * You are a professional robber planning to rob houses along a street. Each house has a
     * certain amount of money stashed, the only constraint stopping you from robbing each of
     * them is that adjacent houses have security system connected and it will automatically contact
     * the police if two adjacent houses were broken into on the same night.
     * Given a list of non-negative integers representing the amount of money of each house,
     * determine the maximum amount of money you can rob tonight without alerting the police.
     */

    public static void  main(String arg[]){
        System.out.println(rob(new int[]{1,1,1}) == 2?"SUCCESS":"ERROR" );
        System.out.println(rob(new int[]{1,3,1}) == 3?"SUCCESS":"ERROR" );
    }

    public static int rob(int[] nums) {

        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];
        if(nums.length == 2)return Math.max(nums[0], nums[1]);

        int res = 0;
        int closeElem = nums[0];
        int farElem = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] + farElem > closeElem){
                res = nums[i] + farElem;
            }else{
                res = closeElem;
            }

            farElem = closeElem;
            closeElem = res;

        }

        return res;
    }
}
