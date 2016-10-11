package it.car.sort;

import java.util.Arrays;

/**
 * Created by ciriti on 02/10/16.
 */

public class HeapSort {

    public static void heapSort(int[] a){
        int[] arr = new int[a.length+1];
        System.arraycopy(a, 0, arr, 1, a.length);
        int dim = arr.length;
        for(int i = dim/2; i > 0; i--){
            System.out.println(i);
            sync(arr, i, dim-1);
        }

        for(int i = dim-1; i>0; i--){
            swap(arr, 1, i);
            sync(arr, 1, i-1);
        }

        System.arraycopy(arr, 1, a, 0, a.length);
    }

    public static void sync(int[] arr, int curr, int max){
        while(2*curr<= max){
            int ic = 2 * curr;
            if(ic < max && lessEq(arr[curr], arr[ic+1])){
                swap(arr, curr, ic+1);
            }
            if(bigger(arr[curr], arr[ic])){
                break;
            }
            curr = ic;
        }
    }



    static boolean lessEq(int a, int b){
        return Math.signum(a) - Math.signum(b) <= 0;
    }

    static boolean bigger(int a, int b){
        return !lessEq(a,b);
    }


    public static void main(String[] args) {

        int[] a = new int[]{-1,-2,9,8,3,-4};
        System.out.println(Arrays.toString(a));
        heapSort(a);
        System.out.println(Arrays.toString(a));


    }

    static void swap(int [] arr, int i, int j){
        int s = arr[i];
        arr[i] = arr[j];
        arr[j] = s;
    }

}
