package it.car.wayfair;

import java.util.Random;

/**
 * Created by ciriti on 02/10/16.
 */

public class IndexOf {

    public static void main(String[] args) {

        int dim = 100000;

        char[] seq = new char[dim];
        Random r = new Random();

        for(int i = dim-1; i >= 0; i--){
            seq[i] = (char)r.nextInt(128);
        }

        String s = String.valueOf(seq);

        int count = 0;
        long start = System.currentTimeMillis();
        for(int i = 0; i < dim; i++){
            if(s.charAt(i) == 'a')count++;
        }

        System.out.println("time: " + (System.currentTimeMillis() - start) + "ms count: "+ count);
        count = 0;
        start = System.currentTimeMillis();
        int index = s.indexOf('a');
        while(index != -1){
            count++;
            index = s.indexOf('a', (index+1));
        }
        System.out.println("time: " + (System.currentTimeMillis() - start) + "ms count: "+ count);
    }

}
