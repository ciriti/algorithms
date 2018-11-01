package com.ciriti.kotlin

/**
 * Created by Carmelo Iriti
 */
fun main(args: Array<String>) {
  val map = mutableMapOf<Int, Int>()
  //map[1] ?: map[1] = 1 // it doesn't compile
  //map[1].runIfNull { map[1] = 1 } // it compiles
//  with(map[1]){
//    println(this)
//  }
  val s = null
  s.runIfNull{
    println("is null")
  }
}

private fun <T> T.runIfNull(func: () -> Unit) = this ?: func()

private fun <T, R> myWith(receiver: T, block: T.() -> R): R {
  return receiver.block()
}
