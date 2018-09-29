package com.alg.graph

/**
 * Created by ciriti
 */
/*************************************************************************
 *  Compilation:  javac DepthFirstSearch.java
 *  Execution:    java DepthFirstSearch filename.txt s
 *  Dependencies: Graph.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/41undirected/tinyG.txt
 *
 *  Run depth first search on an undirected graph.
 *  Runs in O(E + V) time.
 *
 *  % java DepthFirstSearch tinyG.txt 0
 *  0 1 2 3 4 5 6
 *  NOT connected
 *
 *  % java DepthFirstSearch tinyG.txt 9
 *  9 10 11 12
 *  NOT connected
 *
 *************************************************************************/

/**
 *  The <tt>DepthFirstSearch</tt> class represents a data type for
 *  determining the vertices connected to a given source vertex <em>s</em>
 *  in an undirected graph. For versions that find the paths, see
 *  {@link DepthFirstPaths} and {@link BreadthFirstPaths}.
 *  <p>
 *  This implementation uses depth-first search.
 *  The constructor takes time proportional to <em>V</em> + <em>E</em>
 *  (in the worst case),
 *  where <em>V</em> is the number of vertices and <em>E</em> is the number of edges.
 *  It uses extra space (not including the graph) proportional to <em>V</em>.
 *  <p>
 *  For additional documentation, see <a href="/algs4/41graph">Section 4.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class DepthFirstSearch {
  private var marked: BooleanArray    // marked[v] = is there an s-v path?
  private var count: Int = 0           // number of vertices connected to s

  /**
   * Computes the vertices in graph <tt>G</tt> that are
   * connected to the source vertex <tt>s</tt>.
   * @param G the graph
   * @param s the source vertex
   */
  fun DepthFirstSearch(
    G: Graph,
    s: Int
  ): ??? {
    marked = BooleanArray(G.V())
    dfs(G, s)
  }

  // depth first search from v
  private fun dfs(
    G: Graph,
    verticeDaAnalizzare: Int
  ) {
    count++
    marked[verticeDaAnalizzare] = true
    for (vicinoDelVertice in G.adj(verticeDaAnalizzare)) {
      if (!marked[vicinoDelVertice]) {
        dfs(G, vicinoDelVertice)
      }
    }
  }

  /**
   * Is there a path between the source vertex <tt>s</tt> and vertex <tt>v</tt>?
   * @param v the vertex
   * @return <tt>true</tt> if there is a path, <tt>false</tt> otherwise
   */
  fun marked(v: Int): Boolean {
    return marked[v]
  }

  /**
   * Returns the number of vertices connected to the source vertex <tt>s</tt>.
   * @return the number of vertices connected to the source vertex <tt>s</tt>
   */
  fun count(): Int {
    return count
  }

  /**
   * Unit tests the <tt>DepthFirstSearch</tt> data type.
   */
  @JvmStatic fun main(args: Array<String>) {
    val `in` = In(args[0])
    val G = Graph(`in`)
    val s = Integer.parseInt(args[1])
    val search = DepthFirstSearch(G, s)
    for (v in 0 until G.V()) {
      if (search.marked(v))
        StdOut.print(v + " ")
    }

    StdOut.println()
    if (search.count() != G.V())
      StdOut.println("NOT connected")
    else
      StdOut.println("connected")
  }

}