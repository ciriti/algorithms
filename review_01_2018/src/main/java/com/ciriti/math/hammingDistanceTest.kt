package com.ciriti.math

/**
 * Created by Carmelo Iriti
 */
fun main(args: Array<String>) {
  println(4.hammingDistance(2))
  println(4.myHammingDistance(2))
}

fun Int.hammingDistance(other: Int): Int {

  var xBin = this.toString(2)
  var yBin = other.toString(2)
  var hDiff = 0

  while (xBin.length < 8 || xBin.length < yBin.length) {
    xBin = "0$xBin"
  }

  while (yBin.length < 8 || yBin.length < xBin.length) {
    yBin = "0$yBin"
  }

  (0 until xBin.length).forEach {
    if (xBin[it] !== yBin[it]) {
      hDiff++
    }
  }
  return hDiff
}

fun Int.myHammingDistance(y: Int): Int {

  var sx = this.toString(2)
  var sy = y.toString(2)

  val maxL = kotlin.math.max(sx.length, sy.length)

  sx = "${"0".repeat(maxL-sx.length)}$sx"
  sy = "${"0".repeat(maxL-sy.length)}$sy"

  var count = 0
  (0 until maxL).forEach{
    if(sx[it] != sy[it]) count++
  }

  return count

}