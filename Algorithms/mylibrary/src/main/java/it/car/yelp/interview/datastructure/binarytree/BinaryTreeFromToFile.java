package it.car.yelp.interview.datastructure.binarytree;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.LinkedList;


public class BinaryTreeFromToFile {
	
	public static class Tree{
		// Node class
		class Node{
			public int value;
			public Node left;
			public Node right;
			
			public Node(int value){
				this.value = value;
			}
		}
		
		Node root;
		
		public Tree(){
			
		}
		
		public Tree(String stringSerialized) {
			// TODO Auto-generated constructor stub
			String[] strings = stringSerialized.split("-");
			LinkedList<String> ll = new LinkedList<>(Arrays.asList(strings));
			String rootVal = ll.pop();
			int tmp = Integer.valueOf(rootVal);
			root = new Node(tmp);
			restore(ll, root);
			
		}

		void restore(LinkedList<String> ll, Node node) {
			
			if(!ll.isEmpty()){
				String sTmp = ll.pop();
				if(!sTmp.equals("#") && !sTmp.equals("")){
					node.left = new Node(Integer.valueOf(sTmp));
					restore(ll, node.left);
				}
				
				sTmp = ll.pop();
				if(!sTmp.equals("#") && !sTmp.equals("")){
					node.right = new Node(Integer.valueOf(sTmp));
					restore(ll, node.right);
				}
			}
			
		}

		public void  addRight(int target, int value){
			addNode(target, value, true);
		}
		
		public void  addLeft(int target, int value){
			addNode(target, value, false);
		}
		
		void addNode(int target, int value, boolean left){
			if(root == null){
				root = new Node(value);
			}else{
				Node n = searchNode(target, root);
				if(n != null){
					if(left)
						n.left = new Node(value);
					else
						n.right = new Node(value);
				}
					
			}
		}
		
		Node searchNode(int val, Node node){
			Node n = null;
			
			if(node == null)
				return n;
			
			if(node.value == val)
				return node;
			
			n = searchNode(val, node.left);
			
			if(n!=null) 
				return n;
			
			n = searchNode(val, node.right);
			
			return n;
		}

		public String serialize() {
			// TODO Auto-generated method stub
			StringBuilder sb = new StringBuilder();
			preorderVisit(root, sb);
			return sb.toString();
		}

		private void preorderVisit(Node node, StringBuilder sb) {
			// TODO Auto-generated method stub
			if(node == null){
				sb.append("#" + "-");
				return;
			}
			
			sb.append(node.value + "-");
			
			preorderVisit(node.left, sb);
			preorderVisit(node.right, sb);
		}

		public void deserialize(String stringSerialized) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return serialize();
		}
	}
	
	public static void main(String args[]){
		
		// build tree
		Tree tree = new Tree();
		tree.addLeft(0, 50);
		
		tree.addLeft(50, 35);
		tree.addRight(50, 90);
		
		tree.addLeft(90, 10);
		tree.addRight(90, 2);
		
		tree.addRight(35, 1);
		
		// serialize
		String stringSerialized = tree.serialize();
		System.out.println("serializzo: ");
		System.out.println(stringSerialized);
		
		writeOnFile("tree", stringSerialized);
		String serialized = readFromFile("tree");
		
		Tree tree1 = new Tree(serialized);
		System.out.println("deserializzo: \n" + tree1.toString());
		
	}

	private static String readFromFile(String name) {
		// TODO Auto-generated method stub
		StringBuilder res = new StringBuilder();
		BufferedReader br = null;
		FileReader fr = null;
		
		try{
			fr = new FileReader(name);
			br = new BufferedReader(fr);
			String l = "";
			while((l=br.readLine())!=null){
				res.append(l);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(br!=null) br.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return res.toString();
	}

	private static void writeOnFile(String name, String data) {
		// TODO Auto-generated method stub
		BufferedWriter bw = null;
		FileWriter fw = null;
		try{
			fw = new FileWriter(name);
			bw = new BufferedWriter(fw);
			bw.write(data);
			bw.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(bw!=null) bw.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		
		
	}
	

}
