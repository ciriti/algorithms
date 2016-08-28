package it.car.graph;

import java.util.Comparator;
import java.util.List;

/**
 * Created by ciriti on 28/08/16.
 */

public interface IGraph<T> {

    int getNumberVertex();
    int getNumberEdge();
    int getNumberWeightedEdge();
    boolean addDirectedEdge(T v1, T v2);
    boolean addDirectedWeightEdge(T v1, T v2, int weight);
    boolean addUndirectedEdge(T v1, T v2);
    boolean addVertex(T v);
    List<T> adj(T v);
    List<WeightedEdge<T>> adjWeighted(T v);
    List<T> BFS_recursive(T v1, T v2);
    List<T> BFS_linear(T v1, T v2);
    List<T> DFS_recursive(T v1, T v2);
    List<T> DFS_linear(T v1, T v2);
    List<T> dijkstra(T v1, T v2);


    class WeightedEdge<T>{
        public T t;
        public int weigth;

        public WeightedEdge(T t, int weigth) {
            this.t = t;
            this.weigth = weigth;
        }

        @Override
        public String toString() {
            return "  { v:" + t + " w:" + weigth + "}  ";
        }
    }

}
