package com.ciriti.datastructure.graph

/**
 * Created by ciriti
 */
class Node<T>(
  val value: T,
  val args: () -> List<Node<T>> = emptyList<>()
)

object NB {
  operator fun <T> get(vararg a: T) = listOf(*a)
}

object N {
  operator fun <T> get(m: Int) = Node(m)
}

fun main(args: Array<String>) {

}