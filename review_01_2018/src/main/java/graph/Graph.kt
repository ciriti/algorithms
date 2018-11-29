package graph

import java.util.PriorityQueue

/**
 * Created by Carmelo Iriti
 */

fun addPath(map: String) = Graph(map).aStarAlg()

internal class Graph(private val map: String) {

  // creates the matrix out of the string
  private val matrix: Array<CharArray> = buildMatrix(map)
  // Start point on the map
  private val start = locationInMatrixOf(map, 'S')
  // Destination point
  private val target = locationInMatrixOf(map, 'X')

  internal fun aStarAlg(): String {

    // visited location
    val visited: Array<BooleanArray> =
      Array(matrix.size) { BooleanArray(matrix.first().size) { false } }
    // list of nodes to reach the specific location
    val pathsMatrix: Array<Array<Paths>> =
      Array(matrix.size) { Array(matrix.first().size) { Paths() } }
    // priority queue
    val priorityQueue = PriorityQueue<MapPoint>(Comparator { p1: MapPoint, p2: MapPoint ->
      val p1D = heuristicDistance(p1, target) + pathsMatrix.getPaths(p1).distance
      val p2D = heuristicDistance(p2, target) + pathsMatrix.getPaths(
          p2
      ).distance // heuristicDistance(p2, start)//
      p1D.compareTo(p2D)
    })
    // initial point
    val startPoint = MapPoint(start.first, start.second, matrix, start, target)

    // distance 0 to the start node
    pathsMatrix.getPaths(startPoint)
        .distance = 0.0
    // enqueue the star node
    priorityQueue.add(startPoint)
    while (priorityQueue.isNotEmpty()) {
      // dequeue the node
      val node = priorityQueue.poll()
      // if the node is not visited
      if (visited.isNotVisited(node)) {
        visited.markVisited(node)
        if (node.isTarget()) {
          pathsMatrix.getPaths(node)
              .pathsList
              .add(node.toPair())
          return toStringPath(matrix, pathsMatrix.getPaths(node))
        }
        node.neighbours
            .filter { visited.isNotVisited(it) }
            .forEach { neighbor ->

              val distanceNode2Neighbor =
                pathsMatrix.getPaths(node).distance + neighbor.weight

//              val condition = when(neighbor.isTarget()){
//                true -> distanceNode2Neighbor <= pathsMatrix.getPaths(neighbor).distance
//                false -> distanceNode2Neighbor < pathsMatrix.getPaths(neighbor).distance
//              }
              if (distanceNode2Neighbor < pathsMatrix.getPaths(neighbor).distance) {
                pathsMatrix.getPaths(neighbor)
                    .distance = distanceNode2Neighbor

                // update the new path
                pathsMatrix.getPaths(neighbor)
                    .updatePaths(node, pathsMatrix.getPaths(node))

                // enqueue the neighbor
                priorityQueue.add(neighbor)
              }
            }
      }
    }
    return map
  }

  private fun MapPoint.isTarget(): Boolean = (this.row == target.first && this.col == target.second)

  internal data class Paths(
    var distance: Double = Double.MAX_VALUE,
    val pathsList: MutableList<Pair<Int, Int>> = mutableListOf()
  )

  private fun Array<BooleanArray>.isNotVisited(point: MapPoint): Boolean =
    !this[point.row][point.col]

  fun Array<BooleanArray>.markVisited(point: MapPoint) {
    this[point.row][point.col] = true
  }

  private fun Array<Array<Paths>>.getPaths(point: MapPoint): Paths = this[point.row][point.col]

  private fun Paths.updatePaths(
    node: MapPoint,
    paths: Paths
  ) {
    pathsList
        .also { it.clear() }
        .also { it.addAll(paths.pathsList) }
        .also { it.add(Pair(node.row, node.col)) }
  }

  private fun toStringPath(
    pMatrix: Array<CharArray>,
    paths: Paths
  ): String {

    paths
        .pathsList
        .forEach { pMatrix[it.first][it.second] = '*' }

    val sb = StringBuffer()
    val iterator = pMatrix.iterator()
    sb.append(iterator.next().joinToString(prefix = "", postfix = "", separator = ""))
    while (iterator.hasNext()) {
      sb.append("\n${iterator.next().joinToString(prefix = "", postfix = "", separator = "")}")
    }
    return sb.toString()
  }

  private operator fun MapPoint.plus(other: Triple<Int, Int, Double>) =
    this.copy(
        row = this.row + other.first, col = this.col + other.second,
        weight = other.third
    )

  private operator fun MapPoint.plus(other: Pair<Int, Int>) =
    this.copy(row = this.row + other.first, col = this.col + other.second)

  private operator fun MapPoint.plus(other: MapPoint) =
    this.copy(
        row = this.row + other.row, col = this.col + other.col
    )

  private fun MapPoint.toPair() = Pair(row, col)

  private fun buildMatrix(map: String): Array<CharArray> = map
      .lines()
      .let { list ->
        Array(list.size) { list[it].toCharArray() }
      }

}

internal data class MapPoint(
  val row: Int,
  val col: Int,
  private val matrix: Array<CharArray>,
  private val begin: Pair<Int, Int>,
  private val target: Pair<Int, Int>,
  val weight: Double = 0.0
) {

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

  private val movements = listOf(
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

internal operator fun MapPoint.plus(other: Triple<Int, Int, Double>) =
  this.copy(
      row = this.row + other.first, col = this.col + other.second,
      weight = other.third
  )

internal fun heuristicDistance(
  p1: MapPoint,
  p2: Pair<Int, Int>
) = distance(p1.row, p1.col, p2.first, p2.second)

internal fun distance(
  row_1: Int,
  col_1: Int,
  row_2: Int,
  col_2: Int
) = kotlin.math.sqrt(
    Math.pow((row_1 - row_2).toDouble(), 2.toDouble()) +
        Math.pow((col_1 - col_2).toDouble(), 2.toDouble())
)

internal fun locationInMatrixOf(
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

internal fun checkBounds(
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

internal fun checkPath(
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


