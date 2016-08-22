package it.car.yelp.interview.math;

public class MultiplyString {
	
	 public static void main(String[] args) {
		    System.out.println(multiply("234523", "100"));
		  }
		  
		   public static String multiply(String num1, String num2) {
			   
			if(num1.length() > num2.length()){
				String tmp = num1;
				num1 = num2;
				num2 = tmp;
			}
			   
		     
		     int[] res = new int[num1.length() + num2.length()+1];

		     //support variable
		     int carry = 0;
		     int dot = 0;
		     int n1 = 0;
		     int n2 = 0;


		     int sizeN1= num1.length();
		     int sizeN2= num2.length();
		     int count = 0;

		     for(int i = 0; i < sizeN1; i++){
		       for(int j = 0; j < sizeN2; j++){
		         n1 = i<num1.length()?Integer.valueOf(num1.substring(num1.length()-1-i, num1.length()-i)):0; 
		         n2 = j<num2.length()?Integer.valueOf(num2.substring(num2.length()-1-j, num2.length()-j)):0; 
		         dot = (n1 * n2) + carry;
		         carry = dot/10;
		         dot = dot%10;
		         res[res.length-1-j-i] = dot;
		         count = res.length-j-i;
		       }

		     }
		     
		     res[res.length-1-count] = carry;
		     boolean checkZero = false;
		     StringBuffer sb = new StringBuffer();
		     for(int i = 0; i < res.length; i++){
		    	 if(checkZero || res[i] != 0){
		             checkZero = true;
		             sb.append(res[i]);
		           }
		     }

		     return sb.toString();
		    }

}
