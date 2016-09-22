package it.car.compression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by carmeloiriti, 26/08/16.
 */


public class Dna {

    public static void main(String arg[]){

//        System.out.println(rob(new int[]{1,1,1}) == 2?"SUCCESS":"ERROR" );
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

    }

    public static List<String> findRepeatedDnaSequences(String s) {

        List<String> res = new ArrayList<>();

        Map<String, Integer> subSequence = new HashMap<>();
        String tmp;
        for(int i = 0; i < s.length() - 10; i ++){
            tmp = s.substring(i, i+10);
            if(subSequence.containsKey(tmp)){
                subSequence.put(tmp, subSequence.get(tmp)+1);
            }else {
                subSequence.put(tmp, 1);
            }
        }

        Set<String> keys = subSequence.keySet();
        for(String key : keys){
            if(subSequence.get(key) > 1){
                res.add(key);
            }
        }

        return res;
    }


}
