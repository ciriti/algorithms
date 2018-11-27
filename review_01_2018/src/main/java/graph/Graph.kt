package graph

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

  fun getPoint(
    row: Int,
    col: Int
  ): MapPoint {
    checkBounds(Pair(row, col), matrix).let { if (!it) throw InvalidParameterException() }
    return MapPoint(row, col, matrix, begin, target)
  }

  enum class PathType(pathType: Char) {
    BEGIN('S'),
    TARGET('X'),
    PATH('.'),
    WALL('B')
  }

  object COMPARE_BY_DISTANCE : Comparator<MapPoint> {
    override fun compare(
      p1: MapPoint,
      p2: MapPoint
    ): Int {
//      heuristicDistance(p1, p2)
      return 0
    }
  }

}

fun heuristicDistance(
  p1: MapPoint,
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

fun checkBounds(
  p: MapPoint,
  t: Triple<Int, Int, Double>,
  matrix: Array<CharArray>
): Boolean {
  val boundStart = Pair(0, 0)
  val boundEnd = Pair(matrix.lastIndex, matrix.first().lastIndex)
  val indexRow = t.first + p.row
  val indexCol = t.second + p.col
  val a = indexRow >= boundStart.first && indexRow <= boundEnd.first
  val b = indexCol >= boundStart.second && indexCol <= boundEnd.second

  return a && b
}

fun checkBounds(
  p: Pair<Int, Int>,
  matrix: Array<CharArray>
): Boolean {
  val boundStart = Pair(0, 0)
  val boundEnd = Pair(matrix.lastIndex, matrix.first().lastIndex)
  val indexRow = p.first
  val indexCol = p.second
  val a = indexRow >= boundStart.first && indexRow <= boundEnd.first
  val b = indexCol >= boundStart.second && indexCol <= boundEnd.second
  return a && b
}

fun checkPath(
  p: MapPoint,
  t: Triple<Int, Int, Double>,
  matrix: Array<CharArray>
): Boolean {
  val indexRow = t.first + p.row
  val indexCol = t.second + p.col
  if (checkBounds(p, t, matrix)) {
    return matrix[indexRow][indexCol] != 'B'
  }
  return false
}
