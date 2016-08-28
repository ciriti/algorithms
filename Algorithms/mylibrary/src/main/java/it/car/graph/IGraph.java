package it.car.graph;

import java.util.List;

/**
 * Created by ciriti on 28/08/16.
 */

public interface IGraph<T> {

    int getNumberVertex();
    int getNumberEdge();
    boolean addDirectedEdge(T v1, T v2);
    boolean addUndirectedEdge(T v1, T v2);
    boolean addVertex(T v);
    List<T> adj(T v);
    List<T> BFS_recursive(T v1, T v2);
    List<T> BFS_linear(T v1, T v2);
    List<T> DFS_recursive(T v1, T v2);
    List<T> DFS_linear(T v1, T v2);
    List<T> dijkstra(T v1, T v2);

}
