package it.car.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergesortGeneric<T extends Comparable<T>> {
	
	public static void main(String args[]){
		List<Integer> arr = new ArrayList<>();
		arr.add(9);
		arr.add(8);
		arr.add(7);
		arr.add(6);
		arr.add(5);
		arr.add(4);
		arr.add(3);
		arr.add(2);
		new MergesortGeneric<Integer>().sort(arr);
		System.out.println("Res:");
		for(Integer t: arr){
			System.out.print(t + " ");
		}
	}

	public void sort(List<T> data){
		List<T> res = sortRec(data);
		Collections.copy(data, res);
		
	}
	
	protected List<T> sortRec(List<T> data){
		
		if(data.size() == 1)
			return data;
		
		List<T> first = sortRec(data.subList(0, data.size()/2));
		List<T> second = sortRec(data.subList(data.size()/2, data.size()));
		
		int i = 0;
		int j = 0;
		
		List<T> res = new ArrayList<>(first.size() + second.size());
		
		while(i < first.size() || j < second.size()){
			if(i < first.size() && j < second.size()){
				if(first.get(i).compareTo(second.get(j)) < 0){
					res.add(first.get(i));
					i++;
				}else{
					res.add(second.get(j));
					j++;
				}
			}else if(i < first.size()){
				res.add(first.get(i));
				i++;
			}else if(j < second.size()){
				res.add(second.get(j));
				j++;
			}
			
		}
		
		return res;
	}

	void print(List<T> data){
		for(T t: data){
			System.out.print(t + " ");
		}
		System.out.println();
	}

}
