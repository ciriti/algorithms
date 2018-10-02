package com.ciriti.datastructure

/**
 * Created by Carmelo Iriti
 */
class Stack<T> : Collection<T> {

  private var head: Node<T>? = null

  override var size: Int = 0
    private set

  override fun contains(element: T): Boolean {
    for (obj in this) {
      if (obj == element) return true
    }
    return false
  }

  override fun containsAll(elements: Collection<T>): Boolean {
    return true
  }

  override fun isEmpty(): Boolean {
    return size == 0
  }

  override fun iterator(): Iterator<T> {
    return object : Iterator<T> {

      var node: Node<T>? = head

      override fun hasNext(): Boolean = node != null

      override fun next(): T {
        if (!hasNext()) throw NoSuchElementException()
        val current = node!!
        node = current.next
        return current.value
      }
    }
  }

  fun peek(): T? {
    return head?.value
  }

  fun push(elem: T) {
    size++
    val node = Node(elem)
    node.next = head
    head = node
  }

  fun pop(): T? {
    if (size == 0) return null
    size--
    val res = head!!.value
    val newHead = head!!.next
    head = newHead
    return res
  }

  private class Node<T>(
    val value: T,
    var next: Node<T>? = null
  )
}