package com.ciriti.array

import org.junit.Assert
import org.junit.Test

/**
 * Created by Carmelo Iriti
 */
class MaxDistToClosest {

  @Test
  fun t1() {
    Assert.assertEquals(2, intArrayOf(1, 0, 0, 0, 1, 0, 1).maxDistToClosest())
    Assert.assertEquals(4, intArrayOf(0, 0, 0, 0, 1, 0, 1).maxDistToClosest())
    Assert.assertEquals(3, intArrayOf(1, 0, 0, 0).maxDistToClosest())
    Assert.assertEquals(1, intArrayOf(0, 1).maxDistToClosest())
    Assert.assertEquals(2, intArrayOf(0, 0, 1).maxDistToClosest())

  }

}