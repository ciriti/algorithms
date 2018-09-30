package com.ciriti.array;

/**
 * Created by Carmelo Iriti
 */
class Solution { // Time:O(n), Space:O(1)

  public static void main(String[] args){
    System.out.println(maxDistToClosest(new int[]{ 0, 1 }));
    System.out.println(maxDistToClosest(new int[]{ 1, 0, 0, 0, 1, 0, 1 }));
    System.out.println(maxDistToClosest(new int[]{ 0, 0, 0, 0, 1, 0, 1 }));
  }

  public static int maxDistToClosest(int[] seats) {
    int res = 0, count = 0;
    // 1. count the number of leading and trailing 0s
    int front = 0, back = 0 ; // the number of leading and trailing 0s
    int left = 0, right = seats.length - 1; // temp index
    while (seats[left++] == 0) {
      front++;
    }
    while (seats[right--] == 0) {
      back++;
    }
    // 2. count the longest length of consective 0s in between
    for (int seat : seats) {
      if (seat == 0) {
        count++;
      } else {
        count = 0;
      }
      if (count > res) {
        res = count;
      }
    }
    // 3. return res
    return Math.max((res + 1) / 2, Math.max(front, back));
  }
}
