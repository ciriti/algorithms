package it.car.dynamic;

/**
 * Created by carmeloiriti, 25/08/16.
 */
public class Lcs_training {

    /* Driver program to test above function */
    public static void main(String[] args){

        System.out.println(lcsString("ABCDGH", "AEDFHR").equals("ADH")?"SUCCESS":"ERROR");
        System.out.println(lcsString("AGGTAB", "GXTXAYB").equals("GTAB")?"SUCCESS":"ERROR");

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

}
