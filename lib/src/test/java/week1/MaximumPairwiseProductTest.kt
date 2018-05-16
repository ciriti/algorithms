package week1

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by ciriti
 */
class TestMax{

    @Test
    fun t1(){
        val r = Random()
        val start = System.currentTimeMillis()
        while(System.currentTimeMillis() - start < 10000){
            val n = r.nextInt(1000) + 2
            println("n $n")
            val array = IntArray(n)
            for(i in 0 until n-1){
                array[i] = r.nextInt(100_000)
            }
            array.forEach { print("$it ") }
            println()
            println("first: ${maxPairWiseProduct(array)}  second: ${maxPairWiseProduct2(array)}")
            Assert.assertTrue(maxPairWiseProduct(array) == maxPairWiseProduct2(array))
        }
    }

    @Test
    fun t2(){
            val array = arrayOf(3, 0).toIntArray()
            array.forEach { print("$it ") }
            println()
            println("first: ${maxPairWiseProduct(array)}  second: ${maxPairWiseProduct2(array)}")
            Assert.assertTrue(maxPairWiseProduct(array) == maxPairWiseProduct2(array))
    }

//    @Test
//    fun t3(){
//        Assert.assertEquals(1, week1.maxPairWiseProduct(arrayOf(1,1,1).toIntArray()))
//        Assert.assertEquals(12, week1.maxPairWiseProduct(arrayOf(1,2,3,3,3,4).toIntArray()))
//        Assert.assertEquals(63, week1.maxPairWiseProduct(arrayOf(9,3,7,4,5,6,4).toIntArray()))
//        Assert.assertEquals(81, week1.maxPairWiseProduct(arrayOf(9,9,9,9,1).toIntArray()))
//        Assert.assertEquals(81, week1.maxPairWiseProduct(arrayOf(9,9,9,9).toIntArray()))
//        Assert.assertEquals(72, week1.maxPairWiseProduct(arrayOf(9,2,2,2,2,8,7,6,5,4).toIntArray()))
//        Assert.assertEquals(64, week1.maxPairWiseProduct(arrayOf(2,2,2,2,3,3,3,3,8,4,4,4,8).toIntArray()))
//    }
//
//    @Test
//    fun t4(){
//        Assert.assertEquals(1, week1.maxPairWiseProduct2(arrayOf(1,1,1).toIntArray()))
//        Assert.assertEquals(12, week1.maxPairWiseProduct2(arrayOf(1,2,3,3,3,4).toIntArray()))
//        Assert.assertEquals(63, week1.maxPairWiseProduct2(arrayOf(9,3,7,4,5,6,4).toIntArray()))
//        Assert.assertEquals(81, week1.maxPairWiseProduct2(arrayOf(9,9,9,9,1).toIntArray()))
//        Assert.assertEquals(81, week1.maxPairWiseProduct2(arrayOf(9,9,9,9).toIntArray()))
//        Assert.assertEquals(72, week1.maxPairWiseProduct2(arrayOf(9,2,2,2,2,8,7,6,5,4).toIntArray()))
//        Assert.assertEquals(64, week1.maxPairWiseProduct2(arrayOf(2,2,2,2,3,3,3,3,8,4,4,4,8).toIntArray()))
//    }

    @Test
    fun t5(){
        Assert.assertEquals(0, maxPairWiseProduct2(IntArray(100)))
    }
    @Test
    fun t6(){
        Assert.assertEquals(0, maxPairWiseProduct(IntArray(100)))
    }

}