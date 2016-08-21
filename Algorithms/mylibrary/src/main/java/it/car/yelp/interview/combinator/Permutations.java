package it.car.yelp.interview.combinator;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	/**
	 * the anagram are permutations
	 * 
	 * with N element I can obtain N! combination
	 */
	
	public static void main(String args[]){
		String test = "abcd";
		long start = System.currentTimeMillis();
		List<String> list = new ArrayList<>();
		permutate(test, list);
//		System.out.println("tempo : " + (System.currentTimeMillis() - start));
//		System.out.println("size: " + list.size());
		System.out.println(list);
	}

	private static void permutate(String test, List<String> list) {
		permutate("", test, list);
		
	}

	private static void permutate(String prefix, String s, List<String> list) {
		
		if(s.length() == 0) 
			list.add(prefix);
		else{
			for(int i = 0; i < s.length(); i++)
				permutate(prefix+s.charAt(i), s.substring(0, i) + s.substring(i+1, s.length()), list);
		}
		
	}

}
