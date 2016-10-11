package it.car.arrayutils;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;

/**
 * Created by carmeloiriti, 27/09/16.
 */
public class ArrayUtilsMethods {

    /**
     * Print array
     * @param arr
     */
    public static void printAnArray(int[] arr){

        System.out.println("---------------------------------------");

        String s = Arrays.toString(arr);
        System.out.println("" + s);
    }

    /**
     * Compare 2 array
     * @param arr1
     * @param arr2
     */
    public static void compare2Arrays(int[] arr1, int[] arr2){

        System.out.println("---------------------------------------");

        System.out.println("Array not sorted");
        System.out.println(Arrays.toString(arr2).equals(Arrays.toString(arr1)));

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println("Array sorted");
        System.out.println(Arrays.toString(arr2).equals(Arrays.toString(arr1)));
        System.out.println(Arrays.equals(arr2, arr1));
    }

    /**
     * Create a list from an array
     * @param arr
     */
    public static void createListFromArray(Integer[] arr){

        System.out.println("---------------------------------------");

        try{
            List<Integer> res = Arrays.asList(arr);
            res.add(5);
        }catch (Exception e){
            System.out.println("Error:" + e.getMessage());
        }

        List<Integer> res1 = new ArrayList<>(Arrays.asList(arr));
        res1.add(6);
    }

    /**
     * Check if an array contains a certain value
     * @param arr
     * @param val
     */
    public static void containsValue(int[] arr, int val){

        System.out.println("---------------------------------------");

        String s = Arrays.toString(arr);
        System.out.println("Contains " + val+ " " + s.contains(String.valueOf(val)));
    }


    /**
     * Intersection of two array
     * @param arr1
     * @param arr2
     */
    public static void intersectionSet(Integer[] arr1, Integer[] arr2){

        System.out.println("---------------------------------------");

        Set<Integer> set1 = new HashSet<>(Arrays.asList(arr1));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(arr2));

        set1.removeAll(set2);

        System.out.println("Intersection Set" + set1);

    }

    private static void intersectionList(Integer[] arr1, Integer[] arr2) {

        System.out.println("---------------------------------------");
        List<Integer> set1 = new ArrayList<>(Arrays.asList(arr1));
        List<Integer> set2 = new ArrayList<>(Arrays.asList(arr2));

        set1.removeAll(set2);

        System.out.println("Intersection List" + set1);
    }

    /**
     * Reverse an array
     * @param arr
     */
    public static void reverseArray(int[] arr){

        System.out.println("---------------------------------------");

        System.out.println("arr:");
        System.out.println(Arrays.toString(arr));
        ArrayUtils.reverse(arr);
        System.out.println("arr reverse:");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Reverse an array
     * @param arr
     */
    public static void reverseArray1(int[] arr){

        System.out.println("---------------------------------------");

        int i = 0;
        int j = arr.length-1;

        while(i<j){

            int c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;
            j--;
        }

        System.out.println("my reverse: " + Arrays.toString(arr));
    }


    /**
     * Remove element of an array
     * @param arr
     */
    public static void removeElemArray(int[] arr, int elem){

        System.out.println("---------------------------------------");

        int[] removed = ArrayUtils.removeElement(arr, elem);//create a new array
        System.out.println(Arrays.toString(removed));
    }

    /**
     * Remove element of an array
     * @param arr
     */
    public static void removeElemArray1(int[] arr, int elem){

        System.out.println("---------------------------------------");

        int indexOf = -1;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == elem){
                indexOf= i;
                break;
            }
        }

        if(indexOf == -1){
            printAnArray(arr);
        }

        int[] first = Arrays.copyOfRange(arr, 0, indexOf);
        int[] second = Arrays.copyOfRange(arr, indexOf+1, arr.length);

        int[] res = new int[arr.length-1];

        System.arraycopy(first, 0, res, 0, first.length);
        System.arraycopy(second, 0, res, first.length, second.length);

        printAnArray(res);

    }

    public static void randomOrder(Integer[] arr){

        System.out.println("---------------------------------------");

        List<Integer> list = Arrays.asList(arr);
        System.out.println("NO shuffle: " + list);
        Collections.shuffle(list);
        System.out.println("   shuffle: " + list);
    }

    public static void randomOrder1(Integer[] arr){

        System.out.println("---------------------------------------");
        System.out.println("NO shuffle: " + Arrays.asList(arr));
        Random r = new Random();
        for(int i = arr.length -1 ; i > 0; i--){
            swap(arr, r.nextInt(i), i);
        }
        System.out.println("   shuffle: " + Arrays.asList(arr));

    }

    public static void swap(Integer[] arr, int i, int j){
        Integer c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static void shuffle(int[] arr){

        System.out.println("---------------------------------------");

        Random r = new Random();
        for(int i = arr.length-1; i > 1; i--){
            swap(arr, i , r.nextInt(i-1));
        }
        System.out.println("Shuffle: " + Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i , int j){
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static <E> List<E> dealHand(List<E> deck, int n) {

        System.out.println("---------------------------------------");

        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - n, deckSize);
        List<E> hand = new ArrayList<E>(handView);
        handView.clear();
        System.out.println("Remove: " + hand);
        return hand;
    }

    public static void deleteRange(List<Integer> list, int first, int second){

        System.out.println("---------------------------------------");

        list.subList(first, second).clear();

        System.out.println("deleted elem: " + list);
    }

    public static void deleteDuplicates(Integer[] arr){

        System.out.println("---------------------------------------");
        System.out.println(" original: " + Arrays.toString(arr));
        Set<Integer> set = new LinkedHashSet<>(Arrays.asList(arr));
        List<Integer> res = new ArrayList<>(set);
        System.out.println("no duplic: " + res);

    }

    public static void  main(String[] arg){

        /**
         * For List
         */
        deleteRange(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,0)), 1, 10);

        /**
         * For class
         */

        Integer[] arr1 = new Integer[]{1,2,3,4,5,6,7,8,9};
        Integer[] arr2 = new Integer[]{4,9,3,1,5,6,7,2,8};
        createListFromArray(arr1);
        intersectionSet(new Integer[]{1,2,3,4,5,6,7,8,9}, new Integer[]{7,8,9});
        intersectionList(new Integer[]{1,2,3,4,5,6,7,8,9, 9, 9}, new Integer[]{7,8,9,9});
        randomOrder(new Integer[]{1,2,3,4,5,6,7,8,9});
        randomOrder1(new Integer[]{1,2,3,4,5,6,7,8,9});
        dealHand(new ArrayList(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9})), 3);
        deleteDuplicates(new Integer[]{9,8,7,6,5,9,4,8,3,7,2,6,1});

        /**
         * For simple type
         */

        compare2Arrays(new int[]{1,2,3,4,5,6,7,8,9}, new int[]{4,9,3,1,5,6,7,2,8});
        printAnArray(new int[]{1,2,3,4,5,6,7,8,9});
        containsValue(new int[]{1,2,3,4,5,6,7,8,9}, 3);
        reverseArray(new int[]{1,2,3,4,5,6,7,8,9});
        reverseArray1(new int[]{1,2,3,4,5,6,7,8,9});
        removeElemArray(new int[]{1,2,3,4,5,6,7,8,9}, 1);
        removeElemArray1(new int[]{1,2,3,4,5,6,7,8,9}, 1);
        shuffle(new int[]{1,2,3,4,5,6,7,8,9});

    }

}
