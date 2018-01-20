package it.car.list.doubl;

import java.util.Iterator;

public class MyDoubleLinkedList<T> implements Iterable<T>{
	
	private int dim = 0;
	private DNode<T> head = null;
	private DNode<T> tail = null;
	
	public MyDoubleLinkedList(){
		clear();
	}
	
	public boolean isEmpty(){
		return (dim == 0);
	}
	
	public int size(){
		return dim;
	}
	
	void clear(){
		this.dim 	= 0;
		this.head 	= new DNode<T>(null, null, this.tail);
		this.tail 	= new DNode<T>(null, this.head, null);
	}
	
	private static class DNode<T>{
		
		private T data;
		private DNode<T> prev;
		private DNode<T> next;
		
		public DNode(T data, DNode<T> prev, DNode<T> next){
			this.prev = prev;
			this.next = next;
			this.data = data;
		}
		
	}
	
	public DNode<T> head(){
		return head;
	}
	
	public T add(T data){
		 
		DNode<T> newNode = new DNode<T>(data, null, null);
		
		DNode<T> penultimo = tail.prev;
		
		penultimo.next = newNode;
		newNode.prev = penultimo;
		newNode.next = tail;
		tail.prev = newNode;
		
		return data;
	}
	
	private class DLinkedListIterator implements Iterator<T>{
		
		private DNode<T> current = head.next;
		private DNode<T> currentPrev = tail.prev;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (current != tail);
		}

		@Override
		public T next() {
			if(!hasNext())
				throw new java.util.NoSuchElementException();
			// TODO Auto-generated method stub
			T tmp = current.data;
			current = current.next;
			return tmp;
		}
		
		@SuppressWarnings("unused")
		public T previous() {
			if(!hasPrevious())
				throw new java.util.NoSuchElementException();
			// TODO Auto-generated method stub
			T tmp = currentPrev.data;
			current = currentPrev.prev;
			return tmp;
		}
		
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return (currentPrev != head);
		}

		@Override
		public void remove() {
			// TODO remove
			
		}
		
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new DLinkedListIterator();
	}
	
	 public static void main(String[] args) {
	        int N  = 10;

	        // add elements 1, ..., N
	        System.out.println(N + " random integers between 0 and 99");
	        MyDoubleLinkedList<Integer> list = new MyDoubleLinkedList<Integer>();
	        for (int i = 0; i < N; i++)
	            list.add(i);
	        System.out.println(list);
	        System.out.println();

	        Iterator<Integer> iterator = list.iterator();
	        DNode<Integer> current = list.tail.prev;
	        if(current == null) return;
	        while(current.prev != null){
	        	System.out.println(current.data);
	        	current = current.prev;
	        }

//	        // go forwards with next() and set()
//	        System.out.println("add 1 to each element via next() and set()");
//	        while (iterator.hasNext()) {
//	            int x = iterator.next();
//	            iterator.set(x + 1);
//	        }
//	        System.out.println(list);
//	        System.out.println();
//
//	        // go backwards with previous() and set()
//	        System.out.println("multiply each element by 3 via previous() and set()");
//	        while (iterator.hasPrevious()) {
//	            int x = iterator.previous();
//	            iterator.set(x + x + x);
//	        }
//	        System.out.println(list);
//	        System.out.println();
//
//
//	        // remove all elements that are multiples of 4 via next() and remove()
//	        System.out.println("remove elements that are a multiple of 4 via next() and remove()");
//	        while (iterator.hasNext()) {
//	            int x = iterator.next();
//	            if (x % 4 == 0) iterator.remove();
//	        }
//	        System.out.println(list);
//	        System.out.println();
//
//
//	        // remove all even elements via previous() and remove()
//	        System.out.println("remove elements that are even via previous() and remove()");
//	        while (iterator.hasPrevious()) {
//	            int x = iterator.previous();
//	            if (x % 2 == 0) iterator.remove();
//	        }
//	        System.out.println(list);
//	        System.out.println();
//
//
//	        // add elements via next() and add()
//	        System.out.println("add elements via next() and add()");
//	        while (iterator.hasNext()) {
//	            int x = iterator.next();
//	            iterator.add(x + 1);
//	        }
//	        System.out.println(list);
//	        System.out.println();
//
//	        // add elements via previous() and add()
//	        System.out.println("add elements via previous() and add()");
//	        while (iterator.hasPrevious()) {
//	            int x = iterator.previous();
//	            iterator.add(x * 10);
//	            iterator.previous();
//	        }
//	        System.out.println(list);
//	        System.out.println();
	    }

}
