package it.car.yelp.intrw.combinator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	
	/**
	 * Given a set of distinct integers, S, return all possible subsets.
	 * 
	 * exercise - https://leetcode.com/problems/subsets/
	 * solution - http://www.programcreek.com/2013/01/leetcode-subsets-java/
	 * @param nums
	 * @return
	 */

	public List<List<Integer>> subsets(int[] nums) {

		// I'm creating the result list
		List<List<Integer>> res = new ArrayList<>();

		// I'm controlling input data
		if(nums == null)
			return res;

		//I'm sorting the data
		Arrays.sort(nums);

		for(int i = 0; i < nums.length; i++){
			List<List<Integer>> tmp = new ArrayList<>();

			// I'm creating a copy of the final result
			for(List<Integer> arr : res){
				tmp.add(new ArrayList<Integer>(arr));
			}

			// I'm adding at each list the current element at the end
			for(List<Integer> arr : tmp){
				arr.add(nums[i]);
			}

			// I'm adding only the current element
			List<Integer> arr = new ArrayList<>();
			arr.add(nums[i]);
			tmp.add(arr);

			// I'm adding the tmp list to the result list
			res.addAll(tmp);
		}

		// I'm adding the empty list
		res.add(new ArrayList<Integer>());

		return res;

	}
	
	public static List<List<Integer>> subsetsRecursiveVers(int[] S) {
		Arrays.sort(S);
		List<List<Integer>> res = new ArrayList<>();
		createPowerSet(S, res);
		List<Integer> single = new ArrayList<Integer>();
		res.add(single);
		return res;
	}

	private static void createPowerSet(int[] s, List<List<Integer>> res) {

		if(s.length == 0) return;

		List<List<Integer>> resCopy = new ArrayList<>(res);
		List<Integer> tmp = new ArrayList<>();
		for(List<Integer> listInteger : resCopy){
			tmp = new ArrayList<>(listInteger);
			tmp.add(s[0]);
			res.add(tmp);
		}
		List<Integer> single = new ArrayList<Integer>();
		single.add(s[0]);
		res.add(single);
		createPowerSet(Arrays.copyOfRange(s, 1, s.length), res);

	}

}
