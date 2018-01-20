package it.car.yelp.intrw.datastructure.linkedlist;


public class SplitLinkedListInTwoOrderedList {

	public static ListNode[] split(ListNode head){
		ListNode[] res = new ListNode[2];
		ListNode l1 = null;
		ListNode l2 = null;

		ListNode tmp = head;
		int count = 0;

		while(tmp != null){
			count++;
			tmp = tmp.next;
		}

		int newDim = count/2;

		count = 0;
		tmp = head;
		while(tmp != null){
			count++;
			if(count <= newDim){
				ListNode tmp1 = new ListNode(tmp.val);
				if(l1 == null){
					l1 = tmp1;
				}else
					l1 = buildOrderList(l1, tmp1);
			}else{
				ListNode tmp2 = new ListNode(tmp.val);
				if(l2 == null){
					l2 = tmp2;
				}else
					l2 = buildOrderList(l2, tmp2);
			}
			tmp = tmp.next;
		}

		res[0] = l1;
		res[1] = l2;

		return res;
	}

	static ListNode buildOrderList(ListNode list, ListNode toInsert){

		toInsert = new ListNode(toInsert.val);

		if(toInsert.val < list.val){
			toInsert.next = list;
			return toInsert;
		}
		ListNode tmp = list;
		while(tmp != null){
			if(tmp.next != null && tmp.val < toInsert.val && tmp.next.val > toInsert.val){
				toInsert.next = tmp.next;
				tmp.next = toInsert;
				break;
			}if(tmp.next == null){
				tmp.next = toInsert;
				break;
			}
			tmp = tmp.next;
		}

		return list;

	}

	public static void main(String args[]){

		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(6);
//		ListNode l3 = new ListNode(12);
//		ListNode l4 = new ListNode(2);
//		ListNode l5 = new ListNode(100);
//		ListNode l6 = new ListNode(20);
//		ListNode l7 = new ListNode(11);
//		ListNode l8 = new ListNode(15);

		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
//		l5.next = l6;
//		l6.next = l7;
//		l7.next = l8;

		ListNode[] newNode = split(l1);
		print(newNode[0]);
		print(newNode[1]);

	}

	private static ListNode addHead(ListNode l1) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(0);
		l.next = l1;
		l1 = l;
		return l;
	}

	public static void print(ListNode n){
		while(n!=null){
			System.out.print(n.val + " ");
			n = n.next;
		}
		System.out.println();
	}

}
