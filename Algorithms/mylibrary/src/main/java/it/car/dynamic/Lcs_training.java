package it.car.dynamic;

import java.util.Arrays;

/**
 * Created by carmeloiriti, 25/08/16.
 */
public class Lcs_training {

    /* Driver program to test above function */
    public static void main(String[] args){

        System.out.println(lcsString("ABCDGH", "AEDFHR").equals("ADH")?"SUCCESS":"ERROR");
        System.out.println(lcsString("AGGTAB", "GXTXAYB").equals("GTAB")?"SUCCESS":"ERROR");
        System.out.println(lcs_recursive_String("AGGTAB", "GXTXAYB").equals("GTAB")?"SUCCESS":"ERROR");
        System.out.println(lcs_recursive_String("SFABC", "ABCPL").equals("ABC")?"SUCCESS":"ERROR");
        System.out.println(lcs_recursive_String("ABC", "ABC").equals("ABC")?"SUCCESS":"ERROR");
        System.out.println(lcs_recursive_String("qaersdzfuuuz", "12a34as56d78a9s0df").equals("asdf")?"SUCCESS":"ERROR");

    }

    private static int lcs(String x, String y) {

        int m = x.length();
        int n = y.length();
        int[][] mLcs = new int[m+1][n+1];

        for(int i = 0; i <= m; i++){
            for(int k = 0; k <= n; k++){

                if(i == 0 || k == 0){
                    mLcs[i][k] = 0;
                }
                else if(x.charAt(i-1) == y.charAt(k-1)){
                    mLcs[i][k] = mLcs[i-1][k-1] + 1;
                }
                else{
                    mLcs[i][k] = Math.max(mLcs[i-1][k], mLcs[i][k-1]);
                }

            }
        }

        /**
         * print the substring
         */
        System.out.println();

        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++){
                System.out.print(mLcs[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        return mLcs[m][n];
    }

    public static int lcs_recursive(String s1, String s2, int index1, int index2){
        if(index1 == 0 || index2 == 0){
            return 0;
        }else if(s1.charAt(index1) == s2.charAt(2)){
            return 1 + lcs_recursive(s1, s2, index1 -1, index2-1);
        }else{
            return Math.max(lcs_recursive(s1, s2, index1 -1, index2), lcs_recursive(s1, s2, index1, index2-1));
        }
    }



    private static String lcsString(String x, String y) {
        /**
         * Estract the substring
         */
        int m = x.length();
        int n = y.length();
        String[][] mLcsRes = new String[m+1][n+1];

        for(int i = 0; i <= m; i++){
            for(int k = 0; k <= n; k++){

                if(i == 0 || k == 0){
                    mLcsRes[i][k] = "";
                }
                else if(x.charAt(i-1) == y.charAt(k-1)){
                    mLcsRes[i][k] = mLcsRes[i-1][k-1] + x.charAt(i-1);
                }
                else{
                    mLcsRes[i][k] = maxString(mLcsRes[i-1][k], mLcsRes[i][k-1]);
                }

            }
        }

        return mLcsRes[m][n];
    }

    public static String maxString(String a, String b){
        return a.length()>b.length()?a:b;
    }

    /**
     * Build the longest commen sequence
     * @param s1
     * @param s2
     * @return a string that is the LCS
     */
    public static String lcs_recursive_String(String s1, String s2){
        String res = "";
        res = lcs_recursive_char(s1, s2, s1.length(), s2.length());
        return new StringBuilder(res).reverse().toString();
    }

    /**
     * Support method to extract the LCS string
     * @param s1
     * @param s2
     * @param index1
     * @param index2
     * @return
     */
    public static String lcs_recursive_char(String s1, String s2, int index1, int index2){
        if(index1 == 0 || index2 == 0){
            return "";
        }else if(s1.charAt(index1-1) == s2.charAt(index2-1)){
            return String.valueOf(s1.charAt(index1-1)) + lcs_recursive_char(s1, s2, index1 -1, index2-1);
        }else{
            String tmp1 = lcs_recursive_char(s1, s2, index1 -1, index2);
            String tmp2 = lcs_recursive_char(s1, s2, index1, index2-1);
            return tmp1.length() > tmp2.length() ? tmp1:tmp2;
        }
    }

}
