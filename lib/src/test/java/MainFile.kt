import java.util.*

/**
 * Created by ciriti
 */
fun main(args : Array<String>){
    val s = Scanner(System.`in`)
    val n = s.nextInt()
    println(lastFibDigit(n))

}

fun fib(n : Int) : Long{
    return when(n){
        0 -> 0
        1 -> 1
        else -> f(n)
    }
}

fun lastFibDigit(n : Int) : Long{
    return Math.abs(n % 10L)
}

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