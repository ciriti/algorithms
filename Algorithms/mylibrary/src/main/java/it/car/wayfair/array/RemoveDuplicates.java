package it.car.wayfair.array;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Created by ciriti on 02/10/16.
 */

public class RemoveDuplicates {

    public static int removeDuplicates(Integer[] nums) {

        return nums.length - new LinkedHashSet<>(Arrays.asList(nums)).size();

    }

    public static void main(String[] args) {

        System.out.println(removeDuplicates(new Integer[]{1,1,2,2,3}));
    }

}
