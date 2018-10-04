package com.ciriti.puzzle

import android.annotation.SuppressLint

/**
 * Created by Carmelo Iriti
 *
 * LINK -> https://leetcode.com/problems/subarray-sum-equals-k/
 *
 */

fun main(args: Array<String>) {

  println(intArrayOf(1, 1, 1).subarraySum(2))
  println(intArrayOf(1, 1, 1).subarraySum2(2))
  println()
  println(intArrayOf(1, 2, 3).subarraySum(3))
  println(intArrayOf(1, 2, 3).subarraySum2(3))
  println()
  println(intArrayOf(3, 2, 1).subarraySum(3))
  println(intArrayOf(3, 2, 1).subarraySum2(3))
  println()
  println(intArrayOf(1,2,1,2,1).subarraySum(3))
  println(intArrayOf(1,2,1,2,1).subarraySum2(3))
  println()
  println(intArrayOf(0,0,0,0).subarraySum(0))
  println(intArrayOf(0,0,0,0).subarraySum2(0))
}

fun IntArray.subarraySum(k: Int): Int {
  var count = 0
  (0 until this.size).forEach { i ->
    var sum = 0
    (i until this.size).forEach { j ->
      sum += this[j]
      if (sum == k) count++
    }
  }
  return count
}

fun IntArray.subarraySum2(k: Int): Int {
  var res = 0
  val map = mutableMapOf(0 to 1)
  var sum = 0
  for(i in this.indices) {
    sum += this[i]
    if (map.contains(sum - k)) {
      res += map[sum - k]!!
    }
    map[sum] = (map[sum]?:0) + 1
  }

  return res
}