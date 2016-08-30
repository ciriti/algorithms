package it.car.yelp.intw.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Subsets (o anche powerset)
 * LINK - https://leetcode.com/problems/subsets/
 * @author carmelo.iriti
 *
 */
public class SubsetsMain {


	public static void main(String args[]){
		int[] s = new int[]{1,2,3, 4};
		List<List<Integer>> res = subsets(s);
		System.out.println(res);
	}

	/**
	 * Recursive solution
	 * @param S
	 * @return
	 */
	public static List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> res = new ArrayList<>();
		createPowerSet(S, res);
		res.add(new ArrayList<Integer>());
		return res;
	}

	static void  createPowerSet(int[] s, List<List<Integer>> res) {

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
	
	/**
	 * Linear solution
	 */
	
	public static List<List<Integer>> subsetsLinearSolution(int[] S) {
		List<List<Integer>> resList = new ArrayList<>();
		for(int i = 0; i < S.length; i++){
			int tmp = S[i];
			List<List<Integer>> resListCopy = new ArrayList<>(resList);
			
			for(List<Integer> tmpList : resListCopy){
				List<Integer> singleItem = new ArrayList<>(tmpList);
				singleItem.add(tmp);
				Collections.sort(singleItem);
				resList.add(singleItem);
			}
			List<Integer> singleItemTmp = new ArrayList<>();
			singleItemTmp.add(tmp);
			resList.add(singleItemTmp);
		}
		resList.add(new ArrayList<Integer>());
		return resList;
	}


}
