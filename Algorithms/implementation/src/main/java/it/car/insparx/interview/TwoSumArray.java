package it.car.insparx.xsum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumArray {

	public static void main(String args[]){
		System.out.println(solution(6, new int[]{1, 8, -3, 0, 1, 3, -2, 4, 5}));
	}

	public static  int solution(int K, int[] A) {
		// write your code in Java SE 8

		//IDEA : if A[i]+A[j]=k => k - A[j] = A[i]; 

		int count = 0;
		Map<Integer, List<Bean>> map = new HashMap<>();
		int tmp = 0;

		for(int i = 0; i < A.length; i++){

			tmp = K - ( A[i] );
			if(map.containsKey(tmp)){
				map.get(tmp).add(new Bean(A[i], i));
			}else{
				Bean b = new Bean(A[i], i);
				List<Bean> list = new ArrayList<>();
				list.add(b);
				map.put(tmp, list);                
			}            
		}

		for(int i = 0; i < A.length; i++){
			if(map.containsKey(A[i])){
				List<Bean> list = map.get(A[i]);
				for(Bean b : list){
					//                    if(b.index != i)
						System.out.println("index: " + i + " bean index" + b.index);
					count++;
				}

			}
		} 
		return count;
	}

	public static class Bean{
		public int value;
		public int index;

		public Bean(int value, int index){
			this.index = index;
			this.value = value;
		}

		public boolean isValid(int index){
			if(this.index == index){
				return false;
			}
			return true;
		}

	}

}
