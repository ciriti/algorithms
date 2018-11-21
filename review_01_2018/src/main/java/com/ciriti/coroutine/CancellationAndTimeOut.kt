package com.ciriti.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout

/**
 * Created by Carmelo Iriti
 */

fun main() = runBlocking {
  withTimeout(1300L) {
    repeat(1000) { i ->
      println("I'm sleeping $i ...")
      delay(500L)
    }
  }
}

fun main4(args: Array<String>) = runBlocking {
  val job = launch {
    try {
      repeat(1000) { i ->
        println("I'm sleeping $i ...")
        delay(500L)
      }
    }catch (e : Exception){
      e.printStackTrace()
    } finally {
      withContext(NonCancellable) {
        println("I'm running finally")
        delay(1000L)
        println("And I've just delayed for 1 sec because I'm non-cancellable")
      }
    }
  }
  delay(1300L) // delay a bit
  println("main: I'm tired of waiting!")
  job.cancelAndJoin() // cancels the job and waits for its completion
  println("main: Now I can quit.")
}

fun main3(args: Array<String>) = runBlocking {
  val job = launch {
    try {
      repeat(1000) { i ->
        println("I'm sleeping $i ...")
        delay(500L)
      }
    }catch (e : Exception){
      e.printStackTrace()
    } finally {
      println("I'm running finally")
    }
  }
  delay(1300L) // delay a bit
  println("main: I'm tired of waiting!")
  job.cancelAndJoin() // cancels the job and waits for its completion
  println("main: Now I can quit.")
}

fun mainCanc2(args: Array<String>) = runBlocking {
  val startTime = System.currentTimeMillis()
  val job = launch(Dispatchers.Default) {
    var nextPrintTime = startTime
    var i = 0
    while (i < 5) { // computation loop, just wastes CPU
      // print a message twice a second
      if (System.currentTimeMillis() >= nextPrintTime) {
        println("I'm sleeping ${i++} ...")
        nextPrintTime += 500L
      }
    }
  }
  delay(1300L) // delay a bit
  println("main: I'm tired of waiting!")
  job.cancelAndJoin() // cancels the job and waits for its completion
  println("main: Now I can quit.")
}

fun mainCancellation1(args: Array<String>) = runBlocking {
  val job = launch {
    repeat(1000) { i ->
      println("I'm sleeping $i ...")
      delay(500L)
    }
  }
  delay(1300L) // delay a bit
  println("main: I'm tired of waiting!")
  job.cancel() // cancels the job
  job.join() // waits for job's completion
  println("main: Now I can quit.")
}