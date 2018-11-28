package graph

/**
 * Created by Carmelo Iriti
 */

fun main() {
  val mapString = """
        XS..................
        ....................
        ..................XS
        """.trimIndent()


  val matrix: Array<CharArray> = buildMatrix(mapString)
  matrix.printMatrix()

  mapString.lines().count()
  mapString.lineSequence().first().count()

}

fun buildMatrix(map: String): Array<CharArray> = map
    .lines()
    .let { list ->
      Array(list.size) { list[it].toCharArray() }
    }

fun Array<CharArray>.printMatrix() {
  this.forEach { it1 ->
    print(" ${it1.joinToString(separator = " ", postfix = "|", prefix = "|")}")
    println()
  }
}
