package com.ciriti.datastructure.dynamic

/**
 * Created by ciriti
 */

fun main(args : Array<String>){
    val a1 = arrayOf(1,2,3,4,5,6)
    val a2 = arrayOf(1,6,3,8,5)

    println(a1.lcs(a2).toList())
}


fun <T> Array<T>.lcs3() {

}
fun < T> Array<T>.build3DMatrix(arr1 : Array<T>, arr2 : Array<T>) : Array<Array<Array<Int>>>{

    val matrix3D = Array(this.size + 1){ Array(arr1.size + 1){ Array(arr2.size + 1){ 0 } } }


    return arrayOf()
}