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
    val m = s.nextLong()
    println(lastDigitFibSumNumberNM(n, m))

}

fun lastDigitFibSumNumberNMTester(n : Long) : Long{

    var sumFibs = 0L

    for(i in 0 .. n){
        sumFibs = ( sumFibs + fib(i) % 10) % 10
    }

    return sumFibs
}

fun lastDigitFibSumNumberNM(mp : Long, np : Long) : Long{

    val n = np % 60
    val m = mp % 60

    when(n){
        0L -> return 0
        1L -> return 1L
    }

    var a = 0L
    var b = 1L
    var sumFibs = 0L
    var curr = -1L

    for(i in 2 .. n){
        curr = (a + b) % 10
        if(i >= m){
            sumFibs = (sumFibs + curr) % 10
        }

        a = b
        b = curr
    }

    return sumFibs
}

class LastDigitoftheSumofFibonacciNumbersTestNM{


    @Test
    fun t5(){
        Assert.assertEquals(1, lastDigitFibSumNumberNM(3, 7))
        Assert.assertEquals(5, lastDigitFibSumNumberNM(10, 10))
    }



}
