package it.car.yelp.intrw.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;

public class IntervalsTree {

	IntervalNode root;

	public IntervalsTree(){}

	public void put(int lo, int hi){
		if(root == null){
			root = new IntervalNode(lo, hi);
		}else{
			IntervalNode node = new IntervalNode(lo, hi);
			int max = putNode(root, node);
			if(max > root.max)
				root.max = max;

		}
	}

	int putNode(IntervalNode current, IntervalNode node){
		if(node.compareTo(current) == -1){
			if(current.left == null) {
				current.left = node;
				return node.max;
			} 
			else{
				/**
				 * se vengo da sinistra non calcolo il max
				 */
				int max = putNode(current.left, node);
				//				if(current.max < max)
				//					current.max = max;
				return current.max;
			}
		}else if (node.compareTo(current) == 1){
			if(current.right == null) {
				current.right = node;
				current.max = node.max;
				return node.max;
			} 
			else{
				int max = putNode(current.right, node);
				if(current.max < max){
					current.max = max;
				}
				return current.max;
			}
		}

		return current.max;

	}

	public List<IntervalNode> intersect(int lo, int hi){
		List<IntervalNode> res = new ArrayList<>();
		IntervalNode node = new IntervalNode(lo, hi);
		intersectRecursive(res, root, node);
		System.out.println(res);
		return res;
	}
	
	void intersectRecursive(List<IntervalNode> res, IntervalNode node, IntervalNode target){
		if(node == null)
			return;
		
		if(node.intersect(target)) 
			res.add(node);
		
		if(target.compareTo(node) == 1 && (target.lo < node.max || target.hi < node.max)){
			intersectRecursive(res, node.right, target);
		}
		
		if(node.left != null && (target.lo < node.left.max || target.hi < node.left.max)){
			intersectRecursive(res, node.left, target);
		}
		
	}


	// start class node
	class IntervalNode implements Comparable<IntervalNode>{
		public int lo;
		public int hi;
		public int max;

		public IntervalNode left;
		public IntervalNode right;

		public IntervalNode(int lo, int hi){
			this.lo = lo;
			this.hi = hi;
			this.max = hi;
		}    

		public boolean intersect(IntervalNode that){

			if(this.lo > that.hi) return false;
			if(this.hi < that.lo) return false;

			return true;
		}

		public int compareTo(IntervalNode that){

			if(this.lo < that.lo) return -1;
			else if(this.lo > that.lo) return 1;
			else if(this.hi < that.hi) return -1;
			else if(this.hi > that.hi) return 1;
			else
				return 0;

		}
		
		public String toString(){
			return (lo + " " + hi);
		}

	}
	// end class node


	/**
	 * Test method
	 * @param args
	 */
	public static void main(String[] args) {
		IntervalsTree tree = new IntervalsTree();
		tree.put(17, 19);
		tree.put(21, 24);
//		tree.put(25, 30);
		tree.put(5, 8);
		tree.put(4,8);
		tree.put(15, 18);
		tree.put(7,10);
		tree.put(16, 22);
		
		tree.intersect(21, 23);
	}


}
