package com.ciriti.puzzle

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {
  println(longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
}

fun longestConsecutive(nums: IntArray): List<Int> {
  val array = nums.copyOf()
      .apply { sort() }

  var res: List<Int> = mutableListOf()

  nums.fold(mutableListOf<Int>()) { acc, value ->

    when {
      acc.isEmpty() -> acc.apply { add(value) }
      acc.last() == (value + 1) -> acc.apply { add(value) }
      else -> {
        res = when{
          res.size < acc.size -> acc
          else -> res
        }
        mutableListOf()
      }
    }

  }

  return res

}