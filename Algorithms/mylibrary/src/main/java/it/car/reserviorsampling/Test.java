package it.car.reserviorsampling;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by carmeloiriti, 29/09/16.
 */
public class Test {

    public static void swap(int[] arr, int i, int j){
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }


    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        Random r = new Random();

        for(int i = arr.length-1; i > 0; i--){
            swap(arr, i, r.nextInt(i));
        }
        System.out.print(Arrays.toString(arr));
    }
}
