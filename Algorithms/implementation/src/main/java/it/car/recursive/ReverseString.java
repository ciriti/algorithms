package it.car.recursive;


public class ReverseString {
	
	public static String reverseStringNormal(String test){
		
		int dim = test.length();
		StringBuffer builder = new StringBuffer();
		for(int i = dim-1; i>=0; i--){
			builder.append(test.charAt(i));
		}
		return builder.toString();
	}
	
	public static void scambiaChar(char a, char b){
		char temp = a;
		a=b;
		b=temp;
	}

	private static String reverseString(String reverse, int start, int finish) {
		// TODO Auto-generated method stub

		if(reverse.length() == 1 || reverse.length() == 0 || start == finish)
			return reverse;

		if(reverse.length() == 2)
			return reverse.toCharArray()[finish]+""+reverse.toCharArray()[start];

		char[] tmp = reverse.toCharArray();
		char cTemp = tmp[start];
		tmp[start] = tmp[finish];
		tmp[finish] = cTemp;

		return reverseString(new String(tmp), start+1, finish-1);

	}
	
	/**
	 * -------------------------------------------------------------------------------------------
	 * @param args
	 */
	
	public static void main(String args[]){

		String reverse = "abc";
//		System.out.print(reverseString(reverse, 0, reverse.length()-1));
		System.out.println(reverseStringNormal(reverse));

	}

}
