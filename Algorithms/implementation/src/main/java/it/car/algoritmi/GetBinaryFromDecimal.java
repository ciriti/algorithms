package it.car.algoritmi;

import java.util.Stack;

public class GetBinaryFromDecimal {
	
	public static void main(String args[]){
		thirdForm();
	}
	
	/**
	 * third form
	 */
	
	public static void thirdForm(){
		third(10);
	}
	
	public static void third(int n){
		StringBuffer sb = new StringBuffer();
		binaryThree(n, sb);
		System.out.println(sb.toString());
	}
	
	private static void binaryThree(int n, StringBuffer sb) {
		if(n==0) return;
		binaryThree(n/2, sb);
		sb.append(n%2);
	}

	/**
	 * second form
	 */
	
	public static void secondForm(){
		System.out.println(binaryTwo(10));
	}
	
	private static String binaryTwo(int n) {
		
		StringBuffer sb = new StringBuffer();

		for(int i = 0; i < 32; i++){
			sb.append((n&(1<<(31-i)))!=0?1:0);
		}		
		//TODO
		return sb.toString().replaceAll("^0+1[0-1]*$", "\1");
	}

	/**
	 * first form
	 */
	
	public static  void firstForm(){
		stack = new Stack<>();
		binary(5);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
	
	static Stack<String> stack;
	
	static void binary(int i){
		
		/**
		 * condizione di termine
		 */
		if(i == 1 || i == 0) {
			stack.add(String.valueOf(i));
			return;
		}
		
		/**
		 * inserisco il modulo nella struttura dati
		 */
		stack.add(String.valueOf(i%2));
		
		/**
		 * calcolo il succession modulo
		 */
		binary(i/2);
		
	}
	

}
