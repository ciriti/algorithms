package it.car.tree;

import java.util.ArrayList;

import it.car.graph.util.Queue;

import it.car.tree.BinaryTree.TreeNode;

public class TreeTraversal {

	/**
	 * 42 - 
	 * -------------------- FINE LIVELLO ---------------------- 
	 * 25 - 65 - 
	 *  -------------------- FINE LIVELLO ---------------------- 
	 * 12 - 37 - 43 - 87 - 
	 * -------------------- FINE LIVELLO ---------------------- 
	 * 9 - 13 - 30 - 86 - 99 - 
	 *  -------------------- FINE LIVELLO ---------------------- 
	 * 100 - 
	 *  -------------------- FINE LIVELLO ---------------------- 
	 */

	Queue<TreeNode> queue = new Queue<TreeNode>();
	ArrayList<TreeNode> nodeList;

	public void treeLevelTraversal(TreeNode root){
		queue.enqueue(root);
		breadthTraversal(queue);
	}

	private void breadthTraversal(Queue<TreeNode> queue) {
		// TODO Auto-generated method stub
		while(!queue.isEmpty()){
			TreeNode node = queue.dequeue();
			System.out.print(node.val + " ");
			if(node.left!=null) queue.enqueue(node.left);
			if(node.right!=null) queue.enqueue(node.right);
		}
	}

	private void treeLevelTraversalArray(BinaryTree theTree) {
		// TODO Auto-generated method stub
		int maxLevel = (int)Math.ceil(Math.log(theTree.getN()));
		int maxLeafForLevel = (int)Math.pow(2, (maxLevel-1));
		nodeList = new ArrayList<>(maxLeafForLevel);
		nodeList.add(theTree.returnRoot());
		breadthTraversalArray(nodeList);
	}

	int LevelCount = 0;
	private void breadthTraversalArray(ArrayList<TreeNode> nodeList) {
		// TODO Auto-generated method stub
		for(TreeNode node : nodeList){
			queue.enqueue(node);
		}
		nodeList.clear();
		while(!queue.isEmpty()){
			TreeNode node = queue.dequeue();
			System.out.print(node.val + " ");
			if(node.left!=null) nodeList.add(node.left);
			if(node.right!=null) nodeList.add(node.right);
		}

		System.out.println("\n----------------Level " + ++LevelCount + "-----------------\n");
		if(!nodeList.isEmpty())
			breadthTraversalArray(nodeList);
	}

	public static void main(String ars[]){

		// initialize value
		BinaryTree theTree = new BinaryTree();
		theTree.insert(42);
		theTree.insert(25);
		theTree.insert(65);
		theTree.insert(12);
		theTree.insert(37);
		theTree.insert(13);
		theTree.insert(30);
		theTree.insert(43);
		theTree.insert(87);
		theTree.insert(99);
		theTree.insert(9);
		theTree.insert(86);
		theTree.insert(100);

		TreeTraversal treeTraversal = new TreeTraversal();
		treeTraversal.treeLevelTraversalArray(theTree);

	}



}
