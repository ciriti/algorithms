package it.car.wayfair.sort;

import java.util.Arrays;

/**
 * Created by carmeloiriti, 23/09/16.
 */
public class SelectionSortPrincetonrUni {

    /**
     * For every element I must find the minimum N-1 compare
     * For every element I must find the minimum N compare
     *
     * N^/2 complexity
     *
     * @param arr
     */

    public static void sort(Comparable[] arr){
        // scorri l'array
        for(int i = 0; i < arr.length; i++){
            int min = i;
            for(int j = i; j < arr.length; j++)
                if(less(arr[j], arr[min]))
                    // trova il minimo
                    min = j;
            // scambia il minimo
            exc(arr, min, i);
        }
    }

    public static void main(String args[]){
        Integer[] arr = new Integer[]{1,9,2,8,3,7,4,6,5};
        SelectionSortPrincetonrUni.sort(arr);
        System.out.println(Arrays.asList(arr));
    }

    private static void exc(Comparable[] arr, int i, int j){
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

}
