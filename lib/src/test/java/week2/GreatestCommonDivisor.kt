package week2

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by ciriti
 */

fun gcd(a :Int, b: Int) : Int{
    var small = Math.max(a, b)
    var big = 0
    var remainder =  Math.min(a, b)

    do{
        big = small
        small = remainder
        remainder =  big % small

    }while(remainder != 0)

    return small
}

fun gcdSlow(a :Int, b: Int) : Int{
    var na = Math.min(a,b)
    for(i in na downTo 1){
        if(a % i == 0 && b % i == 0) return i
    }
    return 1
}

fun gcdTester(p: Int, q: Int): Int {
    return if (q == 0)  p else gcdTester(q, p % q)
}

class GcdTest{
    @Test
    fun t1(){
        Assert.assertEquals(2, gcd(10, 8))
        Assert.assertEquals(10, gcd(10, 10))
    }

    @Test
    fun t2(){
        Assert.assertEquals(2, gcdSlow(10, 8))
        Assert.assertEquals(10, gcdSlow(10, 10))
    }

    @Test
    fun stress(){
        val start = System.currentTimeMillis()
        while(System.currentTimeMillis() - start < 10000){
            val n1 = Random().nextInt(10000) + 1
            val n2 = Random().nextInt(10000) + 1
            val my = gcd(n1, n2)
            val mySlow = gcdSlow(n1, n2)
            val tester = gcdTester(n1, n2)
            println("n1: $n1 n2:$n2 - my $my, tester $tester")
            Assert.assertTrue( my == tester && my == mySlow)
        }
    }
}