package it.car.xsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.car.graph.util.In;

public class TwoSumArray {

	/**
	 * Given an array of integers, return indices of the two numbers such that they add up to a
	 * specific target. You may assume that each input would have exactly one solution.
	 * LINK - https://leetcode.com/problems/two-sum/
	 */

	public static void main(String args[]){
		System.out.println(solution(6, new int[]{1, 8, -3, 0, 1, 3, -2, 4, 5}));
		TwoSumArray tw = new TwoSumArray();
		System.out.println("Two sum: ");
		int[] res = tw.twoSum(new int[]{3,2,4}, 6);
		System.out.println(res[0]+ " " + res[1]);
	}

	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		Map<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < nums.length; i++){
			map.put(target - nums[i], i);
		}

		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(nums[i]) && i != map.get(nums[i])){
				res[0] = i;
				res[1] = map.get(nums[i]);
				return res;
			}
		}

		return res;
	}

	public static  int solution(int K, int[] A) {
		// write your code in Java SE 8

		//IDEA : if A[i]+A[j]=k => k - A[j] = A[i]; 

		int count = 0;
		Map<Integer, List<Bean>> map = new HashMap<>();
		int tmp = 0;

		for(int i = 0; i < A.length; i++){

			tmp = K - ( A[i] );
			if(map.containsKey(tmp)){
				map.get(tmp).add(new Bean(A[i], i));
			}else{
				Bean b = new Bean(A[i], i);
				List<Bean> list = new ArrayList<>();
				list.add(b);
				map.put(tmp, list);
			}
		}

		for(int i = 0; i < A.length; i++){
			if(map.containsKey(A[i])){
				List<Bean> list = map.get(A[i]);
				for(Bean b : list){
					//                    if(b.index != i)
					System.out.println("index: " + i + " bean index" + b.index);
					count++;
				}

			}
		}
		return count;
	}

	public static class Bean{
		public int value;
		public int index;

		public Bean(int value, int index){
			this.index = index;
			this.value = value;
		}

		public boolean isValid(int index){
			if(this.index == index){
				return false;
			}
			return true;
		}

	}

}
