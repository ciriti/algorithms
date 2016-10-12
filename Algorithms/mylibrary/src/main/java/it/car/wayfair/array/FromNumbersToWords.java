package it.car.wayfair.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static android.R.attr.id;
import static android.R.attr.process;

/**
 * Created by carmeloiriti, 11/10/16.
 */
public class FromNumbersToWords {

    public static void main(String args[]){
        init();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert number: ");
        int num = scanner.nextInt();
        System.out.println(translate(num));

    }

    private static Map<Integer, String> mapUnder20;
    private static Map<Integer, String> maptens;

    public static String translate(int num){

        if(num < 20) return mapUnder20.get(num);

        int processNumber = num;

        List<Integer> processNumberList = new ArrayList<>();

        while(processNumber > 0){

            processNumberList.add(processNumber % 1000);

            processNumber = processNumber / 1000;
        }

        StringBuilder sb = new StringBuilder();
        int dim = processNumberList.size();
        for(int i = dim-1; i >= 0; i --){
            char[] arr = converToArr(processNumberList.get(i));
            sb.append(processThreeDigit(identifier(i), arr[0], arr[1], arr[2]));
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    private static String identifier(int i){
        switch (i){
            case 2:
                return "million";
            case 1:
                return "thousand";
            default:
                return "";
        }
    }

    private static char[] converToArr(int n){
        char[] res = new char[]{'0', '0', '0'};
        char[] numC = String.valueOf(n).toCharArray();
        int index = 2;
        for(int i = numC.length-1; i >=0; i--){
            res[index] = numC[i];
            index--;
        }
        return res;
    }

    private static String processThreeDigit(String identifier, char thirdChar, char secondChar,char firstChar){

        String firstSecond = twoCharacters(secondChar, firstChar);
        return mapUnder20.get(getInteger(thirdChar)) + (thirdChar=='0'?"":" hundred") + " " + firstSecond + " " +identifier;
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
