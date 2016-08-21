package it.car.palindrome;

public class PalindromeString{
	
 public static void main(String args[]){
         
         String test = "assa"; 
         PalindromeString tester = new PalindromeString();
         tester.isPalindrome1(test);
         System.out.println(isPalindrome(test));
     }

    /**
    * check if is palindrome 1
    */
 
    public static boolean isPalindrome(String test){
        int dim = test.length();
        for(int i = 0; i<dim/2; i++){
            if(!(test.charAt(i)==test.charAt(dim -1-i))){
                return false;
            }
        }        
        return true;
    }
    
     public boolean isPalindrome1(String test){
        int dim = test.length();
        for(int i = 0; i<dim/2; i++){
            if(!(test.charAt(i)==test.charAt(dim -1-i))){
                return false;
            }
        }        
        return true;
    }
     

     /**
      * ------------------------------------------------------------------------
      */
     
    
}
