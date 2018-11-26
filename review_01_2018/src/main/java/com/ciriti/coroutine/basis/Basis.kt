package com.ciriti.coroutine.basis

import com.ciriti.printThis
import com.ciriti.threadName
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * Created by Carmelo Iriti
 */

fun main() = runBlocking {
  val time = measureTimeMillis {
    println("The answer is ${concurrentSum()}")
  }
  println("Completed in $time ms")
}

suspend fun concurrentSum(): Int = coroutineScope {
  val one = async { doSomethingUsefulOne() }
  val two = async { doSomethingUsefulTwo() }
  one.await() + two.await()
}

suspend fun doSomethingUsefulOne(): Int {
  delay(1000L) // pretend we are doing something useful here
  println("somethingUsefulOneAsync - ${threadName()}")
  return 13
}

suspend fun doSomethingUsefulTwo(): Int {
  delay(1000L) // pretend we are doing something useful here, too
  println("somethingUsefulTwoAsync - ${threadName()}")
  return 29
}