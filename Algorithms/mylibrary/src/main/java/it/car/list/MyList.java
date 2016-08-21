package it.car.list;

import java.util.Arrays;
import java.util.Iterator;

import it.car.stack.Persona;

public class MyList<E> implements Iterable<String>{

	private int size = 0;
	private static final int DEFAULT_DIM = 10;
	private Object[] elements;

	/**
	 * iterable
	 */


	public MyList() {
		super();
		elements = new Object[DEFAULT_DIM];
	}

	public void add(E e){
		if(size == elements.length){
			aumentaDimensione();
		}
		elements[size++] = e;
	}

	private void aumentaDimensione(){
		elements = Arrays.copyOf(elements, elements.length*2);
	}

	@SuppressWarnings("unchecked")
	public E get(int pos){
		if(pos >= size){
			throw new IndexOutOfBoundsException("index[" + pos +"], Size[" + size + "]");
		}

		return (E) elements[pos];
	}

	public int length(){
		return size;
	}

	public static void main(String args[]){
		MyList<String> mylist = new MyList<>();
		for (int i = 0; i < 20; i++) {
			mylist.add(String.valueOf(i));
		}
//		Iterator<String> iter = mylist.iterator();
//		while(iter.hasNext()) {
//			System.out.println("value " + iter.next());
//		}
		String[] array = {"1", "2", "3"};
		Integer[] arrayInt = {1, 2, 3};
		Persona[] persone = {new Persona("1"), new Persona("2"), new Persona("3")};
		new MyList<>().scorri(persone);
	}

	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new ArrayIterator() ;
	}


	public class ArrayIterator implements Iterator<String>{

		private int i = 0;
		Object[] elementCopy = Arrays.copyOf(elements, size);

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (i<size);
		}

		@Override
		public String next() {
			// TODO Auto-generated method stub

			if(i >= size)
				throw new IndexOutOfBoundsException();

			return (String) elements[i++];
		}

		@Override
		public void remove() {

		}

	}

	public void scorri(E[] array){
		for (E e : array) {
			System.out.println(e);
		}
	}
	
	



}
