package it.car.string;

/**
 * Created by carmeloiriti, 23/09/16.
 */
public class ReverseVowelsofaString {

    public static String reverseVowels(String s) {
        int lo = 0;
        int up = s.length()-1;
        char[] arr = s.toCharArray();
        while(lo<up){

            if(isVolwel(arr[lo]) && isVolwel(arr[up])){
                swap(arr, lo, up);
                lo++;
                up--;
            }else{
                if(!isVolwel(arr[lo]))lo++;
                if(!isVolwel(arr[up]))up--;
            }

        }

        return new String(arr);
    }

    private static boolean isVolwel(char c){
        return c == 'a'
                || c == 'e'
                || c == 'i'
                || c == 'o'
                || c == 'u'
                || c == 'A'
                || c == 'E'
                || c == 'I'
                || c == 'O'
                || c == 'U';
    }

    private static void swap(char[] arr, int i , int j){
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static void main(String args[]){
        System.out.println(reverseVowels("hello").equals("holle")?"SUCCESS":"ERROR");
    }

}
