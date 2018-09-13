package com.ciriti.datastructure

import com.ciriti.printThis

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {

    listOf(1, 1, 1, 1, 1, 1).mySum().printThis()
    listOf(1, 1, 1, 1, 1, 1).myProduct().printThis()
    listOf(1, 1, 1, 1, 1, 1).myMap { it * 2 }.printThis()
    listOf(1, 1, 1, 1, 1, 1).myFlatMap { listOf(it * 2) }.printThis()
    listOf(1, 1, 1, 3, 1, 1).myFilter { it % 3 != 0 }.printThis()
    listOf(1, 1, 1, 3, 1, 1).myJoinTwoString().printThis()

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

fun <T, R> Iterable<T>.myFlatMap(transform: (t: T) -> List<R>): List<R> {
    return fold(listOf()) { acc, i -> acc + transform(i) }
}

fun <T> Iterable<T>.myFilter(filter: (t: T) -> Boolean): List<T> {
    return fold(listOf()) { acc, i -> if (filter(i)) acc + i else acc }
}

fun <T> Iterable<T>.myJoinTwoString(separator: String = " ,", transformer: (t: T) -> String = { "$it" }): String {
    return foldIndexed("") { index, acc, i -> acc + separator.let { if (index == 0) "" else it } + transformer(i) }
}