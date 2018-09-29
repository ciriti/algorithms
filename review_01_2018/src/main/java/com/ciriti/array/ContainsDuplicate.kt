package com.ciriti.array

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {
  println(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2).containsDuplicate2()) // res 3
  println(intArrayOf(1, 2, 3, 4, 5, 6, 7).containsDuplicate2()) // res 3
}

fun IntArray.containsDuplicate(): Boolean {
  fold(mutableMapOf<Int, Int>()){
    acc, value ->
    if(contains(value)) return true
    acc[value] = value
    acc
  }
  return false
}

fun IntArray.containsDuplicate2(): Boolean {
  this.sort()
  for(index in 1..lastIndex){
    if(this[index-1] == this[index])return true
  }
  return false
}