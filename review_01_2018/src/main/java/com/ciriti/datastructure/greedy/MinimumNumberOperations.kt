package com.ciriti.datastructure.greedy

import java.util.*

/**
 * Created by ciriti
 *
 * Dynamic programming week 5 primitive calculator
 */
fun main(args : Array<String>){
    println(greedyMinNumOperation(1))
    println(greedyMinNumOperation(7))
    println(greedyMinNumOperation(96234))
    println(optimal_sequence(96234))
}

fun greedyMinNumOperation(input : Int) : Pair<Int, MutableList<Int>>{

    var operations = 0
    var currentNumber = input
    val list = mutableListOf<Int>()

    while(currentNumber > 0){
        list.add(currentNumber)
        currentNumber = when{
            currentNumber % 3 == 0 -> currentNumber / 3
            currentNumber % 2 == 0 -> currentNumber / 2
            else -> currentNumber - 1
        }.apply { operations++ }
    }

    return Pair(operations, list.apply { reverse() })
}

fun optimal_sequence(n: Int): Pair<Int, MutableList<Int>> {
    var n = n
    val sequence = ArrayList<Int>()
    while (n >= 1) {
        sequence.add(n)
        if (n % 3 == 0) {
            n /= 3
        } else if (n % 2 == 0) {
            n /= 2
        } else {
            n -= 1
        }
    }
    sequence.reverse()
    return Pair(sequence.size, sequence)
}