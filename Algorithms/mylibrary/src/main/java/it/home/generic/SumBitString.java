package it.home.generic;

public class SumBitString {
	
	public static void main(String args[]){
		
		String s1 = "1111";
		String s2 = "1100100";
		
		int max = s1.length()>s2.length()?s1.length():s2.length();
		
		char[] res = new char[max+1];
		for(int i = 0; i < (max+1); i++) 
			res[i] = '0';
		
		char rest = '0';
		
		for(int i = 0; i < max+1; i++){
			
			char one = i > s1.length()-1?'0':s1.charAt((s1.length()-1-i));
			char two = i > s2.length()-1?'0':s2.charAt((s2.length()-1-i));
			
			rest = sum(i, one, two, rest, res);
		}
		
		System.out.println(res);
		
	}

	private static char sum(int i, char one, char two, char rest, char[] res) {
		// TODO Auto-generated method stub
		char restTmp = '0';
		
		if(one == two && one == '1'){
			res[res.length-1-i] = (rest=='0'?'0':'1');
			restTmp = '1';
		}else if(one == two){
			restTmp = '0';
			res[res.length-1-i] = (rest=='0'?'0':'1');
		}else{
			restTmp = '0';
			res[res.length-1-i] = (rest=='0'?'1':'0');
			restTmp = (rest=='0'?'0':'1');
		}
		
		return restTmp;
	}
	

}
