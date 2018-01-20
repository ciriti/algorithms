package it.car.wayfair.array;

/**
 * Created by ciriti on 24/09/16.
 */

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int[] copy = new int[nums.length];

        copy[0] = nums[0];
        int max = nums[0];

        for(int i = 1; i < nums.length; i++){
            copy[i] = Math.max(nums[i], nums[i] + copy[i-1]);
            max = Math.max (copy[i], max);
        }

        return max;

    }

    public static int maxSubArrayFast(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int copy = nums[0];
        int copyOld = nums[0];
        int max = nums[0];


        for(int i = 1; i < nums.length; i++){
            copy = Math.max(nums[i], nums[i] + copyOld);
            max = Math.max (copy, max);
            copyOld = copy;
        }

        return max;

    }

    public static void main(String args[]){
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}) == 6?"SUCCES":"ERROR");
        System.out.println(maxSubArray(new int[]{-2,-1}) == -1?"SUCCES":"ERROR");
        System.out.println(maxSubArray(new int[]{-1,-2}) == -1?"SUCCES":"ERROR");
    }

}
