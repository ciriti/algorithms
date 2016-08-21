package it.car.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ciriti on 21/08/16.
 */

public class Anagram {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        scanner.close();
        List<String> list = makeAnagram(text);
        System.out.println(Arrays.asList(list));


    }

    private static List<String> makeAnagram(String text) {
        return new ArrayList<>();
    }

}
