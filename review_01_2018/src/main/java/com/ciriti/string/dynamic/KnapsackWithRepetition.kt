package com.ciriti.datastructure.dynamic

import com.ciriti.datastructure.myZip
import kotlin.math.max

/**
 * Created by ciriti
 */
fun main(args : Array<String>){

    val capacity = 5
    val weights = arrayOf( 6,  3,  4, 2)
    val values  = arrayOf(30, 14, 16, 9)

    val listOfPairs = weights.myZip( values )

    println(knapsack(capacity, listOfPairs))

}

fun knapsack(capacity : Int, list : ArrayList<Pair<Int, Int>>) : Int{

    val res = Array(capacity + 1){ 0 }

    for(i in 1..capacity){
        list.forEach { element ->
            if(i >= element.first){
                res[i] = max(res[i], element.second + res[i - element.first])
            }
        }
    }

    return res[capacity]
}

/**



    0  1   2    3       4       5
    0  0   9    14      18      23



 */