package com.ciriti.datastructure

/**
 * Created by ciriti
 */

/**
 * https://stackoverflow.com/questions/9769554/how-to-convert-number-into-k-thousands-m-million-and-b-billion-suffix-in-jsp
 * Converts the number to K, M suffix
 * Ex: 5500 will be displayed as 5.5k
 */

fun main(args: Array<String>) {
  println(convertToSuffix(5500))
  println(convertToSuffix2(5500))
  println(convertToSuffix(5000))
  println(convertToSuffix2(5000))
}

fun convertToSuffix(count: Long): String {
  if (count < 1000) return "" + count
  val exp = (Math.log(count.toDouble()) / Math.log(1000.0)).toInt()
  return String.format(
      "%.1f%c",
      count / Math.pow(1000.0, exp.toDouble()),
      "kmgtpe"[exp - 1]
  )
}

fun convertToSuffix2(count: Long): String {
  if (count < 1000) return count.toString()
  val units = "kmgtp"
  val number = count.toString()
  return "${number[0]}.${number[1]}${units[(number.lastIndex / 3) - 1]}"
}

