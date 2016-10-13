package it.car.yelp.intrw.combinator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
	
	/**
	 * the anagram are permutations
	 * 
	 * with N element I can obtain N! combination
	 */
	
	public static void main(String args[]){
		String test = "abc";
		long start = System.currentTimeMillis();
		Set<String> list = new HashSet<>();
		permutate(test, list);
//		System.out.println("tempo : " + (System.currentTimeMillis() - start));
//		System.out.println("size: " + list.size());
		System.out.println(list);
	}

	private static void permutate(String test, Set<String> list) {
		permutate("", test, list);
		
	}

	private static void permutate(String prefix, String s, Set<String> list) {
		
		if(s.length() == 0) 
			list.add(prefix);
		else{
			for(int i = 0; i < s.length(); i++)
				permutate(prefix+s.charAt(i), s.substring(0, i) + s.substring(i+1, s.length()), list);
		}
		
	}

}
