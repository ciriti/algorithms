package it.car.wayfair.cartesian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by carmeloiriti, 18/10/16.
 */
public class CartProd {

    public static void main(String args[]){
        System.out.println(product(
                new String[]{"Ciao", "Hi"},
                new String[]{"Carm","Fabio","Iriti"},
                new String[]{"io vado", "io resto"}
        ));
    }

    private static List<String> product(String[]... arr) {

        if(arr.length == 0)
            return Collections.emptyList();
        if(arr.length == 1)
            return Arrays.asList(arr[0]);

        int dim = 1;

        for(String[] tmpArr : arr){
            dim = dim * tmpArr.length;
        }

        List<String> list = new ArrayList<>(dim);

        for(String s : arr[0]){
            list.add(s);
        }

        for(int i = 1; i < arr.length; i++){
            list = productOfTwo(list, arr[i]);
        }

        return list;
    }

    public static List<String> productOfTwo(List<String> tmp, String[] current){
        List<String> res = new ArrayList<>(tmp.size()*current.length);
        for(int i = 0; i < tmp.size(); i ++){
            for(int k = 0; k < current.length; k++){
                res.add(tmp.get(i) + " " + current[k]);
            }
        }
        return res;

    }

}
