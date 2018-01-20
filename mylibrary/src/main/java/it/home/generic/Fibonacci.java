package it.home.generic;

public class Fibonacci {
	
	
	/**
	 * 
	 * @param pos
	 * @return
	 */
	private static int calFib(int pos) {
		if(pos == 1 || pos == 2){
			return 1;
		}
		return calFib(pos-1) + calFib(pos-2);
	}
	
	/**
	 * -------------------------------------------------------------------------
	 * @param args
	 */

	public static void main(String args[]){
		int fibonacci = 6;
//		calcolaFibonacci(fibonacci);
		table();
		ricalcolaFibonacci();
	}

	private static void ricalcolaFibonacci() {
		
		int pos = 6;
		System.out.println("Ricalcola fibonacci: " + calFib(pos));
		
	}



	private static void calcolaFibonacci(int fibonacci) {
		// TODO 1,1,2,3,5,8,13,21,34,55,89,144,...
		for ( int i = 0; i < 10; i++ ) {
			System.out.print ( fib(i) + ", " );
		}
		System.out.println ( fib(10) );
	}

	static long fib(int n) {
		return n <= 1 ? n : fib(n-1) + fib(n-2);
	}

	public static void table(){
		
		for(int i = 1; i<10 ; i ++){
			for(int j = 1; j < 10; j++){
				System.out.print(String.format("%5s", i*j));
			}
			System.out.println("");
		}
	}
}
