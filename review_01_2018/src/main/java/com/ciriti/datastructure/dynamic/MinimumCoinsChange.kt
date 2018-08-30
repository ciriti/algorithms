package com.ciriti.datastructure.dynamic

/**
 * Created by ciriti
 */

fun main(args : Array<String>){
    //DPChange(10, [1,3,4])
}

fun DPChange(money :Int, coins : Array<Int>){
    val mnc = IntArray(money)
    mnc[0] = 1
    mnc[money-1] = 1
    println(mnc[money-1])
}

