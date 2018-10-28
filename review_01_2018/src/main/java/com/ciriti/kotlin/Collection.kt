package com.ciriti.kotlin

import com.ciriti.printThis

/**
 * Created by Carmelo Iriti
 */

fun main(args : Array<String>){

  val list = listOf(true, true, true, true, true, true)

  list.myAny { !it }.printThis("any") /** if at least a false element is present */
  list.myAll { it }.printThis("all")
  list.myNone { !it }.printThis("none")

}

private fun <T> Collection<T>.myAny(predicate : (T) -> Boolean) : Boolean{
  if(this.isEmpty()) return true
  for(element in this) { if(predicate(element)) return true }
  return false
}

private fun <T> Collection<T>.myAll(predicate : (T) -> Boolean) : Boolean{
  if(this.isEmpty()) return true
  for(element in this) { if(!predicate(element)) return false }
  return true
}

private fun <T> Collection<T>.myNone(predicate : (T) -> Boolean) : Boolean{
  if(this.isEmpty()) return true
  for(element in this){ if(predicate(element)) return false }
  return true
}