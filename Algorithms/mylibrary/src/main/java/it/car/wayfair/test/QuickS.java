package it.car.wayfair.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ciriti on 15/10/16.
 */

public class QuickS {



    public static void main(String args[]){
        Integer[] arr = new Integer[]{8,4,7,3,2,6,5,1};
        sort(arr);
        System.out.println(Arrays.asList(arr));
    }

    public static void sort(Integer[] arr){
        sort(arr, 0, arr.length-1);
    }

    public static void sort(Integer[] arr, int lo, int up){
        int pivot = partition(arr, lo, up);
        if(lo < pivot -1)
            sort(arr, lo, pivot -1);
        if(pivot < up)
            sort(arr, pivot, up);
    }

    public static int partition(Integer[] arr, int lo, int up){

        int valPivot = arr[(up+lo)/2];

        while(lo <= up){
            while(arr[lo] < valPivot)
                lo++;
            while(valPivot < arr[up])
                up--;
            if(lo<=up){
                swap(arr, lo, up);
                lo++;
                up--;
            }
        }

        return lo;
    }

    public static void swap(Integer[] arr, int a, int b){
        Integer c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

    public static boolean less(Integer a, Integer b, MyComparator c){
        return c.compare(a, b) <= 0;
    }

    public static class MyComparator implements Comparator<Integer>{

        public int compare (Integer a, Integer b){
            return (int)(Math.signum(a) - Math.signum(b));
        }
    }

}
