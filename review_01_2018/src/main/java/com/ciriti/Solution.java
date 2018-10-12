package com.ciriti;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carmelo Iriti
 *
 *  Wayfair interview
 *
 */
public class Solution {

  public static void main(String[] args) {
    int[] input = {-2, 5, -1, 7, -3};

    // [[-2], [5], [], [], []]

    System.out.println(getMaxConsecutiveList(input));

  }

  static List<Integer> getMaxConsecutiveList(int[] input){

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    tmp.add(input[0]);
    res.add(tmp);

    for(int i = 1; i < input.length; i++){

      List<Integer> tmp1 = new ArrayList<>();
      int prSum = sum(res.get(i-1));
      tmp1.add(input[i]);

      if(prSum +  input[i] > input[i]){
        tmp1.addAll(res.get(i-1));
      }
      res.add(tmp1);
    }

    int max = 0;
    int maxSum = Integer.MIN_VALUE;

    for(int i = 0; i < res.size(); i++){
      int tmpMax = sum(res.get(i));
      if( tmpMax > maxSum){
        max = i;
        maxSum = tmpMax;
      }
    }

    return res.get(max);

  }

  public static int sum(List<Integer> p){
    int sum = 0;
    for(int i = 0; i < p.size(); i++){
      sum += p.get(i);
    }
    return sum;
  }
}
