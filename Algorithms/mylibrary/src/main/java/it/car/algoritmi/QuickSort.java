package it.car.algoritmi;

import java.util.Arrays;
import java.util.Comparator;

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
    Integer[] sortComparator(Integer[] arr){
        if(arr.length > 0)
            recursiveSort_comparator(arr, 0, arr.length-1);
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

    private void recursiveSort_comparator(Integer[] arr, int pLo, int pUp){
        if(pLo >= pUp) return;
        int lo = pLo;
        int up = pUp;
        int mid = findPivot(lo, up);
        while(lo < up){

            if(/*arr[lo] >= arr[mid]*/ comparator.compare(arr[lo], arr[mid]) >= 0   &&
                    /*arr[up] <= arr[mid]*/ comparator.compare(arr[up], arr[mid]) <= 0){
                int tmp = arr[lo];
                arr[lo] = arr[up];
                arr[up] = tmp;
                lo ++;
                up--;
            }else if(comparator.compare(arr[lo], arr[mid]) >= 0){
                up--;
            }else if(comparator.compare(arr[up], arr[mid]) <= 0){
                lo++;
            }else{
                lo ++;
                up--;
            }


        }
        recursiveSort(arr, pLo, mid);
        recursiveSort(arr, mid+1, pUp);
    }

    static Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer lhs, Integer rhs) {
            return lhs - rhs;
        }
    };

    private int findPivot(int lo, int up){
        return (up - lo) / 2 + lo;
    }

    public static void main(String arg[]){
        System.out.println(Arrays.asList(new QuickSort().sort(new Integer[]{1, 12, 5, 26, 7, 14, 3, 7, 2})));
        System.out.println(Arrays.asList(new QuickSort().sort(new Integer[]{1, -1, 1, -5, 1, -21})));
        System.out.println("Comparator\n"+Arrays.asList(new QuickSort().sortComparator(new Integer[]{1, -1, 1, -5, 1, -21})));
    }

}
