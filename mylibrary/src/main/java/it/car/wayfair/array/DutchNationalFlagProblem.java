package it.car.wayfair.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by carmeloiriti, 22/09/16.
 */
public class DutchNationalFlagProblem {

    public Integer[] sort(Integer[] pArr){

        int u = pArr.length-1;
        int l = 0;
        int curr = 0;
        int tmp;
        while(l<u && curr<=u){
            switch (pArr[curr]){
                case 0:
                    tmp = pArr[l];
                    pArr[l] = pArr[curr];
                    pArr[curr] = tmp;
                    l++;
                    curr++;
                    break;
                case 1:
                    curr++;
                    break;
                case 2:
                    tmp = pArr[u];
                    pArr[u] = pArr[curr];
                    pArr[curr] = tmp;
                    u--;
                    break;
            }
        }

        return pArr;
    }

    public static void quickSort(Integer[] arr){
        quickSort(arr, 0, arr.length-1);
    }


    static int partition(Integer arr[], int lo, int up)
    {
//        int pivot = arr[(lo + up) / 2];
        int piv = arr[lo + (up-lo) / 2];

        while (lo <= up) {
            while (arr[lo] < piv)
                lo++;
            while (arr[up] > piv)
                up--;
            if (lo <= up) {
                swap(arr, lo, up);
                lo++;
                up--;
            }
        }

        return lo;
    }

    static void  quickSort(Integer arr[], int left, int right) {
        int pivot = partition(arr, left, right);
        if (left < pivot - 1)
            quickSort(arr, left, pivot - 1);
        if (pivot < right)
            quickSort(arr, pivot, right);
    }


    static void swap(Integer[] arr, int i, int j ){
        Integer c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static void main(String args[]){
        System.out.println(Arrays.asList(new DutchNationalFlagProblem().sort(new Integer[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1})));
        System.out.println(Arrays.asList(new DutchNationalFlagProblem().sort(new Integer[]{0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1})));

        System.out.println("-----------------------------------");
        for(int i = 0; i < 4; i ++){
            Integer[][] test = new Integer[][]{
                    {2,2,-1,0,0,-1,-1,0},
                    {0,0,0,0,0,-1,0,0},
                    {0,2,2,0,0,2,2,2},
                    {2,2,2,-1,0,-1,2,2}
            };

            quickSort(test[i]);
            System.out.println(Arrays.asList(test[i]));

        }

        System.out.println("-----------------------------------");
        for(int i = 0; i < 4; i ++){
            Integer[][] test = new Integer[][]{
                    {2,2,-1,0,0,-1,-1,0},
                    {0,0,0,0,0,-1,0,0},
                    {0,2,2,0,0,2,2,2},
                    {2,2,2,-1,0,-1,2,2}
            };

            quickSort(test[i]);
            System.out.println(Arrays.asList(test[i]));

        }

        Integer[] test1 = new Integer[] {2,2,2,-1,0,-1,2,2};
//        quickSort(test1);
//        System.out.println(Arrays.asList(test1));

    }

    /**
     *
     *
     * 2,2,2,-1,0,-1,2,2  lo = 0, up = 7, mid = -1
     *
     * lo = 0, up = 5
     * -1,2,2,-1,0,2,2,2
     *
     * lo = 1, up = 4
     * lo = 1, up = 3
     * -1,-1,2,2,0,2,2,2
     *
     * lo = 2, up = 2
     *
     *
     *
     *
     */

    /**

     0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1
     l = 1; curr = 1; u = leng-1
     l = 1; curr = 2; u = leng-1
     l = 1; curr = 3; u = leng-1
     0, 0, 1, 1, 1, 2, 1, 2, 0, 0, 0, 1
     l = 2; curr = 4; u = leng-1
     l = 2; curr = 5; u = leng-1
     0, 0, 1, 1, 1, 1, 1, 2, 0, 0, 0, 2
     l = 2; curr = 5; u = leng-2
     l = 2; curr = 6; u = leng-2
     l = 2; curr = 7; u = leng-2
     0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 2, 2
     l = 2; curr = 7; u = leng-3
     l = 2; curr = 8; u = leng-3
     0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 2, 2
     l = 3; curr = 9; u = leng-3
     0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2
     l = 4; curr = 10; u = leng-3
     */

}
