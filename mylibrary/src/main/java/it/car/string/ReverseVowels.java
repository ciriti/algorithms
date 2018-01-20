package it.car.string;

/**
 * Created by ciriti on 04/09/16.
 */

public class ReverseVowels {

    /**
     * Write a function that takes a string as input and reverse only the vowels of a string.

     Example 1:
     Given s = "hello", return "holle".

     Example 2:
     Given s = "leetcode", return "leotcede".

     Note:
     The vowels does not include the letter "y".


     * @param args
     */

    public static void main(String args[]){
        System.out.println(new ReverseVowels().reverseVowels(""));
    }

    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;
        char[] arr = s.toCharArray();
        while(i<j){

            if(isVowels(arr[i]) && isVowels(arr[j])){
                char c = arr[i];
                arr[i] = arr[j];
                arr[j] = c;
                i++;
                j--;
            } else if(isVowels(arr[i]) && !isVowels(arr[j])){
                j--;
            } else
                i++;



        }

        return new String(arr);
    }

    public boolean isVowels(char c){
        return c == 'a'
                || c == 'e'
                || c == 'i'
                || c == 'o'
                || c == 'u'
                || c == 'A'
                || c == 'E'
                || c == 'I'
                || c == 'O'
                || c == 'U'
                ;
    }

}
