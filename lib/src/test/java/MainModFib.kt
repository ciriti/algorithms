import java.util.*

/**
 * Created by ciriti
 */

fun main(args : Array<String>){
    val scanner = Scanner(System.`in`)

    val a = scanner.nextLong()
    val b = scanner.nextLong()

    println(modFib_fast(a, b))
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