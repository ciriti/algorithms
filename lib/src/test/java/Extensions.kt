import java.text.DecimalFormat
import java.util.*

/**
 * Created by ciriti
 */

fun laps() = System.currentTimeMillis()

fun Double.fourDecimal(): String{
    val df = DecimalFormat("####0.0000")
    return df.format(this)
}

fun Scanner.nextIntSequence() : List<Int>{
    val row = nextLine()
    val arrString = row.trim().split(" ")
    return arrString.map { it.toInt() }
}
fun Scanner.nextIntPair() : Pair<Int, Int>{

    val row = nextLine()
    val arrString = row.trim().split(" ")
    println(arrString.toList())
    try {
        return Pair(arrString[0].toInt(), arrString[1].toInt())
    }catch (e : NumberFormatException){
        throw RuntimeException("ACHTUNG!!! Please Insert at least 2 Int number  ")
    }
}

fun Scanner.nextLongSequence() : List<Long>{
    val row = nextLine()
    val arrString = row.trim().split(" ")
    return arrString.map { it.toLong() }
}

fun Scanner.nextDoubleSequence() : List<Double>{
    val row = nextLine()
    val arrString = row.trim().split(" ")
    return arrString.map { it.toDouble() }
}
