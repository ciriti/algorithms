package com.ciriti.coroutine.basis

import com.ciriti.printThis
import com.ciriti.threadName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Created by Carmelo Iriti
 */
//sampleStart
data class Ball(var hits: Int)

fun main() = runBlocking {
  val table = Channel<Ball>() // a shared table
  async(Dispatchers.IO) {
    withContext(NonCancellable) {
      try {
        player("ping", table)
      } catch (e: Throwable) {
        "done1"
      }
    }
  }
  async(Dispatchers.IO) {
    withContext(NonCancellable) {
      try {
        player("pong", table)
      } catch (e: Throwable) {
        "done2"
      }
    }
  }
  table.send(Ball(0)) // serve the ball
  delay(2000)
  coroutineContext.cancelChildren()
  "finish".printThis()
}

suspend fun player(
  name: String,
  table: Channel<Ball>
) {
  for (ball in table) { // receive the ball in a loop
    ball.hits++

    println("$name $ball ${threadName()}")
    delay(300) // wait a bit
    table.send(ball) // send the ball back
    if (ball.hits == 10) throw RuntimeException("fallo!!")
  }
}