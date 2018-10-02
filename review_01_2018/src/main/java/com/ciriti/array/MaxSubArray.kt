package com.ciriti.array

import kotlin.math.max
import kotlin.system.measureNanoTime

/**
 * Created by Carmelo Iriti
 *
 * LINK - https://leetcode.com/problems/maximum-subarray/description/
 */

fun main(args: Array<String>) {

  measureNanoTime {
    intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4).maxSubArray()
        .apply { println(this) }
  }.apply { println(this) }
  measureNanoTime {
    intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4).maxSubArray1()
        .apply { println(this) }
  }.apply { println(this) }
  measureNanoTime {
    intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4).maxSubArrayList()
        .apply { println(this) }
  }.apply { println(this) }

//  println(intArrayOf(-2,1,-3,4,-1,2,1,-5,4).maxSubArray()) // res 6
}

fun IntArray.maxSubArray(): Int {
  if (isEmpty()) return 0
  val copy = this.copyOf()
  for (index in 1..lastIndex) {
    copy[index] = max(copy[index] + copy[index - 1], copy[index])
  }
  return copy.maxBy { it }!!
}

fun IntArray.maxSubArray1(): Int {
  if (isEmpty()) return 0
  var max = this[0]
  var current: Int
  var prev = this[0]
  for (index in 1..lastIndex) {
    current = kotlin.math.max(this[index], this[index] + prev)
    max = kotlin.math.max(max, current)
    prev = current
  }
  return max
}

fun IntArray.maxSubArrayList(): List<Int> {
  if (isEmpty()) return emptyList()
  val array: Array<MutableList<Int>> = Array(this.size) { mutableListOf<Int>() }
  array[0].add(this[0])
  for (i in 1..lastIndex) {
    array[i].add(this[i])
    array[i] = maxList(array[i], array[i-1])
  }
  return array.maxBy { it.sum() }?.toList() ?: emptyList()
}


fun maxList(list : MutableList<Int>, list2 : MutableList<Int>) : MutableList<Int>{
  if(list.sum() > list2.sum()){
    return list
  }
  return list.apply{ addAll(list2) }
}