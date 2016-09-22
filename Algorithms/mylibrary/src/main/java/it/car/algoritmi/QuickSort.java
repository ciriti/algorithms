package it.car.algoritmi;

import java.util.Arrays;

/**
 * Created by carmeloiriti, 22/09/16.
 */
public class QuickSort {

    /**
     * LINK - http://www.algolist.net/Algorithms/Sorting/Quicksort
     */

    Integer[] sort(Integer[] arr){
        if(arr.length > 0)
            recursiveSort(arr, 0, arr.length-1);
        return arr;
    }

    private void recursiveSort(Integer[] arr, int pLo, int pUp){
        if(pLo >= pUp) return;
        int lo = pLo;
        int up = pUp;
        int mid = findPivot(lo, up);
        while(lo < up){

            if(arr[lo] >= arr[mid]  && arr[up] <= arr[mid]){
                int tmp = arr[lo];
                arr[lo] = arr[up];
                arr[up] = tmp;
                lo ++;
                up--;
            }else if(arr[lo] >= arr[mid]){
                up--;
            }else if(arr[up] <= arr[mid]){
                lo++;
            }else{
                lo ++;
                up--;
            }


        }
        recursiveSort(arr, pLo, mid);
        recursiveSort(arr, mid+1, pUp);
    }

    private int findPivot(int lo, int up){
        return (up - lo) / 2 + lo;
    }

    public static void main(String arg[]){
        System.out.println(Arrays.asList(new QuickSort().sort(new Integer[]{1, 12, 5, 26, 7, 14, 3, 7, 2})));
        System.out.println(Arrays.asList(new QuickSort().sort(new Integer[]{1, 1, 1, 5, 1, 1})));
    }

}
