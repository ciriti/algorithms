package it.car.regex;

import java.util.Scanner;

/**
 * Created by ciriti on 21/08/16.
 */

public class StringFilter {

    /**
     * How to extract numbers from a string?
     * LINK - http://www.programcreek.com/2013/10/top-10-questions-for-java-regular-expression/
     */

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s.replaceAll("\\d",""));
        scanner.close();
    }

//    private static List<Integer> findNUmbersInString(String s) {
//        List<Integer> nums = new ArrayList<>();
//        Pattern pattern = Pattern.compile("\\d+");
//        Matcher matcher = pattern.matcher(s);
//        while (matcher.find()) {
//            nums.add(Integer.parseInt(matcher.group()));
//
//        }
//        return nums;
//    }
}
