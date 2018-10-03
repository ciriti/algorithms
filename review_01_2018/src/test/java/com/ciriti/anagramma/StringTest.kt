package com.ciriti.anagramma

import org.junit.Assert
import org.junit.Test

/**
 * Created by Carmelo Iriti
 */

class StringTest {
  @Test
  fun t1() {
    val s = "abc"
//    Assert.assertEquals("bc", "${s.substring(0, 1)}${s.substring(2, s.length)}")
//    Assert.assertEquals("ac", "${s.substring(0, 1)}${s.substring(2, s.length)}")
//    Assert.assertEquals("ab", "${s.substring(0, 2)}${s.substring(3, s.length)}")
    for(i in 0..s.lastIndex){
      val st = "${s.substring(0, i)}${s.substring(i+1, s.length)}"
      println(st)
    }

  }
}