package it.car.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by carmeloiriti, 07/09/16.
 */
public class TwoStrings {

    /**
     *
     * LINK - https://www.hackerrank.com/challenges/two-strings
     *
     * Given two strings,  and , determine if they share a common substring.

     Input Format

     The first line contains a single integer, , denoting the number of  pairs you must check.
     Each pair is defined over two lines:

     The first line contains string .
     The second line contains string .
     Constraints

     and  consist of lowercase English letters only.
     Output Format

     For each  pair of strings, print YES on a new line if the two strings share a common substring; if no such common substring exists, print NO on a new line.

     Sample Input

     2
     hello
     world
     hi
     world
     Sample Output

     YES
     NO
     Explanation

     We have  pairs to check:

     , . The substrings  and  are common to both  and , so we print YES on a new line.
     , . Because  and  have no common substrings, we print NO on a new line.
     */

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Couple> list = new ArrayList<>(n);
        List<String> res = new ArrayList<>();
        sc.nextLine();
        while(n>0){
            list.add(new Couple(sc.nextLine(), sc.nextLine()));
            n--;
        }

        for(Couple c : list){
            System.out.println(c);

            int indexA = c.a.length()-1;
            int indexB = c.b.length()-2;

            char[] arrA = c.a.toCharArray();
            char[] arrB = c.b.toCharArray();

            Arrays.sort(arrA);
            Arrays.sort(arrB);

            if(c.a.length() == 0 && c.b.length() == 0){
                res.add("YES");
                continue;
            }

            while(indexA > 0 || indexB > 0){
                char ac = indexA > 0 ? c.a.charAt(indexA):'*';
                char bc = indexB > 0 ? c.b.charAt(indexB):'*';
                if(ac == bc ){
                    res.add("YES");
                    break;
                }
                if(indexA > 0 && indexB > 0){
                    if(c.a.charAt(indexA) > c.b.charAt(indexB)){
                        indexA--;
                    }else{
                        indexB--;
                    }
                }else{
                    indexA--;
                    indexB--;
                }

            }

            res.add("NO");

        }
        for(String c : res){
            System.out.println(c);
        }

        sc.close();
    }

    static class Couple{
        public String a;
        public String b;
        public Couple(String a, String b){
            this.a = a;
            this.b = b;
        }
        public String toString(){
            return"[" + a + ", " + b + "]";
        }
    }

}
