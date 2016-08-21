package it.car.booking.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindNonCommonElementInArray {

	public static void main(String args[]){

		/**
		 * INIZIO
		 */
		long startTime = System.nanoTime();
		System.out.println();
		startTime = System.nanoTime();
		char[] resC = intersect(new char[]{'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'C'}, new char[]{'b', 'b', 'b', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'});
		for (char c : resC) {
			System.out.print(c + " ");
		}
		System.out.print("\n intersect time[" + (System.nanoTime() - startTime) + "]\n\n");

		
		/**
		 * PRIMO
		 */
		System.out.println();
		startTime = System.nanoTime();
		char[] resCC = charIntersect(new char[]{'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'C'}, new char[]{'b', 'b', 'b', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'});
		for (char c : resCC) {
			if(c != ' ')
				System.out.print(c + " ");
		}
		System.out.print("\n charIntersect time[" + (System.nanoTime() - startTime) + "]\n\n");

		
		/**
		 * SECONDO
		 */
		System.out.println();
		startTime = System.nanoTime();
		char[] resIntersectBest = charIntersectBest(new char[]{'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'C'}, new char[]{'b', 'b', 'b', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'});
		for (char c : resIntersectBest) {
			if(c != ' ')
				System.out.print(c + " ");
		}
		System.out.print("\n charIntersect best time[" + (System.nanoTime() - startTime) + "]\n\n");
		
		
		/**
		 * TERZO
		 */
		System.out.println();
		startTime = System.nanoTime();
		char[] resSymmetric = symmetricDifference(new char[]{'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'C'}, new char[]{'b', 'b', 'b', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'});
		for (char c : resSymmetric) {
			if(c != ' ')
				System.out.print(c + " ");
		}
		System.out.print("\n charIntersect resSymmetric time[" + (System.nanoTime() - startTime) + "]\n\n");
		
		/**
		 * QUARTO
		 */
		System.out.println();
		startTime = System.nanoTime();
		char[] resSymmetric2 = symmetricDifference2(new char[]{'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'C'}, new char[]{'b', 'b', 'b', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'});
		for (char c : resSymmetric2) {
			if(c != ' ')
				System.out.print(c + " ");
		}
		System.out.print("\n charIntersect resSymmetric2 time[" + (System.nanoTime() - startTime) + "]\n\n");

		//System.out.println("\n" + findNumberOfBits(12, 16));
	}

	public static char[] symmetricDifference(char[] a, char[] b){

		Set<Character> setA = new HashSet<Character>();
		Set<Character> setB = new HashSet<Character>();

		for(int i = 0; i<a.length; i++){
			setA.add(a[i]);
		}

		for(int i = 0; i<b.length; i++){
			setB.add(b[i]);
		}

		// Present our initial data set
//		System.out.println("In set A: " + setA);
//		System.out.println("In set B: " + setB);

		// Option 1: union of differences
		// Get our individual differences.
		Set<Character> notInSetA = new HashSet<Character>(setB);
		notInSetA.removeAll(setA);
		Set<Character> notInSetB = new HashSet<Character>(setA);
		notInSetB.removeAll(setB);

		// The symmetric difference is the concatenation of the two individual differences
		Set<Character> symmetricDifference = new HashSet<Character>(notInSetA);
		symmetricDifference.addAll(notInSetB);
		
		char[] res = new char[symmetricDifference.size()];
		int count = 0;
		for(Character ch : symmetricDifference){
			res[count++] = ch;
		}
		
		return res;

	/*	// Option 2: union minus intersection
		// Combine both sets
		Set<Character> union = new HashSet<Character>(setA);
		union.addAll(setB);

		// Get the intersection
		Set<Character> intersection = new HashSet<Character>(setA);
		intersection.retainAll(setB);

		// The symmetric difference is the union of the 2 sets minus the intersection
		Set<Character> symmetricDifference2 = new HashSet<Character>(union);
		symmetricDifference2.removeAll(intersection);*/

		// Present our results
//		System.out.println("Not in set A: " + notInSetA);
//		System.out.println("Not in set B: " + notInSetB);
//		System.out.println("Symmetric Difference: " + symmetricDifference);
//		System.out.println("Symmetric Difference 2: " + symmetricDifference2);
	}
	
	public static char[] symmetricDifference2(char[] a, char[] b){

		Set<Character> setA = new HashSet<Character>();
		Set<Character> setB = new HashSet<Character>();

		for(int i = 0; i<a.length; i++){
			setA.add(a[i]);
		}

		for(int i = 0; i<b.length; i++){
			setB.add(b[i]);
		}

		// Present our initial data set
//		System.out.println("In set A: " + setA);
//		System.out.println("In set B: " + setB);


		// Option 2: union minus intersection
		// Combine both sets
		Set<Character> union = new HashSet<Character>(setA);
		union.addAll(setB);

		// Get the intersection
		Set<Character> intersection = new HashSet<Character>(setA);
		intersection.retainAll(setB);

		// The symmetric difference is the union of the 2 sets minus the intersection
		Set<Character> symmetricDifference2 = new HashSet<Character>(union);
		symmetricDifference2.removeAll(intersection);
		
		char[] res = new char[symmetricDifference2.size()];
		int count = 0;
		for(Character ch : symmetricDifference2){
			res[count++] = ch;
		}
		
		return res;

	}

	public static char[] charIntersectBest(char[] a, char[] b){

		// elementi differenti
		int count = 0;

		// puntatori mobili


		// ordino i 2 array costo O(n log(n)) per ciascuno
		Arrays.sort(a);    
		Arrays.sort(b);

		// array degli indici dei valori non comuni
		//		int[] indexA = new int[a.length];
		//		int[] indexB = new int[b.length];
		//		for(int i = 0; i <a.length; i++){
		//			indexA[i] = -1;
		//		}
		//		for(int i = 0; i <b.length; i++){
		//			indexB[i] = -1;
		//		}
		int pointerRes = 0;
		int sumSize = b.length + a.length;
		char[] res = new char[sumSize];
		for(int i = 0; i <sumSize; i++){
			res[i] = ' ';
		}

		int pointerA = 0;
		int pointerB = 0;
		while(true){
			if(pointerA>=a.length && pointerB>=b.length){
				break;
			}else if(pointerB>=b.length || (pointerA<a.length && a[pointerA] < b[pointerB])){
				if(pointerRes == 0 || a[pointerA] != res[pointerRes-1]){
					pointerRes++;
					res[pointerRes] = a[pointerA];
				}

				pointerA++;


			}else if(pointerA>=a.length || pointerB<b.length && a[pointerA] > b[pointerB]){
				if(pointerRes == 0 || b[pointerB] != res[pointerRes-1]){
					res[pointerRes] = b[pointerB];
					pointerRes++;
				}

				pointerB++;

			} else{
				pointerB++;
				pointerA++;
			}


		}

		return res;

	}

	public static char[] charIntersect(char[] a, char[] b){

		boolean[] aBool = new boolean[256];
		boolean[] bBool = new boolean[256];
		boolean[] res = new boolean[256];

		for(char aa : a){
			aBool[aa] = true;
		}

		for(char bb : b){
			bBool[bb] = true;
		}

		int count = 0;
		for(int i = 0; i < 256; i++){
			res[i] = aBool[i]^bBool[i];
			if(res[i]) count ++;
		}

		char[] resIntersect = new char[count];
		for(int i = 0; i < count; i++){
			resIntersect[i] = ' ';
		}
		int inc = 0;
		for(int i = 0; i < 256; i++){
			if(res[i])
				resIntersect[inc] = (char)i;
		}

		return resIntersect;
	}


	public static int findNumberOfBits(int x, int y)
	{
		int bitCount = 0;

		int z = x ^ y;  //XOR x and y

		while (z != 0)
		{
			//increment count if last binary digit is a 1:
			bitCount += z & 1; 
			z = z >> 1;  //shift Z by 1 bit to the right
		}

		return bitCount;
	}

	public void intersect1(int[] a, int[] b) {
		HashSet<Integer> hs = new HashSet<Integer>(); 
		for (int i = 0; i < b.length; i++) {
			hs.add(b[i]);
		}

		for (int i = 0; i < a.length; i++) {
			if(hs.contains(a[i])) {
				System.out.println(a[i]+" is present in both arrays");
			}
		}

	}


	public static char[] intersect(char[] s1, char[] s2){

		HashSet<Character> hs1 = new HashSet<>();
		HashSet<Character> hs2 = new HashSet<>();
		for(int i = 0; i < s1.length; i++){
			hs1.add(s1[i]);
		}

		for(int i = 0; i < s2.length; i++){
			hs2.add(s2[i]);
		}

		if(!hs1.retainAll(hs2)){
			return new char[]{};
		}
		char[] res = new char[hs1.size()];
		int count = 0;
		for (Character character : hs1) {
			res[count++] = character;
		}


		return res;
	}

	private static int[] findNonCommonArray(int[] first, int[] second) {
		// TODO Auto-generated method stub

		HashMap<Integer, Integer> frstArray = new HashMap<>();
		for(int i : first){
			frstArray.put(i, i);
		}

		for(int i : second){
			if(frstArray.containsKey(i)){
				frstArray.remove(i);
			}else
				frstArray.put(i, i);
		}

		Set<Integer> resSet = frstArray.keySet();

		int[] res = new int[resSet.size()];

		int count = 0;
		for(Integer i : resSet){
			res[count++] = i;
		}
		return res;
	}

	public static Integer[ ] findCommon( Integer[ ] arrayOne, Integer[ ] arrayTwo ) {

		Integer[ ] arrayToHash;
		Integer[ ] arrayToSearch;

		if( arrayOne.length < arrayTwo.length ) {
			arrayToHash = arrayOne;
			arrayToSearch = arrayTwo;
		} else {
			arrayToHash = arrayTwo;
			arrayToSearch = arrayOne;
		}

		HashSet<Integer> intersection = new HashSet<Integer>( );

		HashSet<Integer> hashedArray = new HashSet<Integer>( );
		for( Integer entry : arrayToHash ) {
			hashedArray.add( entry );
		}

		for( Integer entry : arrayToSearch ) {
			if( hashedArray.contains( entry ) ) {
				intersection.add( entry );
			}
		}

		return intersection.toArray( new Integer[ 0 ] );
	}

}
