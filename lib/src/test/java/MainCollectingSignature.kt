import week3.Segment
import week3.optimalPoints
import java.util.*

/**
 * Created by ciriti
 */
fun main(args : Array<String>){
    val scan = Scanner(System.`in`)
    val dim = scan.nextInt()
    /**
     * IMPORTANT
     *
     * After ".nextInt()" you must call ".nextLine()" to process the next line with the input
     */
    scan.nextLine()
    val input = mutableListOf<Segment>()
    println("------> $dim")
    for(i in 0 until dim){
        val a = scan.nextIntPair()
        input.add(Segment.create(a))
    }
    val res = optimalPoints(input)
    println(res.size)
    println(res)
}