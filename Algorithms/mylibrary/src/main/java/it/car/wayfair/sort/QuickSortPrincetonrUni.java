package it.car.wayfair.sort;

import java.util.Arrays;

import it.car.graph.util.StdRandom;

/**
 * Created by carmeloiriti, 23/09/16.
 */
public class QuickSortPrincetonrUni {

    public static void sort(Comparable[] a)
    {
//        StdRandom.shuffle(a);          // Eliminate dependence on input.
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
        return a.compareTo(b) < 0;
//        return Math.signum((Integer)a) - Math.signum((Integer)b) < 0;
    }


    public static void main(String args[]){
        Integer[] arr = new Integer[]{2,2,2,-1,0,-1,2,2};

        User[] users = new User[]{
                new User("a", 2),
                new User("b", 2),
                new User("c", 2),
                new User("d", -1),
                new User("e", -0),
                new User("f", -1),
                new User("g", 2),
                new User("h", 2)
        };

        sort(users);
        System.out.println(Arrays.asList(users));
    }

    static class User implements Comparable<User>{
        final String name;
        final Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(User another) {
            return this.age - another.age;
        }

        @Override
        public String toString() {
            return "[" + name + " " + age + "]";
        }
    }

}
