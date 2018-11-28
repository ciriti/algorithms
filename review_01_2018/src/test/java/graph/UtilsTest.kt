package graph

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.PriorityQueue
import kotlin.math.sqrt

/**
 * Created by Carmelo Iriti
 */
class UtilsTest {

  lateinit var mapString: String

  lateinit var end: Pair<Int, Int>
  lateinit var start: Pair<Int, Int>

  lateinit var matrix: Array<CharArray>

  @Before
  fun setup() {
    mapString = """
        S...
        ....
        ...X
        """.trimIndent()
    end = locationInMatrixOf(mapString, 'X')
    start = locationInMatrixOf(mapString, 'S')
    matrix = buildMatrix(mapString)
  }

  @Test
  fun `Comparator by distance`() {

    """
      S...
      ..C.
      .BAX
    """.trimIndent()

    val A = MapPoint(2, 2, matrix, end, start)
    val B = MapPoint(2, 1, matrix, end, start)
    val C = MapPoint(1, 2, matrix, end, start)

    val pq = PriorityQueue<MapPoint>(COMPARE_BY_DISTANCE)
    pq.add(C)
    pq.add(A)
    pq.add(B)

    val list = pq.toList()

    Assert.assertEquals(C, list[0])
    Assert.assertEquals(A, list[1])
    Assert.assertEquals(B, list[2])

  }

  @Test
  fun `Test distance`() {
    val A = MapPoint(1, 1, matrix, end, start)

    Assert.assertTrue(tester(A, Pair(1,1)) == heuristicDistance(A, Pair(1,1)))
    Assert.assertTrue(tester(A, Pair(2,2)) == heuristicDistance(A, Pair(2,2)))

  }

  fun tester(
    p1: MapPoint,
    p2: Pair<Int, Int>
  ) =
    sqrt(
        Math.pow((p1.row - p2.first).toDouble(), 2.toDouble()) +
            Math.pow((p1.col - p2.second).toDouble(), 2.toDouble())
    )

}