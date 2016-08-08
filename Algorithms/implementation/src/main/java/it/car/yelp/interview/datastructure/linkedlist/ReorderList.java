package it.car.yelp.interview.datastructure.linkedlist;


public class ReorderList {
	/**
	 * Reorder List 
	 * 
	 * LINK - https://leetcode.com/problems/reorder-list/
	 */

	public static void main(String args[]){

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		//		ListNode l4 = new ListNode(4);
		//		ListNode l5 = new ListNode(5);
		//		ListNode l6 = new ListNode(20);
		//		ListNode l7 = new ListNode(11);
		//		ListNode l8 = new ListNode(15);

		l1.next = l2;
		l2.next = l3;
		//		l3.next = l4;
		//		l4.next = l5;
		//		l5.next = l6;
		//		l6.next = l7;
		//		l7.next = l8;

		reorderList2(l1);
		print(l1);

	}

	public static void print(ListNode n){
		while(n!=null){
			System.out.print(n.val + " ");
			n = n.next;
		}
		System.out.println();
	}
	
	/**
	 * second version NOT WORKS
	 * 
	 */
	public static void reorderList2(ListNode head) {
		ListNode list = rec(head, head);
		head.next = list.next;
	}
	
	

	private static ListNode rec(ListNode node, ListNode head) {
		// TODO Auto-generated method stub
		ListNode tmp = null;
		ListNode curr = node;
		ListNode next = curr.next;
		
		if(next == null) return curr;
		
		tmp = rec(next, head);
		ListNode tmp1 = head.next;
		head.next = tmp;
		tmp.next = tmp1;
		tmp.next = null;
		head = head.next;
		
		return tmp1;
	}

	/**
	 * First version simple
	 * 
	 * @param head
	 */
	public static void reorderList(ListNode head) {

		if(head == null || head.next == null)return;

		ListNode[] lists = breaListMiddle(head);
		ListNode first = lists[0];
		ListNode second = lists[1];
		ListNode rev = reverse(second);
		ListNode res = merge(first, rev);
		head.next = res.next;
	}

	public static ListNode reverse(ListNode head){
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = curr.next;

		while(next!=null){
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
			curr.next = prev;

		}

		return curr;

	}

	public static ListNode[] breaListMiddle(ListNode head){
		ListNode[] res = null;
		int count = 0;
		ListNode tmp = head;

		while(tmp != null){
			tmp = tmp.next;
			count++;
		}

		ListNode first = head;
		tmp = first;
		ListNode second = null;
		int cnt = 0;
		while(tmp != null){
			cnt++;
			if(cnt==count/2){
				second = tmp.next;
				tmp.next = null;
				break;
			}
			tmp = tmp.next;

		}

		res = new ListNode[]{first, second};
		return res;
	}

	public static ListNode merge(ListNode first, ListNode second){
		ListNode res = new ListNode(-1);
		ListNode res1 = res;

		int count = 2;

		while(first != null || second != null){
			if((first != null && count%2==0) || second == null){
				res.next = new ListNode(first.val);
				first = first.next;
			}else if((second != null && count%2!=0) || first == null){
				res.next = new ListNode(second.val);
				second = second.next;
			}else{
				break;
			}
			res = res.next;
			count ++;
		}
		return res1.next;

	}

}
