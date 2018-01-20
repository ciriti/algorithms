package it.home.generic;

public class IsUniqueChar {
	
	public static void main(String args[]){
		String test1 = "qwertyuio";
		System.out.println("is unique: " + isAnagram(test1));
	}

	private static boolean isAnagram(String test1) {
		
		
		boolean[] testBoolean = new boolean[256];
		for(int i = 0; i<test1.length(); i++){
			if(!testBoolean[test1.charAt(i)]){
				testBoolean[test1.charAt(i)] = true;
			}else
				return false;
		}
		
		// TODO Auto-generated method stub
		return true;
	}

}
