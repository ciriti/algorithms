package it.car.stack;
/*************************************************************************
 *  Compilation:  javac ArrayStackOfStrings.java
 *  Execution:    java ArrayStackOfStrings
 *  
 *  Stack of strings implementation with a fixed-size array.
 *
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is 
 * 
 *  % java ArrayStackOfStrings 5 < tobe.txt 
 *  to be not that or be
 *
 *************************************************************************/

import java.util.Iterator;

public class ArrayStackOfStrings implements Iterable<String> {
	private String[] a;  // holds the items
	private int N;       // number of items in stack
	int DIM		= 10;

	public ArrayStackOfStrings() {  a = new String[DIM];       }
	public boolean isEmpty()            {  return (N == 0);           }

	public String pop(){  
		return a[--N];             
	}
	public Iterator<String> iterator()  { return new ArrayIterator(); }

	public void push(String item){  

		int newDim = N++;

		if( newDim  >= DIM){
			DIM = 2*DIM;
			String[] arrTmp = new String[DIM];
			for(int i = 0; i< DIM/2 ; i++){
				arrTmp[i] = a[i];
			}
			a = arrTmp;
		}else{
			a[newDim] = item; 
		}

	}


	public class ArrayIterator implements Iterator<String> {
		private int i = N-1;

		public boolean hasNext() { return i >= 0; }
		public String next()     { return a[i--]; }
		public void remove()      { throw new UnsupportedOperationException(); }
	}


	public static void main(String[] args) {
		//        int max = Integer.parseInt(args[0]);
		ArrayStackOfStrings stack = new ArrayStackOfStrings();

		for(int i = 0; i<11; i++){
			if(i==10){
				System.out.println();
			}
			stack.push(String.valueOf(i));
			System.out.println("push[" + i + "]");
		}

		while(!stack.isEmpty()){
			System.out.println("pop[" + stack.pop() + "]");
		}

	} 
} 