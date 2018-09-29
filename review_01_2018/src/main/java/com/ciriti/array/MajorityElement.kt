package com.ciriti.array

import kotlin.collections.Map.Entry

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {
  println(intArrayOf(3, 2, 3).majorityElement()) // res 3
  println(intArrayOf(2, 2, 1, 1, 1, 2, 2).majorityElement()) // res 3
}

fun IntArray.majorityElement(): Int {
  return myGroupBy { it }
      .myMaxBy { it.value.size }?.key ?: 0
}

fun <K> Map<K, MutableList<Int>>.myMaxBy(selector: (entry: Entry<K, MutableList<Int>>) -> Int): Entry<K, MutableList<Int>>? {
  var res: Entry<K, MutableList<Int>>? = null
  var max : Int = Int.MIN_VALUE
  entries.forEach {
    val tmp = selector(it)
    if(max <= tmp){
      max = tmp
      res = it
    }
  }
  return res
}

fun <K> IntArray.myGroupBy(keySelector: (element: Int) -> K): Map<K, MutableList<Int>> {

  val linkedHashMap = LinkedHashMap<K, MutableList<Int>>()

  forEach {
    val key = keySelector(it)
    linkedHashMap
        .getOrPut(key) { mutableListOf() }
        .add(it)
  }

  return linkedHashMap
}