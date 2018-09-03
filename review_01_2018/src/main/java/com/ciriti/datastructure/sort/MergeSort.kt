package com.ciriti.datastructure.sort

/**
 * Created by ciriti
 */
fun main(args : Array<String>){

    val arr = listOf(9,8,7,6,5,4,3,2,1)
    println(arr.mergeSort())
}

fun <T : Comparable<T>> List<T>.mergeSort() : List<T> {

    if (size <= 1) return this

    val (_half1, _half2) = this.partitionInTwo()

    val half1 = _half1.mergeSort()
    val half2 = _half2.mergeSort()

    val list = mutableListOf<T>()

    var index1 = 0
    var index2 = 0

    while (index1 < half1.size || index2 < half2.size) {

        when {
            index1 < half1.size && index2 < half2.size -> {
                if(half1[index1] <= half2[index2]){
                    list.add(half1[index1])
                    index1++
                }else{
                    list.add(half2[index2])
                    index2++
                }
            }
            index1 < half1.size -> {
                list.add(half1[index1])
                index1++
            }
            index2 < half2.size -> {
                list.add(half2[index2])
                index2++
            }
        }

    }

    return list
}

inline fun <reified T : Comparable<T>> List<T>.mergeSort(comparator : (t : T) -> Int){

}

/**
 * Splits the original collection into pair of lists,
 * where *first* list contains elements from the index 0 to pIndex (excluded),
 * while *second* list contains elements from the index pIndex+1 to the end.
 */
fun<T> List<T>.partitionInTwo() : Pair<List<T>, List<T>>{

    if(size <= 1) return Pair(this, emptyList())

    val list1 = mutableListOf<T>()
    val list2 = mutableListOf<T>()

    val mid = size/2 -1

    forEachIndexed { index, t ->

        when{
            index <= mid -> list1.add(t)
            else -> list2.add(t)
        }

    }
    return Pair(list1, list2)
}