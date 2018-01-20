package it.car.booking.intrw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BinaryHeap2 {
	
	ArrayList<Integer> values;
	
	public BinaryHeap2(String fileNale){
		
		try {
			values = new ArrayList<Integer>();
			values.add(-1);
			BufferedReader br = new BufferedReader(new FileReader(new File(fileNale)));
			String line = "";
			while((line = br.readLine())!=null){
				addElement(Integer.valueOf(line));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void addElement(Integer value) {
		// TODO Auto-generated method stub
		values.add(value);
		swim(values.size());
	}

	private void swim(int i) {
		// TODO Auto-generated method stub
		if(i /2 >= 1 && less(i/2, i)){
			excange(i/2, i);
			swim(i/2);
		}
//		while( i > 0 && less(i/2, i)){
//			excange(i/2, i);
//			i = i/2;
//		}
	}

	private boolean less(int a, int b) {
		if(values.get(a) < values.get(b)){
			return true;
		}
		return false;
	}
	
	private void excange(int a, int b){
		Collections.swap(values, a, b);
	}
	
	public void stampa(){
		System.out.println();
		for(Integer i : values){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		BinaryHeap2 bh = new BinaryHeap2("data_list.txt");
		bh.stampa();
	}

}
