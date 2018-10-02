package com.ciriti.datastructure

/**
 * Created by Carmelo Iriti
 */
class Stack<T> : Collection<T> {

    private var head: Node<T>? = null

    override var size: Int = 0
        private set

    override fun contains(element: T): Boolean {
        return true
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return true
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun iterator(): Iterator<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun peek() : T?{
        return head?.value
    }

    fun push(elem: T) {
        size++
        val node = Node(elem)
        node.next = head
        head = node
    }

    fun pop(): T? {
        if(size == 0) return null
        size--
        val res = head!!.value
        head!!.next = head!!.next?.next
        head = null
        return res
    }

    private class Node<T>(val value: T, var next: Node<T>? = null)
}