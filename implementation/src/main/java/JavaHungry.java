import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class JavaHungry {

	public static void main(String[] args)
	{
		HashSet<Object> hashset = new HashSet<Object>();
		hashset.add(3);
		hashset.add("Java Hungry");
		hashset.add("Blogspot");
		hashset.add(3);                     // duplicate elements
		hashset.add("Java Hungry");
		hashset.add(null);// duplicate elements
		
		HashMap<String, String> hashmap = new HashMap<String, String>();
		hashmap.put(null, "test");
		hashmap.put(null, "test2");
		hashmap.put("test", "test");
		
		ConcurrentHashMap<String, String> concurrenthashmap = new ConcurrentHashMap<String, String>();
		concurrenthashmap.put("test", "test");
		concurrenthashmap.put("test1", "test");
		concurrenthashmap.put("test2", "test");
		
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put("test2", "");
		hashtable.put("test", "test");
		
		TreeMap<String, String> treemap = new TreeMap<>();
		treemap.put("test", "test");
		treemap.put("test2", "test");
		
		ArrayList<String> array = new ArrayList<String>();
		array.add(null);
		array.add(null);
		array.add(null);
		
		Vector<String> vector = new Vector<>();
		vector.add(null);
		vector.add(null);
		
		LinkedList<String> ll = new LinkedList<>();
		ll.add(null);
		ll.add(null);
		

		Iterator<String> iter = treemap.keySet().iterator();

		while (iter.hasNext())
		{
			System.out.println(treemap.get(iter.next()));
//			treemap.put("USA", "+11");			
		}
		
		Iterator<String> iterM = hashmap.keySet().iterator();

		while(iterM.hasNext()){
			Object obj = iterM.next();
//			iter.remove();
		}
		
		/**
		 * LinkedList
		 */
		
		LinkedHashMap<String, String> llHashMap = new LinkedHashMap<>();
		llHashMap.put("test", "test");
		llHashMap.put("test1", "test3");
		llHashMap.put(null, null);
		
		Iterator<String> llIter = llHashMap.keySet().iterator();

		while (llIter.hasNext())
		{
			System.out.println(llHashMap.get(llIter.next()));
//			llHashMap.put("USA", "+11");			
		}
		
		/**
		 * linked hash set
		 */
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("test");
		linkedHashSet.add("test1");
		linkedHashSet.add("test2");
		
		Iterator<String> linkedHashSetIter = linkedHashSet.iterator();

		while (linkedHashSetIter.hasNext())
		{
			System.out.println(linkedHashSetIter.next());
//			linkedHashSet.add("test23");			
		}
		
		/**
		 * treeset
		 */
		
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("test");
		treeSet.add("test1");
		treeSet.add("test2");
		
		Iterator<String> treeSetIter = treeSet.iterator();

		while (treeSetIter.hasNext())
		{
			System.out.println(treeSetIter.next());
//			treeSet.add("test23");			
		}
		
		/**
		 * linked
		 */
		Iterator<String> linkedListIter = ll.iterator();

		while (linkedListIter.hasNext())
		{
			System.out.println(linkedListIter.next());
//			ll.add("test23");			
		}
		
		/**
		 * HashTable
		 */
		
		Iterator<String> hashtableIter = hashtable.keySet().iterator();

		while (hashtableIter.hasNext())
		{
			System.out.println(hashtableIter.next());
			hashtable.put("test", "test1");			
		}
		
		System.out.println("----------");
		/**
		 * 
		 */
		Iterator<String> concurrentHMIter = concurrenthashmap.keySet().iterator();

		while (concurrentHMIter.hasNext())
		{
			System.out.println(concurrentHMIter.next());
			concurrenthashmap.put("test4", "test1");			
		}
		
		System.out.println("----------");

		System.out.println("Set is "+hashset);
		System.out.println("hashmap is "+hashmap);
		System.out.println("treemap is "+treemap);
		System.out.println("hashtable is "+hashtable);
		System.out.println("array is "+array);
		System.out.println("vector is "+vector);
		System.out.println("linkedList is "+ll);
	}

	interface A {
		
		public void  test();

	}

	interface B {
		public void  test();  
	}
	
	class C implements A, B {

		@Override
		public void test() {
			// TODO Auto-generated method stub
			
		}
		
	}
}