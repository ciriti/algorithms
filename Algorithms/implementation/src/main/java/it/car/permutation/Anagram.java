package it.car.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.sun.tools.javac.jvm.ByteCodes.ret;

/**
 * Created by ciriti on 21/08/16.
 */

public class Anagram {

    public static void main(){

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        scanner.close();
        List<String> list = makeAnagram(text);
        System.out.println(Arrays.asList(list));


    }

    private static List<String> makeAnagram(String text) {
        return new ArrayList<>();
    }

    private static void recursiveAnagram(List<String> res, int pos, char[] pAnagram){
        if(pAnagram.length == pos){
            res.add(new String(pAnagram));
        }else {

        }
    }

    private static void addCharacterEverywhere(String a, char charAt, List<String> newList) {
        newList.add(new String(charAt+a));
        for(int i = 0; i < a.length(); i++){
            newList.add(new String(a.substring(0, i) + charAt + a.substring(i, a.length())));
        }
    }

}
