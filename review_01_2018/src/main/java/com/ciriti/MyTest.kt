package com.ciriti

import android.os.Bundle
import android.os.Parcelable
import java.math.BigInteger

/**
 * Created by Carmelo Iriti
 */

val foo1 = run {
  println("Calculating the answer... f1")
  42
}


val foo2: Int
  get() {
    println("Calculating the answer... f2")
    return 42
  }

fun main(args: Array<String>) {
//  println("$foo1 $foo1 $foo2 $foo2")
//  println(duplicateNonZero(listOf(3, 0, 5)))
  val listWithNulls: List<String?> = listOf("Kotlin", null)
  val map = mapOf<Int, Int>()
  for (item in listWithNulls) {
    item?.let { println(it) } // prints A and ignores null
    map[1]?.let {
      println("map")
    } // prints A and ignores null
  }

}

private fun duplicateNonZero(list: List<Int>): List<Int> {
  return list.flatMap {
    if (it == 0) return listOf()
    listOf(it, it)
  }
}

