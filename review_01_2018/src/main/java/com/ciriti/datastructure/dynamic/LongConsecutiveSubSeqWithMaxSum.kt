package com.ciriti.datastructure.dynamic

import com.ciriti.datastructure.L

/**
 * Created by ciriti
 */
/**
 * Longest consecutive subsequence tha give the max sum
 * [-2, 2, 3, -1, 4, -1, -5] -> []
 *
 */
fun main(args : Array<String>){

    val list = L[-2, 2, 3, -1, 4, -1, -5]
    val list1 = L[L[-2], L[2, 3], L[-1, 4, -1, -5]]
    val array = arrayOf(-2, 2, 3, -1, 4, -1, -5)
    val res = list1
            .groupBy { it.size }
            .maxBy { it.value.size }
    println(res)
}

fun <T : Comparable<T>> List<T>.lcsMaxSum() : List<T>{

    val listOfResult = List(size){ mutableListOf<T>() }
    listOfResult[0].add(this[0])

    (1 until size).forEach {
        if( this[it] > this[it-1] ) {
            listOfResult[it] + this[it]
        }
        listOfResult[it] + listOfResult[it-1]
    }

    return emptyList()//listOfResult.groupBy { it.sumBy { it } }
}