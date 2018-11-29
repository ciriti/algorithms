package graph

import java.io.Serializable

/**
 * Created by Carmelo Iriti
 */
data class MapPoint(
  val row: Int,
  val col: Int,
  private val matrix: Array<CharArray>,
  private val begin: Pair<Int, Int>,
  private val target: Pair<Int, Int>,
  val weight: Double = 0.0
) : Serializable {

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
