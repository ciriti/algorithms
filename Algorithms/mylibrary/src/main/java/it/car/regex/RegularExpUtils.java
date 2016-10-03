package it.car.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ciriti on 03/10/16.
 */

public class RegularExpUtils {

    public static boolean usernameMatcher(String username){
        Pattern p = Pattern.compile("^[\\w\\d_-]{3,12}$");
        Matcher m = p.matcher(username);
        return m.matches();

    }

    public static boolean passwordChecker(String password){
        Pattern p = Pattern.compile("^"
                + ".*(?=.{6,})"
                + "(?=.*\\d)"
                + "(?=.*[A-Z]{1,})"
                + "(?=.*[a-z]{1,})"
                + "(?=.*[-_%]{1,})"
                + ".*$");
        Matcher m = p.matcher(password);
        return m.matches();
    }

    public static void main(String args[]){
        /** Username checker */
        assert usernameMatcher("ab") == false;
        assert usernameMatcher("abd") == true;
        assert usernameMatcher("_a-b2d") == true;

        /** Password checker */
        assert passwordChecker("aaAA11%") == true;
        assert passwordChecker("aaAA11") == false;
        assert passwordChecker("1aB%") == false;
    }

}
