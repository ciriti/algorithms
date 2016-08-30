package it.car.yelp.intw.datastructure.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGroupOfString {
	
	public static void main(String[] args) {

		String[] arr = new String[]{"abc","acb","cba","dfg"};
		System.out.println(anagrams(arr));
		

	}

	public static List<String> anagrams(String[] strs) {

		List<String> res = new ArrayList<>();

		if(strs == null) return res;

		Map<String, List<String>> map = new HashMap<>();

		for(String a : strs){

			char[] tmp = a.toCharArray();
			Arrays.sort(tmp);
			String key = Arrays.toString(tmp);
			if(map.containsKey(key)){
				map.get(key).add(a);
			}else{
				List<String> nl = new ArrayList<>();
				nl.add(a);
				map.put(key, nl);
			}       
		}

		for(List<String>  list : map.values())
			if(list.size()>1)
				res.addAll(list);


		return res;
	}

}
