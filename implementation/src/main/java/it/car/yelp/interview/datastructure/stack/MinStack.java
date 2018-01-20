package it.car.yelp.intrw.datastructure.stack;

import java.util.Arrays;

public class MinStack <T extends Comparable<T>> {

	@SuppressWarnings("unchecked")
	T[] arr = (T[])new Object[100]; // (E[]) new Object[size]
	int N = 0;
	int initialSize = 25;


	public void push(T x) {

		if(N == arr.length -1){
			Arrays.copyOf(arr, N*2);
		}

		arr[N] = x;
		N++;
	}

	public void pop() {

		if(N<arr.length/4){
			Arrays.copyOf(arr, arr.length/2);
		}

		arr[--N] = null;
	}

	public T top() {
		return arr[N-1];
	}

//	public T getMin() {
//		int min = arr[0];
//		for(int  i = 0 ; i < N; i++){
//			if(arr[i]<min) min = arr[i];
//		}
//
//		return min;
//	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder b = new StringBuilder();
		for(int i = 0; i < N; i++){
			b.append(arr[i] + " ");
		}
		return b.toString();
	}
	
	public static void main(String args[]){
		MinStack<Integer> stack = new MinStack<Integer>();
		for(int i = 1; i <= 50; i++){
			stack.push(i);
		}
		
		for(int i = 0; i < 49; i++){
			stack.pop();
		}
		
		System.out.println(stack);
	}
	

}
