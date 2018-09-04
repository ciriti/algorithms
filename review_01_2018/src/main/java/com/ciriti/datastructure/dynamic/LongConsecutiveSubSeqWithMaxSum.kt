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

/**
 * Explanation:
 *
 * Simple idea of the Kadane’s algorithm is to look for all positive contiguous
 * segments of the array (max_ending_here is used for this).
 * And keep track of maximum sum contiguous segment among all positive
 * segments (max_so_far is used for this). Each time we get a positive sum compare
 * it with max_so_far and update max_so_far if it is greater than max_so_far
 */
fun main(args : Array<String>){

    val list = L[-2, 2, 3, -1, 4, -1, -5]
    println(list.lcsMaxSum())
    val list1 = L[L[-2], L[2, 3], L[-1, 4, -1, -5]]
//    val array = arrayOf(-2, 2, 3, -1, 4, -1, -5)
//
//    val res = list1
//            .groupBy { it.size }
//            .maxBy { it.value.size }
//    println(res)
}

fun List<Int>.lcsMaxSum() : List<Int>{

    val listOfResult = List(size){ mutableListOf<Int>() }
    listOfResult[0].add(this[0])
    var maxSum = this[0]
    (1 until size).forEach first@{ i1 ->
        var sum = this[i1]
        listOfResult[i1].add(this[i1])
        (i1-1 downTo 0) .forEach{ i2 ->
            if(sum + this[i2]  > sum){
                sum += this[i2]
                listOfResult[i1].add(this[i2])
            }else { return@first }
        }

    }

    val list = listOfResult.map { it.sum() }
    var max = list[0]
    var indexMax = 0
    list.forEachIndexed { index, i ->
        if(max < i) {
            max = i
            indexMax = i
        }}

    return  listOfResult.map { it.sum() }
}