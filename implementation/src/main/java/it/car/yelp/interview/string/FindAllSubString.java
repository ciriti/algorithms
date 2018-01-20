package it.car.yelp.intrw.string;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubString {
	
	/**
	 * Il numero di tutte le sotto stringhe � il fattoriale della dimensione
	 * @param args
	 */
	
	public static void main(String args[]){
		String str = "abc";
		List<String> res = new ArrayList<>();//getAllSubString(str);
		getAllSubString2("", str, res);
		for (String string : res) {
			System.out.println(string);
		}
	}
	
	public static void getAllSubString2(String prefix, String str, List<String> res) {
		res.add(prefix);
		for(int i = 0; i < str.length(); i++){
			prefix = prefix + str.substring(i, i+1);
			str = str.substring(0, i) + str.substring(i+1, str.length());
			getAllSubString2(prefix, str, res);
		}
	}

	public static ArrayList<String> getAllSubString(String str) {
		// TODO Auto-generated method stub
		ArrayList<String> res = new ArrayList<>();
		for(int i = 0; i<str.length(); i++){
			for(int j = 1; j <= (str.length() - i); j++){
				res.add(str.substring(i, j + i));
			}
		}
		return res;
	}


}
