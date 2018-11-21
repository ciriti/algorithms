package com.ciriti.kotlin

import com.ciriti.printThis

/**
 * Created by Carmelo Iriti
 */
val foo1 = run {
  println("Calculating the answer... f1")
  "foo1"
}


val foo2: String
  get() {
    println("Calculating the answer... f2")
    return "foo2"
  }

fun main(args: Array<String>) {
  foo1.printThis()
  foo1.printThis()
  foo2.printThis()
  foo2.printThis()
}