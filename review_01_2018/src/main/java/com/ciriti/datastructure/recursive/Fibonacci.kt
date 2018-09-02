package com.ciriti.datastructure.recursive

import kotlin.system.measureTimeMillis

/**
 * Created by ciriti
 */

fun main(args : Array<String>){
    val time = measureTimeMillis { println(fib(4)) }
    println(time)
    val time1 = measureTimeMillis { println(fibOptimized(6000, mutableMapOf(0 to 0, 1 to 1, 2 to 1))) }
    println(time1)
}

/**
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
 */
fun fib(num : Int) : Int{
    return when(num){
        0 -> 0
        1 -> 1
        else -> fib(num-1) + fib(num-2)
    }
}


fun fibOptimized(num : Int, map : MutableMap<Int, Int>) : Int{

    if(map.containsKey(num)) return map[num]!!

    return when(num){
        0 -> 0
        1 -> 1
        else ->{
            val v1 = fibOptimized(num-1, map)
            map[num-1] = v1
            val v2 = fibOptimized(num-2, map)
            map[num-2] = v2
            v1 + v2
        }
    }



}

