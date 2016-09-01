package it.car.yelp.intrw.combinator;

import java.util.ArrayList;
import java.util.List;

public class UppercaseLowercase {

	public static void main(String args[]){
		String test = "0Ab1cd";
		List<String> res = new ArrayList<>();
		createCombination("", test, res, test.length());
		System.out.println(res);
	}

	public static void createCombination(String prefix, String test, List<String> list, int groupSize){
		if(prefix.length() == groupSize)
			list.add(prefix);
		else{
			if(test.substring(0, 1).matches("[0-9]")){
				createCombination(prefix + test.substring(0, 1), test.substring(1, test.length()), list/*ok*/, groupSize/*ok*/);
			}else{
				createCombination(prefix + test.substring(0, 1).toLowerCase(), test.substring(1, test.length()), list/*ok*/, groupSize/*ok*/);
				createCombination(prefix + test.substring(0, 1).toUpperCase(), test.substring(1, test.length()), list/*ok*/, groupSize/*ok*/);
			}

		}
	}

}
