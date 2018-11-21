package com.ciriti

import java.security.InvalidParameterException
import java.util.Random

/**
 * Created by Carmelo Iriti
 */


fun main(args : Array<String>){

//  val input = generateSequence {
//    readLine().takeIf { it != "exit" }
//  }.toList().toString().printThis()
//
//  val numbers = generateSequence(3) { n ->
//    println("Generating element...")
//    (n + 1).takeIf { it < 7 }
//  }
//  println(numbers.take(9).toList())

//  val s = myBuildString {}.printThis()

  val num = if(Random().nextInt() % 2 == 0){
    2
  }else{
    fail()
  }

}

fun fail() : Nothing{
  TODO()
}



inline fun myBuildString(builderAction: StringBuilder.() -> Unit): String{
  val sb = StringBuilder()
  sb.builderAction()
  return sb.toString()
}

//inline fun f(crossinline body: () -> Unit) {
//  val f = object: Runnable {
//    override fun run() = body()
//  }
//  // ...
//}






