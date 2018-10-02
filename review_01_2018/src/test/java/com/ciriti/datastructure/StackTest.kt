package com.ciriti.datastructure

import org.junit.Assert
import org.junit.Test

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
        val size = Random().ne
    }

}