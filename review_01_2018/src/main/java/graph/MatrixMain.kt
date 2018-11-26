package graph

/**
 * Created by Carmelo Iriti
 */

fun main() {
  val mapString = """
        ....................
        .........XS.........
        ....................
        """.trimIndent()

  val matrix : Array<CharArray> = buildMatrix(mapString)
  matrix.printMatrix()

}

fun buildMatrix(map: String) : Array<CharArray> = map
    .lines()
    .let { list ->
      Array(list.size) { list[it].toCharArray() }
    }

fun addPath(map: String) = ""

fun Array<CharArray>.printMatrix(){
  this.forEach { it1 ->
    print(" ${it1.joinToString(separator = " ", postfix = "|", prefix = "|")}")
    println()
  }
}
