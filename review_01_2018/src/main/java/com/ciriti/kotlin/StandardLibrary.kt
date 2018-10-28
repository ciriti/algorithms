package com.ciriti.kotlin

import com.ciriti.printThis

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {

  // regex
  val regex = "\\d{2}\\.\\d{2}\\.\\d{4}".toRegex()
  regex.matches("10.04.1984").printThis()
  regex.matches("10.4.1984").printThis()

  // conversion number
  "123".toInt().printThis()
  //"xx".toInt().printThis()
  "1e-10".toDouble().printThis()
  "123".toIntOrNull().printThis()
  "xx".toIntOrNull().printThis()
  "10".toInt(8).printThis()

  // infix function
  fun getAnswer() = 4
  (getAnswer() eq 4).printThis()
  (2 to "ciao").printThis()

}

infix fun <T> T.eq(other : T) = this == other

