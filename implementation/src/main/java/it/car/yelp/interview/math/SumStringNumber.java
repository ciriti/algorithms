package it.car.yelp.intrw.math;

public class SumStringNumber {

	public static void main(String[] args) {
		System.out.println(sumTwoString("10","10"));
	}

	public static String sumTwoString(String s1, String s2){

		int sizeS1 = s1.length();
		int sizeS2 = s2.length();

		int maxSize = Math.max(sizeS1 , sizeS2) + 2;

		int numS1 = 0;
		int numS2 = 0;

		int sum = 0;
		int carry = 0;
		int count = 0;

		int[] res = new int[maxSize];

		for(int i = 0; i < maxSize; i++){
			numS1 = i<sizeS1?Integer.valueOf(s1.substring(sizeS1-1-i, sizeS1-i)):0;
			numS2 = i<sizeS2?Integer.valueOf(s2.substring(sizeS2-1-i, sizeS2-i)):0;
			if(i<sizeS1 || i<sizeS2) count++;
			sum = numS1 + numS2 + carry;
			carry = sum/10;
			sum = sum%10;
			res[res.length-1-i] = sum;
			
		}

		res[res.length-1-count] = carry;

		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < res.length; i++){
			sb.append(res[i]);
		}

		return sb.toString();
	}

}
