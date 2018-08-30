package week3

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by ciriti
 */

private fun largestNumberTester(a: Array<String>): String {
    // write your code here
    var result = ""
    for (i in a.indices) {
        result += a[i]
    }
    return result
}

fun largestNumber(pa: Array<String>): String {
    // write your code here
    var a = pa.sortedDescending()
    var result = a[0]
    for(i in 1 until a.size ){
        result += a[i]
    }
    return result
}



class LargestNumber{

    @Test
    fun stess(){
        for(i in 0 .. 10){
            var a = Random().nextInt(100).toString()
            var b = Random().nextInt(100).toString()
            var c = Random().nextInt(100).toString()
            println("$a $b $c")
            println(largestNumber( arrayOf(a, b, c)) )
            println()
        }

    }

    @Test
    fun t1(){
        println(largestNumber(arrayOf("23", "9")))
    }
    @Test
    fun t1_1(){
        Assert.assertTrue(largestNumber(arrayOf("21", "2")) == "221")
        Assert.assertTrue(largestNumber(arrayOf("9", "4", "6",  "1",  "9")) == "99641")
        Assert.assertTrue(largestNumber(arrayOf("23", "39", "92")) == "923923")
    }

}