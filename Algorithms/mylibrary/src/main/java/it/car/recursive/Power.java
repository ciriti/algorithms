package it.car.recursive;

public class Power {
	
	
	/**
	 * CALCOLARE POTENZA
	 * @param k
	 * @param j
	 * @return
	 */
	private static int pwr(int k, int j) {
		// TODO Auto-generated method stub
		if(j == 0) return 1;
		if(j == 1) return k;
		return k*pwr(k, j-1);
	}
	
	/**
	 * ----------------------------------------------------------------------------------------
	 * @param args
	 */
	public static void main(String args[]){
		System.out.println(pwr(2, 5));
	}

}
