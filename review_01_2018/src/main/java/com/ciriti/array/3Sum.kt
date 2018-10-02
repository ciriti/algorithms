package com.ciriti.array

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {
  val target = 0
  val array = intArrayOf(-1, 0, 1, 2, -1, -4)
  array.sum3(0)
}

fun IntArray.sum3(target: Int): List<List<Int>> {

  val map = HashMap<Int, MutableList<Int>>()
  mapIndexed { index, value -> map.getOrPut(target - value) { mutableListOf(index) } }

  val setResult = mutableSetOf<List<Int>>()

  forEachIndexed { index, value ->
    for (index2 in (index + 1)..lastIndex) {
      val sum = this[index] + this[index2]
      if (map.containsKey(sum)) {
        map[sum]!!.forEach {
          if (it != index && it != index2) {
            val min = minOf(value, this[index2], this[it])
            val max = maxOf(value, this[index2], this[it])
            setResult
                .add(
                    listOf(
                        min,
                        (value + this[index2] + this[it]) - min - max,
                        max
                    )
                )
          }
        }
      }
    }
  }

  return setResult.toList()
}