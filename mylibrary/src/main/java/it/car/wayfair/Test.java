package it.car.wayfair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ciriti on 28/09/16.
 */

public class Test {

    public static List<List<Integer>> permutation(Integer[] arr){
        List<List<Integer>> res = new ArrayList<>();
        build(res, new ArrayList<Integer>(), Arrays.asList(arr));
        return res;
    }

    private static void build(List<List<Integer>> res, ArrayList<Integer> tmp, List<Integer> src) {
        if(src.size() == 0){
            res.add(tmp);
            return;
        }
        for(int i = 0; i < src.size(); i++){
            ArrayList<Integer> tmpNew = new ArrayList<>(tmp);
            tmpNew.add(src.get(i));
            List<Integer> srcNew = new ArrayList<>(src);
            srcNew.remove(i);
            build(res, tmpNew, srcNew);
        }
    }


    public static void main(String[] args){

        System.out.println(permutation(new Integer[]{1,2,3}));


    }

}
