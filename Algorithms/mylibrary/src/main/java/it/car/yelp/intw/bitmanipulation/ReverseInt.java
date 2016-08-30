package it.car.yelp.intw.bitmanipulation;

import java.util.Arrays;

public class ReverseInt {

	public static void main(String args[]){
		//		System.out.println(reverse1(153423646));
		//		System.out.println(isPalindrome(-2147447412));
		//		System.out.println(multiply("12", "15"));
		char[] arr = new char[]{'c','v','a'};
		Arrays.sort(arr);
		System.out.println(divide(2147483647, 2));
	}

	public static int reverse1(int x) {
		if(x==0)return 0;

		int res = 0;
		int c = Math.abs(x);
		int signum = Math.abs(x)/x;
		while(c>0){
			res = res *10 + c%10;
			c = c/10;
		}

		return res*signum;
	}

	public static int reverse(int x) {

		int rev = 0;
		while(x != 0){
			rev = rev*10 + x%10;
			x = x/10;
		}

		return rev; 

	}

	public static boolean isPalindrome(int x) {
		String s = String.valueOf(x);
		s = s.replaceAll("-", "");
		for(int i = 0; i< s.length()/2; i++){
			if(s.charAt(i)!=s.charAt(s.length()-1-i))
				return false;
		}
		return true;
	}

	public static String multiply(String num1, String num2) {
		int[] arr1 = new int[num1.length()];
		int[] arr2 = new int[num2.length()];

		for(int i = 0; i < num1.length(); i++){
			arr1[i] = (num1.charAt(i)-'0');
		}

		for(int i = 0; i < num2.length(); i++){
			arr2[i] = (num2.charAt(i)-'0');
		}

		int[] result = new int[num1.length() + num1.length()];
		Arrays.fill(result, 0);
		int [][] partial = new int[arr2.length][arr1.length];

		int carry = 0;
		int cursorArray = 0;
		for(int i = arr1.length-1; i >= 0; i--){
			for(int j =  arr2.length - 1; j >= 0; j--){

				int[] resProd = prodotto2(arr1[j], arr2[i]);
				int[] resSum = sommaDue(carry, resProd[1]);
				partial[j][i] = resSum[1];
				carry = resSum[0] + resProd[0];				

			}
		}
		return "";
	}

	static int[] sommaTre(int a, int b, int c){
		int res = a + b + c;
		int carry = res/10;
		int sum = res%10;
		return new int[]{carry, sum};
	}

	static int[] sommaDue(int a, int b){
		int res = a + b;
		int carry = res/10;
		int sum = res%10;
		return new int[]{carry, sum};
	}
	static int[] prodotto2(int a, int b){
		int res = a * b;
		int carry = res/10;
		int sum = res%10;
		return new int[]{carry, sum};
	}

	public static double pow(double x, int n) {

		if(n==0) return 1;
		if(n==1) return x;

		int signumP = Math.abs(n)/n;

		double res = 0;


		return (signumP>0?res:(1/res));

	}


	public static double pow2(double x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x;

		int pn = n > 0 ? n : -n;// positive n
		int pn2 = pn;

		double px = x > 0 ? x : -x;// positive x
		double result = px;

		int k = 1;
		//the key part of solving this problem
		while (pn / 2 > 0) {
			result = result * result;
			pn = pn / 2;
			k = k * 2;
		}

		result = result * pow(px, pn2 - k);

		// handle negative result
		if (x < 0 && n % 2 == 1)
			result = -result;

		// handle negative power
		if (n < 0)
			result = 1 / result;

		return result;
	}

	public static int divide(int dividend, int divisor) {
		
		int res = 1;
		int count = 0;
		int copy = divisor;
		
		for(int i = 0; i <31; i++){
			res = res|(1<<i);
		}
		
		return res;
	}

}
