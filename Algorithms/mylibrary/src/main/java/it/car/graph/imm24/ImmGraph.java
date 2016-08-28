package it.car.graph.imm24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.car.graph.IGraph;

/**
 * Created by ciriti on 28/08/16.
 */

public class ImmGraph implements IGraph<Integer> {

    List<Integer> vertices = new ArrayList<>();
    Map<Integer, List<Integer>> edges = new HashMap<>();


    @Override
    public int getNumberVertex() {
        return vertices.size();
    }

    @Override
    public int getNumberEdge() {
        int res = 0;
        for(Integer key : edges.keySet()){
            res += edges.get(key).size();
        }
        return res;
    }

    @Override
    public boolean addDirectedEdge(Integer v1, Integer v2) {
        boolean res;
        if(edges.containsKey(v1)){
            res =  edges.get(v1).add(v2);
        }else{
            List<Integer> tmp = new ArrayList<>();
            res = tmp.add(v2);
            edges.put(v1, tmp);
        }
        return res;
    }

    @Override
    public boolean addUndirectedEdge(Integer v1, Integer v2) {
        boolean res;
        boolean res1;
        if(edges.containsKey(v1)){
            res =  edges.get(v1).add(v2);
        }else{
            List<Integer> tmp = new ArrayList<>();
            res = tmp.add(v2);
            edges.put(v1, tmp);
        }
        if(edges.containsKey(v2)){
            res1 =  edges.get(v2).add(v1);
        }else{
            List<Integer> tmp = new ArrayList<>();
            res1 = tmp.add(v1);
            edges.put(v2, tmp);
        }
        return res && res1;
    }

    @Override
    public boolean addVertex(Integer v) {
        return vertices.add(v);
    }

    @Override
    public List<Integer> adj(Integer v) {
        return edges.get(v);
    }

    @Override
    public List<Integer> BFS_recursive(Integer v1, Integer v2) {
        return null;
    }

    @Override
    public List<Integer> BFS_linear(Integer v1, Integer v2) {
        return null;
    }

    @Override
    public List<Integer> DFS_recursive(Integer v1, Integer v2) {
        return null;
    }

    @Override
    public List<Integer> DFS_linear(Integer v1, Integer v2) {
        return null;
    }

    @Override
    public List<Integer> dijkstra(Integer v1, Integer v2) {
        return null;
    }

    public static void main(String[] args){
        ImmGraph graph = new ImmGraph();

        // vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addUndirectedEdge(1, 3);
        graph.addUndirectedEdge(1, 2);
        graph.addUndirectedEdge(1, 5);
        graph.addUndirectedEdge(3, 5);
        graph.addUndirectedEdge(3, 4);
        graph.addUndirectedEdge(2, 5);
        graph.addUndirectedEdge(2, 4);

        System.out.println("Num of vertices: ");
        System.out.println("Num of to edges: ");
        for(int i : graph.vertices){
            System.out.println("Adj of " + i + ": " + graph.adj(i));
        }

    }
}
