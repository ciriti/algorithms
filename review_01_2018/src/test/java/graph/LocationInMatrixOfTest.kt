package graph

import org.junit.Assert
import org.junit.Test

/**
 * Created by Carmelo Iriti
 */
class LocationInMatrixOfTest{

  @Test
  fun `Find start and end - 1`() {
    val mapString = """
        ....................
        .........XS.........
        ....................
        """.trimIndent()

    val end = locationInMatrixOf(mapString, 'X')
    val start = locationInMatrixOf(mapString,'S')

    Assert.assertEquals(end.first, 1)
    Assert.assertEquals(end.second, 9)

    Assert.assertEquals(start.first, 1)
    Assert.assertEquals(start.second, 10)
  }

  @Test
  fun `Find start and end - 2`() {
    val mapString = """
        XS..................
        ....................
        ....................
        """.trimIndent()

    val end = locationInMatrixOf(mapString, 'X')
    val start = locationInMatrixOf(mapString,'S')

    Assert.assertEquals(end.first, 0)
    Assert.assertEquals(end.second, 0)

    Assert.assertEquals(start.first, 0)
    Assert.assertEquals(start.second, 1)
  }

  @Test
  fun `Find start and end - 3`() {
    val mapString = """
        ....................
        ....................
        ..................XS
        """.trimIndent()

    val end = locationInMatrixOf(mapString, 'X')
    val start = locationInMatrixOf(mapString,'S')

    Assert.assertEquals(end.first, 2)
    Assert.assertEquals(end.second, 18)

    Assert.assertEquals(start.first, 2)
    Assert.assertEquals(start.second, 19)
  }

}