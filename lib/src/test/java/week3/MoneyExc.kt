package week3

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by ciriti
 */

/**

Money Change Problem

    Compute the minimum number of coins needed
    to change the given value into coins with denominations
    1, 5, and 10.

Input:
    Integer money.

Output:
    The minimum number of coins with denominations 1, 5, and 10 that changes money.

 */
fun moneyChange(money : Int) = when(money){
    in 1 until 5 -> money
    in 5 until 10 -> money / 5 + money % 5
    else -> money/10 + ((money % 10) / 5) + ((money % 10) % 5)
}

fun getChangeTester(n: Int): Int {
    var n = n
    var numChanges = 0
    val denominations = intArrayOf(10, 5, 1)
    while (n > 0) {
        var i = 0
        while (i <= 2 && denominations[i] > n) i++
        n -= denominations[i]
        numChanges++
    }
    return numChanges
}

fun moneyChange_1_4_6(money : Int) = when(money){
    in 1 until 4 -> money
    in 4 until 6 -> money / 4 + money % 4
    else -> money/6 + ((money % 6) / 4) + ((money % 6) % 4)
}

class ChangeTest{

    @Test
    fun stress(){
        val start = System.currentTimeMillis()
        while(System.currentTimeMillis() - start < 5000){
            var num = Random().nextInt(10000)
            Assert.assertTrue(moneyChange(num) == getChangeTester(num))
        }
    }
    @Test
    fun t2(){
        Assert.assertEquals(2, moneyChange_1_4_6(12))
        Assert.assertEquals(5, moneyChange_1_4_6(15))
        Assert.assertEquals(3, moneyChange_1_4_6(16))
    }

    @Test
    fun t1(){
        Assert.assertEquals(2, moneyChange(2))
        Assert.assertEquals(6, moneyChange(28))
    }

}