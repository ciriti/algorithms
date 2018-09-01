package com.ciriti.datastructure.dynamic

import kotlin.math.max

/**
 * Created by ciriti
 *
 * Link : https://github.com/raywenderlich/swift-algorithm-club/tree/master/Longest%20Common%20Subsequence
 *
 */

fun main(args : Array<String>){
    val array = arrayOf(intArrayOf(1, 2),
            intArrayOf(3, 4),
            intArrayOf(5, 6))
    println("ABCBX".longestCommonSubsequence("ABDCAB"))
    println("Hello World".longestCommonSubsequence("Bonjour le monde"))

}

fun String.longestCommonSubsequence(other : String) : String{
    val matrix = lcsLength(this, other)
    return backtrack(this, other, matrix)
}

fun lcsLength(s1 : String, s2 : String) : Array<Array<Int>>{

    val matrix = Array(s1.length + 1){ Array(s2.length + 1){ 0 } }

    for(i1 in 0 .. (s1.length -1)){
        for(i2 in 0..(s2.length - 1)){
            matrix[i1 + 1][i2 + 1] = when(s1[i1] == s2[i2]){
                true -> { matrix[i1][i2] + 1}
                else -> max(matrix[i1 + 1][i2], matrix[i1][i2 + 1])
            }
        }
    }

    //matrix.printMatrix()

    return matrix

}

fun<T> backtrack(s1 : String, s2 : String, matrix : Array<Array<T>>) : String{

    val sb = StringBuffer()
    var i1 = s1.length
    var i2 = s2.length

    while(i1 >= 1 && i2 >= 1){

        when(matrix[i1][i2]){
            matrix[i1][i2 - 1] -> i2 -= 1
            matrix[i1 - 1][i2] -> i1 -= 1
            else -> {
                i2 -= 1
                i1 -= 1
                sb.append(s1[i1])
            }
        }

    }

    return sb.reverse().toString()
}

/**
 * Extension to print the matrix
 */
fun <T> Array<Array<T>>.printMatrix(){
    this.forEach { it1 ->
        print(" ${it1.toList()}")
        println()
    }
}




