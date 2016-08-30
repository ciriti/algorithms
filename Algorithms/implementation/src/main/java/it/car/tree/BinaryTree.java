package it.car.tree;

import it.car.yelp.intw.binarytree.FindValueTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



public class BinaryTree {
	
	int N = 0;

	/**
	 * POSTORDER L-R-P
	 */
	private static void buildResultPostorder(TreeNode node) {

		if(node!=null){
			buildResultPostorder(node.left);
			buildResultPostorder(node.right);
			System.out.print(node.val + " - ");
		}
	}

	/**
	 * INORDER L-P-R
	 */
	private static void buildResultInOrder(TreeNode node) {

		if(node!=null){
			buildResultInOrder(node.left);
			System.out.print(node.val + " - ");
			buildResultInOrder(node.right);

		}
	}


	/**
	 * PREORDER P-L-R
	 */
	private static void buildPreOrder(TreeNode node) {

		if(node!=null){
			System.out.print(node.val + " - ");
			buildPreOrder(node.left);
			buildPreOrder(node.right);

		}
	}

	/**
	 * max deep
	 */

	private static int maxDeep(TreeNode node) {
		if (node == null) 
			return 0;
		int left_height = maxDeep(node.left);
		int right_height = maxDeep(node.right);
		return ((left_height > right_height) ? left_height : right_height ) + 1;
	}

	/**
	 * get all leafs
	 */
	
	private static void getAlLeafs(TreeNode node, ArrayList<TreeNode> leafs) {
		
		if(node == null) return;
		
		if(node.left == null && node.right == null)
			leafs.add(node);
		getAlLeafs(node.left, leafs);
		getAlLeafs(node.right, leafs);
		
	}

	/**
	 * level traversal
	 */


	private static void buildLevelTraversal(TreeNode... nodes) {
		TreeNode[] lista = nodes;
		ArrayList<TreeNode> array = new ArrayList<TreeNode>();
		for(int i = 0; i<lista.length; i++){
			System.out.print(lista[i].val + " - ");
			if(lista[i].left!=null){
				array.add(lista[i].left);
			}if(lista[i].right!=null){
				array.add(lista[i].right);
			}
		}
		System.out.println("\n -------------------- FINE LIVELLO ---------------------- ");

		if(array.size()>0){
			TreeNode[] listaTMP = new TreeNode[array.size()];
			for(int i = 0; i<array.size(); i++){
				listaTMP[i] = array.get(i);
			}
			buildLevelTraversal(listaTMP);
		}
	}

	private static ArrayList<TreeNode> buildLevelTraversal(ArrayList<TreeNode> result, TreeNode... nodes) {
		TreeNode[] lista = nodes;
		ArrayList<TreeNode> array = new ArrayList<TreeNode>();
		for(int i = 0; i<lista.length; i++){
			System.out.print(lista[i].val + " - ");
			if(lista[i].left!=null){
				array.add(lista[i].left);
			}if(lista[i].right!=null){
				array.add(lista[i].right);
			}
		}
		System.out.println("\n -------------------- FINE LIVELLO ---------------------- ");

		if(array.size()>0){
			TreeNode[] listaTMP = new TreeNode[array.size()];
			for(int i = 0; i<array.size(); i++){
				listaTMP[i] = array.get(i);
			}
			result.addAll(array);
			buildLevelTraversal(result, listaTMP);
		}

		return result;
	}
	
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

	/**
	 * ------------------------------------------------------------------------------------------------------------------------------------
	 */


	TreeNode root;

	public BinaryTree() {
	}

	public TreeNode returnRoot(){
		return root;
	}

	public void insert(int newVal){

		TreeNode  newNode = new TreeNode(newVal);

		if(root == null)
			root = newNode;
		else{
			N++;
			TreeNode current = root;
			TreeNode parent;
			while(true){

				if(newVal < current.val){
					/**
					 * se � minore vai a sinistra
					 */
					if(current.left!=null){
						current = current.left;
					}else{
						current.left = newNode;
						return;
					}

				}else{
					/**
					 * se � maggiore vai a destra
					 */
					if(current.right!=null){
						current = current.right;
					}else{
						current.right = newNode;
						return;
					}

				}
			}

		}

	}	

	public int getN() {
		return N;
	}

	public static void main(String[] args){
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
//		System.out.println(theTree);
		
		printLevel(theTree.returnRoot());

		//postorderTraversal(theTree.returnRoot());
		//		buildResultInOrder(theTree.returnRoot());
		//		buildPreOrder(theTree.returnRoot());
		//		buildResultPostorder(theTree.returnRoot());
//		System.out.println(maxDeep(theTree.returnRoot()));
//		ArrayList<TreeNode> leafs = new ArrayList<>();
//		getAlLeafs(theTree.returnRoot(), leafs);
//		for (TreeNode treeNode : leafs) {
//			System.out.print(treeNode.val + " - ");
//		}
	}


	public static void postorderTraversal(TreeNode root) {

		System.out.print("PostOrder ");
		buildResultPostorder(root);

		System.out.print("\nInOrder ");
		buildResultInOrder(root);

		System.out.print("\nPreorder ");
		buildPreOrder(root);

		System.out.print("\nVisita a livelli\n ");
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		ArrayList<TreeNode> tmpRes = buildLevelTraversal(result, root);
		System.out.println();
	}



	public class TreeNode {
		int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int x) { val = x; }

		public void displayNode()
		{
			System.out.print("[");
			System.out.print(val);
			System.out.print("]");
		}

	}



}
