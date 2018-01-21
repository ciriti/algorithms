package util

import com.google.common.io.ByteSource
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader


/**
 * Created by carmeloiriti, 09/01/18.
 */
class ResourcesReader{

    companion object {
        fun tex(jsonName : String) : String{
            val inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(jsonName)
            val byteSource = object : ByteSource() {
                override fun openStream(): InputStream {
                    return inputStream
                }
            }

            return byteSource.asCharSource(Charsets.UTF_8).read()
        }

        fun file2Rows(jsonName : String) : List<String>{
            val inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(jsonName)
            val br = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
            var line: String?
            var res = mutableListOf<String>()

            do{
                line = br.readLine() ?: break
                res.add(line)
            }while ( line != null)

            br.close()

            return res
        }

    }

}

/**
 * Fills the list with the provided [value].
 *
 * Each element in the list gets replaced with the [value].
 */
inline fun <T> MutableList<T>.fill(value: T) {
    java.util.Collections.fill(this, value)
}

/**
 * Randomly shuffles elements in this mutable list.
 */
inline fun <T> MutableList<T>.shuffle() {
    java.util.Collections.shuffle(this)
}

/**
 * Randomly shuffles elements in this mutable list using the specified [random]
instance as the source of randomness.
 */
inline fun <T> MutableList<T>.shuffle(random: java.util.Random) {
    java.util.Collections.shuffle(this, random)
}

/**
 * Returns a new list with the elements of this list randomly shuffled.
 */
fun <T> Iterable<T>.shuffled(): List<T> = toMutableList().apply { shuffle() }

/**
 * Returns a new list with the elements of this list randomly shuffled
 * using the specified [random] instance as the source of randomness.
 */
fun <T> Iterable<T>.shuffled(random: java.util.Random): List<T> = toMutableList().apply { shuffle(random) }
