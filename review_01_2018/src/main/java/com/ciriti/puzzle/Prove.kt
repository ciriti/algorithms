package com.ciriti.puzzle

import com.ciriti.printThis

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {
//  println(3.factorial())
//  println(rec(60000))
//  println(60000.dimUno())

  listOf(listOf(1) + listOf(2))

  val a = listOf('a', 'b', 'c').anagramma()
      .printThis()

  println()

//  listOf(1, 2, 3).myFunc().printThis()
//  (listOf(1) + listOf(2)).printThis()

}

fun List<Char>.anagramma(): List<List<Char>> {
  return when {
    size == 1 -> listOf(listOf(get(0)))
    else -> {
      val elem = get(0)
      this.drop(1)
          .anagramma()
          .flatMap { itf ->
            (0..itf.size).map {
              itf.plusAt(it, elem)
            }
          }
    }
  }
}

fun List<Char>.plusAt(
  position: Int,
  char: Char
): List<Char> {

  return when {
    size == 0 -> listOf(char)
    position == 0 -> listOf(char) + this
    position == size -> this + listOf(char)
    else -> {
      dropLast(size - position) + listOf(char) + drop(position)
    }
  }

}