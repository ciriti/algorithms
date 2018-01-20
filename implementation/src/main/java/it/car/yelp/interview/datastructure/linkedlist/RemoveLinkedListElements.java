package it.car.yelp.intrw.datastructure.linkedlist;


public class RemoveLinkedListElements {
	
	/**
	 * Remove Linked List Elements 
	 * 
	 * LINK - https://leetcode.com/problems/remove-linked-list-elements/
	 * 
	 * @param head
	 * @param val
	 * @return
	 */

	public static ListNode removeElements(ListNode head, int val) {

		if(head==null) return null;
		
		// cicle to delete the node if they are in head
		while(head!=null && head.val == val){
			head = head.next;
		}

		ListNode tmp = head;
		
		while(tmp!=null){
			if(tmp.next!=null && tmp.next.val == val){
				// metod to delete the node duplicates
				tmp.next = getValidNext(tmp.next, val);
			}
			tmp = tmp.next;
		}
		return head;
	}

	private static ListNode getValidNext(ListNode tmp, int v) {
		// TODO Auto-generated method stub
		while(tmp != null && tmp.val == v){
			tmp = tmp.next;
		}
		return tmp;
	}

	public static void main(String args[]){

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		//
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		ListNode newNode = removeElements(l1, 2);
		print(newNode);

	}

	public static void print(ListNode n){
		while(n!=null){
			System.out.print(n.val + " ");
			n = n.next;
		}
		System.out.println();
	}

}
