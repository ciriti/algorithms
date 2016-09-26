package it.car.wayfair.string;

import java.util.Arrays;

/**
 * Created by ciriti on 22/09/16.
 */

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int maxL = Integer.MAX_VALUE;;
        StringBuilder builder = new StringBuilder();
        for(String s : strs){
            if(s.length() < maxL){
                maxL = s.length();
            }
        }

        for(int i = 0; i < maxL; i++){
            for(int j = 0; j < strs.length-1; j++){
                if(strs[j].charAt(i) != strs[j+1].charAt(i)){
                    return builder.toString();
                }
            }
            builder.append(strs[0].charAt(i));
        }

        return builder.toString();
    }

    public String longestCommonPrefix1(String[] strs) {
        if(strs.length == 0) return "";
        StringBuilder builder = new StringBuilder();

        Arrays.sort(strs);

        String a = strs[0];
        String b = strs[strs.length-1];
        for(int i = 0; i < a.length(); i ++){
            if(a.charAt(i) == b.charAt(i)){
                builder.append(a.charAt(i));
            }else
                break;
        }

        return builder.toString();
    }

    public static void main(String args[]){
        System.out.println(new LongestCommonPrefix().longestCommonPrefix1(
                new String[]{
                        "abc",
                        "abcdfglreo"
                }
        ).equals("abc")?"SUCCESS":"ERROR");
        System.out.println(new LongestCommonPrefix().longestCommonPrefix1(
                new String[]{
                        "",
                        "abc",
                        "abcdfglreo"
                }
        ).equals("")?"SUCCESS":"ERROR");
        System.out.println(new LongestCommonPrefix().longestCommonPrefix1(
                new String[]{}
        ).equals("")?"SUCCESS":"ERROR");
    }

}
