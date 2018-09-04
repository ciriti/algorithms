package it.car.wayfair.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ciriti on 24/09/16.
 */

public class EqualParts {

    public static List<Integer> divide(int num, int parts){
        List<Integer> res = new ArrayList<>(parts);

        int elementsPerPart = num / parts;
        int elemToAdd = num % parts;

        for(int i = 0; i < parts; i++){
            res.add(elementsPerPart);
        }

        for(int i = 0; i<elemToAdd; i++){
            int index = i%4;
            res.add(index, res.get(index)+1);
        }


        return res;
    }

    public static void main(String args[]){
        System.out.println(divide(121, 4));
        System.out.println(divide(129, 4));
    }

}
