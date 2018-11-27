package graph

import graph.MapPoint
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by Carmelo Iriti
 */
class CheckPathsTest {

  lateinit var matrix: Array<CharArray>
  lateinit var matrixWithBlock: Array<CharArray>

  @Before
  fun setup() {
    matrix = Array(3) { CharArray(3) { '.' } }
    matrixWithBlock = Array(3) { CharArray(3) { '.' } }
    matrixWithBlock[2][2] = 'B'
    matrixWithBlock[0][1] = 'B'
  }

  @Test
  fun `Corner MapPoint diagonal movements`() {
    /** matrix 3x3 */

    val p1 = MapPoint(0, 0, matrix, Pair(0,0), Pair(0,0))

    // low right diagonal
    Assert.assertTrue(
        checkPath(
            p1,
            Triple(+1, +1, 1.5),
            matrix
        ))

    // high left diagonal
    Assert.assertFalse(
        checkPath(
            p1,
            Triple(-1, -1, 1.5),
            matrix
        ))

    // low left diagonal
    Assert.assertFalse(
        checkPath(
            p1,
            Triple(-1, -1, 1.5),
            matrix
        ))

    // high right diagonal
    Assert.assertFalse(
        checkPath(
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
        checkPath(
            p1,
            Triple(0, +1, 1.0),
            matrix
        ))

    // down
    Assert.assertTrue(
        checkPath(
            p1,
            Triple(+1, 0, 1.0),
            matrix
        ))

    // left
    Assert.assertFalse(
        checkPath(
            p1,
            Triple(0, -1, 1.0),
            matrix
        ))

    // up
    Assert.assertFalse(
        checkPath(
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
        checkPath(
            p1,
            Triple(0, +1, 1.0),
            matrix
        ))

    // down
    Assert.assertTrue(
        checkPath(
            p1,
            Triple(+1, 0, 1.0),
            matrix
        ))

    // left
    Assert.assertTrue(
        checkPath(
            p1,
            Triple(0, -1, 1.0),
            matrix
        ))

    // up
    Assert.assertTrue(
        checkPath(
            p1,
            Triple(-1, 0, 1.0),
            matrix
        ))

    // low right diagonal
    Assert.assertTrue(
        checkPath(
            p1,
            Triple(+1, +1, 1.5),
            matrix
        ))

    // high left diagonal
    Assert.assertTrue(
        checkPath(
            p1,
            Triple(-1, -1, 1.5),
            matrix
        ))

    // low left diagonal
    Assert.assertTrue(
        checkPath(
            p1,
            Triple(-1, -1, 1.5),
            matrix
        ))

    // high right diagonal
    Assert.assertTrue(
        checkPath(
            p1,
            Triple(-1, +1, 1.5),
            matrix
        ))
  }

  @Test
  fun `Middle MapPoint with 2 blocks B, all direction movements`() {
    /** matrix 3x3 */

    val p1 = MapPoint(1, 1, matrixWithBlock, Pair(0,0), Pair(0,0))

    // right
    Assert.assertTrue(
        checkPath(
            p1,
            Triple(0, +1, 1.0),
            matrixWithBlock
        ))

    // down
    Assert.assertTrue(
        checkPath(
            p1,
            Triple(+1, 0, 1.0),
            matrixWithBlock
        ))

    // left
    Assert.assertTrue(
        checkPath(
            p1,
            Triple(0, -1, 1.0),
            matrixWithBlock
        ))

    // up
    Assert.assertFalse(
        checkPath(
            p1,
            Triple(-1, 0, 1.0),
            matrixWithBlock
        ))

    // low right diagonal
    Assert.assertFalse(
        checkPath(
            p1,
            Triple(+1, +1, 1.5),
            matrixWithBlock
        ))

    // high left diagonal
    Assert.assertTrue(
        checkPath(
            p1,
            Triple(-1, -1, 1.5),
            matrixWithBlock
        ))

    // low left diagonal
    Assert.assertTrue(
        checkPath(
            p1,
            Triple(-1, -1, 1.5),
            matrixWithBlock
        ))

    // high right diagonal
    Assert.assertTrue(
        checkPath(
            p1,
            Triple(-1, +1, 1.5),
            matrixWithBlock
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