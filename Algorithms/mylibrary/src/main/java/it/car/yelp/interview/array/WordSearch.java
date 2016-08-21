package it.car.yelp.interview.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class WordSearch {

	public static void main(String args[]){
		char[][] board = new char[][]{{'A','B', 'C', 'E'},{'S','F', 'C', 'S'},{'A','D', 'E', 'E'} }; //{"ABCE"}, {"SFCS"}, {"ADEE"}
		String s = "ABCCED";
		//		System.out.println(exist(board, s));+
		//		removeElement(new int[]{4, 5}, 4);
		//		System.out.println(compareVersion("01","1"));
		//		"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"
		boolean res = isValidSudoku(new char[][]{
				{'.','.','.',	'.','5','.',	'.','1','.'},
				{'.','4','.',	'3','.','.',	'.','.','.'},
				{'.','.','.',	'.','.','4',	'.','.','7'},

				{'8','.','.',	'.','.','.',	'.','2','.'},
				{'.','.','2',	'.','7','.',	'.','.','.'},
				{'.','1','5',	'.','.','.',	'.','.','.'},

				{'.','.','.',	'.','.','2',	'.','.','.'},
				{'.','2','.',	'9','.','.',	'.','.','.'},
				{'.','.','4',	'.','.','.',	'.','.','.'}});
		//		System.out.println(res);
		//[".87654321","2........","3........","4........","5........","6........","7........","8........","9........"]
//		int[] resA = twoSum(new int[]{3,2,4}, 6);
		List<List<Integer>> res4 = fourSumV2(new int[]{-3, -1, 0, 2, 4, 5},  0);
		System.out.println(res4);

	}


	public static boolean exist(char[][] board, String word) {
		int dim1 = board.length;
		int dim2 = board[0].length;
		boolean[][] boardVisited = new boolean[dim1][dim2];
		boolean res = false;
		for(int i = 0; i < dim1; i++){
			for(int j = 0; j < dim2; j++){
				if(recursive(board, word, 0, i, j, boardVisited)) return true;
			}
		}

		return res;
	}

	public static boolean recursive(char[][] board, String word, int start, int i, int j, boolean[][] boardVisited){

		if((start == word.length())){
			return true;
		}

		if(i>=board.length || j >= board[0].length || i < 0 || j < 0)
			return false;

		if(boardVisited[i][j]) 
			return false;

		if(board[i][j]!=word.charAt(start))
			return false;
		boardVisited[i][j] = true;

		boolean bool1 = recursive(board, word, start +1, i + 1, j, boardVisited) || recursive(board, word, start +1, i, j - 1, boardVisited)||recursive(board, word, start +1, i - 1, j, boardVisited) ||recursive(board, word, start +1, i, j + 1, boardVisited);
		boardVisited[i][j] = false;
		return bool1 ;

	}

	public static void rotate(int[] nums, int k) {
		k = k%nums.length;
		int[] numsRes = new int[nums.length];
		for(int i = 0; i < nums.length; i ++){
			numsRes[(i+k)%nums.length] = nums[i];
		}

		System.arraycopy( numsRes, 0, nums, 0, nums.length );

		for(int i = 0; i < nums.length; i ++){
			System.out.print(nums[i] + " ");
		}


	}

	public static int removeElement(int[] A, int elem) {

		int p = 0;
		int p1 = 0;

		while(p<A.length){
			if(A[p]!=elem){
				A[p1] = A[p];
				p1++;
			}
			p++;
		}

		for(int i = 0; i < p1; i ++){
			System.out.print(A[i] + " ");
		}

		return p1; 
	}

	public static boolean isValid(String s) {

		HashMap<Character, Character> map = new HashMap<>();
		map.put(')','(');
		map.put(']','[');
		map.put('}','{');

		Stack<Character> stack = new Stack<>();

		for(int i = 0; i<s.length(); i ++){
			char c = s.charAt(i);
			if(map.containsKey(c)){
				if(!stack.empty() && map.get(c) == stack.peek()){
					stack.pop();
				}else 
					return false;
			}else{
				if(map.containsValue(c)){
					stack.push(c);
				}
			}

		}

		if(!stack.isEmpty()) 
			return false;

		return true;

	}

	public static int trailingZeroes(int n) {
		//		 int fct = factorial(n);
		//	        int count = 0;
		//	        
		//	        System.out.println("fact[" + fct + "]");
		//	        
		//	        while(fct%10 == 0){
		//	            count++;
		//	            fct = fct/10;
		//	        }
		//	        
		//	        return count;
		int numZero=0;
		while(n>0){
			numZero+=n/5;
			n=n/5;
		}
		return numZero;
	}

	public static int factorial(int n){
		if(n == 0 || n == 1) return 1;
		return n * factorial(n-1);
	}

	public static int titleToNumber(String s) {
		int offSet = 'Z' - 'A' ;
		int count = 0;        

		count += s.length();

		for(int i = 0; i < s.length(); i++){
			count += ((s.charAt(s.length() - 1 - i) - 'A' + 1)* (int) Math.pow(offSet, i));
		}

		return count -1;

	}

	public static int compareVersion(String version1, String version2) {



		version1 = deleteZero(version1);
		version2 = deleteZero(version2);

		if(version1.equals(version2))
			return 0;

		int i = 0;
		while(i < version2.length() || i < version1.length()){
			if(i < version2.length() && i < version1.length()){
				if(version1.charAt(i)>version2.charAt(i))
					return 1;
				else if(version1.charAt(i) != version2.charAt(i) && version2.charAt(i) != '.')
					return -1;
			}else if(i < version2.length()){
				return -1;
			}else{
				return 1;
			}
			i++;
		}

		return -1;
	}


	private static String deleteZero(String version) {
		// TODO Auto-generated method stub

		int count = 1;
		while(version.startsWith("0")){
			version = version.substring(count);
			count++;
		}

		count = 1;
		while(version.endsWith("0")){
			version = version.substring(0, (version.length() - count));
			count++;
		}

		return version;
	}
	public static boolean isValidSudoku(char[][] board) {

		HashMap<Character, Character> row = new HashMap<>();
		HashMap<Character, Character> col = new HashMap<>();

		HashMap<Character, Character> rect = new HashMap<>();

		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){


				if(board[i][j] != '.' && (Character.getNumericValue(board[i][j])<1 || Character.getNumericValue(board[i][j]) > 9 ) || 
						board[j][i] != '.' && (Character.getNumericValue(board[j][i])<1 || Character.getNumericValue(board[j][i]) > 9 ) ||
						board[i][j] != '.' && row.containsKey(board[i][j]) ||
						board[j][i] != '.' && col.containsKey(board[j][i])){
					return false;
				}

				//				if(board[j][i] != '.' && (Character.getNumericValue(board[j][i])<1 || Character.getNumericValue(board[j][i]) > 9 )){
				//					return false;
				//				}


				//				if(board[i][j] != '.' && row.containsKey(board[i][j])) {
				//					System.out.println();
				//					return false;
				//				}
				//
				//
				//				if(board[j][i] != '.' && col.containsKey(board[j][i])) {
				//					System.out.println();
				//					return false;
				//				}

				if(board[i][j] != '.')
					row.put(board[i][j], board[i][j]);
				if(board[j][i] != '.')
					col.put(board[j][i], board[j][i]);

			}

			row.clear();
			col.clear();
		}

		for(int k = 0; k < 9; k+=3){
			for(int y = 0; y < 9; y+=3){
				//				System.out.print("k[" + k +"] y[" + y + "]       ");
				for(int i = k; i < k + 3; i++){
					for(int j = y; j < y + 3; j++){
						//						System.out.print("i[" + i +"] j[" + j + "]    ");
						if(board[i][j] != '.' && rect.containsKey(board[i][j])) {
							return false;
						}
						if(board[i][j] != '.')
							rect.put(board[i][j], board[i][j]);
					}
				}
				rect.clear();
			}
		}

		return true;
	}






	private static void getSubsets(List<Integer> superSet, int k, int idx, Set<Integer> current,List<Set<Integer>> solution) {
		//successful stop clause
		if (current.size() == k) {
			solution.add(new HashSet<>(current));
			return;
		}
		//unseccessful stop clause
		if (idx == superSet.size()) return;
		Integer x = superSet.get(idx);
		current.add(x);
		//"guess" x is in the subset
		getSubsets(superSet, k, idx+1, current, solution);
		current.remove(x);
		//"guess" x is not in the subset
		getSubsets(superSet, k, idx+1, current, solution);
	}

	public static List<Set<Integer>> getSubsets(List<Integer> superSet, int k) {
		List<Set<Integer>> res = new ArrayList<>();
		getSubsets(superSet, k, 0, new HashSet<Integer>(), res);
		return res;
	}


	public static List<List<Integer>> fourSumV2(int[] num, int target) {
		List<List<Integer>> listaRes = new ArrayList<>();
		HashMap<Integer, ArrayList<Bean>> mapSumCouple = new HashMap<>();
		
		ArrayList<Bean> subMap;

		for(int i = 0; i < num.length; i++){
			for(int j = i + 1; j < num.length; j++){
				if(mapSumCouple.containsKey(Integer.valueOf(num[i] + num[j]))){
					mapSumCouple.get(num[i] + num[j]).add( new Bean(num[i], i, num[j], j));
				}else{
					subMap =  new ArrayList<>();
					subMap.add(new Bean(num[i], i, num[j], j));
					mapSumCouple.put((Integer.valueOf(num[i] + num[j])), subMap);
				}
			}
		}

		Set<Integer> keys = mapSumCouple.keySet();
		HashSet<List<Integer>> hasS = new HashSet<>();

		for(Integer i : keys){
			if(mapSumCouple.containsKey(target - i.intValue())){
				ArrayList<Bean> subKeys1 = mapSumCouple.get(i.intValue());
				ArrayList<Bean> subKeys= mapSumCouple.get(target - i.intValue());
				for(Bean b : subKeys){
					for(Bean a : subKeys1){
						if((b.isValid(a))){
							List<Integer> tmp = new ArrayList<Integer>(4);
							tmp.add(b.x);
							tmp.add(b.y);
							tmp.add(a.x);
							tmp.add(a.y);
							Collections.sort(tmp);

							hasS.add(tmp);
						}

					}
				}
			}
		}
		listaRes.addAll(hasS);
		return listaRes;
	}

	public  static boolean exist(ArrayList<Bean> arr, Bean b){
		for(Bean bb : arr){
			if(b.xIndex == bb.xIndex || b.xIndex == bb.yIndex || b.yIndex == bb.xIndex || b.yIndex == bb.yIndex){
				return true;
			}
		}
		return false;
	}

	static class Bean{

		int x;
		int y;

		int xIndex;
		int yIndex;

		public Bean(int x, int xIndex, int y, int yIndex){
			this.x = x;
			this.y = y;
			this.xIndex = xIndex;
			this.yIndex = yIndex;
		}


		public boolean isValid(Bean b){

			if(b.xIndex == this.xIndex || b.xIndex == this.yIndex || b.yIndex == this.xIndex || b.yIndex == this.yIndex){
				return false;
			}

			return true;
		}

	}


}
