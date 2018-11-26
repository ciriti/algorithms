package graph

import com.ciriti.printThis
import graph.Graph.Point
import java.io.Serializable
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

class Graph(map : String){

  val matrix : Array<CharArray> = buildMatrix(map)

  val origin = Pair(0,0)
  val end : Pair<Int, Int>

  init {
    end = Pair(matrix.lastIndex, matrix[0].lastIndex)
  }

  fun verify(){
    matrix[2][9].printThis("value: ")
    Point(1,10).neighbours.forEachIndexed{ index, it -> println(" -> $index: ${matrix[it.row][it.col]} <-") }
    val visited = mutableSetOf<Point>()
    val queue = mutableSetOf<Point>()
  }

  val movements = listOf(
      Triple(+1, +1, 1/1.5), //diagonal
      Triple(-1, -1, 1/1.5), //diagonal
      Triple(+1, -1, 1/1.5), //diagonal
      Triple(-1, +1, 1/1.5), //diagonal

      Triple(0, +1, 1.0),
      Triple(0, -1, 1.0),
      Triple(+1, 0, 1.0),
      Triple(-1, 0, 1.0)
  )

  val Point.neighbours: List<Point>
    get() = movements
        .asSequence()
        .map { this + it }
        .filter { it.row >= origin.first && it.col >= origin.first }
        .filter { it.row <= end.first && it.col <= end.second }
        .filter { matrix[it.row][it.col] != 'B' }
        .toList()

  operator fun Point.plus(other: Pair<Int, Int>) =
    this.copy(row = this.row + other.first, col = this.col + other.second)

  operator fun Point.plus(other: Triple<Int, Int, Double>) =
    this.copy(row = this.row + other.first, col = this.col + other.second, weight = other.third)

  operator fun Point.plus(other: Point) =
    this.copy(row = this.row + other.row, col = this.col + other.col)

  data class Point(
//  val value: PathType,
    val row: Int,
    val col: Int,
//    val end: Pair<Int, Int>,
//    val origin: Pair<Int, Int> = Pair(0, 0),
    var weight: Double = 0.0
  ) : Serializable {
    override fun toString(): String = "{($row, $col) -> $weight}}"

    override fun equals(other: Any?): Boolean {
      if(other == null) return false
      if(other !is Point) return false
      return this.col == other.col && this.row == other.row
    }

    override fun hashCode(): Int {
      var result = 17
      result = 31 * result + row.hashCode()
      result = 31 * result + col.hashCode()
      return result
    }

  }


  enum class PathType(pathType: String) {
    BEGIN("S"),
    TARGET("X"),
    PATH("."),
    WALL("B")
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

fun heuristicDistance(p1 : Point, p2 : Pair<Int, Int>) = sqrt(
    Math.pow((p1.row - p2.first).toDouble(), 2.toDouble()) +
        Math.pow((p1.col - p2.second).toDouble(), 2.toDouble())
)

