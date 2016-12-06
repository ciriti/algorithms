package it.car.wayfair.string;

/**
 * Created by ciriti on 18/10/16.
 */

public class LongestCommonString {

    public static void main(String args[]){
        System.out.println(lcs("abc123d","4a5bc7d").equals("bc")?"SUCCESS":"ERROR");
    }

    private static String lcs(String s1, String s2) {

        StringBuilder[][] sbMatrix = new StringBuilder[s1.length()+1][s2.length()+1];

        for(int i = 0; i < s1.length(); i++){
            for(int k = 0; k < s2.length(); k++) {
                sbMatrix[i][k] = new StringBuilder();
            }
        }

        StringBuilder res = new StringBuilder();

        for(int i = 1; i < s1.length(); i++){
            for(int k = 1; k < s2.length(); k++){
                if(s1.charAt(i-1) == s2.charAt(k-1)){
                    sbMatrix[i][k].append(sbMatrix[i-1][k-1]);
                    sbMatrix[i][k].append(s1.charAt(i-1));
                    if(res.length() < sbMatrix[i][k].length()){
                        res = sbMatrix[i][k];
                    }
                }
            }
        }

        return res.toString();
    }

}
