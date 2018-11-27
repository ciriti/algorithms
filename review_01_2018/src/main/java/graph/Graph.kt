package graph

import graph.Graph.PathType.BEGIN
import graph.Graph.PathType.PATH
import graph.Graph.PathType.TARGET
import graph.Graph.PathType.WALL
import graph.Graph.Point
import java.io.Serializable
import java.security.InvalidParameterException
import kotlin.math.sqrt

/**
 * Created by Carmelo Iriti
 */

fun main() {
  val mapString = """
        ....................
        ........XBS.........
        ....................
        """.trimIndent()

  val graph = Graph(mapString)
  graph.matrix.printMatrix()
  graph.verify()

}

class Graph(map: String) {

  val matrix: Array<CharArray> = buildMatrix(map)
  val begin = locationInMatrixOf(map, 'S')
  val target = locationInMatrixOf(map, 'X')
  val origin = Pair(0, 0)
  val end = Pair(matrix.lastIndex, matrix.first().lastIndex)

  fun verify() {
//    matrix[2][9].printThis("value: ")
//    Point(1, 10).neighbours.forEachIndexed { index, it ->
//      println(
//          " -> $index: ${matrix[it.row][it.col]} <-"
//      )
//    }
//    val visited = mutableSetOf<Point>()
//    val queue = mutableSetOf<Point>()
  }

  operator fun Point.plus(other: Pair<Int, Int>) =
    this.copy(row = this.row + other.first, col = this.col + other.second)

  operator fun Point.plus(other: Point) =
    this.copy(
        row = this.row + other.row, col = this.col + other.col
    )

  data class Point(
    val row: Int,
    val col: Int,
    var weight: Double = 0.0,
    private val matrix: Array<CharArray>,
    private val begin: Pair<Int, Int>,
    private val target: Pair<Int, Int>
  ) : Serializable {

    val distance: Double = heuristicDistance(this, begin) + heuristicDistance(this, target)
    val pathType: PathType = when (matrix[row][col]) {
      'S' -> BEGIN
      'X' -> TARGET
      '.' -> PATH
      'B' -> WALL
      else -> throw InvalidParameterException()
    }

    private val boundStart = Pair(0, 0)
    private val boundEnd = Pair(matrix.lastIndex, matrix.first().lastIndex)

    override fun toString(): String = "{($row, $col) -> $weight}}"

    override fun equals(other: Any?): Boolean {
      if (other == null) return false
      if (other !is Point) return false
      return this.col == other.col && this.row == other.row
    }

    override fun hashCode(): Int {
      var result = 17
      result = 31 * result + row.hashCode()
      result = 31 * result + col.hashCode()
      return result
    }

    operator fun Point.plus(other: Triple<Int, Int, Double>) =
      this.copy(
          row = this.row + other.first, col = this.col + other.second,
          weight = other.third + this.weight
      )

    val neighbours: List<Point>
      get() = movements
          .asSequence()
          .filter { it.first + row >= boundStart.first }
          .map { this + it }
          .filter { matrix[it.row][it.col] != 'B' }
          .filter { it.row >= boundStart.first && it.col >= boundEnd.first }
          .filter { it.row <= boundEnd.first && it.col <= boundEnd.second }
          .toList()

    val movements = listOf(
        Triple(+1, +1, 1.5), //diagonal
        Triple(-1, -1, 1.5), //diagonal
        Triple(+1, -1, 1.5), //diagonal
        Triple(-1, +1, 1.5), //diagonal

        Triple(0, +1, 1.0),
        Triple(0, -1, 1.0),
        Triple(+1, 0, 1.0),
        Triple(-1, 0, 1.0)
    )

  }

  enum class PathType(pathType: Char) {
    BEGIN('S'),
    TARGET('X'),
    PATH('.'),
    WALL('B')
  }

  object COMPARE_BY_DISTANCE : Comparator<Point> {
    override fun compare(
      p1: Point,
      p2: Point
    ): Int {
//      heuristicDistance(p1, p2)
      return 0
    }
  }

}

fun heuristicDistance(
  p1: Point,
  p2: Pair<Int, Int>
) = sqrt(
    Math.pow((p1.row - p2.first).toDouble(), 2.toDouble()) +
        Math.pow((p1.col - p2.second).toDouble(), 2.toDouble())
)

fun locationInMatrixOf(
  s: String,
  c: Char
): Pair<Int, Int> {
  val numCharsPerRow = s.lines()
      .first()
      .count()
  val string = s.replace("\n".toRegex(), "")
  val index = string.indexOf(c)
  return Pair(index / numCharsPerRow, index % numCharsPerRow)
}

inline fun checkBounds(
  p : Point,
  t: Triple<Int, Int, Double>,
  boundStart: Pair<Int, Int>,
  boundEnd: Pair<Int, Int>
) : Boolean {
  val a = t.first + p.row  >= boundStart.first && t.first + p.row >= boundEnd.first
  val b = t.second + p.col  >= boundStart.second && t.second + p.col >= boundEnd.second

  return a && b
}
