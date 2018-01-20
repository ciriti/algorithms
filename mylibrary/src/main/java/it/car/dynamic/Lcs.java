package it.car.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by carmeloiriti, 25/08/16.
 */
public class Lcs {

    /**

     * This is the table for recursive alg:

     -- G X T X A Y B
     -----------------
     A| 0 0 0 0 1 0 0
     G| 1 0 0 0 0 0 0
     G| 1 0 0 0 0 0 0
     T| 0 0 1 0 0 0 0
     A| 0 0 0 0 1 0 0
     B| 0 0 0 0 0 0 1

     */
    static int lcs_recursive( String X, String Y, int m, int n){

        if (m == 0 || n == 0)
            return 0;
        if (X.charAt(m-1) == Y.charAt(n-1))
            return 1 + lcs_recursive(X, Y, m-1, n-1);
        else
            return max(lcs_recursive(X, Y, m, n-1), lcs_recursive(X, Y, m-1, n));
    }

    /**
     * Longest Common Subsequence
     */

    static int lcs( String X, String Y){

        int m = X.length();
        int n = Y.length();
        int[][] L = new int [m+1][n+1];
        int i, j;

        /**
         *  Following steps build L[m+1][n+1] in bottom up fashion. Note
         * that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
         */
        for (i = 0; i <= m; i++){
            for (j = 0; j <= n; j++){

                if (i == 0 || j == 0)
                    L[i][j] = 0;

                else if (X.charAt(i-1) == Y.charAt(j-1))
                    L[i][j] = L[i-1][j-1] + 1;

                else
                    L[i][j] = max(L[i-1][j], L[i][j-1]);
            }
        }
        System.out.println();

        for (i = 0; i <= m; i++){
            for (j = 0; j <= n; j++){
                System.out.print(L[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        /* L[m][n] contains length of LCS for X[0..n-1] and Y[0..m-1] */
        return L[m][n];
    }

    public static String lcsFindSubSequenceCollection(String s, String t){
        List<Character> sArr = new ArrayList<>(s.length());
        List<Character> tArr = new ArrayList<>(t.length());

        for(char c : s.toCharArray()){
            sArr.add(c);
        }

        for(char c : t.toCharArray()){
            tArr.add(c);
        }

        sArr.retainAll(tArr);

        tArr.retainAll(new ArrayList<>(sArr));

        StringBuilder sb = new StringBuilder();

        for(Character c : tArr){
            sb.append(c);
        }

        return sb.toString();
    }
    public static String lcsFindSubSequence(String s, String t){

        String[][] m = new String[s.length() + 1 ][t.length() + 1];
        for(String[] row : m){
            Arrays.fill(row, "");
        }

        for(int i = 1; i < t.length() + 1; i++){
            for(int j = 1; j < s.length() + 1; j++){
                if(s.charAt(j-1) == t.charAt(i-1)){
                    m[j][i] = m[j-1][i-1]= m[j-1][i-1] + s.charAt(j-1);
                }else{
                    String x = m[j-1][i]==null?"":m[j-1][i];
                    String y = m[j][i-1]==null?"":m[j][i-1];
                    if(x.length() >=  y.length())
                        m[j][i] = x;
                    else
                        m[j][i] = y;
                }
            }
        }

        return m[s.length()-1][t.length()-1];
    }



    /* Utility function to get max of 2 integers */
    static int max(int a, int b){
        return (a > b)? a : b;
    }

    /* Driver program to test above function */
    public static void main(String[] args){

        String X = "AGGTAB";
        String Y = "GXTXAYB";

        /**

         * I will have the following matrix at the end:

              G X T X A Y B
          -----------------
          | 0 0 0 0 0 0 0 0
         A| 0 0 0 0 0 1 1 1
         G| 0 1 1 1 1 1 1 1
         G| 0 1 1 1 1 1 1 1
         T| 0 1 1 2 2 2 2 2
         A| 0 1 1 2 2 3 3 3
         B| 0 1 1 2 2 3 3 4



         * This is the table for recursive alg:

            G X T X A Y B
         -----------------
         A| 0 0 0 0 1 0 0
         G| 1 0 0 0 0 0 0
         G| 1 0 0 0 0 0 0
         T| 0 0 1 0 0 0 0
         A| 0 0 0 0 1 0 0
         B| 0 0 0 0 0 0 1

         */

//        System.out.println("Length of LCS is " + lcs(X,Y) );
//        System.out.println("Length of LCS recursive is " + lcs_recursive(X,Y, X.length(), Y.length()) );
//        System.out.println("Length of LCS recursive is " + lcs_recursive_String(X,Y) );
//        System.out.println(lcs("qaersdzfuuuz", "12a34as56d78a9s0df") == 4?"SUCCESS":"ERROR");
//        System.out.println(lcsFindSubSequence("qaersdzfuuuz", "12a34as56d78a9s0df").equals("asdf")?"SUCCESS":"ERROR");
//        System.out.println(lcsFindSubSequenceCollection( "12a34as56d78a9s0df", "qaersdzfuuuz").equals("asdf")?"SUCCESS":"ERROR");
        System.out.println("------------------------------------------------------------");
        System.out.println(lcsFindSubSequence("aa", "aa").equals("aa")?"SUCCESS":"ERROR");
        System.out.println(lcsFindSubSequenceCollection( "aa", "aa").equals("aa")?"SUCCESS":"ERROR");
        System.out.println("------------------------------------------------------------");
        System.out.println(lcsFindSubSequence("aa", "bb").equals("")?"SUCCESS":"ERROR");
        System.out.println(lcsFindSubSequenceCollection( "aa", "bb").equals("")?"SUCCESS":"ERROR");
        System.out.println("------------------------------------------------------------");
        System.out.println(lcsFindSubSequence("qiwuzterqxztocerzvtiurituzqizy", "yxcv"));
        System.out.println(lcsFindSubSequenceCollection( "qiwuzterqxztocerzvtiurituzqizy", "yxcv"));
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
