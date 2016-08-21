package it.car.yelp.interview.combinator;

import java.util.ArrayList;
import java.util.List;

public class LeetcodePermutations {


	/**
	 * Permutations 
	 * LINK - https://leetcode.com/problems/permutations/
	 * @param args
	 */

	public static void main(String args[]){
		int[] nums = new int[]{1,2,3,4};
		System.out.println(permute(nums));
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> preList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		for(int i : nums){
			list.add(i);
		}
		createPermutation(preList, list, res);
		return res;
	}
	
	public static void createPermutation(List<Integer> preList, List<Integer> list, List<List<Integer>> res){
		if(list.size() == 0){
			res.add(preList);
		}else{
			for(int i = 0; i < list.size(); i++){
				Integer tmp = list.get(i);
				List<Integer> preListTmp = new ArrayList<>(preList);
				preListTmp.add(tmp);
				List<Integer> listTmp = new ArrayList<>(list);
				listTmp.remove(i);
				createPermutation(preListTmp, listTmp, res);
			}
		}
	}

}
