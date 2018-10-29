package com.ciriti.kotlin

/**
 * Created by Carmelo Iriti
 */
fun main(args: Array<String>) {

  /**
   * EXTENSION:
   *
   * Calls the specified function [block] with `this` value as its ARGUMENT and returns `this` value.
   *
   * public inline fun <T> T.also(block: (T) -> Unit): T
   *
   * usage: side effects in chains
   */
  val a: A = A().also { println("side effect 1") }.also { println("side effect 2") }

  /**
   * EXTENSION:
   *
   * Calls the specified function [block] with `this` value as its RECEIVER and returns `this` value.
   *
   * public inline fun <T> T.apply(block: T.() -> Unit): T
   *
   * usage: configure object
   */
  val a1: A = A().apply { name = "Carmelo" }

  /**
   * EXTENSION:
   *
   * Calls the specified function [block] with `this` value as its receiver and returns its result.
   *
   * public inline fun <T, R> T.run(block: T.() -> R): R
   *
   * usage: same as let except allows receiver access
   */
  val a2: A = A().run {
    wakeup()
    wearClothes()
    goToWork()
    this
  }

  /**
   * EXTENSION:
   *
   * Calls the specified function [block] with `this` value as its argument and returns its result.
   *
   * public inline fun <T, R> T.let(block: (T) -> R): R
   *
   * usage: convert from one type to another
   */
  val a3: A = A().let { it }

  /**
   * FUNCTION:
   *
   * Calls the specified function [block] with the given [receiver] as its receiver and returns its result.
   *
   * public inline fun <T, R> with(receiver: T, block: T.() -> R)
   *
   * usage: logically group calls on an object
   */
  val a4: A = with(A()){
    wakeup()
    wearClothes()
    goToWork()
    this // the returned type depends from the last expression
  }

}

private data class A(var name: String = ""){
  fun wakeup() = println("wakeup")
  fun wearClothes() = println("Wear Clothes")
  fun goToWork()  = println("Go to work")
}

