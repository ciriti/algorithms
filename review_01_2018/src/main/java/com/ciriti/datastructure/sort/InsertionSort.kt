package com.ciriti.datastructure.sort

import com.ciriti.datastructure.swap

/**
 * Created by ciriti
 */

/**
 * LINK - https://upload.wikimedia.org/wikipedia/commons/0/0f/Insertion-sort-example-300px.gif
 */

fun main(args : Array<String>){

    val arr = arrayOf(10, 68, 9, 55, 1, 2, 3)

    arr.apply { insertionSort() }.forEach { print(" $it") }

    println()
    val arr2 = arrayOf(10, 68, -9, 55, 1, -2, 3)

    arr2.insertionSort { t1, t2 ->
        when{
            t1 < 0 && t2 < 0 -> 0
            t1 >= 0 && t2 >= 0 -> 0
            t1 < 0 -> -1
            else -> 1
        }
    }
    arr2.forEach { print(" $it") }

}

/**
 * inline functions -> https://kotlinlang.org/docs/reference/inline-functions.html
 */
fun <T : Comparable<T>> Array<T>.insertionSort(compare : (t1 : T, t2 : T ) -> Int){
    (0 until size).forEach { firstIndex ->
        ( firstIndex downTo  1).forEach{
            when{
                compare(this[it - 1], this[it]) > 0 -> this.swap(it - 1, it)
            }
        }
    }
}
fun <T : Comparable<T>> Array<T>.insertionSort(){
    this.insertionSort { t1, t2 -> t1.compareTo(t2) }
}
//fun <T : Comparable<T>> Array<T>.insertionSort(){
//    (0 until size).forEach { firstIndex ->
//        ( firstIndex downTo  1).forEach{
//            when{
//                this[it - 1] > this[it] -> this.swap(it - 1, it)
//            }
//        }
//    }
//}
