package it.car.wayfair.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by carmeloiriti, 12/10/16.
 */
public class Subset {

    /**
     * LINK - https://leetcode.com/problems/subsets/

     Given a set of distinct integers, nums, return all possible subsets.

     Note: The solution set must not contain duplicate subsets.

     For example,
     If nums = [1,2,3], a solution is:

     [
     [3],
     [1],
     [2],
     [1,2,3],
     [1,3],
     [2,3],
     [1,2],
     []
     ]

     */

    public static List<List<Integer>> subsets(int[] pNums) {
        Integer[] nums = new Integer[pNums.length];
        for(int i = 0; i < pNums.length; i++){
            nums[i] = pNums[i];
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), new ArrayList<>(Arrays.asList(nums)));
        return res;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, List<Integer> operList){
        list.add(new ArrayList<>(tempList));
        if(operList.size() == 0)
            return;
        for(int i = 0; i < operList.size(); i ++){
            tempList.add(operList.get(i));
            backtrack(list, new ArrayList<>(tempList), new ArrayList<>(operList.subList(i+1, operList.size())));
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String args[]){
        System.out.println(subsets(new int[]{1,2,3}));
    }

}
