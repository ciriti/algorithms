package week3

import org.junit.Assert
import org.junit.Test

/**
 * Created by ciriti
 */
fun maxDotProduct(a : Array<Int>, b : Array<Int>) : Long{
    val aSort = a.sortedArray()
    val bSort = b.sortedArray()
    var sum = 0L
    for(index in aSort.indices){
        sum += aSort[index] * bSort[index]
    }
    return sum
}

class MaxProductTester{

    @Test
    fun t1(){
        val inputA = arrayOf(1, 3, -5)
        val inputB = arrayOf(-2, 4, 1)
        val res = maxDotProduct(inputA, inputB)
        println(res)
        Assert.assertTrue(23L == res)
    }
}