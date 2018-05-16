package week2

import java.util.*

/**
 * Created by ciriti
 */

fun main(args : Array<String>){
    val s = Scanner(System.`in`)
    val n = s.nextInt()
    println(fib(n))

}

fun fib(n : Int) : Long{
    return when(n){
        0 -> 0
        1 -> 1
        else -> f(n)
    }
}

private fun f(n :Int) : Long{
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

fun fib2(n : Int) : Long{
    return when(n){
        0 -> 0
        1 -> 1
        else -> (fib2(n-1) + fib2(n-2))
    }
}