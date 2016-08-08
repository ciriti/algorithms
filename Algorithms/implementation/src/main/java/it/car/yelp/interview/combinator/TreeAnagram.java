package it.car.yelp.interview.combinator;

import java.util.ArrayList;

import java.security.InvalidParameterException;

import java.util.Arrays;
import java.util.List;

public class TreeAnagram {

	public static void main(String args[]){
		List<String> res = new ArrayList<>();
		AnagramTree tree = new AnagramTree();
		
		long start = System.currentTimeMillis();
		
		tree.addValues(new String("abcd").toCharArray());
		tree.getKGroupPermutations(res, 5);
		
		System.out.println("tempo : " + (System.currentTimeMillis() - start));
		
//		Set<String> set = new HashSet<>(res);
		System.out.println(res.size());
		System.out.println(res);
	}
	
	

	static class AnagramTree{
		
		int dimSet = 0;

		NodeTree root;

		static class NodeTree{
			public char value;
			public List<NodeTree> nodes;

			public NodeTree(char value){
				nodes = new ArrayList();
				this.value = value;
			}

		}

		public AnagramTree(){
			root = new NodeTree('*');
		}

		public void getPermutation(List<String> res) {
			// TODO Auto-generated method stub

			fillResult(res, root.nodes, "");

		}
		
		public void getKGroupPermutations(List<String> res, int k) {
			// TODO Auto-generated method stub
			if(k>dimSet)
				throw new InvalidParameterException("k is too large!!!");

			fillResultKGroup(res, root.nodes, "", k);

		}

		private void fillResult(List<String> res, List<NodeTree> nodes, String tmp) {
			// TODO Auto-generated method stub
			if(nodes.size() == 0)
				res.add(tmp);
			else
				for(NodeTree n : nodes){
					fillResult(res, n.nodes, tmp+n.value);
				}
		}
		
		private void fillResultKGroup(List<String> res, List<NodeTree> nodes, String tmp, int k) {
			// TODO Auto-generated method stub
			if(nodes.size() == dimSet - k)
				res.add(tmp);
			else
				for(NodeTree n : nodes){
					fillResultKGroup(res, n.nodes, tmp+n.value, k);
				}
		}

		public void addValues(char[] values){
			addValues(values, root);
			dimSet = values.length;
		}

		public void addValues(char[] values, NodeTree n){

			for(int i = 0; i < values.length; i++){
				NodeTree nNode = new NodeTree(values[i]);
				n.nodes.add(nNode);
				char [] tmp1 = Arrays.copyOfRange(values, 0, i);
				char [] tmp2 = Arrays.copyOfRange(values, i+1, values.length);
				char [] newLength = new char[values.length-1];
				System.arraycopy(tmp1, 0, newLength, 0, tmp1.length);
				System.arraycopy(tmp2, 0, newLength, tmp1.length, tmp2.length);
				addValues(newLength, nNode);
			}

		}

	}

}
