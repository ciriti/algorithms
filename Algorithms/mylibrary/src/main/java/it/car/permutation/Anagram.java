package it.car.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ciriti on 21/08/16.
 */

public class Anagram {

    public static void main(String arg[]){

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        scanner.close();
        List<String> list = makeAnagram(text);
        System.out.println("size: " + list.size());
        System.out.println(Arrays.asList(list));


    }

    private static List<String> makeAnagram(String text) {
        return new ArrayList<>(recursiveAnagram(text));
    }

    private static Set<String> recursiveAnagram(final String pAnagram){
        Set<String> res = new HashSet<>();
        char c;
        String subString;
        for(int i = 0; i < pAnagram.length(); i ++){
            c = pAnagram.charAt(i);
            subString = pAnagram.substring(0, i) + pAnagram.substring(i+1, pAnagram.length());
//            addCharacterEverywhere(subString, c, res);
            for(int j = 0; j < subString.length(); j++){
                res.add(new String(subString.substring(0, j) + c + subString.substring(j, subString.length())));
            }
            res.add(new String(subString + c));
        }
        return res;
    }



//    private static void addCharacterEverywhere(String a, char charAt, Set<String> newSet) {
//        newSet.add(new String(charAt+a));
//        for(int i = 0; i < a.length(); i++){
//            newSet.add(new String(a.substring(0, i) + charAt + a.substring(i, a.length())));
//        }
//    }

}
