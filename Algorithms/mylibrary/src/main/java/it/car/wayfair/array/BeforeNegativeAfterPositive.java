package it.car.wayfair.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by carmeloiriti, 21/09/16.
 */
public class BeforeNegativeAfterPositive {


    /**
     * Complexity O(n) time and O(n) space
     * @param pArray
     * @return
     */
    public Integer[] sort_1(Integer[] pArray){

        Integer[] tmp = new Integer[pArray.length];

        int left = 0;
        int right = pArray.length - 1;

        int indexL  = 0;
        int indexR  = pArray.length - 1;

        while(indexL < indexR){

            if(pArray[left] < 0){
                tmp[indexL] = pArray[left];
                indexL ++;
            }

            if(pArray[right] >= 0){
                tmp[indexR] = pArray[right];
                indexR --;
            }

            left++;
            right--;
        }

        return tmp;
    }

    /**
     * Complexity O(n) time and O(1) space
     * @param pArray
     * @return
     */
    public Integer[] sort_2(Integer[] pArray){

        int neg = 0;
        int pos = 0;

//        while((neg + pos) < 2 * pArray.length){
        int i = 0;
        int tmp;
        while(neg < pArray.length && pos < pArray.length){
            if(pArray[neg] >= 0 && pArray[pos] < 0){
                tmp = pArray[neg];
                pArray[neg] = pArray[neg+1];
                pArray[neg+1] = tmp;
                pos++;
                neg++;
            } else if(pArray[neg] < 0){
                neg++;
            }else if(pArray[pos] >= 0){
                pos++;
            }
            i++;
        }

        return pArray;
    }

    public  static void main(String args[]){

        Integer[] array = new Integer[]{1, -5, -1, 3, 23, -12};
        System.out.println("input");
        System.out.println(Arrays.asList(array));
        System.out.println("output");
        System.out.println(Arrays.asList(new BeforeNegativeAfterPositive().sort_1(array)));
        System.out.println(Arrays.asList(new BeforeNegativeAfterPositive().sort_2(array)));

    }

}
