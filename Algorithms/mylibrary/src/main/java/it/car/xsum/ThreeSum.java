package it.car.xsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static android.R.attr.id;

/**
 * Created by ciriti on 03/09/16.
 */

public class ThreeSum {

    /**
     *
     * LINK - https://leetcode.com/problems/3sum/
     *
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     *
     * Note: The solution set must not contain duplicate triplets.
     *
     * For example, given array S = [-1, 0, 1, 2, -1, -4],

     * A solution set is:
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     *
     */

    public static void main(String[] arg){


        ThreeSum threeSum = new ThreeSum();
        long start = System.currentTimeMillis();

        System.out.println(threeSum.threeSum(getArray()));

        System.out.println(" " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();

        System.out.println(threeSum.threeSumSlow(getArray()));

        System.out.println(" " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();

        System.out.println(threeSum.threeSumSlow1(getArray()));

        System.out.println(" " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();

        System.out.println(threeSum.threeSumFast(getArray()));

        System.out.println(" " + (System.currentTimeMillis() - start));

    }

    public static int[] getArray(){
        int[] test = new int[]{12,5,-12,4,-11,11,2,7,2,-5,-14,-3,-3,3,2,-10,9,-15,2,14,-3,-15,-3,-14,
                -1,-7,11,-4,-11,12,-15,-14,2,10,-2,-1,6,7,13,-15,-13,6,-10,-9,-14,7,-12,3,-1,5,2,11,
                6,14,12,-10,14,0,-7,11,-10,-7,4,-1,-12,-13,13,1,9,3,1,3,-5,6,9,-4,-2,5,14,12,-5,-6,
                1,8,-15,-10,5,-15,-2,5,3,3,13,-8,-13,8,-5,8,-6,11,-12,3,0,-2,-6,-14,2,0,6,1,-11,9,2,
                -3,-6,3,3,-15,-5,-14,5,13,-4,-4,-10,-10,11};

        int[] test2 = new int[]{-1, 0, 1, 2, -1, -4};
        int[] test3 = new int[]{1, 1, -2};
        int[] test4 = new int[]{0, 0, 0};
        int[] test5 = new int[]{-2,0,1,1,2};
        int[] test6 = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        int[] test7 = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        return test6;
    }

    public List<List<Integer>> threeSumFast(int[] nums) {
        if(nums.length == 0) return Collections.EMPTY_LIST;
        if(nums.length < 3) return Collections.EMPTY_LIST;
        List<Integer> tmp;
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        Map<Integer, List<Integer>> map = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i ++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<Integer>());
            map.get(nums[i]).add(i);
        }
        int i = 0;
        int j = nums.length-1;
        int x = 0;
        int y = nums.length-1;
        while(i < j){

            if(map.containsKey(-(nums[i]+nums[j]))){
                for(int th : map.get(-(nums[i]+nums[j]))){
                    if( th != i && th != j){
                        tmp = Arrays.asList(nums[i], nums[j], nums[th]);
                        Collections.sort(tmp);
                        result.add(tmp);
                    }
                }
            }
            if(map.containsKey(-(nums[x]+nums[y]))){
                for(int th : map.get(-(nums[x]+nums[y]))){
                    if( th != x && th != y){
                        tmp = Arrays.asList(nums[x], nums[y], nums[th]);
                        Collections.sort(tmp);
                        result.add(tmp);
                    }
                }
            }

            int alpha = Math.abs(nums[nums.length-1]) - Math.abs(nums[0]);
            alpha = alpha<0?0:alpha;
            if( - alpha + Math.abs(nums[i]) > Math.abs(nums[j]))
                i++;
            else
                j--;
            if(-alpha + Math.abs(nums[x]) >= Math.abs(nums[y]))
                x++;
            else
                y--;

//            int alpha = Math.abs(nums[nums.length-1]) - Math.abs(nums[0]);
//            if( - alpha + Math.abs(nums[i]) > Math.abs(nums[j])){  i++; }
//            else  j--;
//            if(-alpha + Math.abs(nums[x]) >= Math.abs(nums[y])){ x++;  }
//            else y--;
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 2) {
            if(nums[i] > 0) break;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                if(sum <= 0) while(nums[j] == nums[++j] && j < k);
                if(sum >= 0) while(nums[k--] == nums[k] && j < k);
            }
            while(nums[i] == nums[++i] && i < nums.length - 2);
        }
        return result;
    }
    public List<List<Integer>> threeSumSlow1(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        int i = 0;
        int k = 0;
        int j = 0;
        while(i < nums.length-2){
            j=i+1;
            while(j < nums.length-1){
                k = j +1;
                while(k< nums.length){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> tmp = new ArrayList<>(3);
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        Collections.sort(tmp);
                        res.add(tmp);
                    }
                    k++;
                }
                j++;
            }
            i++;
        }

        return new ArrayList<>(res);
    }
    public List<List<Integer>> threeSumSlow(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Map<Integer, Set<TwoIndex>> map = new HashMap<>();

        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(!map.containsKey(nums[i]+nums[j])){
                    map.put(nums[i]+nums[j], new HashSet<TwoIndex>());
                }
                map.get(nums[i]+nums[j]).add(new TwoIndex(i, j));
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(-nums[i])){
                List<TwoIndex> couples = new ArrayList<>(map.get(-nums[i]));
                for(TwoIndex couple : couples){
                    if(i != couple.first && i != couple.second){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[couple.first]);
                        tmp.add(nums[couple.second]);
                        Collections.sort(tmp);
                        res.add(tmp);
                    }
                }

            }
        }

        return new ArrayList<>(res);
    }

    class TwoIndex{
        public final int first;
        public final int second;

        public TwoIndex(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {
            int hash = 17;
            hash = 17 * hash + first;
            hash =  17 * hash + second;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {

            if(!(obj instanceof TwoIndex)){
                return false;
            }

            int minThis = Math.min(this.first, second);
            int maxThis = Math.max(this.first, second);
            int min = Math.min(((TwoIndex)obj).first, ((TwoIndex)obj).second);
            int max = Math.max(((TwoIndex)obj).first, ((TwoIndex)obj).second);

            return minThis == min && maxThis == max;
        }
    }

}
