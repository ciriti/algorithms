package com.ciriti.string

import com.ciriti.datastructure.printMatrix
import kotlin.math.min

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {
  "sitting".levenshteinDistance("kitten")
}

fun String.levenshteinDistance(other: String) {
  val matrix = Array(this.length + 1) { Array(other.length + 1) { 0 } }
  (0 until matrix.size).forEach { matrix[it][0] = it }
  (0 until matrix[0].size).forEach { matrix[0][it] = it }

  matrix.printMatrix()

  println("")
  println("--------------------------------")
  println("")

  (1 until matrix.size).forEach { i ->
    (1 until matrix[0].size).forEach { j ->
      val s1 = this[i - 1]
      val s2 = other[j - 1]
      matrix[i][j] = min(
          matrix[i - 1][j] + 1,  // →  deletion
          matrix[i][j - 1] + 1, //  ↓ insertion
          matrix[i - 1][j - 1] + substitutionCost(s1, s2) //  ↘  substitution
      )
    }
  }
  matrix.printMatrix()
}

val substitutionCost = fun(
  d1: Char,
  d2: Char
) = when (d1) {
  d2 -> 0
  else -> 1
}

fun min(
  d1: Int,
  d2: Int,
  d3: Int
) = min(d1, min(d2, d3))