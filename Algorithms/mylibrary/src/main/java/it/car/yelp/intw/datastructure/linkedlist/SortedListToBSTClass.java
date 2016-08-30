package it.car.yelp.intw.datastructure.linkedlist;

public class SortedListToBSTClass {



	public  static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}


	public  static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main(String args[]){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);


		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		TreeNode treeNode = sortedListToBST(n1);
		System.out.println();
	}


	public static TreeNode sortedListToBST(ListNode head) {

		int dim = sizeList(head);
		TreeNode treeNode = null;

		ListNode p1 = head;
		ListNode p2 = head;

		int count = 0;
		while(p1 != null){
			if(count >= dim/2){
				if(treeNode == null){
					treeNode = new TreeNode(p1.val);
				}else
					fillTree(treeNode, p1);
			}
			p1 = p1.next;
			count ++;
		}

		count = 0;
		while(p2 != null){
			if(count < dim/2){
				if(treeNode == null){
					treeNode = new TreeNode(p2.val);
				}else{
					fillTree(treeNode, p2);
				}

			}
			p2 = p2.next;
			count ++;
		}

		return treeNode;

	}

	public static  void fillTree(TreeNode treeNode, ListNode head){

		if(head.val > treeNode.val ){
			if(treeNode.right == null){
				treeNode.right = new TreeNode(head.val);
			}else{
				fillTree(treeNode.right, head);
			}
		}else{
			if(treeNode.left == null){
				treeNode.left = new TreeNode(head.val);
			}else{
				fillTree(treeNode.left, head);
			}
		}


	}

	public static int sizeList(ListNode head){
		int size = 0;
		ListNode p1 = head;
		while(p1 != null){
			size++;
			p1 = p1.next;
		}
		return size;
	}
}
