package it.car.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by carmeloiriti, 25/08/16.
 */
public class LongestConsecutiveSequence {
    /**
     * Longest Consecutive Sequence
     *
     * LINK - https://leetcode.com/problems/longest-consecutive-sequence/
     */

    public static void main(String[] arg){
        System.out.println(longestConsecutive1(new int[]{100, 4, 200, 1, 3, 2})); // 1,2,3,4
        System.out.println(longestConsecutive1(new int[]{100, 4, 200, 104, 105,  1, 103, 3, 101, 2, 102})); // 100, 101, 102, 103, 104, 105
        System.out.println(longestConsecutive1(new int[]{0, -1})); // -1, 0 // num 2
        System.out.println(longestConsecutive1(new int[]{1,2,0,1})); // 0,1,2 // num 3
        System.out.println(longestConsecutive1(new int[]{9,1,-3,2,4,8,3,-1,6,-2,-4,7})); // num: 4
    }

    public static List<Integer> longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        tmp.add(nums[0]);

        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i-1] == 1){
                tmp.add(nums[i]);
            }
            else if(tmp.size() > res.size()){
                res.clear();
                res.addAll(tmp);
                tmp.clear();
                tmp.add(nums[i]);
            }
        }

        return res;
    }

    public static int longestConsecutive1(int[] nums) {
        // sort the array
        Arrays.sort(nums);
        // final result
        int res = 1;
        // partial result
        int tmp = 1;

        for(int i = 1; i < nums.length; i++){
            // ignore the same num
            if(nums[i] ==  nums[i-1]){
                continue;
            }
            // count the consecutive num
            else if(nums[i-1] + 1 == nums[i]){
                tmp++;
            }
            // reset the tmp var and check the max
            else {
                if(tmp >= res)
                    res = tmp;
                tmp = 1;
            }
        }
        // correct last iteration
        if(tmp > res){
            res = tmp;
        }

        return res;
    }
}
