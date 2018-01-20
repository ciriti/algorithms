package it.car.yelp.intrw.combinator;

public class PrincetonPermutationK {

	static int count = 0;

	public static void choose(char[] a, int R) { 
		enumerate(a, a.length, R); 
	}

	private static void enumerate(char[] a, int lengthArr, int dimGroup) {
		if (dimGroup == 0) {
			for (int i = lengthArr; i < a.length; i++)
				System.out.print(a[i]);
			System.out.println();
			count++;
			return;
		}
		for (int i = 0; i < lengthArr; i++) {
			swap(a, i, lengthArr-1);
			enumerate(a, lengthArr-1, dimGroup-1);
			swap(a, i, lengthArr-1);
		}
	}  

	// helper function that swaps a[i] and a[j]
	public static void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}


	// sample client
	public static void main(String[] args) {
		//        int N = Integer.parseInt(args[0]);
		//        int k = Integer.parseInt(args[1]);
		String elements = "abcdaefhil";

		int N = elements.length();
		int k = 7;

		char[] a = new char[N];
		for (int i = 0; i < N; i++)
			a[i] = elements.charAt(i);
		choose(a, k);

		System.out.println("count : " + count);
	}
}
