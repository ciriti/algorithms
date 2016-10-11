package it.car.wayfair.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by carmeloiriti, 11/10/16.
 */
public class FromNumbersToWords {

    enum type {
        hundred,
        thousand
    }

    private static Map<Integer, String> mapUnder20;
    private static Map<Integer, String> maptens;

    public static String translate(int num){

        if(num < 20) return mapUnder20.get(num);

        int tensthousand = num % 1000;
        int thousand = num / 1000;
        int tensmillion = thousand % 1000;
        int millions = thousand / 1000;


        int processNumber = num;

        List<Integer> processNumberList = new ArrayList<>();

        while(processNumber > 0){

            processNumberList.add(processNumber % 1000);
//            processNumberList.add(processNumber / 1000);

            processNumber = processNumber / 1000;
        }

        char[] tensthousandArr = String.valueOf(tensthousand).toCharArray();

        StringBuilder sb = new StringBuilder();

        sb.append(processThreeDigit(type.hundred,
                tensthousandArr.length > 0 ?tensthousandArr[0]:'0',
                tensthousandArr.length > 1 ?tensthousandArr[1]:'0',
                tensthousandArr.length > 2 ?tensthousandArr[2]:'0'
                ));

        return sb.toString().trim();
    }

    public static void main(String args[]){

        init();
//
//        System.out.println(translate(22).equals("twenty two")?"SUCCESS":"ERROR");
//        System.out.println(twoCharacters('9', '9'));
//        System.out.println(twoCharacters('0', '1'));
//        System.out.println(twoCharacters('1', '7'));
//        System.out.println(twoCharacters('8', '0'));
//        System.out.println(twoCharacters('4', '9'));

//        System.out.println(processThreeDigit(type.hundred, '9', twoCharacters('9', '9')));
//        System.out.println(processThreeDigit(type.hundred, '1', twoCharacters('0', '0')));
//        System.out.println(processThreeDigit(type.hundred, '2', twoCharacters('1', '4')));
//        System.out.println(processThreeDigit(type.hundred, '6', twoCharacters('5', '4')));
//        System.out.println(processThreeDigit(type.hundred, '6', twoCharacters('5', '4')));
//        System.out.println(processThreeDigit(type.hundred, '0', twoCharacters('5', '4')).trim());

//        translate(1234);

        System.out.println(translate(98340));



    }


    private static String processThreeDigit(type t, char thirdChar, char secondChar,char firstChar){

        String firstSecond = twoCharacters(secondChar, firstChar);
        return mapUnder20.get(getInteger(thirdChar)) + " " + (getInteger(thirdChar) == 0 ? "": t.name()) + " " + firstSecond;
    }

    private static void init() {
        mapUnder20 = new HashMap<>(20);
        mapUnder20.put(0,"");
        mapUnder20.put(1,"one");
        mapUnder20.put(2,"two");
        mapUnder20.put(3,"three");
        mapUnder20.put(4,"four");
        mapUnder20.put(5,"five");
        mapUnder20.put(6,"six");
        mapUnder20.put(7,"seven");
        mapUnder20.put(8,"eight");
        mapUnder20.put(9,"nine");
        mapUnder20.put(10,"ten");
        mapUnder20.put(11,"eleven");
        mapUnder20.put(12,"twelve");
        mapUnder20.put(13,"thirteen");
        mapUnder20.put(14,"fourteen");
        mapUnder20.put(15,"fifteen");
        mapUnder20.put(16,"sixteen");
        mapUnder20.put(17,"seventeen");
        mapUnder20.put(18,"eightteen");
        mapUnder20.put(19,"nineteen");

        maptens = new HashMap<>(9);
        maptens.put(0,"");
        maptens.put(10,"ten");
        maptens.put(20, "twenty");
        maptens.put(30, "thrirty");
        maptens.put(40, "forty");
        maptens.put(50, "fifty");
        maptens.put(60, "sixty");
        maptens.put(70, "seventy");
        maptens.put(80, "eighty");
        maptens.put(90, "ninenty");
    }

    public static Integer getInteger(char c){
        return Integer.valueOf(Character.toString(c));
    }

    public static String twoCharacters(char left, char right){
        int num = converter(left, right);
        if(num < 20)
            return mapUnder20.get(num);

        return maptens.get(converter(left, '0')) + " " + mapUnder20.get(Integer.valueOf(Character.toString(right)));
    }

    public static int converter(char left, char right){
        return Integer.valueOf((Character.toString(left) + Character.toString(right)));
    }



}
