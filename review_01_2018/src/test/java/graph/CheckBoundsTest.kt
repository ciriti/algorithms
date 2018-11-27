package graph

import graph.Graph.Point
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by Carmelo Iriti
 */
class CheckBoundsTest {

  lateinit var matrix: Array<CharArray>

  @Before
  fun setup() {
    matrix = Array(3) { CharArray(3) { '.' } }
  }

  @Test
  fun `Corner point diagonal movements`() {
    /** matrix 3x3 */

    val p1 = Point(0, 0, matrix, Pair(0,0), Pair(0,0))

    // low right diagonal
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(+1, +1, 1.5),
            Pair(0,0),
            Pair(2,2)
        ))

    // high left diagonal
    Assert.assertFalse(
        checkBounds(
            p1,
            Triple(-1, -1, 1.5),
            Pair(0,0),
            Pair(2,2)
        ))

    // low left diagonal
    Assert.assertFalse(
        checkBounds(
            p1,
            Triple(-1, -1, 1.5),
            Pair(0,0),
            Pair(2,2)
        ))

    // high right diagonal
    Assert.assertFalse(
        checkBounds(
            p1,
            Triple(-1, +1, 1.5),
            Pair(0,0),
            Pair(2,2)
        ))
  }

  @Test
  fun `Corner point linear movements`() {
    /** matrix 3x3 */

    val p1 = Point(0, 0, matrix, Pair(0,0), Pair(0,0))

    // right
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(0, +1, 1.0),
            Pair(0,0),
            Pair(2,2)
        ))

    // down
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(+1, 0, 1.0),
            Pair(0,0),
            Pair(2,2)
        ))

    // left
    Assert.assertFalse(
        checkBounds(
            p1,
            Triple(0, -1, 1.0),
            Pair(0,0),
            Pair(2,2)
        ))

    // up
    Assert.assertFalse(
        checkBounds(
            p1,
            Triple(-1, 0, 1.0),
            Pair(0,0),
            Pair(2,2)
        ))
  }
  @Test
  fun `Middle point all direction movements`() {
    /** matrix 3x3 */

    val p1 = Point(1, 1, matrix, Pair(0,0), Pair(0,0))

    // right
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(0, +1, 1.0),
            Pair(0,0),
            Pair(2,2)
        ))

    // down
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(+1, 0, 1.0),
            Pair(0,0),
            Pair(2,2)
        ))

    // left
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(0, -1, 1.0),
            Pair(0,0),
            Pair(2,2)
        ))

    // up
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(-1, 0, 1.0),
            Pair(0,0),
            Pair(2,2)
        ))

    // low right diagonal
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(+1, +1, 1.5),
            Pair(0,0),
            Pair(2,2)
        ))

    // high left diagonal
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(-1, -1, 1.5),
            Pair(0,0),
            Pair(2,2)
        ))

    // low left diagonal
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(-1, -1, 1.5),
            Pair(0,0),
            Pair(2,2)
        ))

    // high right diagonal
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(-1, +1, 1.5),
            Pair(0,0),
            Pair(2,2)
        ))
  }



}

/**
Triple(+1, +1, 1.5), //diagonal
Triple(-1, -1, 1.5), //diagonal
Triple(+1, -1, 1.5), //diagonal
Triple(-1, +1, 1.5), //diagonal

Triple(0, +1, 1.0),
Triple(0, -1, 1.0),
Triple(+1, 0, 1.0),
Triple(-1, 0, 1.0)
    */