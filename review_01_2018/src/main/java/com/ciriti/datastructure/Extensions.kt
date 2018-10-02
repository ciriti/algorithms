package com.ciriti.datastructure

/**
 * Created by Carmelo Iriti
 */

/**
 * Extension to print the matrix
 */
fun <T> Array<Array<T>>.printMatrix(){
    this.forEach { it1 ->
        print(" ${it1.toList()}")
        println()
    }
}

/**
 * Just for exercise, this function already exists
 */
fun <T, K> Array<T>.myZip(array : Array<K>) : ArrayList<Pair<T, K>>{
    val resSize = kotlin.math.min(size, array.size)
    val res = ArrayList<Pair<T, K>>(resSize)
    for(i in 0 until resSize){
        res.add(Pair(this[i], array[i]))
    }
    return res
}

/**
 * Swap two elements in the array
 */
fun <T : Comparable<T>> Array<T>.swap(i : Int, j : Int){
    val copy = this[i]
    this[i] = this[j]
    this[j] = copy
}

/**
 * Just for exercise, this function already exists
 */
fun <T> Array<T>.myPartition(func : (T) -> Boolean) : Pair<ArrayList<T>, ArrayList<T>>{

    val list1 = ArrayList<T>()
    val list2 = ArrayList<T>()

    forEach {
        when(func(it)){
            true -> list1.add(it)
            else -> list2.add(it)
        }
    }

    return Pair(list1, list2)
}

/**
 * Just for exercise, this function already exists
 */
fun <T> List<T>.myPartition(func : (T) -> Boolean) : Pair<List<T>, List<T>>{

    val list1 = ArrayList<T>()
    val list2 = ArrayList<T>()

    forEach {
        when(func(it)){
            true -> list1.add(it)
            else -> list2.add(it)
        }
    }

    return Pair(list1, list2)
}