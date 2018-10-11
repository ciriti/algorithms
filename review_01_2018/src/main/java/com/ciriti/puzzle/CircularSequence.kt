package com.ciriti.puzzle

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {

    (0..20).forEach {
        print("${it % 3} ")
    }

    println()

    (0..20).forEach {
        print("${2 - (it % 3)} ")
    }

}