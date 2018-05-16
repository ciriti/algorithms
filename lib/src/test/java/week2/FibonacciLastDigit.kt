package week2

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by ciriti
 */

fun main(args : Array<String>){
    val s = Scanner(System.`in`)
    val n = s.nextInt()
    println(lastFibDigit(n))

}

fun lastFibDigit(n : Int) : Long{
    return Math.abs(fib(n) % 10L)
}

fun lastFibDigitSlow(n : Int) : Long{
    return fib(n).toString().toCharArray().last().toLong() - '0'.toLong()
}

class LastDigit{

    @Test
    fun t1(){
        Assert.assertEquals(5, lastFibDigit(101))
        Assert.assertEquals(7, lastFibDigit(14))
        Assert.assertEquals(1, lastFibDigit(239))
        Assert.assertNotEquals(3, lastFibDigit(14))

        Assert.assertEquals(5, lastFibDigitSlow(101))
        Assert.assertEquals(7, lastFibDigitSlow(14))
        Assert.assertEquals(1, lastFibDigitSlow(239))
        Assert.assertNotEquals(3, lastFibDigitSlow(14))
    }

    @Test
    fun stress(){
        val start = System.currentTimeMillis()
        while(System.currentTimeMillis() - start < 2000){
            val r = Random().nextInt(80)
            val a = lastFibDigit(r)
            val b = lastFibDigitSlow(r)
            println("$r | lfd $a | lfdS $b")
            Assert.assertTrue( a == b)
        }
    }
}