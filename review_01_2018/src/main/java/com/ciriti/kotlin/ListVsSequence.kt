package com.ciriti.kotlin

import com.ciriti.printThis

/**
 * Created by Carmelo Iriti
 */
fun main(args : Array<String>){

  val s = "aabbccdeeffgg"

  /**
   * associateBy vs groupBy
   */
  s.associateBy { it1 -> s.indexOfFirst { it == it1 } } // Map[ key -> char ]
  s.groupBy { it1 -> s.indexOfFirst { it == it1 } }.printThis() // Map[kay -> List<Char>] List<Char>
  // is the list of all the same chars es. 0 -> [a,a]

  /**
   * the Sequence will process vertically the operation:
   * for each item it will apply the transformation/operator in cascade
   * (map - filter - map)
   */
  val resSequence = s.groupBy { it1 -> s.indexOfFirst { it == it1 } }
      .asSequence()
      .map {
        println("###### $it #######")
        it
      }
      .filter { it.value.size == 1 }
      .map { it.key }
      .first()
      .printThis()

  /**
   * Non sequence DS will apply each transformation/operator through the
   * entire DS
   */
  val resList = s.groupBy { it1 -> s.indexOfFirst { it == it1 } }
      .map {
        println("****** $it ******")
        it
      }
      .filter { it.value.size == 1 }
      .map { it.key }
      .first()
      .printThis()
}