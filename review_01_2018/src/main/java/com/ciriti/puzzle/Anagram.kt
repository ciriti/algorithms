package com.ciriti.puzzle

import com.ciriti.printThis
import java.util.HashSet
import kotlin.system.measureTimeMillis

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {

  val s = "abcd"
  measureTimeMillis {
    val root = Tree("abc").root
    val res = mutableListOf<String>()
    dfs(node = root.listChildren[0], res = res)
    println(res)
  }.printThis()

  measureTimeMillis {
    recursiveAnagram("abcd")
  }.printThis()

}

fun dfs(
  node: CN,
  s: String = "",
  res: MutableList<String>
) {
  if (node.listChildren.isEmpty()) {
    res.add("$s${node.value}")
    return
  }
  node.listChildren.forEach {
    it.value
    "$s${node.value}"
    dfs(it, "$s${node.value}", res)
  }
}

class Tree(private val s: String) {

  val root = CN()

  init {
    s.forEachIndexed { index, value ->
      val st = "$value${s.substring(0, index)}${s.substring(index+1, s.length)}"
      root.listChildren.add(CN(st))
    }
    println()
  }

}

class CN(val s: String = "") {

  val value: Char = when (s.isNotEmpty()) {
    true -> s[0]
    else -> '-'
  }

  val listChildren: MutableList<CN> = mutableListOf()

  init {
    if(s.isNotEmpty()) {
      val s1 = s.removeRange(0, 1)
      for (index in 0..s1.lastIndex) {
        val st = "${s1.substring(0, index)}${s1.substring(index + 1, s1.length)}"
        if (st.isNotEmpty())
          listChildren.add(CN(st))
      }
    }

  }
}

private fun recursiveAnagram(text: String): Set<String> {

  val res = HashSet<String>()
  var c: Char
  var subString: String

  for (i in 0 until text.length) {
    // take one char
    c = text[i]
    // create a substring
    subString = text.substring(0, i) + text.substring(i + 1, text.length)

    for (j in 0 until subString.length) {
      res.add(subString.substring(0, j) + c + subString.substring(j, subString.length))
    }
    res.add(subString + c)
  }
  println(res)
  return res
}