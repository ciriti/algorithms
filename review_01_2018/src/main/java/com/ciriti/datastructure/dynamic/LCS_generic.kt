package com.ciriti.datastructure.dynamic

import com.ciriti.datastructure.printMatrix

/**
 * Created by ciriti
 */

fun main(args : Array<String>){
    val a1 = arrayOf(1,2,3,4,5,6)
    val a2 = arrayOf(1,6,3,8,5)

    println(a1.lcs(a2).toList())
}

inline fun <reified T> Array<T>.lcs(other : Array<T>) : Array<T> {
    val matrix = lcsBuildMatrix(this, other)
    return lcsBackTracking(this, other, matrix)
}

/**
 * build the matrix of common elements
 */
inline fun <reified T> lcsBuildMatrix(arr1 : Array<T>, arr2 : Array<T>) : Array<Array<Int>>{

    val matrix = Array(arr1.size +1 ){ Array(arr2.size + 1 ){ 0 } }

    for(i in 0..(arr1.size - 1)){
        for(j in 0..(arr2.size - 1)){
            matrix[i + 1][j + 1] = when(arr1[i] == arr2[j]){
                true -> matrix[i][j] + 1
                else -> maxOf(matrix[i][j + 1], matrix[i + 1][j])
            }
        }
    }

    return matrix
}

/**
 * Start from the last element and go back til the begin to reconstruct the sub sequence
 */
inline fun <reified T> lcsBackTracking(arr1 : Array<T>, arr2 : Array<T>, matrix : Array<Array<Int>>) : Array<T>{

    val list = mutableListOf<T>()

    var i = arr1.size
    var j = arr2.size

    while(i >= 1 &&  j>=1){
        when(matrix[i][j]){
            matrix[i - 1][j] -> i -= 1
            matrix[i][j - 1] -> j -= 1
            else -> {
                list.add(arr1[i - 1])
                i -= 1
                j -= 1

            }
        }
    }

    return list.toTypedArray().apply { reverse() }
}


