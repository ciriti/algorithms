package it.car.wayfair.cartesian;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by carmeloiriti, 21/09/16.
 */
public class ProdottoCartesiano {

    public List<List<Integer>> cartesianProduct(List<Integer>... lists){

        List<Integer> begin = lists[0];
        List<List<Integer>> tmp = new ArrayList<>();

        for(Integer num : begin){
            List<Integer> singl = new ArrayList<>();
            singl.add(num);
            tmp.add(singl);
        }

        for(int i = 1; i < lists.length; i++){
            tmp = numtiplyList(tmp, lists[i]);
        }

        return tmp;
    }

    private List<List<Integer>> numtiplyList(List<List<Integer>> firstList, List<Integer> secondList) {

        List<List<Integer>> res = new ArrayList<>();

        for(List<Integer> list : firstList){
            for(Integer elem : secondList){
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                newList.add(elem);
                res.add(newList);
            }
        }

        return res;
    }

    public static void main(String args[]){
        System.out.println(new ProdottoCartesiano().cartesianProduct(Collections.<Integer>emptyList()));
        long start = System.currentTimeMillis();
        System.out.println(new ProdottoCartesiano().cartesianProduct(Arrays.asList(1,2,3,4,5,6,7,8,9,0), Arrays.asList(1,2,3,4,5,6,7,8,9,0), Arrays.asList(1,2,3,4,5,6,7,8,9,0), Arrays.asList(1,2,3,4,5,6,7,8,9,0)));
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.println(Lists.cartesianProduct(Arrays.asList(1,2,3,4,5,6,7,8,9,0), Arrays.asList(1,2,3,4,5,6,7,8,9,0), Arrays.asList(1,2,3,4,5,6,7,8,9,0), Arrays.asList(1,2,3,4,5,6,7,8,9,0)));
        System.out.println(System.currentTimeMillis() - start);
    }

}
