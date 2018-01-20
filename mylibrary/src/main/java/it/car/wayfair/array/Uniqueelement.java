package it.car.wayfair.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ciriti on 22/09/16.
 */

public class Uniqueelement {


    public int findUniqueElement(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : arr){
            Integer val = map.get(a) != null ? map.get(a) : 0;
            map.put(a, val+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }

    public static void main(String args[]){
        System.out.println(new Uniqueelement().findUniqueElement(new int[]{1,1,1,2,3,3,4,4,4,5,5,5,6,9,9,6,6,6,}));
    }

}
