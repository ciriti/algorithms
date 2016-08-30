package it.car.yelp.intw.datastructure.binarytree;

import java.util.LinkedList;

/**
 * 
 * The difference between i BST e BT is that the BST have the value of the left leaf is less than the value of parent and 
 * the value of the right leaf is greater than the vaule of the parent
 * @author carmelo.iriti
 *
 */
public class SerializationDeserializationBST {

	TreeNode root;
	int N = 0;


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

	public static LinkedList<Integer> preorderVisit(TreeNode root){
		LinkedList<Integer> result = new LinkedList<>();
		preorderRecursive(root, result);
		return result;
	}

	private static void preorderRecursive(TreeNode root, LinkedList<Integer> result){
		if(root == null)
			return;
		result.add(root.val);
		preorderRecursive(root.left, result);
		preorderRecursive(root.right, result);

	}

	public static void main(String[] args){
		SerializationDeserializationBST theTree = new SerializationDeserializationBST();
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
		
		// serializzo
		LinkedList<Integer> res = preorderVisit(theTree.returnRoot());
		System.out.println(res);
		theTree = new SerializationDeserializationBST();
		for(Integer i : res){
			theTree.insert(i.intValue());
		}
		res = preorderVisit(theTree.returnRoot());
		System.out.println(res);

	}


	public class TreeNode {
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
