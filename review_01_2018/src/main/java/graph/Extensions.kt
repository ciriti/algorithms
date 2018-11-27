package graph


/**
 * Created by Carmelo Iriti
 */

operator fun MapPoint.plus(other: Triple<Int, Int, Double>) =
  this.copy(
      row = this.row + other.first, col = this.col + other.second,
      weight = other.third + this.weight
  )

operator fun MapPoint.plus(other: Pair<Int, Int>) =
  this.copy(row = this.row + other.first, col = this.col + other.second)

operator fun MapPoint.plus(other: MapPoint) =
  this.copy(
      row = this.row + other.row, col = this.col + other.col
  )