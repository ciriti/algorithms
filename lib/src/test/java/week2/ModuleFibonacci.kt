package week2

import org.junit.Assert
import org.junit.Test

/**
 * Created by ciriti
 *
#define PHI    1.61803398874989484820458683436563811772
#define SQRT5  2.236067977499789696409173668731276235441;

double fn_mod_m;
unsigned int n, m;

fn_mod_m = floor(pow_mod(PHI, n, SQRT5 * (double)m) / SQRT5);
 *
 *
 *
 */

fun modFibSlow(n: Long, m : Long) = fib(n) % m

fun fib(n : Long) : Long{
    return when(n){
        0L -> 0
        1L -> 1
        else -> f(n)
    }
}

private fun f(n :Long) : Long{
    var n_2 = 0L
    var n_1 = 1L
    var curr = 1L
    var count = n
    while(--count > 0){
        curr = n_1 + n_2
        n_2 = n_1
        n_1 = curr
    }
    return curr
}

fun modFib_fast(n: Long, m : Long) : Long{
    val period = findPeriod(m)
    val reducedFib = n % period
    return modFib(reducedFib, m)
}

fun findPeriod(m : Long) : Long{

    var a_2 = 0L
    var a_1 = 1L
    var curr = 1L

    var count = 1L
    var countPeriod = 0L

    while(countPeriod < 2){
        if(a_1 == 1L && a_2 == 0L) {
            countPeriod++
        }else{
            count++
        }
        if(countPeriod == 2L){
            break
        }
        curr = (a_1 + a_2) % m
        a_2 = a_1
        a_1 = curr
    }
    return count

}

fun modFib(n: Long, m : Long) : Long {

    if(n < 2) return n

    var a_2 = 0L
    var a_1 = 1L
    var mod = 1L

    var count = n
    var period = 3

    do{

        mod = (a_2 % m + a_1 % m) % m
        a_2 = a_1
        a_1 = mod

        if(a_2 == 0L && a_1 == 1L){
            period++
        }

    }while(--count >= 2)

    return mod
}

class FibNumbAgainTest{

    @Test
    fun t7(){
    }

    @Test
    fun t6(){
        Assert.assertTrue(modFib(15, 4) == modFib_fast(15, 4))
        Assert.assertTrue(modFib(2, 2) == modFib_fast(2, 2))
        Assert.assertTrue(modFib(15, 3) == modFib_fast(15, 3))
        Assert.assertTrue(modFib(3, 2) == modFib_fast(3, 2))
        Assert.assertTrue(modFib_fast(2816213588, 30524) == 10249L)
    }

    @Test
    fun t5(){
        Assert.assertEquals(8, findPeriod(3))
        Assert.assertEquals(3, findPeriod(2))
        Assert.assertEquals(6, findPeriod(4))
        Assert.assertEquals(20, findPeriod(5))
        Assert.assertEquals(24, findPeriod(6))
    }

    @Test
    fun t4(){
        Assert.assertTrue(modFib(20, 2) == modFibSlow(3, 2))
    }

    @Test
    fun t3(){
        Assert.assertTrue(modFib(3, 2) == modFibSlow(3, 2))
        Assert.assertTrue(modFib(2816213588, 30524) == 10249L)
    }
    @Test
    fun t2(){
        for(n in 0 .. 14){
            for(m in 2 .. 10){
                println("n: $n  -  m: $m")
                Assert.assertTrue(modFib(n.toLong(), m.toLong()) == modFibSlow(n.toLong(), m.toLong()))
                Assert.assertTrue(modFib(n.toLong(), m.toLong()) == modFib_fast(n.toLong(), m.toLong()))
            }
        }
    }
    @Test
    fun t1(){
        val arr = arrayOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811)
        for(i in 2 .. 5){
            arr.forEach { print("${it%i} ") }
            println()
            println()
        }

    }

}