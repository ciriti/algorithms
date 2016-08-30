package it.car.yelp.intw.math;

import java.util.LinkedList;
import java.util.Queue;

public class UglyNumber {
	
	/**
	 * 
	 * Write a program to check whether a given number is an ugly number.
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
	 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
	 * Note that 1 is typically treated as an ugly number.
	 * 
	 * LINK - https://leetcode.com/problems/ugly-number/
	 * @param num
	 * @return
	 */

	public static boolean isUgly(int num) {

		int tmp = num;
        if(tmp == 1) return true;
		while(tmp!=1 && tmp!= 0){

			if(tmp / 2 == 1 && tmp % 2 == 0 || tmp / 3 == 1 && tmp % 3 == 0 || tmp / 5 == 1 && tmp % 5 == 0){
				return true;
			}

			if(tmp % 2 == 0 && tmp / 2 != 1){
				tmp = ((tmp / 2));
			}else if(tmp % 3 == 0 && tmp / 3 != 1){
				tmp = ((tmp / 3));
			}else if(tmp % 5 == 0 && tmp / 5 != 1){
				tmp = ((tmp / 5));
			}else{
            	return false;
            }

		}

		return false;
	}
	
	    public static boolean  isUglyQueue(int num) {
	        
	        Queue<Integer> qu = new LinkedList<>();
	        
	        qu.add(num);
	        
	        while(!qu.isEmpty()){
	            
	            Integer tmp = qu.poll();
	            
	            if(tmp / 2 == 1 || tmp / 3 == 1 || tmp / 5 == 1){
	                return true;
	            }
	            
	            if(tmp % 2 == 0 && tmp / 2 != 1){
	                qu.add((tmp / 2));
	            }else if(tmp % 3 == 0 && tmp / 3 != 1){
	                qu.add((tmp / 3));
	            }else if(tmp % 5 == 0 && tmp / 5 != 1){
	                qu.add((tmp / 5));
	            }else{
	            	return false;
	            }
	            
	        }
	        
	        return false;
	    }
	
	public static void main(String args[]){
		long statrt = System.nanoTime();
		System.out.println("is ugly number? " + isUgly(7) + " " + (System.nanoTime()-statrt));
		statrt = System.nanoTime();
//		System.out.println("is ugly number queue? " + isUglyQueue(-1000) + " " + (System.nanoTime()-statrt));
	}

}
