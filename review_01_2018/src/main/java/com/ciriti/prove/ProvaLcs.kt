package com.ciriti.prove

import kotlin.math.max

/**
 * Created by Carmelo Iriti
 */


fun main(args: Array<String>) {
    val s = "____________ABC___________"

    println(s.provaLcs("-------------12AB----------------"))
}

fun String.provaLcs(other: String): String {


    val matrix = Array(other.length + 1) { Array(this.length + 1) { 0 } }

    for (row in 1 until (other.length + 1)) {
        for (col in 1 until (this.length + 1)) {
            matrix[row][col] = when (other[row - 1] == this[col - 1]) {
                true -> matrix[row - 1][col - 1] + 1
                false -> max(matrix[row - 1][col], matrix[row][col - 1])
            }
        }
    }
    return matrix.backTracking(other)
}

fun Array<Array<Int>>.backTracking(string : String): String {

    val sb = StringBuffer()
    var lastRow = lastIndex
    var lastCol = this[0].lastIndex

    while (lastRow >= 1 && lastCol >= 1) {
        when (this[lastRow][lastCol]) {
            this[lastRow - 1][lastCol] -> lastRow--
            this[lastRow][lastCol - 1] -> lastCol--
            else -> {
                sb.append(string[lastRow-1])
                lastRow--
                lastCol--
            }
        }
    }
    return sb.reverse().toString()
}