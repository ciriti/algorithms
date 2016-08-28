package it.car.yelp.interview.datastructure.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordGroupingAnagram {

	/**
	 * Ragruppa insieme che sono anagramma di loro stessi es. like  anagramma di kile e vanno nello stesso gruppo
	 * @param args
	 */

	public static void main(String args[]){
		String[] words = new String[]{"man" ,"car" ,"kile" ,"arc" ,"none" ,"like"};
		//		printGroupingWords(words);
		List<String> print = anagrams(words);
		System.out.println(print);
	}

	public static List<String> anagrams1(String[] strs) {
		HashMap<String, LinkedList<String>> dict = new HashMap<>();

		for (int i = 0; i < strs.length; i++) {
			
			String s = strs[i];
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String sortedString = String.valueOf(chars);

			if (dict.containsKey(sortedString)) {
				dict.get(sortedString).add(s);
			} else {
				LinkedList<String> list = new LinkedList<>();
				list.add(s);
				dict.put(sortedString, list);
			}

		}
		List<String> ret = new LinkedList<>();
		for (LinkedList<String> list : dict.values()) {
			if (list.size() > 1)
				ret.addAll(list);
		}
		return ret;
	}

	public static List<String> anagrams(String[] strs) {

		String[] words = strs;
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for(String str : words){

			char[] arrayStr = str.toCharArray();
			Arrays.sort(arrayStr);
			String tmp = new String(arrayStr);
			
			if(map.containsKey(tmp)){
				map.get(tmp).add(str);
			}else{
				ArrayList<String> tmpArr = new ArrayList<String>();
				tmpArr.add(str);
				map.put(tmp, tmpArr);
			}


		}
		List<String> list = new ArrayList<String>();
		for(ArrayList<String> tmp : map.values()){
			if(tmp.size()>1)
				list.addAll(tmp);
		}


		return list;

	}

	private static void printGroupingWords(String[] words) {
		// TODO Auto-generated method stub
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		String ord;
		ArrayList<String> tmpArr;
		char[] tmpCharArr;

		for(String str : words){
			tmpCharArr = str.toCharArray();
			Arrays.sort(tmpCharArr);
			ord= new String(tmpCharArr);

			if(map.get(ord) == null){
				tmpArr = new ArrayList<String>();
				tmpArr.add(str);
				map.put(ord, tmpArr);
			}else{
				map.get(ord).add(str);
			}
		}

		Set<String>keySet = map.keySet();
		for (String key : keySet) {
			tmpArr = map.get(key);
			for (String string : tmpArr) {
				System.out.print(string + " ");
			}
			System.out.println();
		}
	}



}
