package graph

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

    val p1 = MapPoint(0, 0, matrix, Pair(0,0), Pair(0,0))

    // low right diagonal
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(+1, +1, 1.5),
            matrix
        ))

    // high left diagonal
    Assert.assertFalse(
        checkBounds(
            p1,
            Triple(-1, -1, 1.5),
            matrix
        ))

    // low left diagonal
    Assert.assertFalse(
        checkBounds(
            p1,
            Triple(-1, -1, 1.5),
            matrix
        ))

    // high right diagonal
    Assert.assertFalse(
        checkBounds(
            p1,
            Triple(-1, +1, 1.5),
            matrix
        ))
  }

  @Test
  fun `Corner MapPoint linear movements`() {
    /** matrix 3x3 */

    val p1 = MapPoint(0, 0, matrix, Pair(0,0), Pair(0,0))

    // right
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(0, +1, 1.0),
            matrix
        ))

    // down
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(+1, 0, 1.0),
            matrix
        ))

    // left
    Assert.assertFalse(
        checkBounds(
            p1,
            Triple(0, -1, 1.0),
            matrix
        ))

    // up
    Assert.assertFalse(
        checkBounds(
            p1,
            Triple(-1, 0, 1.0),
            matrix
        ))
  }
  @Test
  fun `Middle MapPoint all direction movements`() {
    /** matrix 3x3 */

    val p1 = MapPoint(1, 1, matrix, Pair(0,0), Pair(0,0))

    // right
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(0, +1, 1.0),
            matrix
        ))

    // down
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(+1, 0, 1.0),
            matrix
        ))

    // left
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(0, -1, 1.0),
            matrix
        ))

    // up
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(-1, 0, 1.0),
            matrix
        ))

    // low right diagonal
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(+1, +1, 1.5),
            matrix
        ))

    // high left diagonal
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(-1, -1, 1.5),
            matrix
        ))

    // low left diagonal
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(-1, -1, 1.5),
            matrix
        ))

    // high right diagonal
    Assert.assertTrue(
        checkBounds(
            p1,
            Triple(-1, +1, 1.5),
            matrix
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