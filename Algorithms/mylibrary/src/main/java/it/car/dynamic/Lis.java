package it.car.dynamic;

import android.content.IntentFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by carmeloiriti, 23/08/16.
 */
public class Lis {

    /**
     * LINK - http://www.practice.geeksforgeeks.org/problem-page.php?pid=134
     *
     * Given a sequence, find the length of the longest subsequence of a given sequence .
     * The longest increasing subsequence means to find a subsequence of a given sequence in which
     * the subsequence's elements are in sorted order, lowest
     * to highest, and in which the subsequence is as long as possible. This subsequence is
     * not necessarily contiguous, or unique.
     *
     * PROBLEM:
     * Skipping nextLine() after using next(), nextInt() or other nextFoo() methods
     * SOLUTION:
     * Thats because the Scanner#nextInt method does not consume the last newline character of
     * your input, and thus that newline is consumed in the next call to Scanner#nextLine
     */

    /**
     * CASE TEST 1
     * INPUT:
     * 1
     * 16
     * 0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15
     * OUTPUT:
     * 6
     * [0, 4, 6, 9, 13, 15]
     * @param arg
     */

    /**
     * CASE TEST 2
     * INPUT:
     * 1
     * 9
     * 10 22 9 33 21 50 41 60 80
     * OUTPUT:
     * 6
     * 10 22 33 50 60 80
     * @param arg
     */

    public static void main(String arg[]){
        //code

        Scanner scan = new Scanner(System.in);
        int numTest = scan.nextInt();
        int dim = scan.nextInt();
        scan.nextLine();
        int[] array = new int[dim];
        String s = scan.nextLine();
        String[] params = s.split(" ");
        for(int i = 0; i < dim; i ++){
            array[i] = Integer.parseInt(params[i]);
        }
        scan.close();

        long start = System.nanoTime();
        numElementsLis(array);
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        numElementsLis1(array);
        System.out.println(System.nanoTime() - start);
        printSequenceLis(array);


    }

    public static void printSequenceLis(int[] array){
        int dim = array.length;
        List<List<Integer>> arrList = new ArrayList<>(dim);
        for(int i = 0; i < dim; i ++){
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(array[i]);
            arrList.add(tmpList);
        }

        for(int i = 0; i < dim; i ++) {
            for (int j = 0; j < i; j++) {
                if ((arrList.get(i).size() < arrList.get(j).size() + 1) && array[i] > array[j]) {
                    arrList.get(i).clear();
                    arrList.get(i).addAll(arrList.get(j));
                    arrList.get(i).add(array[i]);
                }
            }
        }

        List<Integer> res = arrList.get(0);

        for(List<Integer> resTmp : arrList){
            if(resTmp.size() > res.size()){
                res = resTmp;
            }
        }

        System.out.println(res);

    }

    /**
     * print only the number of alement of LIS
     * @param array
     */
    public static void numElementsLis(int[] array){
        int res = 0;
        int dim = array.length;
        int[] cache = new int[dim];
        for(int i = 0 ; i < dim ; i++){
            cache[i] = 1;
        }

        for(int i = 1; i < dim; i ++){
            for(int j = 0; j < i; j ++){
                if(array[i] > array[j] && (cache[j]+1)>cache[i]){
                    cache[i] = cache[j]+1;
                    res = cache[i]>res?cache[i]:res;
                }
            }
        }

        System.out.println(res);
    }
    /**
     * print only the number of alement of LIS
     * @param array
     */
    public static void numElementsLis1(int[] array){
        int res = 0;
        int dim = array.length;
        int[] cache = new int[dim];
        for(int i = 0 ; i < dim ; i++){
            cache[i] = 1;
        }

        int i = 0;
        while(i/dim < dim){

//            System.out.println("i [" + i/5 + "]");
//            System.out.println("j [" + i%5 + "]");
            if(array[i/dim] > array[i%dim] && (cache[i%dim]+1)>cache[i/dim]){
                cache[i/dim] = cache[i%dim]+1;
                res = cache[i/dim]>res?cache[i/dim]:res;
            }
            i++;
        }

        System.out.println(res);
    }

}
