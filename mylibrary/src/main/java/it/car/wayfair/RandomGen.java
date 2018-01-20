package it.car.wayfair;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static java.util.Arrays.asList;

/**
 * Created by ciriti on 25/09/16.
 */

public class RandomGen {

    public static void main(String args[]){


        System.out.println();

        Integer[] arr = new Integer[100];
        for(int i = 0; i < 100; i ++){
            arr[i] = i;
        }

        List<Integer> list = Arrays.asList(arr);
        Collections.shuffle(list);

        System.out.println(list.subList(0, 10));

        Set<Integer>  set = new HashSet<>(10);
        while(set.size() < 10){
            int x = new Random().nextInt(100);
            set.add(arr[x]);
        }

        System.out.println(set);

//        List<Integer> list =  Arrays.asList(arr);
//        Collections.shuffle(list);
//        System.out.println(list);
    }

}
