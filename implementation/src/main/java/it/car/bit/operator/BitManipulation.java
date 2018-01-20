package it.car.bit.operator;

public class BitManipulation {
	
	public static void main(String arg[]){
//		char[] res = getBit(4);
//		for(char a : res){
//			System.out.print(a + " ");
//		}
		System.out.println();
		String test = "";
		test.concat("");
	}
	
	
	
	public static int sommaDueInteri(int a, int b){
		
		return 0;
	}
	
	/**
	 * restituisce un array di char con i bit che formano n
	 * @param n
	 * @return
	 */
	public static char[] getBit(int n){
		
		int countBit = 0;
		int copy = n;
		
		while(copy>0){
			countBit++;
			copy = copy>>1;
		}
		
		char[] arr = new char[countBit];
		
		copy = n;
		int count = 0;
		while(copy>0){
			countBit++;
			arr[arr.length-1 - count] = (char)((copy&1) + '0');
			copy = copy>>1;
			count++;
		}
		
		return arr;
	}
	
	public static void test(){
		System.out.println(10|3); // è 11
		System.out.println(11 & 3);
		System.out.println(11 & 4);
		System.out.println(11 & 9);
		System.out.println(11 & 20);
		System.out.println(11 & 6);
		
	}

}
