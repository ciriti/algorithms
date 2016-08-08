package it.car.yelp.interview.datastructure.linkedlist;

public class ReverseLinkedList {
	
	/**
	 * Reverse Linked List 
	 * 
	 * 
	 * @author ciriti
	 *
	 */

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static ListNode reverseIterative1(ListNode node){
		return null;

	}
	
	public static ListNode reverseRecursiv1(ListNode node){
		
		ListNode tmp = null;
		ListNode curr = node;
		ListNode next = curr.next;
		
		if(next == null){
			return curr;
		}else{
			tmp = reverseRecursiv1(next);
			next.next = curr;
			curr.next = null;
		}
		
		return tmp;
	}

	public static void main(String args[]){

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;

		ListNode newNode =reverseRecursiv1(l1);
		System.out.println();


	}

	public static ListNode reverseIterative(ListNode node){
		ListNode prev = null;
		ListNode curr = node;
		ListNode succ = node.next;

		while(succ != null){
			curr.next = prev;
			prev = curr;
			curr = succ;
			succ = succ.next;
			curr.next = prev;
		}
		return curr;

	}

	public static ListNode reverseRecursiv(ListNode node){
		ListNode tmp = null;
		ListNode curr = node;
		ListNode succ = curr.next;

		if(succ == null){
			return curr;
		}else{
			tmp = reverseRecursiv(succ);
			succ.next = curr;
			curr = null;
		}


		return tmp;
	}



}
