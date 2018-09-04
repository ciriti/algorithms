package com.ciriti.datastructure.dynamic

import ciriti.review_01_2018.R

/**
 * Created by ciriti
 */

/**
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence
 * of a given sequence such that all elements of the subsequence are sorted in increasing order.
 * For example, the length of LIS for :
 *
 * {10, 22, 9, 33, 21, 50, 41, 60, 80}
 *
 * is 6 and LIS is
 *
 * {10, 22, 33, 50, 60, 80}.
 *
 * Link - https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 *
 */

fun main(args : Array<String>){
    val array = arrayOf(10, 22, 9, 33, 21, 50, 41, 60, 80)
    val res = lis(array)
    println(res)
}

inline fun <reified T : Comparable<T>> lis(array: Array<T>): List<T> {

    val resArray = List(array.size){ mutableListOf(array[it]) }

    (1 until array.size).forEach { index ->
            when{
                array[index] > array[index -1] -> {
                    resArray[index].addAll(resArray[index-1])
                }
                else -> {
                    resArray[index].clear()
                    resArray[index].addAll(resArray[index-1])
                }
            }
    }

    return resArray.last()
}

fun <T, R : Comparable<R>> Array<T>.myMaxBy(selector : (t : T) -> R) : T?{
    val iterator = this.iterator()
    if(iterator.hasNext()) return null
    var maxElement = iterator.next()
    var maxVal = selector(maxElement)
    while(iterator.hasNext()){
        val tmpElem = iterator.next()
        val tmpVal = selector(tmpElem)
        if(tmpVal > maxVal){
            maxVal = tmpVal
            maxElement = tmpElem
        }
    }
    return maxElement
}
