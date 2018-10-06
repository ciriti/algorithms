package com.ciriti.kotlin

/**
 * Created by Carmelo Iriti
 */
fun main(args: Array<String>) {
  val map = mutableMapOf<Int, Int>()
//  map[2].executeIfNull { map[2] = 2 }
//  map[2] = 2
  map[2]?.let {
    println("I'm $it")
  }
}
