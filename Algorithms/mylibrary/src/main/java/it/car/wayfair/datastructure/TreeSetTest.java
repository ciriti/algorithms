package it.car.wayfair.datastructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by carmeloiriti, 28/09/16.
 */
public class TreeSetTest {

    public static void main(String args[]){
        SortedSet<String> sortedSet = new TreeSet<>(Arrays.asList("cc","bb","zz", "dd", "aa"));
        System.out.println(sortedSet.subSet("b", "d"));

        SortedMap<String, String> sortedMap = new TreeMap<>();
        sortedMap.put("bb","bb");
        sortedMap.put("zz","zz");
        sortedMap.put("cc","cc");
        sortedMap.put("aa","aa");
        sortedMap.put("dd","dd");

        System.out.println(sortedMap.subMap("b", "d"));

        String s = "aaabbcdd";
        SortedMap<String, Integer> countChars = new TreeMap<>();

        for(char a : s.toCharArray()){
            countChars.put(String.valueOf(a), countChars.get(a) == null ? 1: (countChars.get(a) + 1));
        }

        System.out.println();

    }

}
