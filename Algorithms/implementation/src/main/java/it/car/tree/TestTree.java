package it.car.tree;

import java.util.ArrayList;
import java.util.Stack;

public class TestTree{

	/**
	 *                      42 - 
	 * ------------------------------------ FINE LIVELLO ---------------------- 
	 *            25 -              65 - 
	 *  ------------------------------------ FINE LIVELLO ---------------------- 
	 *         12     37 -       43 -    87 - 
	 * ------------------------------------ FINE LIVELLO ---------------------- 
	 *       9 - 13 -        30 -      86 - 99 - 
	 *  ------------------------------------ FINE LIVELLO ---------------------- 
	 *                                          100 - 
	 *  ------------------------------------ FINE LIVELLO ---------------------- 
	 */


	Node root = null;

	boolean leftNull = false;

	public TestTree(){

	}

	public void insert(int mData){
		Node newNode = new Node(mData);
		if(root == null){
			root = newNode;
		}else{
			recursiveInsert(root, newNode);
		}
	}

	public Node returnRoot(){
		return root;
	}

	public void recursiveInsert(Node current, Node nodeToInsert){
		if(nodeToInsert.data > current.data){
			/**
			 * go right
			 */
			if(current.rigthNode == null){
				current.rigthNode = nodeToInsert;
			}else{
				recursiveInsert(current.rigthNode, nodeToInsert);
			}
		}else{
			if(current.leftNode == null){
				current.leftNode = nodeToInsert;
			}else{
				recursiveInsert(current.leftNode, nodeToInsert);
			}
		}

	}

	private static class Node{

		private int data;
		private Node leftNode;
		private Node rigthNode;

		public Node(int mData){
			this.data = mData;
		}

		public void displayData(){
			System.out.print("" + data + "   ");
		}

	}

	void printValueNode(Node node){
		if(node!=null){
			System.out.print(node.data + " ");
		}
	}

	/**
	 * POSTORDER L-R-P
	 */

	public void postOrder(Node node){

		if(node != null){
			postOrder(node.leftNode);
			postOrder(node.rigthNode);
			printValueNode(node);			
		}

	}


	/**
	 * INORDER L-P-R
	 */
	public void inOrder(Node node){

		if(node != null){
			inOrder(node.leftNode);
			printValueNode(node);
			inOrder(node.rigthNode);
		}

	}
	
	/**
	 * INORDER LINEAR L-P-R
	 */
	public void inOrderLinear(Node node){

		

	}



	/**
	 * PREORDER P-L-R
	 */
	public void preorder(Node node){

		if(node != null){
			printValueNode(node);
			preorder(node.leftNode);			
			preorder(node.rigthNode);
		}


	}

	/**
	 * PREORDER LINEAR P-L-R
	 */
	public void preorderLineare(Node node){
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		while(!stack.isEmpty()){
			Node n = stack.pop();
			System.out.print(n.data + " ");
			if(n.rigthNode != null)
				stack.push(n.rigthNode);
			if(n.leftNode != null)
				stack.push(n.leftNode);
			
		}

	}

	public void level(Node... node){

		if(node.length == 0) return;
		if(node.length == 1){ node[0].displayData(); System.out.println("\n");}

		Node[] nodes = node;
		ArrayList<Node> lista = new ArrayList<Node>();
		int dim = nodes.length;
		for(int i = 0 ; i < dim; i++){
			if(nodes[i].leftNode!=null) lista.add(nodes[i].leftNode);
			if(nodes[i].rigthNode!=null) lista.add(nodes[i].rigthNode);
		}

		for(Node tmp : lista){
			tmp.displayData();
		}

		System.out.println("\n");

		if(lista.size() > 0){
			Node[] tmp = new Node[lista.size()];
			lista.toArray(tmp);
			level(tmp);
		}

	}

	public static void main(String[] args){
		TestTree theTree = new TestTree();
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
		System.out.println(theTree);

		System.out.println("---------------------------------------------");

		System.out.println("preorder recursive");

		theTree.preorder(theTree.returnRoot());

		System.out.println("\npreorder Lineare");

		theTree.preorderLineare(theTree.returnRoot());

		System.out.println("");
		System.out.println("inOrder");

		theTree.inOrder(theTree.returnRoot());

		System.out.println("");
		System.out.println("postOrder");

		theTree.postOrder(theTree.returnRoot());

		System.out.println("");
		System.out.println("level");

		theTree.level(theTree.returnRoot());

		//		postorderTraversal(theTree.returnRoot());
	}

} 
