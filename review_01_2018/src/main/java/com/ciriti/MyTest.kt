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
  val list = listOf("a", "a", "a", "", "a")

  " ".isEmpty().printThis()
  " ".isBlank().printThis()
  " ab ".trim().printThis()

}

private fun duplicateNonZero(list: List<Int>): List<Int> {
  return list.flatMap {
    if (it == 0) return listOf()
    listOf(it, it)
  }
}

