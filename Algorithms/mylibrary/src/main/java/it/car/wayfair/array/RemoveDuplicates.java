package it.car.wayfair.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ciriti on 02/10/16.
 */

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        if(nums.length < 2) return nums.length;

        int lo = 0;
        int up = 1;
        while(up < nums.length){
            if(nums[lo] != nums[up]){
                swap(nums, lo+1, up);
                lo++;
                up++;
            }else{
                up++;
            }
        }

        System.out.println(Arrays.toString(nums));

        return lo+1;

    }

    static void swap(int[] nums, int i, int j){
        int c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }


    public static void main(String[] args) {

        System.out.println(removeDuplicates(new int[]{1,1,2,2,3}));
    }

}
