package it.car.recursive;

public class Fattoriale {

	/**
	 * FATTORIALE
	 * @param i
	 * @return
	 */
	private static int fattoriale(int i) {
		// TODO Auto-generated method stub
		if(i==0 | i ==1)
			return 1;
		return i*fattoriale(i-1);
	}
	
	/**
	 * ------------------------------------------------------------------------------------------
	 * @param args
	 */
	
	public static void main(String args[]){

		System.out.println(fattoriale(6));
	}


}
