package it.car.list;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;




public class TestPerformance {

	public static final int DIM = 10;
	int count = 0;

	public static void main(String [] args){

//		testReverse();
//		testReverseOriginal();
		kadane();
		/*
		//		testPerformance();
		MyLinkedList.MyNode node2 = null;
		MyLinkedList.MyNode tmp;
		MyLinkedList linkedList = new MyLinkedList();
		for (int i = 1; i <= 10; i++){

			tmp = new MyLinkedList.MyNode("carmelo" + i);
			linkedList.add(tmp);
//			if(i==2){
//				node2 = tmp;
//			}
//
//			if(tmp.next()==null){
//				tmp.setNext(node2);
//			}
		}


		System.out.println("hasLoop[" + hasLoop(linkedList.head()) + "]");
		middleNode(linkedList.head());

		 */
		
		String ciao = " 1";
		ciao = ciao.trim();
		ciao.matches("[0-9]+");
	}

	private static void kadane() {
		int[] intArr={3, -1, 1, -1, 1, 1, 4, 0, 0, 0 };
    	//int[] intArr = {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
    	//int[] intArr={-6,-2,-3,-4,-1,-5,-5};
        findMaxSubArray(intArr);
		
	}
	
	public static void findMaxSubArray(int[] inputArray){
		 
        int maxStartIndex=0;
        int maxEndIndex=0;
        int maxSum = Integer.MIN_VALUE; 
 
        int cumulativeSum= 0;
        int maxStartIndexUntilNow=0;
        		
        for (int currentIndex = 0; currentIndex < inputArray.length; currentIndex++) {
        	
            int eachArrayItem = inputArray[currentIndex];
            
            cumulativeSum+=eachArrayItem;
 
            if(cumulativeSum>maxSum){
                maxSum = cumulativeSum;
                maxStartIndex=maxStartIndexUntilNow;
                maxEndIndex = currentIndex;
            }
            else if (cumulativeSum<0){
            	maxStartIndexUntilNow=currentIndex+1;
            	cumulativeSum=0;
            }
        }
 
        System.out.println("Max sum         : "+maxSum);
        System.out.println("Max start index : "+maxStartIndex);
        System.out.println("Max end index   : "+maxEndIndex);
    }

	private static void testReverseOriginal() {
		LinkedList<String> list = new LinkedList<String>();
		for (int i = 0; i < DIM; i++) {
			list.add(("" + i));
		}
		
		list.getFirst();
		
		Iterator i = list.iterator();
		String prev = null;
		String current = null;
		String next = null;
		while(i.hasNext()){
			current = (String) i.next();
		}
	}

	private static void testReverse() {
		// TODO Auto-generated method stub

		MyLinkedList list = new MyLinkedList();

		MyLinkedList.MyNode current1 = new MyLinkedList.MyNode("");
		MyLinkedList.MyNode current = list.head();
		for (int i = 1; i <= 10; i++){
			MyLinkedList.MyNode tmp = new MyLinkedList.MyNode(""+i);
			current.setNext(tmp);
			current = tmp;
		}

		current = list.head();
		while(current.next()!=null){
			System.out.println(current.next().data());
			current = current.next();
		}

		MyLinkedList.MyNode head = list.head();
		current = invertList(head);
		System.out.println("-----------------------------");
		while(current.next()!=null){
			System.out.println(current.data());
			current = current.next();
		}

		

	}

	private static MyLinkedList.MyNode invertList(MyLinkedList.MyNode node) {
		
		MyLinkedList.MyNode  previus = null;
		MyLinkedList.MyNode  current = node;
		MyLinkedList.MyNode  nextNode;
		
		
		while(current.next() != null){
			
			nextNode = current.next();
			current.setNext(previus);
			previus = current;
			current = nextNode;
			
		}
		current.setNext(previus);
		MyLinkedList.MyNode   head = current;
		return head;
		
	}

	static boolean hasLoop(MyLinkedList.MyNode first) {

		if(first == null) // list does not exist..so no loop either.
			return false;

		MyLinkedList.MyNode slow, fast; // create two references.

		slow = fast = first; // make both refer to the start of the list.

		while(true) {

			slow = slow.next();          // 1 hop.

			if(fast.next() != null)
				fast = fast.next().next(); // 2 hops.
			else
				return false;          // next node null => no loop.

			if(slow == null || fast == null) // if either hits null..no loop.
				return false;

			if(slow == fast) // if the two ever meet...we must have a loop.
				return true;
		}
	}

	static void middleNode(MyLinkedList.MyNode first) {

		if(first == null) // list does not exist..so no loop either.
			return;

		MyLinkedList.MyNode slow, fast; // create two references.

		slow = fast = first; // make both refer to the start of the list.
		int count = 1;

		while(count!=0) {

			if(fast != null){

				fast = fast.next();

				if(count%2==0){
					slow = slow.next();
					System.out.println(slow.data());
				}


				count++;

			}else
				count = 0;



		}
		System.out.println(slow.data());

	}

	private static void testPerformance() {
		Random r = new Random();
		int count = 0;

		//		HashSet<Dog> hashSet = new HashSet<Dog>();
		//		TreeSet<Dog> treeSet = new TreeSet<Dog>();
		//		LinkedHashSet<Dog> linkedSet = new LinkedHashSet<Dog>();
		//
		//		// start time
		//		long startTime = System.nanoTime();
		//
		//		for (int i = 0; i < 1000; i++) {
		//			int x = r.nextInt(1000 - 10) + 10;
		//			hashSet.add(new Dog(x));
		//		}
		//		// end time
		//		long endTime = System.nanoTime();
		//		long duration = endTime - startTime;
		//		System.out.println("HashSet: " + duration);
		//
		//		// start time
		//		startTime = System.nanoTime();
		//		for (int i = 0; i < 1000; i++) {
		//			int x = r.nextInt(1000 - 10) + 10;
		//			treeSet.add(new Dog(x));
		//		}
		//		// end time
		//		endTime = System.nanoTime();
		//		duration = endTime - startTime;
		//		System.out.println("TreeSet: " + duration);
		//
		//		// start time
		//		startTime = System.nanoTime();
		//		for (int i = 0; i < 1000; i++) {
		//			int x = r.nextInt(1000 - 10) + 10;
		//			linkedSet.add(new Dog(x));
		//		}
		//		// end time
		//		endTime = System.nanoTime();
		//		duration = endTime - startTime;
		//		System.out.println("LinkedHashSet: " + duration);

		LinkedList<Persona> list = new LinkedList<Persona>();
		Persona[] persona = new Persona[DIM];
		HashMap<Integer, Persona> hashM = new HashMap<>();
		Map<Integer, Persona> mapSync = Collections.synchronizedMap(hashM);
		LinkedHashMap<Integer, Persona> lhm = new LinkedHashMap<Integer, Persona>();
		Hashtable<Integer, Persona> hashtable = new Hashtable<>();
		ConcurrentHashMap<Integer, Persona> concurrentHM = new ConcurrentHashMap<>();
		Persona p;
		for (int i = 0; i < DIM; i++) {
			list.add(new Persona("Carmelo" + i));
			persona[i] = new Persona("Carmelo" + i);
			hashM.put(1, new Persona("Carmelo"));
			mapSync.put(i, new Persona("Carmelo" + i));
			lhm.put(i, new Persona("Carmelo" + i));
			hashtable.put(i, new Persona("Carmelo" + i));
			concurrentHM.put(i, new Persona("Carmelo" + i));
		}

		// start time
		long startTime = System.nanoTime();

		for (int i = 0; i < DIM; i++) {
			p = persona[i];
		}
		// end time
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("\n Vettore: " + "\n	" + duration);



		/**
		 * LinkedList
		 */
		count = 0;
		// start time
		startTime = System.nanoTime();
		Iterator<Persona> iter_link = list.iterator();
		while(iter_link.hasNext()){
			p = iter_link.next();
			count++;
		}

		// end time
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("\n LinkedList: " + "\n	" + duration + "  count[" + count + "]");

		/**
		 * HashMap
		 */
		count = 0;
		// start time
		startTime = System.nanoTime();
		Set<Integer> hashM_key = hashM.keySet();
		Iterator<Integer> iter_hashMap = hashM_key.iterator();
		while(iter_hashMap.hasNext()){
			Integer element = iter_hashMap.next();
			p = hashM.get(element);
			count++;
		}

		// end time
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("\n HashMap: " + "\n	" + duration + "  count[" + count + "]");


		/**
		 * HashMapSync
		 */
		count = 0;
		// Get a set of the entries
		Set<Entry<Integer, Persona>> set_mapSync = mapSync.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, Persona>> i_mapSync = set_mapSync.iterator();
		// start time
		startTime = System.nanoTime();

		// start time
		startTime = System.nanoTime();

		// Display elements
		while(i_mapSync.hasNext()) {
			Entry<Integer, Persona> me = i_mapSync.next();
			Persona str =(Persona) me.getValue();
			count++;
		}

		// end time
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("\n HashMapSynch: " + "\n	" + duration + "  count[" + count + "]");

		/**
		 * LinkedHashMap
		 */
		count = 0;
		// Get a set of the entries
		Set<Entry<Integer, Persona>> set = lhm.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, Persona>> i = set.iterator();
		// start time
		startTime = System.nanoTime();


		// Display elements
		while(i.hasNext()) {
			Entry<Integer, Persona> me = i.next();
			Persona str =me.getValue();
			count++;
		}

		//		for (int i = 0; i < DIM; i++) {
		//			String str = (String) lhm.get(i);
		//		}
		// end time
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("\n LinkedHashMap: " + "\n	" + duration + "  count[" + count + "]");

		/**
		 * HashTable
		 */
		count = 0;
		startTime = 0;
		startTime = System.nanoTime();
		// Get a set of the entries
		Set<Integer> hashTab_key = hashtable.keySet();
		Iterator<Integer> iter_hashTab = hashTab_key.iterator();
		while(iter_hashTab.hasNext()){
			Integer element = iter_hashTab.next();
			p = hashtable.get(element);
			count++;
		}

		//		for (int i = 0; i < DIM; i++) {
		//			String str = (String) lhm.get(i);
		//		}
		// end time
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("\n HashTable: " + "\n	" + duration + "  count[" + count + "]");

		/**
		 * ConcurrentHashMap
		 */
		count = 0;
		startTime = 0;
		startTime = System.nanoTime();
		// Get a set of the entries
		Set<Integer> concurrentHM_key = concurrentHM.keySet();
		Iterator<Integer> iter_concurrentHM = concurrentHM_key.iterator();
		while(iter_concurrentHM.hasNext()){
			Integer element = iter_concurrentHM.next();
			p = concurrentHM.get(element);
			count++;
		}

		//		for (int i = 0; i < DIM; i++) {
		//			String str = (String) lhm.get(i);
		//		}
		// end time
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("\n ConcurrentHashMap: " + "\n	" + duration + "  count[" + count + "]");

		/**
		 * 
		 * 
		 * 
		 * 			GET ELEMENT
		 * 
		 * 
		 */

		System.out.println("\n ******************************************   GET ELEMENT   ******************************************");

		/**
		 * get element
		 */
		startTime = System.nanoTime();

		p = persona[500];

		// end time
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("\n Vector get element: " + "\n	" + duration + "  name[" + p.getName() + "]");

		/**
		 * HashMap
		 */
		startTime = System.nanoTime();

		p = hashM.get(new Persona("Carmelo" + 500));

		// end time
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("\n HashMap get element: " + "\n	" + duration);

		/**
		 * HashMapSync
		 */
		startTime = System.nanoTime();

		p = mapSync.get(new Persona("Carmelo" + 500));

		// end time
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("\n HashMapSync get element: " + "\n	" + duration);

		/**
		 * LinkedHashMap
		 */
		startTime = System.nanoTime();

		p = lhm.get(new Persona("Carmelo" + 500));

		// end time
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("\n LinkedHashMap get element: " + "\n	" + duration);

		/**
		 * HashTable
		 */
		startTime = System.nanoTime();

		p = hashtable.get(new Persona("Carmelo" + 500));

		// end time
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("\n HashTable get element: " + "\n	" + duration);

		for (int a = 0; a < DIM; a++) {
			hashM.put(a, new Persona("Carmelo" + a));
			mapSync.put(a, new Persona("Carmelo" + a));
			lhm.put(a, new Persona("Carmelo" + a));
			hashtable.put(a, new Persona("Carmelo" + a));
		}



	}



}
