package it.car.wayfair.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ciriti on 18/10/16.
 */

public class LongestCommonSequence {

    public static void main(String args[]){
        System.out.println(lcsequence("xabc123d","4a5bc7dx").equals("abcd")?"SUCCESS":"ERROR");

        List<String>[][] l = new List[10][10];
        for(int i = 0; i < 10; i++){
            for(int k = 0; k < 10; k++){
                l[i][k] = new ArrayList<>();
            }
        }
        System.out.println();
    }

    private static String lcsequence(String s1, String s2) {

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        StringBuilder[][] sbMatrix = new StringBuilder[arr1.length+1][arr2.length+1];

        for(int i = 0; i < arr1.length+1; i++){
            for(int k = 0; k < arr2.length+1; k++){
                sbMatrix[i][k] = new StringBuilder();
            }
        }

        for(int i = 1; i < arr1.length+1; i++){
            for(int k = 1; k < arr2.length+1; k++){
                if(arr1[i-1] == arr2[k-1]){
                    sbMatrix[i][k].append(sbMatrix[i-1][k-1]);
                    sbMatrix[i][k].append(arr1[i-1]);
                }else{
                    sbMatrix[i][k].append(
                            sbMatrix[i][k-1].length() > sbMatrix[i-1][k].length()?
                                    sbMatrix[i][k-1] : sbMatrix[i-1][k]
                    );
                }
            }
        }

        return sbMatrix[arr1.length][arr2.length].toString();
    }

}
