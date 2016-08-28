package it.car.palindrome;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by carmeloiriti, 26/08/16.
 */
public class GameofThrones {

    /**
     *
     * Check if the string is an anagram of one palindrome word
     *
     * LINK - https://www.hackerrank.com/challenges/game-of-thrones
    */

    public static void main() {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();

        String ans = check(inputString);
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        System.out.println(ans);
        myScan.close();
    }

    public static void main(String[] args) {
        System.out.println(check("aaabbbb").equals("YES")?"SUCCESS":"ERROR");
        System.out.println(check("cdefghmnopqrstuvw").equals("NO")?"SUCCESS":"ERROR");
        System.out.println(check("cdcdcdcdeeeef").equals("YES")?"SUCCESS":"ERROR");
        System.out.println(check("cdcdcdcdf").equals("YES")?"SUCCESS":"ERROR");
    }

    public static String check(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int singularity = 0;
        for(int i = 0; i < arr.length - 1 ; i += 2){
            if((arr[i] ^ arr[i+1]) != 0){
                singularity++;
            }
            if(singularity > 1)  break;
        }

        return singularity <= 1 ? "YES":"NO";
    }
}
