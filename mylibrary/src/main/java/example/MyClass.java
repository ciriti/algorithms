package example;

import java.util.Arrays;
import java.util.Random;

public class MyClass {

    public static int min(int[] arr){

        Arrays.sort(arr);

        return arr[0];
    }

    public static int min2(int[] arr){

        int min = arr[0];
        for(int i : arr){
            if(i < min){
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args){
        int[] arr = new int[1000001];

        for(int i = arr.length-2; i > 0; i-=2){
            int r = new Random().nextInt(i);
            arr[i] = r;
        }
        long start = 0;
        System.out.println(min(Arrays.copyOf(arr, arr.length)));
        System.out.println("Min : "+(System.currentTimeMillis() - start));
        start = 0;
        System.out.println(min2(Arrays.copyOf(arr, arr.length)));
        System.out.println("Min2: "+(System.currentTimeMillis() - start));


    }
}
