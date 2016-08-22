package it.car.recursive;

public class Palindroma {
	

	private static void checkPalindrome(String palindroma, int start, int finish) {
		// TODO Auto-generated method stub
		
		
		if(palindroma.length()==0 || palindroma.length()==1 || start >= finish){
			System.out.print("" + true);
			return;
		}
		
		char[] tmpArr = palindroma.toCharArray();
		if(tmpArr[start] != tmpArr[finish]){
			System.out.print("" +  false);
			return;
		}
			
		else if(start < finish)
			checkPalindrome(palindroma, start+1, finish-1);
		
		
	}
	
	/**
	 * --------------------------------------------------------------------------------------------
	 * @param args
	 */
	public static void main(String args[]){
		
		String palindroma = "aac";
		checkPalindrome(palindroma, 0, palindroma.length()-1);
	}

}
