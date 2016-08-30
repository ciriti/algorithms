package it.car.yelp.intw.pi;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	public static void main(String args[]){
		
		int num = 500000;
		
		long start = System.nanoTime();
//		System.out.println(fibonacci(num));
//		System.out.println("tempo: " + (System.currentTimeMillis() -start));
//		System.out.println("---------------------------------");
//		start = System.nanoTime();
//		System.out.println(fibonacciPD(num));
//		System.out.println("tempo: " + (System.nanoTime() -start));
//		System.out.println("---------------------------------");
		start = System.nanoTime();
		System.out.println(fibonacciMostImpro(num));
		System.out.println("tempo: " + (System.nanoTime() -start));
	}
	
	public static long fibonacciMostImpro(long n){
		
		int n1 = 1;
		int n2 = 1;
		int current = 0;
		for(long i = 3l; i <= n; i++){
			current = n1 + n2;
			n2 = n1;
			n1 = current;
		}
		
		return current;
	}
	
	public static long fibonacciImpro(long n){
		long[] arr = new long[(int)n+1];
		arr[0] = 1;
		arr[1] = 1;
		if(n<3) return arr[(int)n];
		int size = (int)n;
		for(int i = 2; i < size+1; i++){
				arr[i] = arr[i-1] + arr[i-2];	
		}
		return (arr[(int)n-1] + arr[(int)n-2]);
	}

	public static long fibonacci(long n){
		if( n== 0 || n == 1)
			return 1;
		return fibonacci(n-1)+fibonacci(n-2);
	}

	public static long fibonacciPD(long n){

		//Map to store the previous results
		Map<Long,Long> computedValues = new HashMap<Long, Long>();
		computedValues.put(0l, 1L);
		computedValues.put(1l, 1L);

		return fibonacciPDRec(n, computedValues);
	}

	private static long fibonacciPDRec(long n, Map<Long, Long> computedValues) {
		// TODO Auto-generated method stub

		if(computedValues.containsKey(n))
			return computedValues.get(n);
		
		computedValues.put(n-1, fibonacciPDRec(n-1, computedValues));
		computedValues.put(n-2, fibonacciPDRec(n-2, computedValues));
		

		long res = computedValues.get(n-1) + computedValues.get(n-2);
		computedValues.put(n, res);
		return res;
	}
	
	
	/**
	 * You are climbing a stair case. It takes n steps to reach to the top. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	 * La soluzione  la serie di fibonacci
	 * https://leetcode.com/problems/climbing-stairs/
	 * @param n
	 * @return
	 */
	public static int climbStairs(int n) {
		 if(n == 0 || n == 1) return 1;
	        int tmp1 = 1;
	        int tmp2 = 1;
	        int res = 0;
	        int i = 2;
	        while(i++<n+1){
	            res = tmp1 + tmp2;
	            tmp2 = tmp1;
	            tmp1 = res;
	        }
	        
	        return res; 
    }

}
