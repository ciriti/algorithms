package com.ciriti.kotlin

/**
 * Created by Carmelo Iriti
 */
fun main() {
  greet0
  greet1
  greet2

}

fun greet() = println("Hello")
fun greet1() = { println("Hello") }
fun greet2() = fun() { println("Hello") }

val greet0 = println("Hello")
val greet1 = { println("Hello") }
val greet2 = fun() { println("Hello") }

/**
 * Lambda expression
 */
val greet_l: () -> Unit = { println("Hello") }
val square_l: (Int) -> Int = { x -> x * x }
val producePrinter_l: () -> () -> Unit = { { println("I am printing") } }

/**
 * Anonymus function is an alternative way to define a function. Let’s use it to fill variables:
 */
val greet: () -> Unit = fun() { println("Hello") }
val square: (Int) -> Int = fun(x) = x * x
val producePrinter: () -> () -> Unit = fun() = fun() { println("I am printing") }