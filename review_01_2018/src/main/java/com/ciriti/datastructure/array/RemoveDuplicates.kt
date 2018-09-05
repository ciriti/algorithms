package com.ciriti.datastructure.array

/**
 * Created by ciriti
 */
fun main(args : Array<String>){

    val s = "abbcdeefghhiaabbcdeefghhi"
    println(s.removeSequenceOfDuplicate())
    println(s.removeDuplicate())
}

fun String.removeSequenceOfDuplicate() : String {

    if(length <= 1) return this

    val res = StringBuffer()
    res.append(this[0])
    (1 until length).forEach {
        if(this[it] != this[it-1]) res.append(this[it])
    }

    return res.toString()
}

fun String.removeDuplicate() : String {

    if(length <= 1) return this
    val arr = Array(('z'-'a' + 1)) { 0 }

    val res = StringBuffer()
    (0 until length).forEach {

        if(arr[this[it].getIndex()] == 0){res.append(this[it])}
        arr[this[it].getIndex()]++
    }

    return res.toString()
}

fun Char.getIndex() : Int{
    return this - 'a'
}