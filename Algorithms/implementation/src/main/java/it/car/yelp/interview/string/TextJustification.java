package it.car.yelp.intw.string;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class TextJustification {
	
	public static void main(String args[]){
		String[] s = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
		System.out.println(fullJustify(s, 16));
	}

	public static  List<String> fullJustify(String[] words, int maxWidth) {
		
		List<String> res = new ArrayList<>();
		List<List<String>> listaOfRow = new ArrayList<>();
		
		int[] dimWords = new int[words.length];
		
		for(int i = 0; i < words.length; i++){
			dimWords[i] = words[i].length();
		}
		
		int count = 0;
		List<String> tmp = new LinkedList<>();
		for(int i = 0; i < words.length; i++){
//			if(){
//				
//			}
		}
		
		for(List<String> list : listaOfRow){
			res.add(createRow(list, maxWidth));
		}
		
		return res;
	}
	
	public static String createRow(List<String> list, int maxWidth){
		
		StringBuffer sb = new StringBuffer();
		
		int numSpace = (list.size()-1)/maxWidth;
		int padding = (list.size()-1)%maxWidth;
		
		for(String word : list){
			sb.append(word + (numSpace>0?" ":"") + (padding>0?" ":""));
			numSpace--;
			padding--;
		}
		System.out.println("Size: " + sb.toString().length());
		return sb.toString();
	}

}
