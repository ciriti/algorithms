package week2

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by ciriti
 */

fun main(args : Array<String>){
    val s = Scanner(System.`in`)
    val n = s.nextLong()
    println(lastDigitFibSumNumber(n))

}

fun lastDigitFibSumNumberTester(n : Long) : Long{

    var sumFibs = 0L

    for(i in 0 .. n){
        sumFibs = ( sumFibs + fib(i) % 10) % 10
    }

    return sumFibs
}

fun lastDigitFibSumNumber(np : Long) : Long{

    val n = np % 60

    when(n){
        0L -> return 0
        1L -> return 1L
    }

    var a = 0L
    var b = 1L
    var sumFibs = a + b
    var curr = -1L

    for(i in 2 .. n){
        curr = (a + b) % 10
        sumFibs = (sumFibs + curr) % 10
        a = b
        b = curr
    }

    return sumFibs
}

class LastDigitoftheSumofFibonacciNumbersTest{

    @Test
    fun t6(){
        val b2 = arrayOf(0, 1, 2, 4, 7, 2, 0, 3, 4, 8, 3, 2, 6, 9, 6, 6, 3, 0, 4, 5, 0, 6, 7, 4, 2, 7, 0, 8, 9, 8, 8, 7, 6, 4, 1, 6, 8, 5, 4, 0, 5, 6, 2, 9, 2, 2, 5, 8, 4, 3, 8, 2, 1, 4, 6, 1, 8, 0, 9, 0)
        val b1 = arrayOf(7, 2, 0, 3, 4, 8, 3, 2, 6, 9, 6, 6, 3, 0, 4, 5, 0, 6, 7, 4, 2, 7, 0, 8, 9, 8, 8, 7, 6, 4, 1, 6, 8, 5, 4, 0, 5, 6, 2, 9, 2, 2, 5, 8, 4, 3, 8, 2, 1, 4, 6, 1, 8, 0, 9, 0, 0, 1, 2, 4)

    }

    @Test
    fun t5(){
        for(i in 0L .. 80L){
            Assert.assertTrue(lastDigitFibSumNumberTester(i) == lastDigitFibSumNumber(i))
        }
    }

    @Test
    fun t4(){
        val b = arrayOf(0, 1, 2, 4, 7, 2, 0, 3, 4, 8, 3, 2, 6, 9, 6, 6, 3, 0, 4, 5, 0, 6, 7, 4, 2, 7, 0, 8, 9, 8, 8, 7, 6, 4, 1, 6, 8, 5, 4, 0, 5, 6, 2, 9, 2, 2, 5, 8, 4, 3, 8, 2, 1, 4, 6, 1, 8, 0, 9, 0)
        println(b.size)
        var sum = 0
        for(i in b){
            sum = (sum + i) //% 10
        }
        println(sum)
//        for(i in 0L .. 160L){
//            val a = lastDigitFibSumNumber(i)
//            print("$a ")
//        }
    }


    @Test
    fun t3(){
        Assert.assertEquals(4, lastDigitFibSumNumber(3))
        Assert.assertEquals(2, lastDigitFibSumNumber(832564823476))
    }

    @Test
    fun t2(){
        Assert.assertEquals(4, lastDigitFibSumNumber(3))
        Assert.assertEquals(5, lastDigitFibSumNumber(100))
    }

    @Test
    fun t1(){
        val arr = LongArray(10)
        for(i in 0 until 10){
            arr[i] = Random().nextInt(10).toLong()
        }
        arr.sort()
        println(arr.toList())
    }

}
