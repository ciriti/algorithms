package graph

import graph.Graph.PathType.BEGIN
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Carmelo Iriti
 */
class PointTest {

  @Test
  fun `Find neighbours - 1`() {
    val mapString = """
        BBB
        BS.
        B.X
        """.trimIndent()

    val graph = Graph(mapString)
    val point = graph.getPoint(1,1)
    assertEquals(BEGIN, point.pathType)
    val neighbours = point.neighbours
    assertEquals(3, neighbours.size)
  }

  @Test
  fun `Find neighbours - 2`() {
    val mapString = """
        BBB
        BSB
        BBB
        """.trimIndent()

    val graph = Graph(mapString)
    val point = graph.getPoint(1,1)
    assertEquals(BEGIN, point.pathType)
    val neighbours = point.neighbours
    assertEquals(0, neighbours.size)
  }

  @Test
  fun `Find neighbours - 3`() {
    val mapString = """
        ...
        .S.
        .X.
        """.trimIndent()

    val graph = Graph(mapString)
    val point = graph.getPoint(1,1)
    assertEquals(BEGIN, point.pathType)
    val neighbours = point.neighbours
    assertEquals(8, neighbours.size)
  }

}