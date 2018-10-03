package com.ciriti.string

import com.ciriti.datastructure.printMatrix
import java.util.ArrayDeque
import java.util.Deque
import kotlin.math.max

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {
  println("sittin".longestCommonConsecutiveSubsequence("kitten"))
}

fun String.longestCommonConsecutiveSubsequence(other: String): String {
  val matrix = lcsLength(this, other)
  return backtrackConsecutive(this, other, matrix)
}

fun lcsLength(
  s1: String,
  s2: String
): Array<Array<Int>> {

  val matrix = Array(s1.length + 1) { Array(s2.length + 1) { 0 } }

  for (i1 in 0..(s1.length - 1)) {
    for (i2 in 0..(s2.length - 1)) {
      matrix[i1 + 1][i2 + 1] = when (s1[i1] == s2[i2]) {
        true -> {
          matrix[i1][i2] + 1
        }
        else -> max(matrix[i1 + 1][i2], matrix[i1][i2 + 1])
      }
    }
  }
  return matrix
}

fun <T : Comparable<T>> backtrackConsecutive(
  s1: String,
  s2: String,
  matrix: Array<Array<T>>
): String {

  val stack: Deque<Char> = ArrayDeque<Char>()
  var i1 = s1.length
  var i2 = s2.length

  matrix.printMatrix()

  while (i1 > 1 && i2 > 1) {
    when {
      equals3( matrix[i1][i2 - 1], matrix[i1 - 1][i2], matrix[i1 - 1][i2 - 1]) &&
          matrix[i1][i2].hadIncrement(matrix[i1 - 1][i2 - 1]) -> {
        stack.push(s1[i1 - 1])
        i2 -= 1
        i1 -= 1
      }
      equals3(matrix[i1][i2 - 1], matrix[i1 - 1][i2], matrix[i1 - 1][i2 - 1]) &&
          !matrix[i1][i2].hadIncrement(matrix[i1 - 1][i2 - 1]) -> {
        stack.pop()
        i2 -= 1
        i1 -= 1
      }
      matrix[i1][i2] == matrix[i1][i2 - 1] -> i2 -= 1
      matrix[i1][i2] == matrix[i1 - 1][i2] -> i1 -= 1
    }

  }
  return stack.toString()
}

fun <T> equals3(
  n1: T,
  n2: T,
  n3: T
) = (n1 == n2 && n2 == n3)

fun <T : Comparable<T>> T.hadIncrement(other: T) = this.compareTo(other) > 0
