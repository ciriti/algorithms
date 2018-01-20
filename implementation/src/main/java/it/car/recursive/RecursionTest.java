package it.car.recursive;

public class RecursionTest {

	private static int serieDiFibonacci(int i) {

		if(i<1) throw new IllegalArgumentException("Valore non valido!!!");
		if(i==1 || i==2)
			return 1;
		return serieDiFibonacci(i-1) + serieDiFibonacci(i-2);
	}

	/**
	 * ------------------------------------------------------------------
	 * MAIN
	 */
	public static void main(String args[]){

		for(int i = 1; i<= 10; i++)
			System.out.print(String.format("%-3d", serieDiFibonacci(i)));
	}



}
