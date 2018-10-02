package com.ciriti.datastructure.graph

import org.junit.Assert
import org.junit.Test

/**
 * Created by Carmelo Iriti
 */
class GraphElementTest {

  @Test
  fun dfsGraph() {
    val n =
      C['a',
          C['b',
              C['d'], C['f'], C['g']
          ],
          C['c',
              C['x'], C['h', C['i', C['l'] ] ], C['y']
          ]
      ]
    val resultDfs = listOf('a', 'c', 'y', 'h', 'i', 'l', 'x', 'b', 'g', 'f', 'd')
    Assert.assertEquals(resultDfs.toString(), n.dfs().toString())
  }

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
    val resultDfs = listOf('a', 'b', 'c', 'd', 'f', 'g', 'x', 'h', 'y', 'i', 'l')
    Assert.assertEquals(resultDfs.toString(), n.bfs().toString())
  }

}