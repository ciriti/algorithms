package com.ciriti.puzzle

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {
  val input = intArrayOf(-2, 5, -1, 7, -3)
  println(input.getMaxConsecutiveList())
}

fun IntArray.getMaxConsecutiveList() : List<Int> {

  val copy = Array(size) { Pair(Int.MIN_VALUE, Pair(0, 0)) }
  copy[0] = Pair(this[0], Pair(0, 0))

  (1..copy.lastIndex).forEach {
    when {
      this[it] + copy[it - 1].first > this[it] -> {
        copy[it] = copy[it].copy(
            first = (this[it] + copy[it - 1].first),
            second = Pair(copy[it - 1].second.first, it)
        )
      }
      else ->  copy[it] = copy[it].copy(first = this[it], second = Pair(it, it))
    }
  }

  val maxPair = copy.maxBy{ it.first }!!

  return this.copyOfRange(maxPair.second.first, maxPair.second.second + 1).toList()

}