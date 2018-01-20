package it.car.graph.imm24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import it.car.graph.IGraph;

/**
 * Created by ciriti on 28/08/16.
 */

@SuppressWarnings("ALL")
public class ImmGraph implements IGraph<Integer> {

    List<Integer> vertices = new ArrayList<>();
    Map<Integer, List<Integer>> edges = new HashMap<>();
    Map<Integer, List<WeightedEdge<Integer>>> weighedEdges = new HashMap<>();

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
    public int getNumberWeightedEdge() {
        int res = 0;
        for(Integer key : weighedEdges.keySet()){
            res += weighedEdges.get(key).size();
        }
        return res;
    }

    @Override
    public boolean addDirectedEdge(Integer v1, Integer v2) {
        boolean res;
        res =  edges.get(v1).add(v2);
        return res;
    }

    @Override
    public boolean addDirectedWeightEdge(Integer v1, Integer v2, int weight) {
        return weighedEdges.get(v1).add(new WeightedEdge<>(v2, weight));
    }

    @Override
    public boolean addUndirectedEdge(Integer v1, Integer v2) {
        boolean res =  edges.get(v1).add(v2);
        boolean res1 =  edges.get(v2).add(v1);
        return res && res1;
    }

    @Override
    public boolean addUndirectedWeightEdge(Integer v1, Integer v2, int weight) {
        weighedEdges.get(v1).add(new WeightedEdge<>(v2, weight));
        weighedEdges.get(v2).add(new WeightedEdge<>(v1, weight));
        return true;
    }

    @Override
    public boolean addVertex(Integer v) {
        weighedEdges.put(v, new ArrayList<WeightedEdge<Integer>>());
        return vertices.add(v) && edges.put(v, new ArrayList<Integer>()) != null;
    }

    @Override
    public List<Integer> adj(Integer v) {
        return edges.get(v);
    }

    @Override
    public List<WeightedEdge<Integer>> adjWeighted(Integer v) {
        return weighedEdges.get(v);
    }

    @Override
    public List<Integer> BFS_recursive(Integer v1, Integer v2) {
        return null;
    }

    @Override
    public List<Integer> BFS_linear(Integer v1, Integer v2) {
        /**
         * 1. initialize the datas structures: Queue (unvisited nodes), HashSet (visited nodes),
         * HashMap (parent)
         * 2. enquee in the queue the first node e mark it as visited
         * 3. loop if is the queue not empty
         *      4. dequeue the node (current), if it is == to the destination return the parents list
         *      5. for each neighbour NOT VISITED:
         *          - add in visited set
         *          - enqueue in the queue
         *          - add the current node as parent of this node
         */
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> parents = new HashMap();

        queue.add(v1);
        visited.add(v1);

        while(!queue.isEmpty()){
            Integer curr = queue.poll();
            if(curr == v2) break;
            for (Integer neighbour : edges.get(curr)){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.add(neighbour);
                    if(parents.get(neighbour) == null){
                        parents.put(neighbour, new ArrayList<Integer>());
                    }
                    if(parents.get(curr) != null)
                        parents.get(neighbour).addAll(parents.get(curr));
                    parents.get(neighbour).add(curr);


                }
            }
        }

        if(parents.get(v2) != null){
            parents.get(v2).add(v2);
        }
        return parents.get(v2) == null? new ArrayList<Integer>():parents.get(v2);
    }

    @Override
    public List<Integer> DFS_recursive(Integer v1, Integer v2) {
        return null;
    }

    @Override
    public List<Integer> DFS_linear(Integer v1, Integer v2) {

        /**
         * 1. initialize the datas structures: Stack (unvisited nodes), HashSet (visited nodes),
         * HashMap (parent)
         * 2. push in the stack the first node e mark it as visited
         * 3. loop if is the stack in not empty
         *      4. pull the node (current), if it is == to the destination return the parents list
         *      5. for each neighbour NOT VISITED:
         *          - add in visited set
         *          - put in the stack
         *          - add the current node as parent of this node
         */

        Stack<Integer> stack = new Stack();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> parent = new HashMap<>();

        stack.push(v1);
        visited.add(v1);

        while(!stack.isEmpty()){
            int curr = stack.pop();
            if(curr == v2) break;
            for(Integer neighbour : edges.get(curr)){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    stack.push(neighbour);
                    if(!parent.containsKey(neighbour)){
                        parent.put(neighbour, new ArrayList<Integer>());
                    }
                    if(parent.get(curr) != null)
                        parent.get(neighbour).addAll(parent.get(curr));
                    parent.get(neighbour).add(curr);
                }
            }
        }

        if(parent.get(v2) != null){
            parent.get(v2).add(v2);
        }

        return parent.get(v2) == null? new ArrayList<Integer>():parent.get(v2);
    }

    @Override
    public List<Integer> dijkstra(Integer v1, Integer v2) {
        /**
         * 1. Init the data structures
         * N.B. COMPARE is the comparator used to order the element to the priority queue
         */
        PriorityQueue<WeightedEdge> pq = new PriorityQueue<>(vertices.size(), COMPARE);
        Set<Integer> visited = new HashSet<>();
        HashMap<Integer, List<Integer>> parents = new HashMap<>();
        HashMap<Integer, Integer> distance = new HashMap<>();

        /**
         * 2. Set the initial distace to a big value and the distance of the starting vertex to 0
         */
        for(Integer v : vertices){
            if(v != v1)
                distance.put(v, Integer.MAX_VALUE);
            else
                distance.put(v, 0);
        }

        /**
         * 3. Add in the queue the starting vertex
         */

        pq.add(new WeightedEdge<Integer>(v1, 0));
        parents.put(v1, new ArrayList<Integer>());

        /**
         * 4. Loop until the queue is not empty
         */
        while(!pq.isEmpty()){
            /**
             * 5. take the value with the minimum weight
             */
            WeightedEdge<Integer> curr = pq.poll();

            /**
             * 6. check if curr is not visited (redundant condition)
             */
//            if(!visited.contains(curr.node)){

            /**
             * 7. mark curr as visited
             */
            visited.add(curr.node);

            /**
             * 8. if curr is == to the target vertex stop the loop
             */
            if(curr.node == v2){
                break;
            }

            /**
             * 9. scann all the neighbour of curr
             */
            for(WeightedEdge<Integer> neightbour : adjWeighted(curr.node)){
                /**
                 * 10. if the neighbour is not visited
                 */
                if(!visited.contains(neightbour.node)){
                    /**
                     * 11. if DIST(curr) + neighbour.weight < DIST(neighbour)
                     * set the new distance
                     */
                    if(neightbour.weigth + distance.get(curr.node) < distance.get(neightbour.node)){
                        distance.put(neightbour.node, neightbour.weigth + distance.get(curr.node));

                        /**
                         * 12. avoid null pointer exception
                         */
                        if(parents.get(neightbour.node) == null){
                            parents.put(neightbour.node, new ArrayList<Integer>()) ;
                        }
                        /**
                         * 13. set the new parent of neighbour
                         */
                        parents.get(neightbour.node).clear();
                        parents.get(neightbour.node).addAll(parents.get(curr.node));
                        parents.get(neightbour.node).add(curr.node);
                        /**
                         * 14. add neightbour to the prioriti queue
                         */
                        pq.add(neightbour);
                    }
                }
            }

        }
//        }

        parents.get(v2).add(v2);

        return parents.get(v2);
    }

    public static Comparator<WeightedEdge> COMPARE = new Comparator<WeightedEdge>() {
        @Override
        public int compare(WeightedEdge o1, WeightedEdge o2) {
            return o1.weigth - o2.weigth;
        }
    };

    public static Comparator<Integer> COMPARE1 = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleziona:");
        System.out.println("1 - per undirectedGrap");
        System.out.println("2 - per directedGrap");
        System.out.println("3 - per directedWeightGrap");
        System.out.println("4 - per dijkstra");
        System.out.println("");
        int type = scanner.nextInt();

        scanner.close();
        switch (type){
            case 1:
                System.out.println("Undirected:");
                undirectedGrap();
                break;
            case 2:
                System.out.println("Directed:");
                directedGrap();
                break;
            case 3:
                System.out.println("Directed and weighted:");
                directedWeightGrap();
                break;
            case 4:
                System.out.println("Dijkstra:");
                dijkstra();
                break;
        }

    }

    public static void undirectedGrap(){
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

        System.out.println("Num of vertices: " + graph.getNumberVertex());
        System.out.println("Num of to edges: " + graph.getNumberEdge());
        for(int i : graph.vertices){
            System.out.println("Adj of " + i + ": " + graph.adj(i));
        }

        System.out.println();
    }
    public static void directedGrap(){
        ImmGraph graph = new ImmGraph();

        // vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(8);
        graph.addVertex(9);
        graph.addVertex(10);

        graph.addUndirectedEdge(1, 2);
        graph.addUndirectedEdge(1, 4);
        graph.addUndirectedEdge(1, 5);
        graph.addUndirectedEdge(2, 5);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(3, 6);
        graph.addUndirectedEdge(6, 5);
        graph.addUndirectedEdge(6, 9);
        graph.addUndirectedEdge(9, 5);
        graph.addUndirectedEdge(9, 8);
        graph.addUndirectedEdge(8, 7);
        graph.addUndirectedEdge(8, 5);
        graph.addUndirectedEdge(7, 5);
        graph.addUndirectedEdge(7, 4);
        graph.addUndirectedEdge(4, 5);
        graph.addUndirectedEdge(9, 10);

        System.out.println("Num of vertices: " + graph.getNumberVertex());
        System.out.println("Num of to edges: " + graph.getNumberEdge());
        for(int i : graph.vertices){
            System.out.println("Adj of " + i + ": " + graph.adj(i));
        }

        System.out.println();

        System.out.println("DSF: " + graph.DFS_linear(1, 10));
        System.out.println("BSF: " + graph.BFS_linear(1, 10));
    }

    public static void directedWeightGrap(){

        ImmGraph graph = new ImmGraph();

        // vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(8);
        graph.addVertex(9);
        graph.addVertex(10);
        graph.addVertex(11);

        /*graph.addDirectedWeightEdge(1, 2, 5);
        graph.addDirectedWeightEdge(1, 4, 1);
        graph.addDirectedWeightEdge(1, 3, 3);
        graph.addDirectedWeightEdge(4, 5, 1);
        graph.addDirectedWeightEdge(4, 2, 2);
        graph.addDirectedWeightEdge(3, 4, 3);
        graph.addDirectedWeightEdge(3, 5, 2);
        graph.addDirectedWeightEdge(3, 7, 5);
        graph.addDirectedWeightEdge(2, 5, 3);
        graph.addDirectedWeightEdge(2, 7, 6);
        graph.addDirectedWeightEdge(5, 6, 1);
        graph.addDirectedWeightEdge(6, 7, 1);*/

        graph.addUndirectedWeightEdge(1, 6, 1);
        graph.addUndirectedWeightEdge(1, 2, 1);
        graph.addUndirectedWeightEdge(1, 7, 1);
        graph.addUndirectedWeightEdge(2, 8, 10);
        graph.addUndirectedWeightEdge(2, 3, 1);
        graph.addUndirectedWeightEdge(3, 4, 1);
        graph.addUndirectedWeightEdge(4, 5, 1);
        graph.addUndirectedWeightEdge(8, 5, 10);

        System.out.println("Num of vertices: " + graph.getNumberVertex());
        System.out.println("Num of to edges: " + graph.getNumberWeightedEdge());
        for(int i : graph.vertices){
            System.out.println("Adj weighted of " + i + ": " + graph.adjWeighted(i));
        }

        System.out.println();

        System.out.println("dijkstra from: " + 1 + " to " + 5 + " "+ graph.dijkstra(1, 5));
        System.out.println("dijkstra from: " + 1 + " to " + 5 + " "+ graph.trainDijkstra(1, 5) + "  TRAINING");
    }

    public static void dijkstra(){

        ImmGraph graph = new ImmGraph();

        // vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(8);
        graph.addVertex(9);
        graph.addVertex(10);
        graph.addVertex(11);

        graph.addUndirectedWeightEdge(1, 6, 1);
        graph.addUndirectedWeightEdge(1, 2, 1);
        graph.addUndirectedWeightEdge(1, 7, 1);
        graph.addUndirectedWeightEdge(2, 8, 10);
        graph.addUndirectedWeightEdge(2, 3, 1);
        graph.addUndirectedWeightEdge(3, 4, 1);
        graph.addUndirectedWeightEdge(4, 5, 1);
        graph.addUndirectedWeightEdge(8, 5, 10);

        System.out.println("dijkstra from: " + 1 + " to " + 5 + " "+ graph.dijkstra(1, 5));
        System.out.println("dijkstra from: " + 1 + " to " + 5 + " "+ graph.trainDijkstra(1, 5) + "  TRAINING");
    }

    public List<Integer> trainDijkstra(int from, int to){
        Queue<Integer> queue = new PriorityQueue<>(100, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> parents = new HashMap<>();
        HashMap<Integer, Integer> distance = new HashMap<>();
        for(int v = 0; v < getNumberVertex(); v++){
            distance.put(v, Integer.MAX_VALUE);
        }

        queue.add(from);
        distance.put(from, 0);
        visited.add(from);
        parents.put(from, new ArrayList<Integer>());

        while(!queue.isEmpty()){
            Integer current = queue.poll();
            for(WeightedEdge<Integer> edge : weighedEdges.get(current)){
               if(!visited.contains(edge.node)){
                   if(distance.get(edge.node) > distance.get(current) + edge.weigth){
                       distance.put(edge.node, distance.get(current) + edge.weigth);
                       if(parents.containsKey(edge.node)){
                           parents.get(edge.node).clear();
                       }else
                           parents.put(edge.node, new ArrayList<Integer>());
                       parents.get(edge.node).addAll(parents.get(current));
                       parents.get(edge.node).add(current);
                       visited.add(edge.node);
                       queue.add(edge.node);
                   }
               }
            }
        }

        if(parents.containsKey(to))parents.get(to).add(to);

        return parents.containsKey(to)?parents.get(to): Collections.EMPTY_LIST;
    }
}
