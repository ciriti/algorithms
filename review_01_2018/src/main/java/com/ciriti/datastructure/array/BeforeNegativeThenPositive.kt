package com.ciriti.datastructure.array

import com.ciriti.datastructure.sort.mergeSort
import com.ciriti.datastructure.sort.quickSort

/**
 * Created by ciriti
 */

fun main(args : Array<String>){

    val arr = listOf(1,2,3,-4,5,6,7,-8,9)

    val res = arr.mergeSort { t1, t2 ->
        when{
            t1 <= 0 && t2 <= 0 -> 0
            t1 > 0 && t2 > 0 -> 0
            t1 <= 0 -> -1
            else -> 1
        }
    }

    println(res)
    val res1 = arr.quickSort{ t1, t2 ->
        when{
            t1 < 0 && t2 < 0 -> 0
            t1 >= 0 && t2 >= 0 -> 0
            t1 < 0 -> -1
            else -> 1
        }
    }

    println("$res1 The result looks wrong but it is right because thi algorithm IS NOT STABLE!!!")
    println(arr)
    var res2 = arr.sortedWith(Comparator { t1, t2 ->
        when{
            t1 < 0 && t2 < 0 -> 0
            t1 >= 0 && t2 >= 0 -> 0
            t1 < 0 -> -1
            else -> 1
        }
    })
    println(res2)

}