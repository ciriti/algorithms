package it.car.yelp.intw.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class FindValueTree {

	public static void printLevel(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			
			TreeNode tempNode = queue.poll();
			
			System.out.printf("%d ",tempNode.val);
			
			if(tempNode.left!=null)
				queue.add(tempNode.left);
			if(tempNode.right!=null)
				queue.add(tempNode.right);
		}
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main(String args[]){

		TreeNode root = new TreeNode(1);
		TreeNode uno = new TreeNode(2);
		TreeNode due = new TreeNode(3);
		TreeNode tre = new TreeNode(4);
		TreeNode qu = new TreeNode(5);
		TreeNode cin = new TreeNode(6);
		TreeNode sei = new TreeNode(7);

		root.left = uno;
		root.right = due;
		uno.left = tre;
		uno.right = qu;
		due.left = cin;
		due.right = sei;

		printLevel1(root);

	}
	
	public static void printLevel1(TreeNode node){
		
		Queue<TreeNode> q = new LinkedList<>();
		
		q.add(node);
		TreeNode tmp;
		while(!q.isEmpty()){
			tmp = q.poll();
			System.out.printf("%d ", tmp.val);
			if(tmp.left != null) q.add(tmp.left);
			if(tmp.right != null) q.add(tmp.right);
		}
		
	}

}
