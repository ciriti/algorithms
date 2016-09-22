package it.car.yelp.intrw.datastructure.linkedlist;


public class RemoveNthNodeFromEndofList {
	
	/**
	 * Given a linked list, remove the nth node from the end of list and return its head.
	 * LINK - https://leetcode.com/problems/remove-nth-node-from-end-of-list/
	 * @param head
	 * @param n
	 * @return
	 */
	
	public static ListNode removeNthFromEnd(ListNode head, int n){
		
		if(head == null || n==0) return head;
		
		int count = 0;
		ListNode tmp = head;
		
		while(tmp!=null){
			tmp = tmp.next;
			count++;
		}
		
		if(count==1 && n>=1) return null;
		
		int pos = count - n;
		if(pos == 0){
			return head.next;
		}
		ListNode tmp1 = head;
		while(tmp1 != null){
			pos--;
			if(pos == 0){
				tmp1.next = tmp1.next.next;
				break;
			}
			tmp1 = tmp1.next;
			
		}
		
		return head;
	}
	
	public static void main(String args[]){

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
//		ListNode l3 = new ListNode(3);
//		ListNode l4 = new ListNode(4);
//		ListNode l5 = new ListNode(5);
//
		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;

		ListNode newNode = removeNthFromEnd(l1, 2);
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
