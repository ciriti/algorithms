package it.car.yelp.intrw.bitmanipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

public class DnaSequence {

	public static void main(String args[]){
		//		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		//		List<String> res = findRepeatedDnaSequences(s);
		//		System.out.println(res);
		;
//		System.out.println(majorityElement(new int[]{2}));
		System.out.println(reverseBits(1));
	}

	public static List<String> findRepeatedDnaSequences(String s) {

		List<String> res = new ArrayList<String>();
		Set<String> map = new HashSet<String>();

		for(int i = 0; i < s.length() -10 ; i++){
			String test = s.substring(i, i+10);
			if(map.contains(test)){
				res.add(test);
			}else{
				map.add(test);
			}
		}
		return res;
	}

	public static int hammingWeight(int n) {
		int num  = 0;

		for(int i = 1; i <= 32; i++){
			if((n&(1<<i))==1){
				num++;
			}
		}

		return num;
	}

	public static int majorityElement(int[] num) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = -1;
		if(num.length ==1) return num[0];
		for(int i = 0; i< num.length; i++){
			if(map.containsKey(num[i])){
				map.put(num[i], map.get(num[i])+1);
				if(map.get(num[i]) > num.length/2) {
					max = map.get(num[i]); 
					break;
				}

			}else{
				map.put(num[i], 1);
			}

		}
		return max;
	}
	public static int majorityElement1(int[] num) {
		int max = -1;

		int dim = num.length;
		if(dim ==1) return num[0];
		int[] numTmp = num;
		Arrays.sort(numTmp);
		max = num[0];
		int numOccurrence = 1;
		for(int i = 1; i < dim; i++){
			if(max == num[i]){
				numOccurrence++;
				if(numOccurrence > dim/2)return max;
			}else{
				max = num[i];
				numOccurrence = 1;
			}
		}
		return max;
	}

	public static int reverseBits(int n) {
		int res = 0;
		boolean[] bit = new boolean[33];
		for(int i = 0; i < 32; i++){
			bit[i] = (n&(1<<(31-i))) != 0?true:false;
//			res = res | ((bit[i]?1:0)<<i);
		}
		
		for(int i = 0; i < 32; i++){
			res = res | ((bit[i]?1:0)<<i);
		}
		
		return res;
	}

}
