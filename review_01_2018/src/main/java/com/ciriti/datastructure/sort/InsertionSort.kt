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

}

/**
 * inline functions -> https://kotlinlang.org/docs/reference/inline-functions.html
 */
fun <T : Comparable<T>> Array<T>.insertionSort(){
    (0 until size).forEach { firstIndex ->
        ( firstIndex downTo  1).forEach{
            when{
                this[it - 1] > this[it] -> this.swap(it - 1, it)
            }
        }
    }
}
