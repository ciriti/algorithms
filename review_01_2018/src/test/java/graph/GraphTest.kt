package graph

import com.ciriti.printThis
import org.junit.Assert
import org.junit.Test

/**
 * Created by Carmelo Iriti
 */
class GraphTest {

  @Test
  fun t1(){
    val mapString = """
        .......
        ..XBS..
        .......
        """.trimIndent()
    mapString.printThis()
    println("")
    println("")
    println("")

    val graph = Graph(mapString)
    graph.aStarAlg().printThis()
  }

  @Test
  fun `Mark way around wall 2`() {
    val mapString = """
        ..........B.........
        ......X...B.........
        ..........B.........
        ........BBB....S....
        ....................
        """.trimIndent()

    val marked = """
        ..........B.........
        ......*...B.........
        ......*...B.........
        .......*BBB*****....
        ........***.........
        """.trimIndent()
    marked.printThis()
    println("")

    val res = addPath(mapString)
    res.printThis()

    Assert.assertEquals(marked, res)
  }

}