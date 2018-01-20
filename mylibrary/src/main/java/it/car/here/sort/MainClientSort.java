package it.car.here.sort;

import java.util.Arrays;

/**
 * Created by ciriti on 04/12/16.
 */

public class MainClientSort {

    /**
     * Review sort algorithms and Strategy pattern
     * @param ars
     */

    public static void main(String ars[]){
        int[] a = new int[]{1,9,5,6,7,3,8};
        new SortContext(new QuickSort()).executeAndPrint(Arrays.copyOf(a, a.length));
        new SortContext(new MergeSort()).executeAndPrint(Arrays.copyOf(a, a.length));

    }
}
