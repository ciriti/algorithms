package com.ciriti.array

/**
 * Created by Carmelo Iriti
 *
 * LINK - https://leetcode.com/problems/maximize-distance-to-closest-person/
 *
 * To Solve
 *
 */

fun main(args: Array<String>) {
  println(intArrayOf(1, 0, 0, 0, 1, 0, 1).maxDistToClosest()) // res 2
  println(intArrayOf(0, 0, 0, 0, 1, 0, 1).maxDistToClosest()) // res 0
  println(intArrayOf(1, 0, 0, 0).maxDistToClosest()) // res 3
  println(intArrayOf(0, 1).maxDistToClosest()) // res 1
  println(intArrayOf(0, 0, 1).maxDistToClosest()) // res 2
  println(intArrayOf(1, 0, 1).maxDistToClosest()) // res 1
}

fun IntArray.maxDistToClosest(): Int {

  var left = 0
  var right = left + 1
  val list = mutableListOf<Pair<Int, Int>>()

  while (right in (left + 1)..lastIndex) {
    when{
      this[left] == 1 -> { left ++
        right = left + 1
      }
      this[right] == 0 -> {
        right ++
        if(right == lastIndex) list.add(Pair(left, right))
      }
      else -> {
        list.add(Pair(left, right))
        left = right
        right++
      }
    }
  }

  val pair = list.maxBy{ it.second - it.first }?:Pair(0,0)

  val res = when{
    pair.first == 0 -> (pair.second - pair.first)
    pair.second == lastIndex -> lastIndex
    else -> (pair.second - pair.first) / 2 + 1
  }

  return res

}