package com.ciriti.datastructure.dynamic

import kotlin.math.max

/**
 * Created by ciriti
 */
fun main(args : Array<String>){

    val capacity = 10
    val weights = arrayOf(6, 3, 4, 2)
    val values = arrayOf(30, 14, 16, 9)

    val list : List<Pair<Int, Int>> = weights.zip(values)

    print(knapsackWithoutRepetitions(capacity, list))

}

fun knapsackWithoutRepetitions(capacity: Int, list: List<Pair<Int, Int>>) : Int {

    val matrix = Array(list.size + 1){ Array(capacity + 1) { 0 } }

    (1..list.size).forEach{ elem ->
        (1..capacity).forEach{ cap ->
            when{
                cap >= list[elem - 1].first -> matrix[elem][cap] = max( matrix[elem-1][cap], list[elem - 1].second + matrix[elem - 1][ cap - list[elem - 1].first] )
                else -> matrix[elem][cap] = matrix[elem - 1][cap]
            }
        }
    }

    return matrix.last().last()

}

/**


            0   1   2   3   4   5   6   7   8   9
            0   0   0   0   0   0   0   0   0   0
        1   0   0   0   0   0   0   30  30  30  30      6 -> 30
        2   0   0   0   14  14  14  30  30  30  44      3 -> 14
        3   0   0   0   14  16  16  30  30  30  44                      4 -> 16
        4   0                                           2 -> 9


        30 +

 */