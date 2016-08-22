package it.car.regex;

/**
 * Created by ciriti on 21/08/16.
 */

public class ReplaceSpace {

    public static void main(String[] args){
        String line = "  aa bbbbb   ccc     d  ";
        System.out.println(line.replaceAll("\\s{2,}", " ").trim());
    }

}
