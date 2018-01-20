package it.car.here.sort;

import java.util.Arrays;

/**
 * Created by ciriti on 04/12/16.
 */

public class SortContext {

    ISort sortObj;

    public SortContext(ISort sortObj) {
        this.sortObj = sortObj;
    }

    public void executeSort(int[] arr){
        sortObj.sort(arr);
    }
    public void executeAndPrint(int[] arr){
        sortObj.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
