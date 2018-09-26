package com.ciriti.math

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {
    val array = arrayOf(1, 0, -1, 0, -2, 2)
    val target = 0
    println(array.sumOfThree(target))
    println(array.toList().sumOfThree(0))
}

fun List<Int>.sumOfThree(target: Int): Set<List<Int>> {

    val resList = mutableSetOf<List<Pair<Int, Int>>>()
    val map = mutableMapOf<Int, Set<Pair<Int, Int>>>()
    forEachIndexed { index, it -> map[it - target] = mutableSetOf(Pair(index, it)) }
    forEachIndexed { index1, it1 ->
        for (index2 in index1 + 1..lastIndex) {
            val setFirstRound = map[it1 + this[index2]]
            setFirstRound?.forEach {
                resList.add(listOf(
                        Pair(it.first, it.second),
                        Pair(index1, it1),
                        Pair(index2, this[index2])
                ))
            }
        }
    }
    return resList
            .filter { it.size == 3 }
            .map {
                it.map { it.second }
            }
            .toSet()
}


fun Array<Int>.sumOfThree(target: Int): List<List<Int>> {

    val map: MutableMap<Int, MutableSet<Pair<Int, Int>>> = mutableMapOf()
    val results: MutableSet<List<Int>> = mutableSetOf()
    forEachIndexed { index, value -> map[(target - value)] = mutableSetOf(Pair(index, value)) }
    forEachIndexed { index, value ->
        for (i in index + 1..lastIndex) {
            val sum = value + this[i]
            map.containsKey(sum).let {
                if (it) {
                    map[sum]!!.forEach {
                        results.add(listOf(value, this[i], it.second))
                    }
                }
            }
        }
    }
    return results.toList()

}

