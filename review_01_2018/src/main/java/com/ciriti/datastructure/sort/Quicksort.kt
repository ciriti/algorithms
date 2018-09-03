package com.ciriti.datastructure.sort

import com.ciriti.datastructure.myPartition

/**
 * Created by ciriti
 */
fun main(args : Array<String>){

    val arr = listOf(2,1)
    println(arr.quickSort())

}

fun <T : Comparable<T>> List<T>.quickSort() : List<T>{
    if(size <= 1) return this
    val pivot = this[0]
    val (left, right) = this.drop(1).myPartition { it <= pivot }
    return left.quickSort() + pivot + right.quickSort()
}

fun <T : Comparable<T>> List<T>.quickSort(compare : (t1 : T, t2 : T) -> Int) : List<T>{
    if(size <= 1) return this
    val pivot = this[0]
    val (left, right) = this.drop(1).myPartition { compare(it, pivot) == -1 }
    return left.quickSort() + pivot + right.quickSort()
}

