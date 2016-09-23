package it.car.prod_cartesiano;

import java.util.Arrays;

/**
 * Created by ciriti on 20/09/16.
 */

public class ProdottoCartesiano {

    public static void generate(int[][] sets) {
        int solutions = 1;
        for(int i = 0; i < sets.length; solutions *= sets[i].length, i++);
        for(int i = 0; i < solutions; i++) {
            int j = 1;
            for(int[] set : sets) {
                System.out.print(set[(i/j)%set.length] + " ");
                j *= set.length;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        generate(new int[][]{{1,2,3}, {4,5}, {6,7}});
    }


}
