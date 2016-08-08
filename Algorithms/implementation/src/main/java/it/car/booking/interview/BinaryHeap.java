package it.car.booking.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.InvalidParameterException;

public class BinaryHeap {

	char[] values;
	int numElem = 1;

	public BinaryHeap(String nameFile) throws Exception{
		super();
		// TODO Auto-generated constructor stub
		File file = new File(nameFile);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		int size = Integer.valueOf(br.readLine());
		values = new char[size];
		String line;
		int count = 0;
		while((line = br.readLine()) != null){
			values[count] = line.toCharArray()[0];
			swim(count);
			count++;
			if(count >= size) 
				break;
		}
	}

	public BinaryHeap() {
		values = new char[10];
	}

	public void addValue(char a){
		if(numElem >= values.length) 
			throw new InvalidParameterException("Numero troppo grande");
		values[numElem] = a;
		swim(numElem);
		numElem++;
		stampa();
	}

	public void swim(int k){
		if(k>1 && less(k/2, k)){
			exchange(k/2, k);
			swim(k/2);
		}
	}

	public int size(){
		return values.length -1 ;
	}

	private void exchange(int i, int j) {
		// TODO Auto-generated method stub
		char a = values[i];
		values[i] = values[j];
		values[j] = a;
	}

	public boolean less(int nodeA, int nodeB){
		if(values[nodeA] < values[nodeB]){
			return true;
		}
		return false;
	}

	public BinaryHeap(int size) throws Exception{
		super();
		values = new char[size];
	}
	
	public int getNumLevel(){
		int res = (int)Math.log(values.length);
		return res + 1;
	}
	
	public void remove(int index){
		exchange(index, size() -1 );
		values[size() -1] = ' ';
		numElem--;
		stampa();
	}

	public void stampa() {
		// TODO Auto-generated method stub
		for (int i = 1; i < values.length; i++) {
			System.out.print(values[i] + " ");
		}
		System.out.print("\n");
	}
	
	public void sink(int index){
		if(2*index <= size()){
			int child = 2 * index;
			if(child < size() && less(child, child + 1)){
				child++;
			}
			if(less(index, child)){
				exchange(index, child);
			}
			sink(child);
		}
	}

	public static void main(String args[]){
		try {
			BinaryHeap bh = new BinaryHeap("dataheap.txt");
//			BinaryHeap bh = new BinaryHeap();
//			bh.addValue('a');
//			bh.addValue('b');
//			bh.addValue('c');
//			bh.addValue('d');
//			bh.addValue('e');
			bh.stampa();
			bh.remove(1);
			bh.stampa();
			bh.sink(1);
			bh.stampa();
			
			System.out.println("NumLevel[" + bh.getNumLevel() + "]");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
