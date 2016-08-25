package it.car.dynamic;

import java.util.Arrays;

/**
 * Created by ciriti on 24/08/16.
 */

public class Ls_home {

    /*

    Given "abcabcbb", the answer is "abc", which the length is 3.

    Given "bbbbb", the answer is "b", with the length of 1.

    Given "pwwkew", the answer is "wke", with the length of 3.
    Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

     */

    public static void main(String arg[]){

        System.out.println(maxSubString("abcabcbb").equals("abc")?"OK":"ERROR");
        System.out.println(maxSubString("bbbbb").equals("b")?"OK":"ERROR");
        System.out.println(maxSubString("pwwkew").equals("wke")?"OK":"ERROR");
        System.out.println(maxSubString("cc").equals("c")?"OK":"ERROR");
        System.out.println(maxSubString("c").equals("c")?"OK":"ERROR");
        System.out.println(maxSubString("au").equals("au")?"OK":"ERROR");
        System.out.println(maxSubString("dvdf").equals("vdf")?"OK":"ERROR");

    }

    public static String maxSubString(String s){

        if(s.length() == 1 || s.length() == 0){
            return s;
        }

        int[] posChars = new int[256];
        Arrays.fill(posChars, -1);
        String res = "";

        /**
         * k - puntatore che indica da dove sono partito
         */
        int k = 0;
        /**
         * i - va avanti e controlla che i caratteri sono unici
         */
        for(int i = 0; i < s.length(); i++){
            /**
             * se il corrente carattere si trova nella posizione davanti a k
             * vuol dire che il carattere è già contenuto nella sottostringa,
             * posso perciò estrarre la sotto stringa e controllare se è più
             * grande di quella già salvata
             */
            if(posChars[s.charAt(i)] >= k){

                String sub = s.substring(k, i);
                if(sub.length() > res.length()){
                    res = sub;
                }
                k = posChars[s.charAt(i)]+1;
                /**
                 * condizione per l'ultimo elemento
                 */
            }else if(i == s.length()-1){
                String sub = s.substring(k, s.length());
                if(sub.length() > res.length()){
                    res = sub;
                }
            }
            posChars[s.charAt(i)] = i;

        }
        return res;
    }
}
