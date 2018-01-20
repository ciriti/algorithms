package it.car.yelp.intrw.binarytree;


import java.util.ArrayList;
import java.util.List;

public class PathSumII {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> res = new ArrayList<>();

		if(root == null) return res;

		List<Integer> tmp = new ArrayList<>();
		fillResult(new ArrayList<Integer>(), res, root, 0, sum);
		return res;
	}

	public void fillResult(List<Integer> tmp, List<List<Integer>> res, TreeNode node, int sum, int target){
		if(node.left == null && node.right == null){
			if(sum + node.val == target){
				List<Integer> tmp1 = new ArrayList<>(tmp);
				tmp1.add(node.val);
				res.add(tmp1);
			}
		}else{
			if(node.left != null){
				List<Integer> tmp1 = new ArrayList<Integer>(tmp);
				tmp1.add(node.val);
				fillResult(tmp1, res, node.left, (node.val+sum), target);
			}
			if(node.right != null){
				List<Integer> tmp1 = new ArrayList<Integer>(tmp);
				tmp1.add(node.val);
				fillResult(tmp1, res, node.right, (node.val+sum), target);
			}
		}
	}

}
