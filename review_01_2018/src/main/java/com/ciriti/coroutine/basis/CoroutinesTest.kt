package com.ciriti.coroutine.basis

import com.ciriti.printThis
import com.ciriti.threadName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

/**
 * Created by Carmelo Iriti
 */

fun main() = runBlocking {
  val workManager = WorkManager()
  launch {
    try {
      val db = workManager.getFromDb()
      val net = workManager.getFromNet()
      "db: $db net: $net".printThis()
//      workManager.cancelAllWork()
    } catch (e: Throwable) {
      e.printStackTrace()
    }

  }
  workManager.cancelAllWork()
  delay(2000)
  println("finish")
}

class WorkManager : CoroutineScope {
  private val job = SupervisorJob()
  //  val scope =
  override val coroutineContext: CoroutineContext by lazy { Dispatchers.Default + job }

  suspend fun getFromNet(): String = async {
    delay(10000)
    "NET  ".apply { print(this) }
    threadName().printThis()
    "NET"
  }.await()

  suspend fun getFromDb(): Either<String> = safeExecution {
    async {
      throw RuntimeException()
      delay(10000)
      "DB  ".apply { print(this) }
      threadName().printThis()
      Either.Success("DB")
    }.await()
  }

  fun cancelAllWork() {
//    coroutineContext.cancel()
    coroutineContext.cancelChildren()         // (1)
  }
}

suspend fun <T : Any> safeExecution(
  call: suspend () -> Either<T>
): Either<T> = try {
  call.invoke()
} catch (e: Exception) {
  Either.Error(e)
}

sealed class Either<out T : Any> {
  data class Success<out T : Any>(val data: T) : Either<T>()
  data class Error(val exception: Exception) : Either<Nothing>()
}


