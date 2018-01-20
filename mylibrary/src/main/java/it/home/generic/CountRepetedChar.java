package it.home.generic;

public class CountRepetedChar {
	
	public static void main(String args[]){
		String test = "";
		int count = 1;
		for(int i = 0; i<test.length(); i++){
			char succ = (i+1)<test.length()?test.charAt(i+1):test.charAt(i);
			if(test.charAt(i) == succ && ((i+1)<test.length())){
				count++;
			}else{
				System.out.print(test.charAt(i)+"["+ count+"]");
				count = 1;
			}
		}
	}

}
