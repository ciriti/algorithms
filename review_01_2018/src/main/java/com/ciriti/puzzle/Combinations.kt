package com.ciriti.puzzle

import com.ciriti.printThis

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {
  listOf(1, 2, 3).myTest().printThis()
}

fun <T> Collection<T>.myTest(): List<List<T>>{

  return when{
    isEmpty() -> listOf(listOf())
    else ->
      this.drop(1)
          .myTest()
          .let {
            it + it.map { it + first() }
          }
  }

}

fun <T> Collection<T>.myPowerset(): Set<Set<T>> = when {
  isEmpty() -> setOf(setOf())
  else ->
    this.drop(1)
        .myPowerset()
        .let {
          it + it.map { it + first() }
        }
}
