package com.ciriti.datastructure

import org.junit.Assert
import org.junit.Test
import java.util.Random

/**
 * Created by Carmelo Iriti
 */
class StackTest {

  @Test
  fun t1() {
    val stack = Stack<Int>()
    stack.push(10)
    Assert.assertEquals(10, stack.peek())
    Assert.assertEquals(1, stack.size)
    Assert.assertEquals(10, stack.pop())
    Assert.assertEquals(0, stack.size)
    Assert.assertEquals(null, stack.pop())
    Assert.assertEquals(null, stack.peek())
  }

  @Test
  fun t2() {
    val stack = Stack<Int>()
    val sizeTest = 3//Random().nextInt(1000)
    (1..sizeTest).map { stack.push(Random().nextInt()) }
    Assert.assertEquals(sizeTest, stack.size)
    (1..sizeTest).map { stack.pop() }
    Assert.assertEquals(0, stack.size)
  }

  @Test
  fun contains() {
    val stack = Stack<Int>()
    (0..100).map{
      stack.push(it)
    }
    Assert.assertTrue(stack.contains(100))
    Assert.assertTrue(stack.contains(1))
    Assert.assertFalse(stack.contains(101))
    Assert.assertFalse(stack.contains(102))
  }

  @Test
  fun containsAll() {
    val stack = Stack<Int>()
    (0..100).map{
      stack.push(it)
    }
    Assert.assertTrue(stack.containsAll((20..40).flatMap { listOf(it) }))
    Assert.assertTrue(stack.containsAll((90..100).flatMap { listOf(it) }))
    Assert.assertTrue(stack.containsAll((90..101).flatMap { listOf(it) }))
  }

}