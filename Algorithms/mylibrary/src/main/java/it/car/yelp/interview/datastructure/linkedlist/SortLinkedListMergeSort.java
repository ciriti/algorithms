package it.car.yelp.interview.datastructure.linkedlist;


public class SortLinkedListMergeSort {

	public static void main(String args[]){

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
				ListNode l3 = new ListNode(12);
				ListNode l4 = new ListNode(2);
				ListNode l5 = new ListNode(100);
				ListNode l6 = new ListNode(20);
				ListNode l7 = new ListNode(11);
				ListNode l8 = new ListNode(15);

		l1.next = l2;
				l2.next = l3;
				l3.next = l4;
				l4.next = l5;
				l5.next = l6;
				l6.next = l7;
				l7.next = l8;

		ListNode newNode = sortList(l1);
		print(newNode);

	}


	public static void print(ListNode n){
		while(n!=null){
			System.out.print(n.val + " ");
			n = n.next;
		}
		System.out.println();
	}

	public static ListNode sortList(ListNode head) {

		// initial condition
		if(head == null)
			return null;


		if(head.next == null)
			return head;

		int count = 0;
		ListNode tmp = head;

		while(tmp != null){
			tmp = tmp.next;
			count++;
		}

		int alfCount = count / 2;

		int cnt = 1;
		
		ListNode first = head;
		tmp = first;
		ListNode second = null;
		ListNode tmp1;
		while(tmp != null){

			// questo è il punto fondamentale : rompere la lista a metà
			if(cnt >= alfCount){
				tmp1 = tmp.next;
				tmp.next = null;
				second = tmp1;
				break;
			}
			cnt++;
			tmp = tmp.next;
		}

		first = sortList(first);
		second = sortList(second);

		ListNode res = new ListNode(Integer.MAX_VALUE);
		ListNode res1 = res;

		while(first != null || second != null){
			if(first != null && second != null){
				res.next = new ListNode(first.val < second.val ? first.val:second.val);
				res.next.next = new ListNode(first.val > second.val ? first.val:second.val);
				res = res.next.next;
				first = first.next;
				second = second.next;
			}else if(first != null){
				res.next = new ListNode(first.val);
				res = res.next;
				first = first.next;
			}else{
				res.next = new ListNode(second.val);
				res = res.next;
				second = second.next;
			}
		}

		return res1.next;

	}

}
