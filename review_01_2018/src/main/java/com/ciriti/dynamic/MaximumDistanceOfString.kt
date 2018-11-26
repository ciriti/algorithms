package com.ciriti.datastructure.dynamic

/**
 * Created by Carmelo Iriti
 */
fun main(args : Array<String>){
    println(mcs("short", "ports"))
//    println(mcs("editing", "distance"))
}

//fun main(args: Array<String>) {
//    val rows = 2
//    val columns = 3
//    val firstMatrix = arrayOf(intArrayOf(2, 3, 4), intArrayOf(5, 2, 3))
//    val secondMatrix = arrayOf(intArrayOf(-4, 5, 3), intArrayOf(5, 6, 3))
//
//    // Adding Two matrices
//    val sum = Array(rows) { IntArray(columns) }
//    for (i in 0..rows - 1) {
//        for (j in 0..columns - 1) {
//            sum[i][j] = firstMatrix[i][j] + secondMatrix[i][j]
//        }
//    }
//
//    // Displaying the result
//    println("Sum of two matrices is: ")
//    for (row in sum) {
//        for (col in row) {
//            print("$col    ")
//        }
//        println()
//    }
//}

fun mcs(s1 : String, s2 : String) : String{

    val sb = StringBuilder()
    val matrix : MutableList<MutableList<Int>> = MutableList(s1.length){ MutableList(s2.length) { 0 } }
    var flag = true

    for (i in 0..(s1.length - 1)) {
        for (j in 0 .. (s2.length-1)) {
            if(s1[i] == s2[j]){
                matrix[i][j] = 1
                if(flag)
                    sb.append(s1[i])
                flag = false
            }
            print(" ${matrix[i][j]}")
        }
        print("\n")
        flag = true
    }

    return sb.toString()

}