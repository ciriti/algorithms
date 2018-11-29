package graph

/**
 * Created by Carmelo Iriti
 */

fun main() {

}

fun Array<CharArray>.printMatrix() {
  this.forEach { it1 ->
    print(" ${it1.joinToString(separator = " ", postfix = "|", prefix = "|")}")
    println()
  }
}
