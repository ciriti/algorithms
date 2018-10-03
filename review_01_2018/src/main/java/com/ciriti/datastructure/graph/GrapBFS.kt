package com.ciriti.datastructure.graph

/**
 * Created by ciriti
 */

object CH {
  operator fun get(vararg a: String) = listOf(*a)
}

fun main(args: Array<String>) {
  println(CH["ci", "ao"])
}