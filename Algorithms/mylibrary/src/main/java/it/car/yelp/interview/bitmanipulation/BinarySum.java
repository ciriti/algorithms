package it.car.yelp.interview.bitmanipulation;

import java.util.Stack;

public class BinarySum {

	public static void main(String args[]){
		long start = System.nanoTime();
		System.out.println(addBinary("1", "1"));
		System.out.println("time: " + (System.nanoTime()-start));
	}

	public static String addBinary(String a, String b) {
		StringBuilder res = new StringBuilder();

		if(a.length()==0 && b.length()==0) return "";
		if(a.length()==0) return b;
		if(b.length()==0) return a;

		Stack<Character> stack = new Stack<>();

		//recursive(a, b, a.length()-1, b.length()-1, '0', stack);
		char carry = '0';
		int max = Math.max(a.length(), b.length());
		char [] resSum;
		for(int i = 0; i < max; i ++){
			char achar = (i < a.length()? a.charAt(a.length()-1-i):'0');
			char bchar = (i < b.length()? b.charAt(b.length()-1-i):'0');
			resSum = sum2Char(achar, bchar, carry);
			stack.push(resSum[1]);
			carry = resSum[1];
		}
		
		if(carry!='0')
			stack.push(carry);

		while(!stack.isEmpty()){
			res.append(stack.pop().toString());
		}

		return res.toString();
	}

	static void recursive(String a, String b, int sizeA, int sizeB, char carry, Stack<Character> stack){
		if(sizeA < 0 && sizeB < 0){
			if(carry!='0')
				stack.push(carry);
			return;
		}
		if(sizeA < 0){
			char[] res = sum2Char('0', b.charAt(sizeB), carry);
			stack.push(res[1]);
			recursive(a, b, sizeA, --sizeB, res[0], stack);
		}else if(sizeB < 0){
			char[] res = sum2Char(a.charAt(sizeA), '0', carry);
			stack.push(res[1]);
			recursive(a, b, --sizeA, sizeB, res[0], stack);
		}else{
			char[] res = sum2Char(a.charAt(sizeA), b.charAt(sizeB), carry); 
			stack.push(res[1]);
			recursive(a, b, --sizeA, --sizeB, res[0], stack);
		}

	}

	static char[] sum2Char(char first, char second, char carry){

		if(first == second && second == '0' && carry == '0')
			return new char[]{'0', '0'};
		if((first == second && second == '0' && carry == '1') || (first != second && carry == '0'))
			return new char[]{'0', '1'};
		if((first == second && second == '1' && carry == '0') || (first != second && carry == '1'))
			return new char[]{'1', '0'};
		return new char[]{'1', '1'};

		//        if(first == second && second == '0'){
		//            if(carry == '0')
		//                return new char[]{'0', '0'};
		//            else{
		//                return new char[]{'0', '1'};
		//            }
		//        }
		//            
		//        if(first == second && second == '1'){
		//            if(carry == '0')
		//                return new char[]{'1', '0'};
		//            else
		//                return new char[]{'1', '1'};
		//        }
		//        
		//        if(carry == '0')   
		//            return new char[]{'0', '1'};
		//        return new char[]{'1', '0'};
	}

}
