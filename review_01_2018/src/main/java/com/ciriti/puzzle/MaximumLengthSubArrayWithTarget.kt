package com.ciriti.puzzle

/**
 * Created by Carmelo Iriti
 */

/**
 * LINK - https://www.geeksforgeeks.org/longest-sub-array-sum-k/
 */

fun main(args: Array<String>) {
  val array = arrayOf(10, 5, 2, 7, 1, 9)
  val k = 15 // output {5, 2, 7, 1}
  maxSubArrTarget(array, k).toList().printThisPrivate()
}

private fun maxSubArrTarget(
  arr: Array<Int>,
  target: Int
): Array<Int> {

  val map = mutableMapOf(arr[0] to 0)
  var diff = 0
  var subArray = arrayOf<Int>()

  val sumArray = Array(arr.size) { 0 }.apply { this[0] = arr[0] }
  (1 until arr.size).forEach {
    sumArray[it] = arr[it] + sumArray[it - 1]
    map[arr[it] + sumArray[it - 1]] = it
  }

  sumArray.indices.forEach {
    map[sumArray[it] - target].runIfNotNull{
      diff = Math.max(it - map[sumArray[it] - target]!!, diff)
      subArray = arr.copyOfRange(map[sumArray[it] - target]!! + 1, it + 1)
    }
  }

  return subArray

}

private fun <T> T.runIfNull(func: () -> Unit) = this ?: func.invoke()
private fun <T> T.runIfNotNull(func: () -> Unit) = this?.let { func.invoke() }
private fun <T> T.printThisPrivate() = println(this)


