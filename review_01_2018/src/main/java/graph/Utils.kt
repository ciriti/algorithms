package graph

import kotlin.math.sqrt

/**
 * Created by Carmelo Iriti
 */

fun heuristicDistance(
  p1: MapPoint,
  p2: Pair<Int, Int>
) = distance(p1.row, p1.col, p2.first, p2.second)

fun heuristicDistance(
  p1: Pair<Int, Int>,
  p2: Pair<Int, Int>
) = distance(p1.first, p1.second, p2.first, p2.second)

fun heuristicDistance(
  p1: MapPoint,
  p2: MapPoint
) = distance(p1.row, p1.col, p2.row, p2.col)

fun distance(
  row_1: Int,
  col_1: Int,
  row_2: Int,
  col_2: Int
) = sqrt(
    Math.pow((row_1 - row_2).toDouble(), 2.toDouble()) +
        Math.pow((col_1 - col_2).toDouble(), 2.toDouble())
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

enum class PathType(pathType: Char) {
  BEGIN('S'),
  TARGET('X'),
  PATH('.'),
  WALL('B')
}
