package it.car.her_.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carmeloiriti, 05/12/16.
 */

public class Anagramm {

    static List<String> anagramm(String s){
        List<String> res = new ArrayList<>();
        recAnag("", s, res);
        return res;
    }

    static void recAnag(String tmp, String orig, List<String> res){
        if(orig.length() == 0){
            res.add(tmp);
        }else{
            for(int i = 0; i < orig.length(); i++){
                String par = tmp + orig.charAt(i);
                String newSeed = orig.substring(0, i) + orig.substring(i+1, orig.length());
                recAnag(par, newSeed, res);
            }
        }
    }

    public static void main(String args[]){
        System.out.println(anagramm("abc"));
    }

}
