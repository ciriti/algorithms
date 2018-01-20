package it.car.wayfair.array;

import java.util.Arrays;
import java.util.Comparator;

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

        int lo = 0;

        for(int i = 0; i < pArray.length; i++){
            int iTmp = i ;
            if(pArray[i] < 0){
                while(iTmp > lo){
                    int c = pArray[iTmp];
                    if(iTmp-1 < 0) break;
                    pArray[iTmp] = pArray[iTmp-1];
                    pArray[iTmp-1] = c;
                    iTmp--;
                }
                lo++;
            }

        }

        return pArray;
    }

    public Integer[] sort_3(Integer[] pArray){
        Arrays.sort(pArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer lhs, Integer rhs) {
                return (int)(Math.signum(lhs) - Math.signum(rhs));
            }
        });
        return pArray;
    }

    public Integer[] sort_4(Integer[] pArray){
        return pArray;
    }

    public Integer[] dualPivot(Integer[] a){
        return sort(a, 0, a.length-1);
    }

    // quicksort the subarray a[lo .. hi] using dual-pivot quicksort
    private  Integer[] sort(Integer[] a, int lo, int hi) {
        if (hi <= lo) return a;

        // make sure a[lo] <= a[hi]
        if (less(a[hi], a[lo])) exch(a, lo, hi);

        int lt = lo + 1, gt = hi - 1;
        int i = lo + 1;
        while (i <= gt) {
            if       (less(a[i], a[lo])) exch(a, lt++, i++);
            else if  (less(a[hi], a[i])) exch(a, i, gt--);
            else                         i++;
        }
        exch(a, lo, --lt);
        exch(a, hi, ++gt);

        // recursively sort three subarrays
        sort(a, lo, lt-1);
        if (less(a[lt], a[gt])) sort(a, lt+1, gt-1);
        sort(a, gt+1, hi);

        return a;

    }


    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private boolean less(int v, int w) {
//        return v.compareTo(w) < 0;
        return comparator.compare(v, w) < 0;
    }

    Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer lhs, Integer rhs) {
            return (int)(Math.signum(lhs) - Math.signum(rhs));
        }
    };

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * Insertionsort
     *
     * 1, -1, 5, -1, 3, 23, -12  k = 0, J = 1 -> j-1 = 0
     *
     */

    public static Integer[] sort_insertionsort(Integer[] arr, Comparator<Integer> comparator){

        for(int k = 0; k < arr.length-1; k++){
            int j = k+1;
            while(j > 0){

                if(comparator.compare(arr[j], arr[j-1]) < 0){
                    swap(j-1, j, arr);
                }
                j--;
            }
        }

        return arr;
    }

    public static void swap(int a, int b, Integer[] arr){
        Integer c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }




    public  static void main(String args[]){

        Integer[] array = new Integer[]{1, -1, 5, -1, 3, 23, -12};
        System.out.println("input");
        System.out.println(Arrays.asList(array));

        System.out.println("output");
//        System.out.println(Arrays.asList(new BeforeNegativeAfterPositive().sort_1(array)));
//        System.out.println(Arrays.asList(new BeforeNegativeAfterPositive().sort_2(array)));
//        System.out.println(Arrays.asList(new BeforeNegativeAfterPositive().sort_3(array)));
        System.out.println(Arrays.asList(sort_insertionsort(array,

                new Comparator<Integer>(){
                    public int compare(Integer a, Integer b){
                        return (int)(Math.signum(a) - Math.signum(b));
                    }
                }


        )));

//        System.out.println("dualpivot\n" + Arrays.asList(new BeforeNegativeAfterPositive().dualPivot(array)));

    }

}
