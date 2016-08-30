package it.car.dynamic;

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

        System.out.println("Length of LCS is " + lcs(X,Y) );
        System.out.println("Length of LCS recursive is " + lcs_recursive(X,Y, X.length(), Y.length()) );

    }

}
