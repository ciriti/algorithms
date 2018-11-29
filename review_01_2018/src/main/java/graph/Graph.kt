package graph

import java.security.InvalidParameterException
import java.util.PriorityQueue

/**
 * Created by Carmelo Iriti
 */

fun addPath(map: String) = Graph(map).aStarAlg()

private class Graph(val map: String) {

  // creates the matrix out of the string
  val matrix: Array<CharArray> = buildMatrix(map)
  // Start point on the map
  val start = locationInMatrixOf(map, 'S')
  // Destination point
  val target = locationInMatrixOf(map, 'X')

  fun aStarAlg(): String {

    // visited location
    val visited: Array<BooleanArray> =
      Array(matrix.size) { BooleanArray(matrix.first().size) { false } }
    // list of nodes to reach the specific location
    val pathsMatrix: Array<Array<Paths>> =
      Array(matrix.size) { Array(matrix.first().size) { Paths() } }
    // priority queue
    val priorityQueue = PriorityQueue<MapPoint>(Comparator { p1: MapPoint, p2: MapPoint ->
      val p1D = heuristicDistance(p1, target) + getMetricsP1(p1, pathsMatrix.getPaths(p1))
      val p2D = heuristicDistance(p2, target) + getMetricsP2(p2, pathsMatrix.getPaths(p2))
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
        if (node.col == 7 && node.row == 3) {
          println()
        }
        node.neighbours
            .filter { visited.isNotVisited(it) }
            .forEach { neighbor ->

              val distanceNode2Neighbor =
                pathsMatrix.getPaths(node).distance + neighbor.weight

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

  fun getPoint(
    row: Int,
    col: Int
  ): MapPoint {
    checkBounds(Pair(row, col), matrix).let { if (!it) throw InvalidParameterException() }
    return MapPoint(row, col, matrix, start, target)
  }

  fun MapPoint.isTarget(): Boolean = (this.row == target.first && this.col == target.second)

  data class Paths(
    var distance: Double = Double.MAX_VALUE,
    val pathsList: MutableList<Pair<Int, Int>> = mutableListOf()
  )

  fun Array<BooleanArray>.isNotVisited(point: MapPoint): Boolean = !this[point.row][point.col]
  fun Array<BooleanArray>.markVisited(point: MapPoint) {
    this[point.row][point.col] = true
  }

  fun Array<Array<Paths>>.getPaths(point: MapPoint): Paths = this[point.row][point.col]

  fun Paths.updatePaths(
    node: MapPoint,
    paths: Paths
  ) {
    pathsList
        .also { it.clear() }
        .also { it.addAll(paths.pathsList) }
        .also { it.add(Pair(node.row, node.col)) }
  }

  fun toStringPath(
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

  fun getMetricsP1(
    p1: MapPoint,
    path: Paths
  ): Double {
    return path.distance
  }

  val countWalls = map.count { it == 'B' }

  fun getMetricsP2(
    p2: MapPoint,
    path: Paths
  ): Double {
    return if (countWalls < 40)
      heuristicDistance(p2, start)
    else
      path.distance
  }

  operator fun MapPoint.plus(other: Triple<Int, Int, Double>) =
    this.copy(
        row = this.row + other.first, col = this.col + other.second,
        weight = other.third
    )

  operator fun MapPoint.plus(other: Pair<Int, Int>) =
    this.copy(row = this.row + other.first, col = this.col + other.second)

  operator fun MapPoint.plus(other: MapPoint) =
    this.copy(
        row = this.row + other.row, col = this.col + other.col
    )

  fun MapPoint.toPair() = Pair(row, col)

}


