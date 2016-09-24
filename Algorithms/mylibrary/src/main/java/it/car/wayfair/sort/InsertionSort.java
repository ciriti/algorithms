package it.car.wayfair.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by carmeloiriti, 22/09/16.
 */
public class InsertionSort<T> {

//    public T[] sort(T[] arr, Comparator<T> compartor){
//        return arr;
//    }

    public Integer[] sort(Integer[] arr, Comparator<Integer> compartor){

        for(int i = 1; i < arr.length; i ++){
            int tmp = i;
            while(tmp-1 >= 0 && compartor.compare(arr[tmp], arr[tmp-1]) < 0){
                exc(arr, tmp, tmp-1);
                tmp--;
            }
        }

        return arr;
    }

    private void exc(Integer[] arr, int index1, int index2){
        Integer i = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = i;
    }

    static class MyComparator<T extends Comparable<T>> implements Comparator<T> {

        @Override
        public int compare(T lhs, T rhs) {
            return lhs.compareTo(rhs);
        }
    }

    static class PositiveNegative implements Comparator<Integer> {

        @Override
        public int compare(Integer lhs, Integer rhs) {
            return (int)(Math.signum(lhs) - Math.signum(rhs));
        }
    }

    static class COMPARATOR_DIV_BY_3 implements Comparator<Integer>{
        @Override
        public int compare(Integer lhs, Integer rhs){
            int res = 0;
            if(lhs%3==0 && rhs%3 == 0){
                res = 0;
            }else if(lhs%3==0 ){
                res = -1;
            }else{
                res = 1;
            }
            return res;
        }
    };

    public static void main(String args[]){
        MyComparator<Integer> comparator = new MyComparator<>();
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        System.out.println(Arrays.asList(insertionSort.sort(new Integer[]{1, 12, 5, 26, -7, 14, -3, 7, 2}, new PositiveNegative())));
        System.out.println(Arrays.asList(insertionSort.sort(new Integer[]{5, 6, 2, 7, 3, 8, 9}, new COMPARATOR_DIV_BY_3())));
    }
}
