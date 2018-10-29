package com.ciriti.kotlin

/**
 * Created by Carmelo Iriti
 */

fun main(args : Array<String>){



  val action = { name : String, surname : String -> myPrint(name, surname) }

  //val action1 = myPrint // compile error
  val action2 = ::myPrint // it is ok

  action("carmelo", "iriti")
  action2("carmelo", "iriti")

}

private fun myPrint(name : String, surname : String) {
  println("$name $surname")
}