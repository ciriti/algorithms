package it.car.string;

import java.util.Arrays;

/**
 * Created by ciriti on 03/09/16.
 */

public class AddBinary {

    /**
     * Given two binary strings, return their sum (also a binary string).
     * For example,
     * a = "11"
     * b = "1"
     * Return "100".
     * @param args
     */


    public static void main(String args[]){

        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary(String.valueOf(1010), String.valueOf(1011)).equals("10101")?"SUCCESS":"ERROR");
        System.out.println(ab.addBinary(String.valueOf(1), String.valueOf(11)).equals("100")?"SUCCESS":"ERROR");
        System.out.println(ab.addBinary(String.valueOf(1111), String.valueOf(1111)).equals("11110")?"SUCCESS":"ERROR");
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        boolean sum;
        boolean carry = false;
        int max = Math.max(a.length(), b.length());
        for(int i = 0; i < max; i++){
            char aa = i < a.length()? a.charAt(a.length()-1-i):'0';
            char bb = i < b.length()? b.charAt(b.length()-1-i):'0';
            boolean aBol = aa == '0'? false:true;
            boolean bBol = bb == '0'? false:true;

            sum = carry?!(aBol^bBol):(aBol^bBol);
            carry = carry?((aBol || bBol) && carry):(aBol && bBol);

            sb.append(sum?'1':'0');

        }
        if(carry)
            sb.append('1');
        return sb.reverse().toString();
    }


}
