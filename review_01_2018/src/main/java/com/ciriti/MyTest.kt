package com.ciriti

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
  println("$foo1 $foo1 $foo2 $foo2")
}