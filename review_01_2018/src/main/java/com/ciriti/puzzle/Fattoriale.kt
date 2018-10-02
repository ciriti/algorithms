package com.ciriti.puzzle

/**
 * Created by Carmelo Iriti
 */
fun main(args: Array<String>) {
  println(3.factorial())
  println(rec(60000))
  println(60000.dimUno())

}

fun Int.factorial() = (1..this).fold(1) { acc, value -> acc * value }

fun rec(num: Int): Int {
  return if (num == 0) 0
  else rec(num - 1)
}

fun Int.dimUno(): Int {
  return if (this == 0) 0
  else this.dimUno()
}