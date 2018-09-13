package com.ciriti.datastructure

import io.reactivex.Observable

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {

//    println(listOf(1, 1, 1, 1, 1, 1).mySum())
//    println(listOf(1, 1, 1, 1, 1, 1).myProduct())
    println(listOf(1, 2, 3, 4, 5, 6).map { if(it % 2  ==  0) {
        listOf(it * 2, 6)
    }else

        listOf(it * 2) })
    println(listOf(1, 2, 3, 4, 5, 6).flatMap {

        if(it % 2  ==  0) {
            listOf(it * 2, 6)
        }else
            listOf(it * 2)
    })


}

fun <T> List<T>.mySum(sum: (t1: T, t2: T) -> T): T = this.subList(1, lastIndex).fold(this.first()) { acc, i -> sum(acc, i) }

fun List<Int>.mySum(): Int {
    val first = first()
    return subList(1, lastIndex).fold(first) { acc, i -> acc + i }
}

fun Iterable<Int>.myProduct(): Int {
    return fold(1) { acc, i -> acc * i }
}

fun <T, R> Iterable<T>.myMap(transform: (t: T) -> R): List<R> {
    return fold(listOf()) { acc, i -> acc + transform(i) }
}