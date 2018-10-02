package com.ciriti.datastructure.graph

import org.junit.Assert
import org.junit.Test

/**
 * Created by Carmelo Iriti
 */
class GraphElementTest {

  @Test
  fun bfsGraph() {
    val n =
      C['a',
          C['b',
              C['d'], C['f'], C['g']
          ],
          C['c',
              C['x'], C['h', C['i', C['l'] ] ], C['y']
          ]
      ]
    val result = listOf('a', 'c', 'y', 'h', 'i', 'l', 'x', 'b', 'g', 'f', 'd')
    Assert.assertEquals(result.toString(), n.dfs().toString())
  }

}