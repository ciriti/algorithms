package com.ciriti.coroutine

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

/**
 * Created by Carmelo Iriti
 *
 * LINK - https://github.com/Kotlin/kotlinx.coroutines/blob/master/docs/basics.md#waiting-for-a-job
 */

fun main(args: Array<String>) = runBlocking <Unit> { // start main coroutine
    launch { // launch new coroutine in background and continue
        Thread.currentThread().name
        delay(1000L)
        println("World!")
    }
    Thread.currentThread().name
    println("Hello,") // main coroutine continues here immediately
    delay(2000L)      // delaying for 2 seconds to keep JVM alive
}