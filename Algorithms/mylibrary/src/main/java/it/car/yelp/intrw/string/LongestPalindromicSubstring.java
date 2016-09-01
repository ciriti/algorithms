package it.car.yelp.intrw.string;

public class LongestPalindromicSubstring {

	public static void main(String args[]){

		String test = "bb";

		String res = "";
		long start = System.currentTimeMillis();
		res = longestPalindrome(test);
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(res);
	}

	public static String longestPalindrome(String s) {
        String res = "";
        int diff = -1;
        
        if(s== null || s.length()==0) return res;
        if(s.length() == 1) return s;
        
        int[] firstIndex;
        int[] secondIndex;
        
        for(int i = 0; i < s.length(); i++){
            firstIndex = check(s, i, i);
            secondIndex = check(s, i, i+1);
            if(firstIndex[1]-firstIndex[0] > secondIndex[1]-secondIndex[0]){
                if(res.length()<(firstIndex[1]-firstIndex[0]+1)){
                    res = s.substring(firstIndex[0], firstIndex[1]+1);
                }
            }else{
                 if(res.length()<(secondIndex[1]-secondIndex[0]+1)){
                    res = s.substring(secondIndex[0], secondIndex[1]+1);
                }
            }
        }
        
        return res;
    }
    
    public static int[] check(String s, int lo, int hi){
        int[] values = new int[2];
        while(lo>=0 && hi<s.length()){
            if(s.charAt(lo)!=s.charAt(hi)){
                break;
            }else{
                lo--;
                hi++;
            }
            
        }
        values[0] = lo+1;
        values[1] = hi-1;
        return values;
    }

}
