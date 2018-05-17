package week2

import org.junit.Assert
import org.junit.Test

/**
 * Created by ciriti
 */

fun lcm(a : Int, b : Int) : Long{
    val gcd = gcdLcm(a, b)
    val n1 = a.toLong() / gcd
    val res : Long = b.toLong() * n1
    return res
}

private fun gcdLcm(a :Int, b: Int) : Int{
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

class LcmTest{
    @Test
    fun f1(){
        Assert.assertEquals(1933053046, lcm(28851538,1183019))
        Assert.assertEquals(24, lcm(6,8))
    }
}