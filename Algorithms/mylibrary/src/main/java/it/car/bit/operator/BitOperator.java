package it.car.bit.operator;

public class BitOperator {

	/**
	 * ARRAY di BIT
	 * @param num
	 * @return
	 */
	public static boolean[] getBitFromInt(int num){

		int numOfBit = countBits(5);
		boolean[] res= new boolean[numOfBit];
		for(int i = numOfBit-1; i >= 0; i--){
			res[i] = (num & 1<<i) == 1;
		}
		return res;
	}

	/**
	 * NUMERO DI BIT
	 * @param arg
	 */

	public static int countBits(int num) {
		int result = 0;
		while (num > 0) {
			num = num >> 1;
			result++;
		}
		return result;
	}


	/**
	 * ---------------------------------------------------------------------------------------------------------------------------
	 * @param arg
	 */
	
	
	public static void main(String arg[]){
		System.out.println(getBitFromInt(5)+"");
	}

	public static void complementOperator(){

		int number = 8; //0000 1000
		System.out.println("Original number : " + number);

		//left shifting bytes with 1 position
		number = number<<1; //should be 16 i.e. 0001 0000

		//equivalent of multiplication of 2
		System.out.println("value of number after left shift: " + number);

		number = -8;
		//right shifting bytes with sign 1 position
		number = number>>1; //should be 16 i.e. 0001 0000

		//equivalent of division of 2
		System.out.println("value of number after right shift with sign: " + number);

		number = -8;
		//right shifting bytes without sign 1 position
		number = number>>>1; //should be 16 i.e. 0001 0000

		//equivalent of division of 2
		System.out.println("value of number after right shift with sign: " + number);



	}

}
