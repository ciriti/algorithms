package com.ciriti.math

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {
    val array = arrayOf(1, 0, -1, 0, -2, 2)
    val target = 0
    println(array.sumOfThree(target))
}

fun Array<Int>.sumOfThree(target: Int): List<Triple<Int, Int, Int>> {

    val map: MutableMap<Int, MutableSet<Pair<Int, Int>>> = mutableMapOf()
    val results: MutableSet<Triple<Pair<Int, Int>, Pair<Int, Int>, Pair<Int, Int>>> = mutableSetOf()

    forEachIndexed { index, value ->
        map[(target - value)] = mutableSetOf(Pair(index, value))
    }

    forEachIndexed { index, value ->
        for (i in index + 1..lastIndex) {
            val sum = value + this[i]
            map.containsKey(sum).let {
                if (it) {
                    map[sum]!!.forEach {
                        results.add(
                                Triple(
                                        first = Pair(index, value),
                                        second = Pair(i, this[i]),
                                        third = Pair(it.first, it.second)
                                )
                        )
                    }

                }
            }
        }
    }

    return results.map { Triple(it.first.second, it.second.second, it.third.second) }

}