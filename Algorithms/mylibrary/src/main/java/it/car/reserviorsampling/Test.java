package it.car.reserviorsampling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by carmeloiriti, 29/09/16.
 */
public class Test {

    public List<List<String>> cartesianProduct(String[]... arrays){

        List<List<String>> res = new ArrayList<>();
        for(String s : arrays[0]){
            res.add(Arrays.asList(s));
        }

        for(int i = 1; i < arrays.length; i++){
            res = multiplyTwoArrays(res, arrays[i]);
        }

        System.out.println("dim " + res.size());
        return res;

    }

    List<List<String>> multiplyTwoArrays(List<List<String>> res, String[] set2){

        List<List<String>> tmp = new ArrayList<>(res.size() * set2.length);

        for(List<String> list : res){
            for(String s2 : set2){
                List<String> l = new ArrayList<>(list);
                l.add(s2);
                tmp.add(l);
            }
        }

        return tmp;

    }


    public static void main(String[] args) {

        String[] set1 = new String[]{"aa", "bb", "cc", "dd", "ee"};
        String[] set2 = new String[]{"ff", "gg", "hh"};
        String[] set3 = new String[]{"ii", "ll", "mm"};
        System.out.print(new Test().cartesianProduct(set1,set2,set3));
    }
}
