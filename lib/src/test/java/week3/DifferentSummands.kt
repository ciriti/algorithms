package week3

import org.junit.Assert
import org.junit.Test
import java.util.ArrayList

/**
 * Created by ciriti
 */

fun optimalSummands(n : Int) : List<Int>{
    val res = mutableListOf<Int>()
    var value = n
    var i = 0
    while(value > 0 && i++ <= value){
        if( 2 * i >= value ){
            res.add(value)
            value = 0
        }else{
            res.add(i)
            value -= i
        }
    }
    return res
}

private fun optimalSummandsTester(n: Int): List<Int> {
    var n = n
    val summands = ArrayList<Int>()

    var k = n
    var l = 1

    while(k > 0){
        if (k <= 2 * l) {
            summands.add(k)
            k -= k
        }else {
            summands.add(l)
            k -= l
        }
        l++
    }
    return summands
}

class DiffSummTester{

    @Test
    fun t3(){
        Assert.assertEquals(listOf(1, 2).toString(), optimalSummands(3).toString())
    }

    @Test
    fun t2(){
        for(i in 1 ..20){
            println("$i ${optimalSummandsTester(i)}")
            println("$i ${optimalSummands(i)}")
            Assert.assertTrue(optimalSummandsTester(i) == optimalSummands(i))
        }
    }

    @Test
    fun t1(){
        Assert.assertEquals(listOf(1, 2, 3).toString(), optimalSummandsTester(6).toString())
    }

}