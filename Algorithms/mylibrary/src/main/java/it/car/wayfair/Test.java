package it.car.wayfair;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by ciriti on 28/09/16.
 */

public class Test {

     /*
         5 -1 -5 -12 9 8 7
  */

    public static void sort(int[] a){
        int[] m = rec(a);
        System.arraycopy(m, 0, a, 0, m.length);
    }

    public static int[] rec(int[] a){

        if(a.length < 2) return a;

        int mid = a.length/2;

        int[] c1 = rec(Arrays.copyOfRange(a, 0, mid+1));
        int[] c2 = rec(Arrays.copyOfRange(a, mid+1, a.length));

        int[] merge = new int[c1.length + c2.length];
        int i = 0;
        int j = 0;
        int m = 0;
        while(i < c1.length || j < c2.length){

            if(i < c1.length && j < c2.length){
                if(c1[i] <= c2[j]){
                    merge[m] = c1[i];
                    i++;
                }else{
                    merge[m] = c2[j];
                    j++;
                }
            }else if(i < c1.length){
                merge[m] = c1[i];
                i++;
            }else if(j < c2.length){
                merge[m] = c2[j];
                j++;
            }
            m++;

        }

        return merge;


    }


    public static void main(String[] args) {
        if(args == null) throw new InvalidParameterException();
        System.out.print(new ArrayList<>(Arrays.asList("asdf".toCharArray())));

        int[] arr = new int[]{5,-1,-5,-12,9,8};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        LinkedList ll = new LinkedList();
    }
}
