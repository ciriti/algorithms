package it.car.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ciriti on 21/08/16.
 */

public class FindNumber {

    /**
     * How to extract numbers from a string?
     * LINK - http://www.programcreek.com/2013/10/top-10-questions-for-java-regular-expression/
     */

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<Integer> res = findNUmbersInString(s);
        System.out.println(Arrays.asList(res));
        scanner.close();
    }

    private static List<Integer> findNUmbersInString(String s) {
        List<Integer> nums = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d{1}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            nums.add(Integer.parseInt(matcher.group()));

        }
        return nums;
    }
}
