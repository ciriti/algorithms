package it.car.wayfair.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ciriti on 03/10/16.
 */

public class LongConsecutiveSubSeq {

    /**
     * Longest consecutive subsequence tha give the max sum
     * [-2, 2, 3, -1, 4, -1, -5] -> []
     *
     */

    public static List<Integer> longestConsecutiveSubsequence(Integer[] arr){

        List<Integer> res = new ArrayList<>();
        int max = 0;

        for(int i = 0; i < arr.length; i++){

            int lo = i;
            int up = i+1;

            while(lo > 0 && up < arr.length){
                List<Integer> tmp = new ArrayList<>();
                int sum = 0;
                for(int k = lo; k <= up; k++){
                    sum += arr[k];
                    tmp.add(arr[k]);
                }
                if(sum > max){
                    max = sum;
                    res = tmp;
                }
                lo--;
                up++;

            }

        }


        return res;
    }

    public static int sum(List<Integer> arr){
        int sum = 0;

        for(int i: arr){
            sum += i;
        }
        return sum;
    }

    public static void main(String args[]){
        System.out.println(longestConsecutiveSubsequence(new Integer[]{-2, 2, 3, -1, 4, -1, -5}));
        System.out.println(longestConsecutiveSubsequence(new Integer[]{-2, -2, -3, -1, -4, -1, -5}));
        System.out.println(longestConsecutiveSubsequence(new Integer[]{-2, -2, -3, 1, 4, -1, -5}));
        System.out.println(longestConsecutiveSubsequence(new Integer[]{}));
    }

}
