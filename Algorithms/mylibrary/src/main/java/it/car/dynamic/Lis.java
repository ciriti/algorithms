package it.car.dynamic;

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

        int res = 0;

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

}
