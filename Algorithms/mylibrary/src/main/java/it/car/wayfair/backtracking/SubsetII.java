package it.car.wayfair.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by carmeloiriti, 13/10/16.
 */
public class SubsetII {

    /**
     * LINK - https://leetcode.com/problems/subsets-ii/
     */

    /**
     Given a collection of integers that might contain duplicates, nums, return all possible subsets.

     Note: The solution set must not contain duplicate subsets.

     For example,
     If nums = [1,2,2], a solution is:

     [
     [2],
     [1],
     [1,2,2],
     [2,2],
     [1,2],
     []
     ]
     */


    public static List<List<Integer>> subsetII(int[] nums){
        Set<List<Integer>> res = new LinkedHashSet<>();

        List<Integer> workingArr = new ArrayList<>(nums.length);

        for(int  i : nums){
            workingArr.add(i);
        }

        rec(res, new ArrayList<Integer>(), workingArr);

        return new ArrayList<>(res);
    }

    static void  rec(Set<List<Integer>> set, List<Integer> tmp, List<Integer> workingArr){
        Collections.sort(tmp);
        set.add(tmp);
        if(workingArr.size() == 0) return;
        for(int i = 0; i < workingArr.size(); i++){
            List<Integer> tmpCopy = new ArrayList<>(tmp);
            tmpCopy.add(workingArr.get(i));
            List<Integer> workingArrCopy = workingArr.subList(i+1, workingArr.size());
            rec(set, tmpCopy, workingArrCopy);
        }
    }

    public static void main(String args[]){
        System.out.println(subsetII(new int[]{1,2,2}));
    }
}
