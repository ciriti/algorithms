package com.ciriti.datastructure.graph

import com.ciriti.datastructure.Stack

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

fun<T> Node<T>.dfs() : List<T>{
  val list = mutableListOf<T>()
  val stack = Stack<Node<T>>()
  stack.push(this)
  while(!stack.isEmpty()){
    val current : Node<T> = stack.pop()!!
    list.add(current.value)
    current.args.forEach { stack.push(it) }
  }
  return list
}


fun main(args: Array<String>) {

    val n =
      C['a',
            C['b',
                C['d'], C['f'], C['g']
            ],
            C['c',
                C['x'], C['h', C['i', C['l'] ] ], C['y']
            ]
      ]

  println(n.dfs())

}