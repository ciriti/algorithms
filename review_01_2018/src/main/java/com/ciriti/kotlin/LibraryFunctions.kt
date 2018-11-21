package com.ciriti.kotlin

import com.ciriti.printThis

/**
 * Created by Carmelo Iriti
 */
fun main(args: Array<String>) {

  /**
   * The 2 expressions are the same
   */
  listOf(1, 2, 3, 4, 5).filter { it < 3 }
      .size.printThis()
  listOf(1, 2, 3, 4, 5).count { it < 3 }
      .printThis()

  /**
   * The 2 expressions are the same
   */
  listOf(1, 2, 3, 4, 5).sortedBy { it }
      .reversed()
  listOf(1, 2, 3, 4, 5).sortedByDescending { it }

  /**
   * The 2 expressions are the same
   */
  listOf(true to "carmelo", false to "iriti")
      .map { person ->
        person.takeIf { it.first }?.second
      }
      .filterNotNull()
      .printThis()

  listOf(true to "carmelo", false to "iriti")
      .mapNotNull { person ->
        person.takeIf { it.first }?.second }

  /**
   * map
   */
  val map = mutableMapOf<Int, MutableList<Person>>()
  if(10 !in map){
    map[10] = mutableListOf()
  }
  /** The 2 expressions are the same */
  map.getValue(10) += Person("carmelo", 10)
  val group = map.getOrPut(11){ mutableListOf(Person("",1)) }



}