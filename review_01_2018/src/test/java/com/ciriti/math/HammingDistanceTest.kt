package com.ciriti.math

import org.junit.Assert
import org.junit.Test
import kotlin.system.measureNanoTime

/**
 * Created by Carmelo Iriti
 */
class HammingDistanceTest {

  @Test
  fun t1() {
    (0..1000).forEach {
      Assert.assertEquals(it.hammingDistance(it), it.myHammingDistance(it))
    }
  }
  @Test
  fun t2() {
    var c1 = 0
    var c2 = 0
    (100000..101000).forEach {
      val t1 = measureNanoTime { it.hammingDistance(it) }
      val t2 = measureNanoTime { it.myHammingDistance(it) }
      if(t1>t2) c1++ else c2++
    }
    println("t1 - t2    $c1 - $c2")
  }

}