package it.car.wayfair.cartesian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by carmeloiriti, 21/09/16.
 */
public class CartesianProduct<T> {

    /**
     * Given a two-dimensional array of strings, return all possible combination of words.

     Example:
     ['grey','black']
     ['fox','dog']
     ['jumped','ran','growled']

     Return:
     grey fox jumped
     grey fox ran
     grey fox growled
     black fox jumped

     */

    public List<List<T>> cartesianProduct(List<T>... lists){

        List<List<T>> res = new ArrayList<>();

        List<T> begin = lists[0];

        for(T elem : begin){
            List<T> myList = new ArrayList<>();
            myList.add(elem);
            res.add(myList);
        }

        for(int i = 1; i < lists.length; i ++){
            res = multiply(res, lists[i]);
        }

        return res;

    }

    private List<List<T>> multiply(List<List<T>> listOfList, List<T> list) {

        List<List<T>> res = new ArrayList<>();

        for(List<T> tmp : listOfList){
            for(T t : list){
                List<T> buildingList = new ArrayList<>(tmp);
                buildingList.add(t);
                res.add(buildingList);
            }
        }
        return res;
    }

    public static void main(String args[]){
        System.out.println(new CartesianProduct<String>().cartesianProduct(Arrays.asList("grey", "black"), Arrays.asList("fox","dog"), Arrays.asList("jumped","ran","growled")));
        System.out.println(new CartesianProduct<Integer>().cartesianProduct(Arrays.asList(1, 2, 3),Arrays.asList(4, 5)));
    }


}
