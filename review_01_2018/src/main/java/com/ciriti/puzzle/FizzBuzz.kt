package com.ciriti.puzzle

/**
 * Created by Carmelo Iriti
 */

fun main(args : Array<String>){
  val map = mapOf(3 to "fizz", 5 to "buzz")

  (1..20).forEach {
    var s = map[(it%3)]?:"" + map[(it%5)]?:""
    println()
  }

}
