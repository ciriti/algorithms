package it.home.isnumber;

public class CheckIsAnumber {
	
	/**
	 *  IS A NUMBER
	 * @param num
	 */
	public static boolean checkString(String num){

		// 
		if(num.length()==0) return false;
		
		
		for(int i = num.charAt(0)=='-'?1:0; i<num.length(); i++){
			if(	(!(((int)num.charAt(i))<=((int)'9') && num.charAt(i)>=((int)'0'))) || num.charAt(i)==' '){
				return false;
			}
		}
		
		return true;
	}

	public static void main(String arg[]){

		String test = "1234981274";
		long start = 0;
		long finish = 0;
		start = System.nanoTime();
		check(test);
		finish = System.nanoTime();
		System.out.println("Array: " + (finish-start));

		System.out.println("*********************************");

		start = System.nanoTime();
		checkInteger(test);
		finish = System.nanoTime();
		System.out.println("Integer: " + (finish-start));

		System.out.println("*********************************");

		start = System.nanoTime();
		System.out.println(checkString(test));
		finish = System.nanoTime();
		System.out.println("String: " + (finish-start));
		
		System.out.println("*********************************");

		start = System.nanoTime();
		checkRegex(test);
		finish = System.nanoTime();
		System.out.println("Regex: " + (finish-start));
	}

	public static void checkInteger(String num){

		if(num.length()==0){
			System.out.println(false);
			return;
		}
		try{
			int i = Integer.parseInt(num);
			System.out.println(true);
		}catch(Exception e){
			System.out.println(false);
		}
	}


	public static void check(String num){

		if(num.length()==0){
			System.out.println(false);
			return;
		}

		char []arr = num.toCharArray();
		for(int i = 0; i<arr.length; i++){
			if((arr[i]>=9 && arr[i]<=0)  || num.charAt(i)!=' '){
				System.out.println(false);
				return;
			}
		}
		System.out.println(true);


	}

	public static void checkRegex(String num){

		System.out.println(num.matches("-?[0-9]+"));

	}

}
