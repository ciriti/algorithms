package graph

import graph.PathType.*
import java.io.Serializable
import java.security.InvalidParameterException

/**
 * Created by Carmelo Iriti
 */
data class MapPoint(
  val row: Int,
  val col: Int,
  private val matrix: Array<CharArray>,
  private val begin: Pair<Int, Int>,
  private val target: Pair<Int, Int>,
  var weight: Double = 0.0
) : Serializable {

  /**
   * It is the sum of the 2 distance:
   * 1. distance between this node and the start point
   * 1. distance between this node and the target point
   */
  val heuristicDistance: Double = heuristicDistance(this, begin) + heuristicDistance(this, target)

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
    if (other !is MapPoint) return false
    return this.col == other.col && this.row == other.row
  }

  override fun hashCode(): Int {
    var result = 17
    result = 31 * result + row.hashCode()
    result = 31 * result + col.hashCode()
    return result
  }

  val neighbours: List<MapPoint>
    get() = movements
        .asSequence()
        .filter { checkPath(this, it, matrix) }
        .map { this + it }
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
