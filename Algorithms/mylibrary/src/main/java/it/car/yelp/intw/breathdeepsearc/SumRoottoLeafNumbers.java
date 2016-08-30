package it.car.yelp.intw.breathdeepsearc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Sum Root to Leaf Numbers 
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * 
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * @author carmelo.iriti
 *
 */
public class SumRoottoLeafNumbers {
	

	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
//		root.left = new TreeNode(2);
		System.out.println(sumNumbers(root));

	}

	public static int sumNumbers(TreeNode root) {

		int resSum = 0;

		if(root == null)return resSum;

		List<Integer> res = new ArrayList<>();

		goRecursive(root, 0, res);

		for(Integer a : res)
			resSum += a;

		return resSum;
	}

	public static void goRecursive(TreeNode node, int n, List<Integer> res){

		if(node == null) {
			return;
		}

		if(node.left == null && node.right == null)
			res.add((n*10 + node.val));
		else{
			goRecursive(node.left, (n*10 + node.val), res);
			goRecursive(node.right, (n*10 + node.val), res);
		}

	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }

		public void displayNode()
		{
			System.out.print("[");
			System.out.print(val);
			System.out.print("]");
		}

	}

}
