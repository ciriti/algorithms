package it.car.yelp.interview.combinator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	/**
	 * Dammi tutti i sub set per cui la somma dei numeri contenuti  unguale a quella richiesta
	 * @param args
	 */
	
	public static void main(String args[]){
		int[] test = new int[]{14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,
				30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
		int[] test1 = new int[]{1,1};
		System.out.println(combinationSum2(test, 27));
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

		// I'll create the Ntn subset from the N-1tn subset
		/**
		 * ---------------> KEY <--------------- 
		 * 
		 * I have to eliminate all number who are greater than the request sum
		 */

		int[] supp = candidates;
		
		Arrays.sort(supp);
		
		int limit = supp.length-1;
		for(int i = 0; i < supp.length; i++){
			if(supp[i]>target){
				limit = i;
				break;
			}
		}
		
		supp = Arrays.copyOf(supp, limit+1);
		
		List<Integer> container = new ArrayList<>();
		for(int i : supp){
			container.add(i);
		}
		
		

		// creating result list
		List<List<Integer>> res = new ArrayList<>();

		// creating a fully subset list
		List<List<Integer>> fully = new ArrayList<>();
		// creating all subset
		for(int i = 0; i < container.size(); i++){

			// temporany list
			List<List<Integer>> tmp = new ArrayList<>();

			// creating a copy of the fully list
			int sum = 0;
			for(List<Integer> l : fully){
				for(Integer integer : l){
					sum += integer;
				}
				if(sum == target){
					res.add(l);
				}else if(sum + container.get(i) <= target){
					
					if(sum + container.get(i) == target){
						l.add(container.get(i));
						res.add(new ArrayList<>(l));
					}else
						tmp.add(new ArrayList<>(l));			
					
				}
				sum = 0;
			}

			// adding another element to the oeiginal list
			for(List<Integer> l : tmp){
				l.add(container.get(i));
			}

			// adding the current element
			List<Integer> curr = new ArrayList<>();
			curr.add(container.get(i));
			tmp.add(curr);

			// adding all new subset
			fully.clear();
			fully.addAll(tmp);

		}

		// foreach list in fully I'll adding all value of the element to verify 
		// if the sum is equals to target
		int sum = 0;
		for(List<Integer> ll : fully){
			for(Integer i : ll){
				sum += i;
			}
			if(sum == target)
				res.add(ll);
			sum = 0;
		}

		return res;
	}

}
