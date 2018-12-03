package com.ciriti.coroutine.basis

/**
 * Created by Carmelo Iriti
 */

import com.ciriti.printThis
import com.ciriti.threadName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

suspend fun CoroutineScope.massiveRun(action: suspend () -> Unit) {
  val n = 100  // number of coroutines to launch
  val k = 1000 // times an action is repeated by each coroutine
  val time = measureTimeMillis {
    val jobs = List(n) {
      launch {
        repeat(k) { action() }
        threadName().printThis()
      }
    }
    jobs.forEach { it.join() }
  }
  println("Completed ${n * k} actions in $time ms")
}

val counterContext = newSingleThreadContext("CounterContext")
var counter = 0
val mutex = Mutex()

fun main() = runBlocking<Unit> {
  val ctx = coroutineContext
  //sampleStart
//  GlobalScope.massiveRun { // run each coroutine with DefaultDispathcer
//    withContext(ctx) { // but confine each increment to the single-threaded context
//      counter++
//    }
//  }
//  GlobalScope.massiveRun {
//    mutex.withLock {
//      counter++
//    }
//  }
  CoroutineScope(ctx).massiveRun { // run each coroutine in the single-threaded context
    counter++
  }
  println("Counter = $counter")
//sampleEnd
}