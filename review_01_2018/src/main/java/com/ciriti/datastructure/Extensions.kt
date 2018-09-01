package com.ciriti.datastructure

/**
 * Created by Carmelo Iriti
 */

object L {
    operator fun <T> get (vararg a : T) = listOf(*a)
}

/**
 * Extension to print the matrix
 */
fun <T> Array<Array<T>>.printMatrix(){
    this.forEach { it1 ->
        print(" ${it1.toList()}")
        println()
    }
}