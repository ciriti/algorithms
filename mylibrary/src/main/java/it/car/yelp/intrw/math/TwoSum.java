package it.car.yelp.intrw.math;

import java.util.HashMap;

public class TwoSum {
	
	/**
	 * Find two number such that n1 + n2 = target 
	 * @param numbers
	 * @param target
	 * @return
	 */
	
	public static int[] twoSum(int[] numbers, int target) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < numbers.length; i++){
			if(map.containsKey(numbers[i])){
				return new int[]{map.get(numbers[i]) + 1, i + 1};
			}else{
				map.put(target - numbers[i], i);
			}
		}


		return null;
	}

}
