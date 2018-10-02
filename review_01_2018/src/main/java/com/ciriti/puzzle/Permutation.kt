package com.ciriti.puzzle

import com.ciriti.printThis
import com.marcinmoskala.math.combinations
import com.marcinmoskala.math.permutationsNumber

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {

  listOf('a', 'b', 'c')
      .myPerm()
      .printThis()

}

fun List<Char>.myPerm(): List<List<Char>> {

  return when {
    isEmpty() -> listOf()
    size == 1 -> listOf(listOf(get(0)))
    else -> {
      val element = get(0)
      this.drop(1)
          .myPerm()
          .flatMap { subList ->
            (0..subList.size).map { index ->
              subList.sumAt(index, element)
            }
          }
    }
  }

}

fun List<Char>.sumAt(
  index: Int,
  element: Char
) : List<Char>{
  return when {
    index == 0 -> listOf(element) + this
    index == size -> this + listOf(element)
    else -> dropLast(index) + listOf(element) + drop(index)
  }
}