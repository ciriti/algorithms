package com.ciriti.datastructure.graph

/**
 * Created by ciriti
 */

data class Node<T>(
  val value: T,
  val args: List<Node<T>> = emptyList()
)

object N {
  operator fun get(
    b: Int,
    vararg a: Node<Int>
  ) = Node(b, listOf(*a))
}

object C {
  operator fun get(
    b: Char,
    vararg a: Node<Char>
  ) = Node(b, listOf(*a))
}

fun <T> Node<T>.print() = println("[ val: $value, neighbour size: ${args.size} ]")

fun <T> Node<T>.printChild() {
  print(" $value ")
  if (args.isNotEmpty()) args.forEach {
    print(", ")
    it.printChild()
  }
}


fun main(args: Array<String>) {
  val n =
    N[1,
        N[2,
            N[22],
            N[23],
            N[24],
            N[25]
        ],
        N[3],
        N[4],
        N[5]]

  n.printChild()

}