package com.ciriti.datastructure.array

/**
 * Created by ciriti
 */
fun main(args : Array<String>){

    val array = arrayOf(-2,1,-3,4,-1,2,1,-5,4)
    val res = array.maxConsecutiveSubsequence(0) { a, b -> a + b }
    res.forEach { print(" $it") }

}

inline fun <reified T : Comparable<T>> Array<T>.maxConsecutiveSubsequence(initVal : T, plus : (a : T, b : T) -> T) : Array<T>{

    val resList = Array(size){ mutableListOf<T>() }
    resList[0].add(this[0])
    val resVal = Array(size){ initVal }
    resVal[0] = this[0]

    (1 until size).forEach {
        when(this[it] < plus(this[it], resVal[it - 1])){
            true -> {
                resVal[it] = plus(this[it], resVal[it - 1])
                resList[it].clear()
                resList[it].add(this[it])
                resList[it].addAll(resList[it-1])
            }
            else -> {
                resVal[it] = this[it]
                resList[it].clear()
                resList[it].add(this[it])
            }
        }
    }

    val max = resVal.max()
    val index = resVal.indexOf(max)

    return resList[index].toTypedArray()
}