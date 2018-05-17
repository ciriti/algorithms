import java.util.*

/**
 * Created by ciriti
 */

fun main(args : Array<String>){
    val s = Scanner(System.`in`)
    val n = s.nextLong()
    println(lastDigitFibSumNumber(n))

}

private fun lastDigitFibSumNumber(np : Long) : Long{

    val n = np % 60

    when(n){
        0L -> return 0
        1L -> return 1L
    }

    var a = 0L
    var b = 1L
    var sumFibs = a + b
    var curr = -1L

    for(i in 2 .. n){
        curr = (a + b) % 10
        sumFibs = (sumFibs + curr) % 10
        a = b
        b = curr
    }

    return sumFibs
}