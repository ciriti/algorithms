package it.car.yelp.intw.math;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;


public class ThreeSum {

	public static void main(String args[]){
		System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
	}

	public static List<List<Integer>> fourSum(int[] num, int target) {

		List<List<Integer>> res = new LinkedList<>();
		Map<Integer, LinkedList<BeanInteger>> map = new HashMap<>();

		for(int i = 0; i < num.length; i++){
			for(int j = i+1; j < num.length; j++){
				Integer integer = Integer.valueOf(num[i]+num[j]);
				if(map.containsKey(integer)){
					map.get(integer).add(new BeanInteger(num[i], i, num[j], j));
				}else{
					LinkedList<BeanInteger> ll = new LinkedList<>();
					ll.add(new BeanInteger(num[i], i, num[j], j));
					map.put(integer, ll);
				}
			}
		}

		for(int i = 0; i < num.length; i++){
			if(map.containsKey(Integer.valueOf(target - num[i]))){
				LinkedList<BeanInteger> list = map.get(Integer.valueOf(target - num[i]));
				for(BeanInteger bean : list){
					if(bean.firstIndex != i && bean.secondIndex != i){
						LinkedList<Integer> llTmp = new LinkedList<Integer>();
						llTmp.add(bean.firstValue);
						llTmp.add(bean.secondValue);
						llTmp.add(num[i]);
						res.add(llTmp);
					}
				}

			}
		}

		return res;
	}

	static class BeanInteger{
		public int firstValue;
		int firstIndex;

		public int secondValue;
		int secondIndex;

		public BeanInteger(int firstValue, int firstIndex, int secondValue, int secondIndex){
			this.firstValue = firstValue;
			this.firstIndex = firstIndex;
			this.secondValue = secondValue;
			this.secondValue = secondValue;
		}
	}

}
