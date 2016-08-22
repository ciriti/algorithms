package it.car.yelp.interview.datastructure.binarytree;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * The difference between i BST e BT is that the BST have the value of the left leaf is less than the value of parent and 
 * the value of the right leaf is greater than the vaule of the parent
 * @author carmelo.iriti
 *
 */
public class SerializationDeserializationBT {

	TreeNode root;
	int N = 0;

	/**
	 * Node
	 * @author carmelo.iriti
	 *
	 */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }

		public String toString(){
			return "["+ val + "]";
		}

	}


	/**
	 * Metodi albero binario
	 * @return
	 */
	public TreeNode returnRoot(){
		return root;
	}

	public TreeNode insert(int newVal){

		TreeNode  newNode = new TreeNode(newVal);

		if(root == null)
			root = newNode;
		else{
			N++;
			TreeNode current = root;
			TreeNode parent;
		}

		return root;

	}

	public TreeNode insertValueInParentLeft(int valueParent, int newValue){
		TreeNode res = null;
		insertValueInParent(valueParent, newValue, true);

		return res;
	}

	public TreeNode insertValueInParentRight(int valueParent, int newValue){
		TreeNode res = null;
		insertValueInParent(valueParent, newValue, false);

		return res;
	}

	TreeNode insertValueInParent(int valueParent, int newValue, boolean left){

		if(root == null){
			root = new TreeNode(newValue);
			return root;
		}

		TreeNode res = getNodeFromValue(valueParent);
		if(res == null) return null;
		if(left){
			res.left = new TreeNode(newValue);
		}else{
			res.right = new TreeNode(newValue);
		}

		return res;
	}

	TreeNode getNodeFromValue(int i){
		return searchRecursive(root, i);
	}

	TreeNode searchRecursive(TreeNode root, int val){

		if(root == null)
			return null;

		if(root.val == val)
			return root;

		TreeNode nodeLeft = searchRecursive(root.left, val);
		TreeNode nodeRight = searchRecursive(root.right, val);

		if(nodeLeft!=null)
			return nodeLeft;

		return nodeRight;
	}

	public int getN() {
		return N;
	}

	/**
	 * Serializzazione
	 * @param root
	 * @return
	 */

	public static LinkedList<Integer> serialize(TreeNode root){
		LinkedList<Integer> result = new LinkedList<>();
		preorderRecursive(root, result);
		return result;
	}

	private static void preorderRecursive(TreeNode root, LinkedList<Integer> result){
		if(root == null){
			result.add(-1);
			return;
		}

		result.add(root.val);
		preorderRecursive(root.left, result);
		preorderRecursive(root.right, result);

	}

	/**
	 * Deserializzazione
	 * @param data
	 * @return
	 */

	public static SerializationDeserializationBT deserialize(LinkedList<Integer> result){

		SerializationDeserializationBT tree = new SerializationDeserializationBT();
		tree.insert(result.pop());

		deserializeRecursive(tree.root, result);

		return tree;

	}


	private static void deserializeRecursive(TreeNode root, LinkedList<Integer> result) {
		// TODO Auto-generated method stub
		if(root.left == null && !result.isEmpty()){
			int val = result.poll();
			if(val != -1){
				root.left = new TreeNode(val);
				deserializeRecursive(root.left, result);
			}

		}
		if(root.right == null && !result.isEmpty()){
			int val = result.poll();
			if(val != -1){
				root.right = new TreeNode(val);
				deserializeRecursive(root.right, result);
			}

		}
	}

	/**
	 * Visualizza i nodi a livelli
	 * @param args
	 */

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		List<TreeNode> ll = new LinkedList<>();
		ll.add(root);
		if(root != null)
			levelOrderBottomRec(res, ll);
		Collections.reverse(res);
		return res;
	}

	static void levelOrderBottomRec(List<List<Integer>> res, List<TreeNode> llList){

		if(!llList.isEmpty()){
			List<TreeNode> tmpList = new LinkedList<>();
			List<Integer> val = new LinkedList<>();
			Iterator<TreeNode> it = llList.iterator();
			TreeNode tmpNode;
			while(it.hasNext()){
				tmpNode = it.next();
				if(tmpNode.left != null)
					tmpList.add(tmpNode.left);
				if(tmpNode.right != null)
					tmpList.add(tmpNode.right);
				val.add(tmpNode.val);
			}
			res.add(val);
			levelOrderBottomRec(res, tmpList);
		}
	}

	/**
	 * Max deep
	 * @param args
	 */

	public static int maxDepth(TreeNode root) {
		if(root == null) return 0;

		return maxDepthRec(root);//TODO;
	}

	public static int maxDepthRec(TreeNode node){
		if(node == null) return 0;

		int deepL = maxDepthRec(node.left) + 1;
		int deepR = maxDepthRec(node.right) + 1;

		return Math.max(deepL, deepR);
	}

	/**
	 * 
	 */

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();

		if(root != null){
			//TODO
			LinkedList<TreeNode> ll = new LinkedList<>();
			ll.add(root);
			levelOrderRec(res, ll);
		}

		//		Collections.reverse(res);    
		return res;
	}

	static void levelOrderRec(List<List<Integer>> res, LinkedList<TreeNode> ll){
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<TreeNode> listTmp = new LinkedList<>();
		for(int i = 0; i < ll.size(); i++){
			TreeNode node = ll.get(i);
			list.add(node.val);
			if(node.left != null)
				listTmp.add(node.left);
			if(node.right != null)
				listTmp.add(node.right);
		}
		res.add(list);

		if(!listTmp.isEmpty())
			levelOrderRec(res, listTmp);
	}


	/**
	 * Main to test
	 * @param args
	 */

	public static void main(String[] args){
		SerializationDeserializationBT theTree = new SerializationDeserializationBT();
		TreeNode root = theTree.insert(1);
		theTree.insertValueInParentLeft(root.val, 2);
		//		theTree.insertValueInParentRight( root.val, 3);
		//		theTree.insertValueInParentRight(root.val, 20); 
		//		theTree.insertValueInParentRight(20, 7);
		//		theTree.insertValueInParentLeft(20, 15);

		//Max deep
		System.out.println("Deep: " + maxDepth(root));

		//LevelOrder
		System.out.println("Level Order: " + levelOrder(root));


		//serializzo
		LinkedList<Integer> res = serialize(theTree.returnRoot());
		System.out.println("uno" + res);

		//		//{3,9,20,#,#,15,7}
		//		LinkedList<Integer> data = new LinkedList<>();
		//		data.addAll(Arrays.asList(new Integer[]{3, 9, 20,-1,-1, 15, 7, -1, -1}));

		//deserializzo
		SerializationDeserializationBT theTreeNew = deserialize(res);
		System.out.println("due" + serialize(theTreeNew.returnRoot()));

		//		System.out.println(levelOrderBottom(theTreeNew.root));




	}





}
