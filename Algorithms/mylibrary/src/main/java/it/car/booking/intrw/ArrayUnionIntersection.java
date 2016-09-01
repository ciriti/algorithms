package it.car.booking.intrw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayUnionIntersection {

	/**
	 * Collection (so ArrayList also) have:
	 * 
	 * 		col.retainAll(otherCol) 				// for INTERSECTION
	 * 		col.addAll(otherCol) 					// for UNION
	 */

	/**
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public char[] union(char[] arr1, char[] arr2){

		HashSet<Integer> mySet = new HashSet<>();
		for(int i : arr1){
			mySet.add(i);
		}
		for(int i : arr2){
			mySet.add(i);
		}

		Object[] arrResult = mySet.toArray();
		char[] res = new char[arrResult.length];
		for(int i = 0; i < arrResult.length; i++){
			res[i] = (char)((int)arrResult[i]);
		}

		return res;
	}
	public char[] unionArrays(char[] arr1, char[] arr2){

		List<Integer> arrList1 = new ArrayList<>();
		List<Integer> arrList2 = new ArrayList<>();

		for(int i : arr1){
			arrList1.add(i);
		}

		for(int i : arr2){
			arrList2.add(i);
		}

		arrList1.addAll(arrList2);
		char[] res = new char[arrList1.size()];
		int count = 0;
		for(Integer i : arrList1){
			res[count++] = (char)i.intValue();
		}

		return res;
	}

	public char[] nonCommonElements(char[] arr1, char[] arr2){
		Map<Integer, Integer> map = new HashMap<>();

		for(int i : arr1){
			map.put(i, i);
		}
		for(int i : arr2){
			if(map.containsKey(i)){
				map.remove(i);
			}else
				map.put(i, i);
		}

		Set<Integer> set = map.keySet();
		char[] res = new char[set.size()];
		int count = 0;
		for(Integer i : set){
			res[count++] = (char)i.intValue();
		}
		return res;
	}
	public char[] intersection(char[] arr1, char[] arr2){
		Map<Integer, Integer> map = new HashMap<>();
		HashSet<Integer> intersectElem = new HashSet<>();

		for(int i : arr1){
			map.put(i, i);
		}

		//find common elements
		for(int i : arr2){
			if(map.containsKey(i)){
				intersectElem.add(i);
			}
		}

		char[] res = new char[intersectElem.size()];
		int count = 0;
		for(Integer i : intersectElem){
			res[count++] = (char)i.intValue();
		}
		return res;
	}
	public char[] intersectionArrays(char[] arr1, char[] arr2){
		List<Integer> arrList1 = new ArrayList<>();
		List<Integer> arrList2 = new ArrayList<>();

		for(int i : arr1){
			arrList1.add(i);
		}

		for(int i : arr2){
			arrList2.add(i);
		}

		arrList1.retainAll(arrList2);

		char[] res = new char[arrList1.size()];
		int count = 0;
		for (Integer c : arrList1) {
			res[count++] = (char) c.intValue();
		}
		return res ;
	}

	public static void main(String args[]){
		char[] arr1 = new char[]{'a','b','c'};
		char[] arr2 = new char[]{'d','e','c'};

		long startTime = 0;

		System.out.print("arr1: ");
		for (char c : arr1) {
			System.out.print(c + " ");
		}
		System.out.print("\narr2: ");
		for (char c : arr2) {
			System.out.print(c + " ");
		}
		System.out.println("");


		// UNION
		System.out.println("\nUnion:");
		ArrayUnionIntersection arrUnion = new ArrayUnionIntersection();
		startTime = System.nanoTime();
		char[] resUnion = arrUnion.union(arr1, arr2);
		Arrays.sort(resUnion);
		for (char c : resUnion) {
			System.out.print(c + " - ");
		}
		System.out.println("\nUnion " + (System.nanoTime() - startTime));

		// UNION ARRAYS
		System.out.println("\nUnion Arrays:");
		startTime = System.nanoTime();
		char[] resUnionArrays = arrUnion.unionArrays(arr1, arr2);
		Arrays.sort(resUnionArrays);
		for (char c : resUnion) {
			System.out.print(c + " - ");
		}
		System.out.println("\nUnion Arrays " + (System.nanoTime() - startTime));

		//COMMON
		System.out.println("\nNon Common Elements:");
		startTime = System.nanoTime();
		char[] resCommonElem = arrUnion.nonCommonElements(arr1, arr2);
		for (char c : resCommonElem) {
			System.out.print(c + " - ");
		}
		System.out.println("\nNon Common " + (System.nanoTime() - startTime));

		//INTERSECTION
		System.out.println("\nInsersection:");
		startTime = System.nanoTime();
		char[] resIntersection = arrUnion.intersection(arr1, arr2);
		for (char c : resIntersection) {
			System.out.print(c + " - ");
		}
		System.out.println("\nIntersection " + (System.nanoTime() - startTime));
		//INTERSECTION
		System.out.println("\nInsersectionArrays:");
		startTime = System.nanoTime();
		char[] resIntersectionArrays = arrUnion.intersection(arr1, arr2);
		for (char c : resIntersectionArrays) {
			System.out.print(c + " - ");
		}
		System.out.println("\nIntersection Arrays " + (System.nanoTime() - startTime));
	}

}
