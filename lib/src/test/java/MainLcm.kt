import java.util.*

/**
 * Created by ciriti
 */

fun main(args : Array<String>){
    val scanner = Scanner(System.`in`)

    val a = scanner.nextInt()
    val b = scanner.nextInt()

    println(lcm(a, b))
}

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