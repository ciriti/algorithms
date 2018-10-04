package com.ciriti.tree

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {
  val trie = Trie()
  trie.insert("carmelo")
  trie.insert("caramella")
  println(trie)
}

class Trie {
  private data class Node(
    val value: Char,
    val children: MutableMap<Char, Node> = mutableMapOf()
  )

  private val head = Node('-')

  fun insert(text: String) {
    var node = head
    text.forEach {
      node.children[it] ?: node.children.put(it, Node(it))
      node = node.children[it]!!
    }
  }

  fun searchAllWordsByPrefix(prefix: String): List<String> {

    val res = mutableListOf<String>()



    return emptyList()
  }

  private fun Node.dfs(
    index: Int,
    text: String,
    list: MutableList<String>
  ) {
  }

}