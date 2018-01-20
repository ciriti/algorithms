package it.car.tree.binaryheap;

public class BinaryHeap {

	private char[] alfabeto;
	private int SIZE = 21;
	private int index = 0;

	private BinaryHeap() {
		super();
		// TODO Auto-generated constructor stub
		alfabeto = new char[SIZE];
		for(int i = 0; i < SIZE; i++){
			alfabeto[i] = 0;
		}
	}

	public void addLettera(char c){
		index++;
		alfabeto[index] = c;
		swim(index);
		
	}

	private void excange(int i, int j){
		char tmp = alfabeto[i];
		alfabeto[i] = alfabeto[j];
		alfabeto[j] = tmp;
	}

	public int getSize(){
		return index;
	}

	private void swim(int i){
		if(i > 1 && index > 1){
			if(alfabeto[i] < alfabeto[i/2]){
				excange(i, i/2);
			}
			swim(i/2);
		}
	}

	private void sync(int i){
		int newIndex = -1;
		if(2*i <= index){
			if(alfabeto[2*i+1] != 0 && alfabeto[2*i+1] < alfabeto[2*i]){
				newIndex = 2*i+1;
			}else{
				newIndex = 2*i;
			}
			if(alfabeto[i] > alfabeto[newIndex]){
				excange(i, newIndex);
				sync(newIndex);
			}
		}
	}

	int getMin(int i , int j){
		return alfabeto[i]<alfabeto[i]?i:j;
	}

	public char pop(){

		if(index == 0) return '-';

		excange(1, index);
		char c = alfabeto[index];
		alfabeto[index] = 0;
		index--;
		sync(1);

		return c; 
	}

	public static void main(String args[]){
		BinaryHeap bh = new BinaryHeap();
		bh.addLettera('c');
		bh.addLettera('e');
		bh.addLettera('m');
		bh.addLettera('v');
		bh.addLettera('z');
		bh.addLettera('b');
		bh.addLettera('a');
		bh.addLettera('l');
		bh.addLettera('A');
		bh.addLettera('d');
		bh.addLettera('a');

		while(bh.getSize() > 0)
			System.out.println(bh.pop());
	}


}
