package it.car.wayfair.string_;

import java.util.regex.Pattern;

/**
 * Created by carmeloiriti, 23/09/16.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int lo = 0;
        int up = s.length()-1;

        while(lo < up){
            if(isAlphaNum(s.charAt(lo)) && isAlphaNum(s.charAt(up))){
                if(s.charAt(lo) != s.charAt(up))
                    return false;
                else{
                    lo++;
                    up--;
                }
            }else{
                if(!isAlphaNum(s.charAt(lo))) lo++;
                if(!isAlphaNum(s.charAt(up))) up--;
            }
        }

        return true;
    }

    private boolean isAlphaNum(char c){
//        Pattern pat = Pattern.compile("^[a-zA-Z]$");
//        return pat.matcher(String.valueOf(c)).matches();
        return ((c <= 'z') && (c >= 'a'))
                || ((c <= '9') && (c >= '0'))
                || ((c <= 'Z') && (c >= 'A'));

    }

    public static void main(String args[]){
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama") == true?"SUCCESS":"ERROR");
        System.out.println(new ValidPalindrome().isPalindrome("race a car") == false?"SUCCESS":"ERROR");
        System.out.println(new ValidPalindrome().isPalindrome("0P") == false?"SUCCESS":"ERROR");
    }

}
