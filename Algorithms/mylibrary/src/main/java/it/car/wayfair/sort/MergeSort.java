package it.car.wayfair.sort;

import java.util.Arrays;

/**
 * Created by carmeloiriti, 28/09/16.
 */
public class MergeSort {

    public void sort(int[] arr){
        int[]  m = helper(arr, 0, arr.length);
        System.arraycopy(m, 0, arr, 0, arr.length);
    }

    public int[] helper(int[] arr, int lo, int up){
        if(arr.length < 2) return arr;

        int mid = lo + (up-lo)/2;

        int[] a1 = Arrays.copyOfRange(arr, lo, mid);
        a1 = helper(a1, 0, a1.length);
        int[] a2 = Arrays.copyOfRange(arr, mid, up);
        a2 = helper(a2, 0, a2.length);

        int[] merge = new int[a1.length + a2.length];

        int i = 0;
        int j = 0;
        int m = 0;

        while((i < a1.length || j < a2.length) && m < merge.length){

            if(i < a1.length && j < a2.length){
                if(less(a1[i], a2[j])){
                    merge[m] = a1[i];
                    i++;
                }else{
                    merge[m] = a2[j];
                    j++;
                }
            }else if(i < a1.length){
                merge[m] = a1[i];
                i++;
            }else if(j < a2.length){
                merge[m] = a2[j];
                j++;
            }

            m++;
        }
        return merge;

    }

    boolean less(int a, int b){
        return (a - b) < 0;
//        return (Math.signum(a) - Math.signum(b)) <= 0;
    }

    public static void main(String[] args) {

        int[] arr = new int[] {-1,2,5,-7,9,2,4};
        new MergeSort().sort(arr);
        System.out.println(Arrays.toString(arr));


    }

}
