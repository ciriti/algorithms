package it.car.yelp.interview.combinator;

import java.util.ArrayList;
import java.util.List;

public class PossibileCombination_PowerSet {
	
	/**
	 * How Many Subsets???
	 * 
	 * If the original set has n members, then the Power Set will have 2^n members
	 * 
	 * @param prefix
	 * @param str
	 * @param list
	 */

	private static void combination(String prefix, String str, List<String> list){
		int n = str.length();

//		System.out.println(prefix);
		list.add(prefix);

		for (int i = 0; i < n; i++) {
			combination(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1), list);
		}
	}
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		combination("", "abcd", list);
		System.out.println(list);

	}

}
