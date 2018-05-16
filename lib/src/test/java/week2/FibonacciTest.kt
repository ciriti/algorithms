package week2

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by ciriti
 */
class FibonacciTest{
    @Test
    fun t1(){
        Assert.assertEquals(0, fib(0))
        Assert.assertEquals(1, fib(1))
        Assert.assertEquals(1, fib(2))
        Assert.assertEquals(2, fib(3))
        Assert.assertEquals(3, fib(4))
        Assert.assertEquals(5, fib(5))
        Assert.assertEquals(8, fib(6))
    }

    @Test
    fun stress(){
        val start = System.currentTimeMillis()
        while(System.currentTimeMillis() - start < 800){
            val n = Random().nextInt(30)
            println("n $n")
            val f = fib(n)
            val f1 = fib2(n)
            println("f: $f f1:$f1")
            Assert.assertTrue( f == f1)
        }
    }
}