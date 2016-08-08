package it.car.yelp.interview.datastructure.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Map;

public class FindDuplicates {
	
	public static void main(String args[]){
		String a = "abbcddeff";
		String b = "bbff";
		List<Character> list = findDuplicates(a, b);
		for(Character c : list){
			System.out.print(c + " - ");
		}
	}

	private static List<Character> findDuplicates(String a, String b) {
		
		LinkedHashSet<Character> res = new LinkedHashSet<>();
		Map<Character, Character> map = new HashMap<>();
		
		for(int i = 0; i < b.length(); i++){
			map.put(b.charAt(i), b.charAt(i));
		}
		
		for(int i = 0; i < a.length(); i++){
			if(map.containsKey(a.charAt(i)))
				res.add(a.charAt(i));
		}
		
		return new ArrayList(res);
	}

}
