package com.ciriti.kotlin

import com.ciriti.printThis
import kotlin.coroutines.experimental.buildSequence

/**
 * Created by Carmelo Iriti
 */
fun fibonacci(): Sequence<Int> = buildSequence {
  var elements = Pair(0,1)
  while(true){
    yield(elements.first)
    elements = Pair(elements.second, elements.first + elements.second)
  }
}

fun main(args: Array<String>) {
  (fibonacci().take(4).toList().toString() eq
      "[0, 1, 1, 2]").printThis()

  (fibonacci().take(10).toList().toString() eq
      "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]").printThis()
}
