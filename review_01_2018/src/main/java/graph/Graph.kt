package graph

import com.ciriti.datastructure.printMatrix
import java.security.InvalidParameterException
import java.util.PriorityQueue

/**
 * Created by Carmelo Iriti
 */

fun addPath(map: String) = Graph(map).aStarAlg()

class Graph(val map: String) {

  // creates the matrix out of the string
  val matrix: Array<CharArray> = buildMatrix(map)
  // Start point on the map
  val start = locationInMatrixOf(map, 'S')
  // Destination point
  val target = locationInMatrixOf(map, 'X')
  // Buonds on the map
  val origin = Pair(0, 0)
  val end = Pair(matrix.lastIndex, matrix.first().lastIndex)

  fun aStarAlg(): String {

    // visited location
    val visited: Array<BooleanArray> =
      Array(matrix.size) { BooleanArray(matrix.first().size) { false } }
    // list of nodes to reach the specific location
    val pathsMatrix: Array<Array<Paths>> =
      Array(matrix.size) { Array(matrix.first().size) { Paths() } }
    // priority queue
    val priorityQueue = PriorityQueue<MapPoint>(Comparator { p1: MapPoint, p2: MapPoint ->
      val p1D = heuristicDistance(p1, target) + pathsMatrix.getPaths(p1).distance
      val p2D = heuristicDistance(p2, target) + pathsMatrix.getPaths(p2).distance
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
  ) {
    /*override fun toString(): String {

      val s1 = when (distance) {
        Double.MAX_VALUE -> " ".padStart(5)
        else -> "%.2f".format(distance).padStart(5)
      }
      val s2 = "${pathsList.size}".padStart(3)
      return s1
    }*/
  }

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

}
