package it.car.here.sort;

/**
 * Created by ciriti on 04/12/16.
 */

public class QuickSort implements ISort {

    @Override
    public void sort(int[] arr) {
        int[] a = arr;
        sort(a, 0, arr.length-1);
    }

    void sort(int[] arr, int lo, int up){
        int partition = partition(arr, lo, up);

        if(lo < partition-1)
            sort(arr, lo, partition-1);
        if(partition < up)
            sort(arr, partition, up);

    }


    int partition(int[] arr, int lo, int up){

        int indP = (lo + up)/2;
        int valP = arr[indP];

        while(lo <= up){
            while(arr[lo] < valP){
                lo++;
            }
            while(arr[up] > valP){
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

    void swap(int[] arr, int i, int j){
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
