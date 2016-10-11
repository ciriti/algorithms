package it.car.wayfair.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by carmeloiriti, 22/09/16.
 */
public class QuickSort {

    /**
     * LINK - http://www.algolist.net/Algorithms/Sorting/Quicksort
     */

    void swap(int[] arr, int i, int j){
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public void sort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    public int partition(int[] arr, int lo, int up){

        int mid = arr[lo + (up-lo)/2];
        while(lo<=up){


            while(arr[lo] < mid){
                lo++;
            }
            while(mid < arr[up]){
                up--;
            }

            if((lo<=up)){
                swap(arr, lo, up);
                lo++;
                up--;
            }

        }

        return lo;
    }

    public void sort(int[] arr, int lo, int up){

        int pivot = partition(arr, lo, up);

        if(lo < pivot-1)
            sort(arr, lo, pivot-1);
        if(pivot < up)
            sort(arr, pivot , up);


    }

    public static void main(String arg){

        System.out.println();
        for(int i = 0; i < 4; i ++){
            int[][] test = new int[][]{
                    {2,2,-1,0,0,-1,-1,0},
                    {0,0,0,0,0,-1,0,0},
                    {0,2,2,0,0,2,2,2},
                    {2,2,2,-1,0,-1,2,2}
            };
            new QuickSort().sort(test[i]);
            System.out.println(Arrays.toString(test[i]));
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1,9,1,-4,-6,5,1,8};
        new QuickSort().sort(a);
        System.out.println(Arrays.toString(a));

    }

}
