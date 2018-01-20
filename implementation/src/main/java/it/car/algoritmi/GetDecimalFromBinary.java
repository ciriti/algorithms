package it.car.algoritmi;


public class GetDecimalFromBinary {

	public static void main(String args[]){
		thirdForm();
	}
	
	/**
	 * start third form
	 */
	public static void thirdForm(){
		System.out.println(binToDec("101"));
	}
	
	public static int binToDec(String s) {
		// TODO Auto-generated method stub
		int res = 0;
		
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(s.length()-1-i)=='1')
				res = res | (1<<i);
		}
		
		return res;
	}

	/**
	 * start second form
	 */
	
	public static void secondForm(){
		System.out.println(binaryToDecimal("10"));
	}
	
	public static int binaryToDecimal(String b){		
		int res = 0;
		
		for(int i = 0; i < b.length(); i++){
			res += b.charAt(b.length()-1-i)=='0'?0:Math.pow(2, i);
		}
		
		return res;
	}

	/**
	 * start first form
	 */
	static int decimale = 0;

	static void decimale(String str, int index){
		if(index < 0) return;
		decimale += (str.charAt(index)-'0') * Math.pow(2, str.length()-1 - index);
		decimale(str, index-1);
	}	

	public static void firstForm(){
		String binario = "1110";
		decimale(binario, binario.length()-1);
		System.out.println("" + decimale);
	}

}
