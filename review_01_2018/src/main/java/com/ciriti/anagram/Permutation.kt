package com.ciriti.anagram

import com.ciriti.printThis

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {

  listOf(1,2,3, 3)
      .myPerm()
      .printThis()

}

fun List<Int>.myPerm(): List<List<Int>> {

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

fun List<Int>.sumAt(
  index: Int,
  element: Int
) : List<Int>{
  return when {
    index == 0 -> listOf(element) + this
    index == size -> this + listOf(element)
    else -> dropLast(index) + listOf(element) + drop(index)
  }
}