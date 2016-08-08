package it.car.yelp.interview.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum4 {

	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> listaRes = new ArrayList<>();
		HashMap<Integer, ArrayList<Bean>> mapSumCouple = new HashMap<>();

		for(int i = 0; i < num.length; i++){
			for(int j = i + 1; j < num.length; j++){
				if(mapSumCouple.containsKey(Integer.valueOf(num[i] + num[j]))){
					Bean bean = new Bean(num[i], i, num[j], j);
					mapSumCouple.get(num[i] + num[j]).add(bean);
				}else{
					ArrayList<Bean> subMap =  new ArrayList<>();
					Bean bean = new Bean(num[i], i, num[j], j);
					subMap.add(bean);
					mapSumCouple.put((Integer.valueOf(num[i] + num[j])), subMap);
				}
			}
		}

		Set<Integer> keys = mapSumCouple.keySet();
		HashSet<List<Integer>> hasS = new HashSet<>();

		for(Integer i : keys){
			if(mapSumCouple.containsKey(target - i.intValue())){
				ArrayList<Bean> subKeys1 = mapSumCouple.get(i.intValue());
				ArrayList<Bean> subKeys= mapSumCouple.get(target - i.intValue());
				for(Bean b : subKeys){
					for(Bean a : subKeys1){
						if((b.isValid(a))){
							List<Integer> tmp = new ArrayList<Integer>(4);
							tmp.add(b.x);
							tmp.add(b.y);
							tmp.add(a.x);
							tmp.add(a.y);
							Collections.sort(tmp);

							hasS.add(tmp);
						}

					}
				}
			}
		}
		listaRes.addAll(hasS);
		return listaRes;
	}

	public  static boolean exist(ArrayList<Bean> arr, Bean b){
		for(Bean bb : arr){
			if(b.xIndex == bb.xIndex || b.xIndex == bb.yIndex || b.yIndex == bb.xIndex || b.yIndex == bb.yIndex){
				return true;
			}
		}
		return false;
	}

	static class Bean{

		int x;
		int y;

		int xIndex;
		int yIndex;

		public Bean(int x, int xIndex, int y, int yIndex){
			this.x = x;
			this.y = y;
			this.xIndex = xIndex;
			this.yIndex = yIndex;
			//			if(x == y) 
				//				throw new InvalidParameterException("x[" + x + "]  y[" + y + "]");
		}

		public boolean isValid(Bean b){

			if(b.xIndex == this.xIndex || b.xIndex == this.yIndex || b.yIndex == this.xIndex || b.yIndex == this.yIndex){
				return false;
			}

			return true;
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			int hash = 17;
			hash += x;
			hash += y;
			return hash;
		}
	}

}
