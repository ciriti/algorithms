/*  Recursion example: creating anagrams

An anagram is a type of word play, the result of rearranging the
letters of a word or phrase to produce other words, using all the
original letters exactly once.

This is a class that asks the user to enter a string and prints out
all anagrams of that string, that is, all possible orderings
(permutations), of the letters in the string. For example, the
anagrams of "abc" are: abc, acb, bac, bca, cab, cba.

The main method is makeAnagram() which is recursive. It works as follows:
put every character in the string as first letter, and recursively find all 
anagrams of the remaining letters. 

Laura Toma, csci107
*/
public class Anagram {
	
	static int count = 10;
	
	public static void main (String args[]) {
		
//		ReadStream r = new ReadStream();
//		//Read a string from the user
//		System.out.print("Enter a string:"); 
//		String s = r.readString(); 
//		r.readLine(); 
		
		String s ="abcdefgh";

		//We convert the string to an array of characters. Basically
		//we want to freely change the letters in the string, and this
		//is not possible with class String, and is too cumbersome
		//with class StringBuffer.
		long start = System.currentTimeMillis();
		char[] text = new char[s.length()]; 
		for (int i=0; i<s.length(); i++) 
			text[i] = s.charAt(i);
				
		System.out.println("Here are all the anagrams of " + s);
		makeAnagram(text, 0); 
		System.out.println("finish : " + (System.currentTimeMillis() - start));
		System.out.println("Goodbye! ");
	} // end of main

	/* This method prints all anagrams of a obtained by leaving the first 
	   i characters unchanged and going through all possible orderings of 
	   characters i and beyond. For example:
	   makeAnagram("abc", 1) prints out abc acb 
	   makeAnagram("abc", 0) prints out abc acb bac bca cab cba
	   makeAnagram("abcd", 2) prints out abcd abdc
	*/
	static void makeAnagram(char[] a, int i) {
		// System.out.println("MakeAnagram i=" + i); //for debug
		if (i == a.length-1)  {
			count++;
//			printArray(a);
			
		}
			
		else {
			for (int j=i; j< a.length; j++) {
				//swap a[i] with a[j]
				char c = a[i]; 
				a[i] = a[j]; 
				a[j] = c;
				makeAnagram(a, i+1);
				//swap back
				c = a[i]; 
				a[i] = a[j]; 
				a[j] = c;
			}
		}
	}//end of makeAnagram
	
	//print an array
	static void printArray(char [] a) {
		System.out.print(count + " ");
		for (int i=0; i< a.length; i++) 
			System.out.print(a[i]); 
		System.out.println();
	} //end of printArray	
} // end of class