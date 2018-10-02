package com.ciriti.array

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {
  println(intArrayOf(3, 2, 2, 3).removeArray(3)) // res 3
  println(intArrayOf(2, 2, 1, 1, 1, 2, 2).removeArray(1)) // res 3
}

fun IntArray.removeArray(value: Int): Int {

  var i = 0

  forEachIndexed{ index, elem ->
    this[i] = elem
    if(value != elem){
      i++
    }
  }

  print("[")
  forEachIndexed{ index, item ->
    if(index < i) print("$item ")
  }
  println("]")

  return i
}