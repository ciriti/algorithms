package week2

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by ciriti
 */

//fun main(args : Array<String>){
//    val s = Scanner(System.`in`)
//    val n = s.nextInt()
//    println(lastFibDigit(n))
//
//}

fun lastFibDigit(n : Long) : Long{
    var n_b = 0L
    var n_a = 1L
    var curr = 1L

    var count = n

    while(--count > 0){
        curr = (n_b % 10L + n_a % 10L) % 10L
        n_b = n_a % 10L
        n_a = curr
    }

    return curr
}




fun lastFibDigitSlow(n : Int) : Long{
    return fib(n).toString().toCharArray().last().toLong() - '0'.toLong()
}

class LastDigit{

    @Test
    fun t3() {
        Assert.assertEquals(5, lastFibDigit(832564823476))
    }
    @Test
    fun t1(){
        Assert.assertEquals(5, lastFibDigit(295))
        Assert.assertEquals(7, lastFibDigit(296))
        Assert.assertEquals(1, lastFibDigit(239))

//        Assert.assertEquals(5, lastFibDigitSlow(101))
//        Assert.assertEquals(7, lastFibDigitSlow(14))
//        Assert.assertEquals(1, lastFibDigitSlow(239))
//        Assert.assertNotEquals(3, lastFibDigitSlow(14))
    }

    @Test
    fun t2(){
        Assert.assertEquals(3, lastFibDigitSlow(7))
        Assert.assertEquals(1, lastFibDigitSlow(8))

        Assert.assertEquals(3, lastFibDigit(7))
        Assert.assertEquals(1, lastFibDigit(8))
//        Assert.assertEquals(1, lastFibDigitSlow(239))
//        Assert.assertNotEquals(3, lastFibDigitSlow(14))
    }

    @Test
    fun stress(){
        val start = System.currentTimeMillis()
        while(System.currentTimeMillis() - start < 2000){
            val r = Random().nextInt(80)
            val a = lastFibDigit(r.toLong())
            val b = lastFibDigitSlow(r)
            println("$r | lfd $a | lfdS $b")
            Assert.assertTrue( a == b)
        }
    }
}