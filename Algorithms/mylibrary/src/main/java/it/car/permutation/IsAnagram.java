package it.car.permutation;

import java.util.Scanner;

/**
 * Created by ciriti on 21/08/16.
 */

public class IsAnagram {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        scanner.close();
        System.out.println(isAnagram(s1, s2));
    }

    public static boolean isAnagram(String s1, String s2){

        if(s1.length() != s2.length()) return false;

        int r1 = s1.charAt(0);
        int r2 = s2.charAt(0);

        for(int i = 1; i < s1.length(); i ++){
            r1 = r1 ^ s1.charAt(i);
            r2 = r2 ^ s2.charAt(i);
        }

        return ((r1^r2) == 0);
    }

}
