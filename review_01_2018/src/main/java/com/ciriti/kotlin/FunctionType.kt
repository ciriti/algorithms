package com.ciriti.kotlin

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {

  println(2.square())
  println(squareFun1(2))
  println(squareFun2(2))
  println(squareFun3(2))

  println(Int::square)

}

/** extension function */
fun Int.square() = this * this
/**
 * function reference ---> Int::square
 * if we need to associate this function (Int.square()) with the property then we can use a
 * function reference as follows
 */
val squareFun1: Int.()->Int = Int::square
/**
 *  Instead of using function reference [Int::square]
 *  we can define function using one of the function literals with receiver { ... }.
 *  This is how we can define it using lambda expression with receiver:
 */
val squareFun2: Int.()->Int = { this * this }
/**
 * This is how we can define it using anonymous function with receiver --> fun Int.()
 */
val squareFun3: Int.()->Int = fun Int.() = this * this
/**
 * This is how we can define it using anonymous function with receiver --> fun Int.()
 * but with type inferred
 */
val squareFun4 = fun Int.() = this * this