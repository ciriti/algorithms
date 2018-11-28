package com.ciriti

/**
 * Created by Carmelo Iriti
 */

fun<T> List<T>.printAll() = println(this)
fun<T> T.printThis(prefix : String = "", postfix : String = "") = when{
  prefix.isBlank() -> println("$this $postfix")
  else -> println("$prefix $this $postfix")
}
fun <T> T.runIfNull(func: () -> Unit) = this ?: func()

fun threadName() = Thread.currentThread().name
