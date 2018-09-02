package com.ciriti.datastructure.dynamic

import com.ciriti.datastructure.myZip
import kotlin.math.max

/**
 * Created by ciriti
 */
fun main(args : Array<String>){

    val capacity = 10
    val weights = arrayOf(6, 3, 4, 2)
    val values = arrayOf(30, 14, 16, 9)

    val listOfPairs = weights.myZip( values )
            .apply { sortByDescending { it.first } }

    println(knapsack(capacity, listOfPairs))

}

fun knapsack(capacity : Int, list : ArrayList<Pair<Int, Int>>) : Int{

    val res = Array(capacity + 1){ 0 }

    for(i in 1..capacity){
        list.forEach {
            if(i >= it.first){
                res[i] = max(res[i], res[i - it.first] + it.second)
            }
        }
    }

    return res[capacity]
}
