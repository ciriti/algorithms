package it.car.yelp.intrw.combinator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Combinations {

	/**
	 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	 * 
	 * link - https://leetcode.com/problems/combinations/
	 */

	public static List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> res = new ArrayList<>();
		List<Integer> data = new ArrayList<>();
		for(int i = 0; i < n; i++){
			data.add(i+1);
		}

		recursive(data , res, k);

		Iterator<List<Integer>> i = res.iterator();

		while(i.hasNext()){
			List<Integer> tmp = i.next();
			if(tmp.size()!=k){
				i.remove();
			}
		}

		return res;

	}

	public static void recursive(List<Integer> data, List<List<Integer>> res, int k){

		if(data.size()==0) return;

		List<List<Integer>> tmp = new ArrayList<>();

		for(List<Integer> list : res){
			if(list.size()==k){
				continue;
			}
			List<Integer> tmp1 = new ArrayList<>(list);
			tmp1.add(data.get(0));
			tmp.add(tmp1);
		}

		List<Integer> newList = new ArrayList<>();
		newList.add(data.get(0));

		tmp.add(newList);

		res.addAll(tmp);

		recursive(data.subList(1, data.size()) , res, k);
	}
	

	public static void main(String args[]){
		System.out.println(combine(5, 2));
	}

}
