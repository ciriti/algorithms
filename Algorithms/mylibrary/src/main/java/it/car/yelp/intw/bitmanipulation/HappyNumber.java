package it.car.yelp.intw.bitmanipulation;

public class HappyNumber {
	
	public static void main(String args[]){
		System.out.println(isHappy(2));
	}
	
	public static boolean isHappy(int n) {
		  
        return recursive(n, 0);
    }
    
    public static boolean recursive(int n, int count){
         if(n==1)
            return true;
         
         if(count == 100)
             return false;
        int res = n;
        int sum = 0;
        while(res>0){
            int mod = res%10;
            sum = sum + mod*mod;
            res = res/10;
        }
        
        return recursive(sum, ++count);
    }

}
