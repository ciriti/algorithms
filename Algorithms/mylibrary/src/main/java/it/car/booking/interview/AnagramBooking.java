package it.car.booking.interview;

import java.util.ArrayList;
import java.util.LinkedList;

public class AnagramBooking {
	
	public static void main(String args[]){
		LinkedList<String> queue = new LinkedList<>();
		String test = "abc";
		String resto = new StringBuilder(test).deleteCharAt(0).toString();
		queue.offerLast(String.valueOf(test.charAt(0)));
		ArrayList<String> parziale = new ArrayList<>(queue);
		for(int i = 1; i< resto.length(); i++){
			
		}
		
		insertAnyWhere("b", 'a', null);
		
		
	}
	
	public static void insertAnyWhere(String stringTmp, char ch, LinkedList<String> queue){
		String tmp = ch + stringTmp;
		for(int i = 0; i < tmp.length() - 1 ; i++){
			swap(tmp.toCharArray(), i, i+1, queue);
		}
	}
	
	public static void swap(char[] stringArr, int index1, int index2, LinkedList<String> queue){
		System.out.println(stringArr);
		char a = stringArr[index1];
		stringArr[index1] = stringArr[index2];
		stringArr[index2] = a;
		//queue.offer(new String(stringArr));
		System.out.println(stringArr);
	}

}
