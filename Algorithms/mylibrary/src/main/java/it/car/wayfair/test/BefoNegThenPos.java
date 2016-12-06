package it.car.wayfair.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ciriti on 15/10/16.
 */

public class BefoNegThenPos {



    public static void main(String args[]){
        System.out.println(Arrays.asList(sort(new Integer[]{3,-1,6,-4, 2,-20}, new MyComparator())));
    }

    public static Integer[] sort(Integer[] arr, MyComparator c){
        return sortRec(arr, c);
    }

    private static Integer[] sortRec(Integer[] arr, MyComparator c) {
        if(arr.length == 1) return arr;
        Integer[] a = sortRec(Arrays.copyOfRange(arr, 0, arr.length/2), c);
        Integer[] b = sortRec(Arrays.copyOfRange(arr, arr.length/2, arr.length), c);
        Integer[] res = new Integer[a.length + b.length];
        int indexA = 0;
        int indexB = 0;
        int indexRes = 0;
        while(indexA < a.length || indexB < b.length){

            if(indexA < a.length && indexB < b.length){
                if(less(a[indexA], b[indexB], c)){
                    res[indexRes] = a[indexA];
                    indexA++;
                }else{
                    res[indexRes] = b[indexB];
                    indexB++;
                }
            }else if(indexA < a.length){
                res[indexRes] = a[indexA];
                indexA++;
            }else{
                res[indexRes] = b[indexB];
                indexB++;
            }
            indexRes++;
        }

        return res;

    }

    public static boolean less(Integer a, Integer b, MyComparator c){
        return c.compare(a, b) <= 0;
    }

    public static class MyComparator implements Comparator<Integer>{

        public int compare (Integer a, Integer b){
            return (int)(Math.signum(a) - Math.signum(b));
        }
    }

}
