package com.ciriti.datastructure.graph

import com.ciriti.datastructure.Stack
import java.util.LinkedList
import java.util.Queue

/**
 * Created by ciriti
 */

data class Node<T>(
  val value: T,
  val args: List<Node<T>> = emptyList()
) {
  override fun hashCode(): Int = value?.hashCode() ?: 0
  override fun equals(other : Any?) : Boolean = value?.equals(other)?:false
}

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

fun <T> Node<T>.dfs(): List<T> {
  val list = mutableListOf<T>()
  val stack = Stack<Node<T>>()
  stack.push(this)
  while (stack.isNotEmpty()) {
    val current: Node<T> = stack.pop()!!
    list.add(current.value)
    current.args.forEach { stack.push(it) }
  }
  return list
}

fun <T> Node<T>.bfs(): List<T> {
  val res = mutableListOf<T>()
  val queue: Queue<Node<T>> = LinkedList<Node<T>>()
  queue.add(this)
  queue.forEach {
    while (queue.isNotEmpty()) {
      val current = queue.poll()
      res.add(current.value)
      current.args.forEach { queue.add(it) }
    }
  }
  return res

}