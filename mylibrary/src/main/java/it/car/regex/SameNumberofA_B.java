package it.car.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ciriti on 21/08/16.
 */

public class SameNumberofA_B {

    public static void main(String args[]){
        String s = "aabbbbb  aabbb ccc  aabb   d  ";
        Pattern pattern = Pattern.compile("(a+)(b+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            matcher.groupCount();
            if(matcher.group(1).length() == matcher.group(2).length()){
                System.out.println(matcher.group());
            }
        }
    }

}
