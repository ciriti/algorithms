package graph

import com.ciriti.printThis
import java.io.Serializable

/**
 * Created by Carmelo Iriti
 */

fun main() {

  val end = Pair(5, 5)

  Point(0, 0, end).neighbours.printThis()
  Point(5, 5, end).neighbours.printThis()
  Point(2, 1, end).neighbours.printThis()
  Point(5, 5, end).neighbours.printThis()
}

val movements = listOf(
    Triple(+1, +1, 1.5F), //diagonal
    Triple(-1, -1, 1.5F), //diagonal
    Triple(+1, -1, 1.5F), //diagonal
    Triple(-1, +1, 1.5F), //diagonal

    Triple(0, +1, 1.0F),
    Triple(0, -1, 1.0F),
    Triple(+1, 0, 1.0F),
    Triple(-1, 0, 1.0F)
)

val Point.neighbours: List<Point>
  get() = movements
      .asSequence()
      .map { this + it }
      .filter { it.row >= origin.first && it.col >= origin.first }
      .filter { it.row <= end.first && it.col <= end.second }
      .toList()

operator fun Point.plus(other: Pair<Int, Int>) =
  this.copy(row = this.row + other.first, col = this.col + other.second)

operator fun Point.plus(other: Triple<Int, Int, Float>) =
  this.copy(row = this.row + other.first, col = this.col + other.second, weight = other.third)

operator fun Point.plus(other: Point) =
  this.copy(row = this.row + other.row, col = this.col + other.col)

data class Point(
//  val value: PathType,
  val row: Int,
  val col: Int,
  val end: Pair<Int, Int>,
  val origin: Pair<Int, Int> = Pair(0, 0),
  val weight: Float = 0F
) : Serializable {
  override fun toString(): String = "{($row, $col) -> $weight}"
}

enum class PathType(pathType: String) {
  BEGIN("S"),
  TARGET("X"),
  PATH("."),
  WALL("B")
}