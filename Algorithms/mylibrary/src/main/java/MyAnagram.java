import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyAnagram {
	
	static int count = 0;
	
	public static void main(String args[]){
		long start = System.currentTimeMillis();
		makeAnagram();
		System.out.println(System.currentTimeMillis()-start);
		start = System.currentTimeMillis();
		makeAnagram2();
		System.out.println(System.currentTimeMillis()-start);
		
	}
	
	/**
	 * second version
	 */
	
	public static void makeAnagram2(){
		String anagram = "abcdefghilm";
		List<String> list = new ArrayList<String>();
		makeAnagram(list, anagram);
//		System.out.println(list.size());
//		System.out.println(list);
	}
	
	private static void makeAnagram(List<String> list, String s) {
		recursiveAnagram(s.toCharArray(), 0, list);
	}

	private static void recursiveAnagram(char[] array, int position, List<String> list) {
		
		if(position == array.length){
			list.add(new String(array));
		}else{
			for(int i = position; i<array.length; i++){
				exchange(array, position, i);
				recursiveAnagram(array, position+1, list);
				exchange(array, i, position);
			}
		}
		
	}
	
	static void exchange(char[] arr, int i, int j){
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}

	/**
	 * first version
	 */
	
	public static void makeAnagram(){
		Map<Integer, List<String>> map = new HashMap<>();
		String anagram = "abcdefghilm";
		List<String> list = new ArrayList<String>();
		list.add(anagram.substring(0,1));
		map.put(1, list);
		makeAnagram(map, 1, anagram);
//		System.out.println(count);
//		System.out.println(map);
		
	}
	
	public static void makeAnagram(Map<Integer, List<String>> map, int size, String s){
		
		if(size==s.length()) return;
		
		List<String> list = map.get(size);
		map.put(size+1, new ArrayList<String>());
		for(String a : list){
			addCharacterEverywhere(a, s.charAt(size), map.get(size+1));
		}
		
		for(int i = 0; i<=size; i++) {
			map.remove(i);
		}
		
		makeAnagram(map, size+1, s);
	}

	private static void addCharacterEverywhere(String a, char charAt, List<String> newList) {
		newList.add(new String(charAt+a));
		for(int i = 0; i < a.length(); i++){
			newList.add(new String(a.substring(0, i) + charAt + a.substring(i, a.length())));
			count++;
		}
	}

}
