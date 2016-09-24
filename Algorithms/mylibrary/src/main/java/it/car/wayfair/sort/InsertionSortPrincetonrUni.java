package it.car.wayfair.sort;

import java.util.Arrays;

/**
 * Created by carmeloiriti, 23/09/16.
 */
public class InsertionSortPrincetonrUni {

    public static void sort(Comparable[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j >0 && less(arr[j], arr[j-1]); j--){
                exc(arr, j, j-1);
            }
        }
    }

    public static void main(String args[]){
        Integer[] arr = new Integer[]{1,9,2,8,3,7,4,6,5};
        InsertionSortPrincetonrUni.sort(arr);
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
