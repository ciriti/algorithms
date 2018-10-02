package com.ciriti.math

import com.ciriti.printThis
import java.security.InvalidParameterException
import java.util.Random

/**
 * Created by Carmelo Iriti
 */
fun main(args: Array<String>) {
  arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
      .myShuffle()
      .toList()
      .printThis()
}

fun <T : Comparable<T>> Array<T>.myShuffle(): Array<T> {
  (lastIndex - 1 downTo 0).forEach {
    this.mySwap(Random().nextInt(it + 1), it + 1)
  }
  return this
}

fun <T> Array<T>.mySwap(
  pos1: Int,
  pos2: Int
) {
  if (pos1 !in 0..lastIndex || pos1 !in 0..lastIndex) throw InvalidParameterException()
  val a = this[pos1]
  this[pos1] = this[pos2]
  this[pos2] = a
}