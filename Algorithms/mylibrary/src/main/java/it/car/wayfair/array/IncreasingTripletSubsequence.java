package it.car.wayfair.array;

/**
 * Created by ciriti on 24/09/16.
 */

public class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {

        if(nums.length < 3) return false;
        // initial condition
        int first = Integer.MAX_VALUE;
        int sec = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i ++){
            // if the current element is bigger than "first" and...
            if(nums[i] > first){
                // ... if the current element is bigger than "second", you have the rigth Triplet
                if(nums[i] > sec){
                    return true;
                }else{
                    // if the current element is lower than "second",
                    // put it inside "second"
                    sec = nums[i];
                }
            }else{
                // if the current element is lower than "first",
                // put it inside "first"
                first = nums[i];
            }
        }

        return false;
    }

    public static void main(String args[]){
        System.out.println(increasingTriplet(new int[]{2,1,5,0,3}) == false?"SUCCES":"ERROR");
        System.out.println(increasingTriplet(new int[]{1}) == false?"SUCCES":"ERROR");
        System.out.println(increasingTriplet(new int[]{1, 2, 3, 4, 5}) == true?"SUCCES":"ERROR");
        System.out.println(increasingTriplet(new int[]{5, 4, 3, 2, 1}) == false?"SUCCES":"ERROR");
    }
}
