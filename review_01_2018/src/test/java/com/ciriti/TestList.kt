package com.ciriti

import org.junit.Test

/**
 * Created by Carmelo Iriti
 */
class TestList {

  @Test
  fun t1() {
    /** insert at index 2 */
    val index = 4
    val l = listOf(1, 2, 3, 4)
    val list = l.dropLast(l.size - index) + listOf(9) + l.drop(index)

    println(list)

  }

}