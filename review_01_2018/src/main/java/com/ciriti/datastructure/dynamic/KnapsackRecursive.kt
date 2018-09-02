package com.ciriti.datastructure.dynamic

/**
 * Created by ciriti
 */
fun main(args : Array<String>){

    val capacity = 10
    val goldBars = arrayOf(1, 4, 8)

    val res = knapsackRec(capacity, goldBars, mutableMapOf())

    println(res)

}

fun knapsackRec(cap : Int, arr : Array<Int>, map : MutableMap<Int, Int>) : Int{

    if(map.containsKey(cap)) return map[cap]!!

    map[cap] = 0


    (1..arr.size).forEach{
        if(arr[it - 1] <= cap){
            val value = knapsackRec(cap - arr[it - 1], arr, map) + it - 1
            if(value > map[cap]?:0){
                map[cap] = value
            }
        }
    }

    return map[cap] ?: 0
}

