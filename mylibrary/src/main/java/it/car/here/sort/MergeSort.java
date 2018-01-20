package it.car.here.sort;

import java.util.Arrays;

/**
 * Created by ciriti on 04/12/16.
 */

public class MergeSort implements ISort {

    @Override
    public void sort(int[] arr) {
        System.arraycopy(sortRec(arr), 0, arr, 0, arr.length);
    }

    int[] sortRec(int[] arr){

        if(arr.length < 2)
            return arr;

        int[] a = Arrays.copyOfRange(arr, 0, arr.length/2);
        int[] b = Arrays.copyOfRange(arr, arr.length/2, arr.length);

        a = sortRec(a);
        b = sortRec(b);

        int[] res = new int[a.length + b.length];
        int i = 0;
        int ia = 0;
        int ib = 0;
        while(ia < a.length || ib < b.length){
            if(ia < a.length && ib < b.length){
                if(a[ia] <= b[ib]){
                    res[i] = a[ia];
                    i++;
                    ia++;
                }else{
                    res[i] = b[ib];
                    i++;
                    ib++;
                }
            }else if(ia < a.length){
                res[i] = a[ia];
                i++;
                ia++;
            }else{
                res[i] = b[ib];
                i++;
                ib++;
            }
        }
        return res;
    }

}
