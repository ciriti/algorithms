package com.ciriti.datastructure.xsum

/**
 * Created by ciriti
 */

/**
 *
 * LINK - https://leetcode.com/problems/3sum/
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note: The solution set must not contain duplicate triplets.
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4],

 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 */

fun main(args : Array<String>){

    val a = arrayOf(-1, 0, 1, 2, -1, -4)
}

fun <T : Comparable<T>> Array<T>.threeSum(target : T, sum : (t1 : T, t2 : T) -> T) : Array<T>{

    if(size <= 3) return this

    val map = mutableMapOf<T, Pair<T,T>>()

    forEach {
        map[sum(target,it)] = Pair(target,it)
    }



    return this
}