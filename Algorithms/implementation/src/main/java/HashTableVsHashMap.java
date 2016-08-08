import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class HashTableVsHashMap {

	public static void main (String args[]) {
		testHashTable();
	}

	public static void testHashTable(){
		final Hashtable<String, String> table = new Hashtable<>();
		final Map<String, String> map = new HashMap<>();
		final ConcurrentHashMap<String, String> cMap = new ConcurrentHashMap<>();
		final ArrayList<String> arrayList = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			table.put(String.valueOf(i), String.valueOf(i));
			map.put(String.valueOf(i), String.valueOf(i));
			cMap.put(String.valueOf(i), String.valueOf(i));
			arrayList.add(String.valueOf(i));
		}

		 final Map<String, String> sMap = Collections.synchronizedMap(map);

		new Thread(){
			public void run() {

				//				Iterator<String> i = table.keySet().iterator();
				//				while(i.hasNext()){
				//					i.next();
				//					i.remove();
				//				}


				//				Iterator<String> iMap = map.keySet().iterator();
				//				while(iMap.hasNext()){
				//					iMap.next();
				//					iMap.remove();
				//				}
				
//				Iterator<String> iArr = sMap.keySet().iterator();
//				while(iArr.hasNext()){
//					iArr.next();
//					iArr.remove();
//				}

				Iterator<String> iCMap = cMap.keySet().iterator();
				while(iCMap.hasNext()){
					iCMap.next();
					iCMap.remove();
				}
			};

		}.start();

		new Thread(){
			public void run() {
				Iterator<String> i = table.keySet().iterator();
				while(i.hasNext()){
					i.next();
					i.remove();
				}

				//				Iterator<String> iMap = map.keySet().iterator();
				//				while(iMap.hasNext()){
				//					iMap.next();
				//					iMap.remove();
				//				}
				
				Iterator<String> iArr = sMap.keySet().iterator();
				while(iArr.hasNext()){
					iArr.next();
					iArr.remove();
				}

				
				
				Iterator<String> iCMap = cMap.keySet().iterator();
				while(iCMap.hasNext()){
					iCMap.next();
					iCMap.remove();
				}

			};

		}.start();

		//		Iterator<String> i = table.keySet().iterator();
		//		while(i.hasNext()){
		//			i.next();
		//			i.remove();
		//		}
		//		
		//		System.out.println("table  " + table);
		//		
		//		Iterator<String> iMap = map.keySet().iterator();
		//		while(iMap.hasNext()){
		//			iMap.next();
		//			iMap.remove();
		//		}
		//		
		//		System.out.println("map  " + map);
	}

}
