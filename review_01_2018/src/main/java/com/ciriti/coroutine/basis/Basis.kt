package com.ciriti.coroutine.basis

import com.ciriti.threadName
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Created by Carmelo Iriti
 */

fun main() = runBlocking {
  val jobs = Job()//SupervisorJob()
  val job = launch(jobs) {
    val time = measureTimeMillis {
      println("The answer is ${concurrentSum()}")
    }
    println("Completed in $time ms")
  }
//  job.cancelChildren()
  println()
//  jobs.cancelChildren()
  job.join()
}

suspend fun concurrentSum(): Int = coroutineScope {
  val one = async { doSomethingUsefulOne() }
  val two = async { doSomethingUsefulTwo() }
  one.await() + two.await()
}

suspend fun doSomethingUsefulOne(): Int  = coroutineScope{
  async {
    delay(1000L) // pretend we are doing something useful here
    println("somethingUsefulOneAsync - ${threadName()}")
    13
  }.await()
}

suspend fun doSomethingUsefulTwo(): Int = coroutineScope {
  async {
    delay(1000L) // pretend we are doing something useful here, too
    println("somethingUsefulTwoAsync - ${threadName()}")
    29
  }.await()
}