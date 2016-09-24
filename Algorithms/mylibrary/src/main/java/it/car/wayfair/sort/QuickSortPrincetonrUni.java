package it.car.wayfair.sort;

import java.util.Arrays;

import it.car.graph.util.StdRandom;

/**
 * Created by carmeloiriti, 23/09/16.
 */
public class QuickSortPrincetonrUni {

    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);          // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);  // Partition (see page 291).
        sort(a, lo, j-1);              // Sort left part a[lo .. j-1].
        sort(a, j+1, hi);              // Sort right part a[j+1 .. hi].
    }

    private static int partition(Comparable[] a, int lo, int hi)
    {  // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi+1;            // left and right scan indices
        Comparable v = a[lo];            // partitioning item
        while (true)
        {  // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }


    private static void exch(Comparable[] arr, int i, int j){
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static boolean less(Comparable a, Comparable b){
//        return a.compareTo(b) < 0;
        return Math.signum((Integer)a) - Math.signum((Integer)b) < 0;
    }


    public static void main(String args[]){
        Integer[] arr = new Integer[]{1, -1, 5, -1, 3, 23, -12};
        QuickSortPrincetonrUni.sort(arr);
        System.out.println(Arrays.asList(arr));
    }

}
