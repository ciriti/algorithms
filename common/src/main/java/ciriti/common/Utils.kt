package ciriti.common

import com.google.common.io.ByteSource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream

/**
 * Created by Carmelo Iriti
 */

fun threadName() = Thread.currentThread().name

fun<T> T.printThis(prefix : String = "", postfix : String = "") = when{
  prefix.isBlank() -> println("$this $postfix")
  else -> println("$prefix $this $postfix")
}

/**
 * Parse file.json and return list of objects
 */
inline fun <reified K> String.createListObjByJsonFile(): K {
  val typeToken = object : TypeToken<K>() {}.type
  val jsonString = this.jsonFile2String()
  var objs: K = Gson().fromJson<K>(jsonString, typeToken)
  return objs
}

/**
 * Receive file.json and return the content as string
 */
fun String.jsonFile2String(): String {
  val inputStream = Thread.currentThread()
      .contextClassLoader.getResourceAsStream(this)
  val byteSource = object : ByteSource() {
    override fun openStream(): InputStream {
      return inputStream
    }
  }

  return byteSource.asCharSource(Charsets.UTF_8)
      .read()
}

/**
 * Receive a file.json and create a reified Object
 */
inline fun <reified T> String.createGsonObj(): T {
  val jsonString = this.jsonFile2String()
  return Gson().fromJson(jsonString, T::class.java)
}

