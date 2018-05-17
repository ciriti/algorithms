import java.util.*

/**
 * Created by ciriti
 */
fun main(args : Array<String>){
    val s = Scanner(System.`in`)
    val n = s.nextLong()
    println(fib(n))

}

fun fib(n : Long) : Long{
    return when(n){
        0L -> 0
        1L -> 1
        else -> f(n)
    }
}

fun lastFibDigit(n : Int) : Long{
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