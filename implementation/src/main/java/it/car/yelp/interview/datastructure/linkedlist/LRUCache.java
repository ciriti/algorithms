package it.car.yelp.intrw.datastructure.linkedlist;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class LRUCache {

	int capacity;

	public DLLNode head;
	public DLLNode end;

	Map<Integer, DLLNode> map;

	// constructor
	public LRUCache(int capacity){
		this.capacity = capacity;
		map = new HashMap<>(capacity);
	}

	public void set(int key, int value){
		DLLNode current;
		// if exist edit and carry in head
		if(map.containsKey(key)){
			current = map.get(key);
			current.value = value;
			setHead(current);

		}//if doesn't exist create the new node and carry in ead
		else{

			current = new DLLNode(key, value);

			if(map.size() < capacity){
				setHead(current);
			}else{
				map.remove(end.key);
				//end = end.prev;
				remove(end);
				setHead(current);
			}
			map.put(key, current);
		}


	}

	public int size(){
		return map.size();
	}

	public int get(int key){

		if(map.containsKey(key)){
			DLLNode res = map.get(key);
			remove(res);
			return res.value;
		}

		return -1;
	}

	void setHead(DLLNode node){

		// empty list
		if(head == null && end == null){
			head = node;
			end = node;
			return;
		}

		if(head==node) 
			return;

		node.next = head;
		head.prev = node;
		node.prev = null;

		head = node;

	}

	void remove(DLLNode node){

		// only one element
		if(head == end){
			head = null;
			end = null;
			map.remove(node.key);
			return;

		}

		if(node.prev == null){
			head = node.next;
			head.prev = null;
		}else if(node.next == null){
			end = node.prev;
			end.next = null;
		}else{
			DLLNode current_prev = node.prev;
			DLLNode current_next = node.next;

			current_prev.next = current_next;
			current_next.prev = current_prev;
		}

		map.remove(node.key);
	}

	public List<DLLNode> getAllValueOrdered(){
		List<DLLNode> list = new ArrayList<>();

		DLLNode node = head;
		if(node == null) return list;
		list.add(node);
		while(node.next != null){
			list.add(new DLLNode(node.next.key, node.next.value));
			node = node.next;
		}

		return list;
	}

	public List<DLLNode> getAllValueReverse(){
		List<DLLNode> list = new ArrayList<>();

		DLLNode node = end;
		if(node == null) return list;

		while(node.prev != null){
			list.add(new DLLNode(node.next.key, node.next.value));
			node = node.prev;
		}

		return list;
	}


	//Linked list node
	public class DLLNode{

		public int value;
		public int key;

		public DLLNode next;
		public DLLNode prev;

		public DLLNode(int key, int value){
			this.value = value;
			this.key = key;
		}

		public String toString(){
			return "[" + key +" - " + value + "]";
		}
	}
	
	

	public static void main(String args[]){
		LRUCache lru = new LRUCache(2);
		lru.set(2,1);
		lru.set(1,1);
		System.out.println(lru.get(2));
		lru.set(4,1);
		System.out.println(lru.get(1));
		System.out.println(lru.get(2));

//		System.out.println("Stampa lru[" + lru.size() +"]: " + lru.getAllValueOrdered());
	}
	
	/**
	 * Input:	2,[set(2,1),set(1,1),get(2),set(4,1),get(1),get(2)] 
	 * Output:	[1,1,-1] 
	 * Expected:	[1,-1,1]
	 */

	
	


}
