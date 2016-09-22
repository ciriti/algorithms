package it.car.wayfair.array;

import java.util.Arrays;

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

    public static void main(String args[]){
        System.out.println(Arrays.asList(new DutchNationalFlagProblem().sort(new Integer[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1})));
        System.out.println(Arrays.asList(new DutchNationalFlagProblem().sort(new Integer[]{0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1})));
    }

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
