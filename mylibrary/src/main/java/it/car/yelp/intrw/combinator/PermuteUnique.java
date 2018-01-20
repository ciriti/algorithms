package it.car.yelp.intrw.combinator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PermuteUnique {


	/**
	 * Permutations 
	 * LINK - https://leetcode.com/problems/permutations/
	 * @param args
	 */

	public static void main(String args[]){
		int[] nums = new int[]{1,1,2};
		System.out.println(permuteUnique(nums));
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> preList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		for(int i : nums){
			list.add(i);
		}
		
		Set<List<Integer>> resSet = new HashSet<>();
		createPermutation(preList, list, resSet);
		
		Iterator<List<Integer>> i = resSet.iterator();
		while(i.hasNext()){
			res.add(i.next());
		}
		
		return res;
	}
	
	public static void createPermutation(List<Integer> preList, List<Integer> list, Set<List<Integer>> resSet){
		if(list.size() == 0){
			resSet.add(preList);
		}else{
			for(int i = 0; i < list.size(); i++){
				Integer tmp = list.get(i);
				List<Integer> preListTmp = new ArrayList<>(preList);
				preListTmp.add(tmp);
				List<Integer> listTmp = new ArrayList<>(list);
				listTmp.remove(i);
				createPermutation(preListTmp, listTmp, resSet);
			}
		}
	}

}
