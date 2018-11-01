package com.ciriti.datastructure.dynamic

import kotlin.math.max

/**
 * Created by ciriti
 */
fun main(args: Array<String>) {

  val capacity = 10
  val goldBars = arrayOf(3, 6, 3)
  val values = Array(capacity + 1) { mutableListOf<Int>() }
  val res = knapsackRec(capacity, goldBars, mutableMapOf(), values)

  println(res)

}

fun knapsackRec(
  cap: Int,
  arr: Array<Int>,
  map: MutableMap<Int, Int>,
  cachedLists: Array<MutableList<Int>>
): Int {

  if (map.containsKey(cap)) {
    return map[cap]!!
  }
  map[cap]?.let { map[cap]= 0 }

  (0 until arr.size).forEach {
    if (arr[it] <= cap) {
      val value = knapsackRec(cap - arr[it], arr, map, cachedLists) + arr[it]
      map[cap] = max(value, map[cap]!!)
    }
  }

  return map[cap]!!
}

