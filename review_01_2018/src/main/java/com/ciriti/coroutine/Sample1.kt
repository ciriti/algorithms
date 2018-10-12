package com.ciriti.coroutine

import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

/**
 * Created by Carmelo Iriti
 *
 * LINK - https://github.com/Kotlin/kotlinx.coroutines/blob/master/docs/basics.md#waiting-for-a-job
 */

fun main(args: Array<String>) = runBlocking {
  val job = GlobalScope.launch { // launch new coroutine and keep a reference to its Job
    delay(1000L)
    println("World!")
  }
  println("Hello,")
  job.join() // wait until child coroutine completes
}

fun main1(args: Array<String>) = runBlocking {
  // start main coroutine
  GlobalScope.launch {
    // launch new coroutine in background and continue
    delay(1000L)
    println("World!")
  }
  Thread.currentThread()
      .name
  println("Hello,") // main coroutine continues here immediately
  delay(2000L)      // delaying for 2 seconds to keep JVM alive
}