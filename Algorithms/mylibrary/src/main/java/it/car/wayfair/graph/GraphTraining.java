package it.car.wayfair.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by carmeloiriti, 30/09/16.
 */
public class GraphTraining {

    List<Node> vtc;
    Map<Node, List<Node>> edges;

    public GraphTraining(){
        vtc = new ArrayList<>();
        edges = new HashMap<>();
    }

    public void addVertex(Node a){
        vtc.add(a);
        edges.put(a, new ArrayList<Node>());
    }

    public void addEdge(Node a, Node b){
        edges.get(a).add(b);
        edges.get(b).add(a);
    }

    public List<Node> getVertices(){
        return new ArrayList<>(vtc);
    }

    public List<Node> getEdges(Node a){
        return new ArrayList<>(edges.get(a));
    }


    public List<Node> dijkstra(Node from, Node to){

        Map<Node, Integer> distance = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, List<Node>> parents = new HashMap<>();

        // init distance
        for(Node n : this.getVertices()){
            distance.put(n, Integer.MAX_VALUE);
            parents.put(n, new ArrayList<Node>());
        }

        distance.put(from, 0);
        visited.add(from);
        pq.add(from);

        assert !pq.isEmpty() : "\n\n------ Priority queue is Empty ---------\n\n";
        //assert(pq.isEmpty());

        while(!pq.isEmpty()){

            Node curr = pq.poll();

            assert this.getEdges(curr).size()>0 : "\n\n------ NO neighbours ---------\n\n";

            for(Node ng : this.getEdges(curr)){



                if(visited.contains(ng)) continue;


                distance.put(ng, Math.max(distance.get(ng), distance.get(curr) + 1));
                visited.add(ng);
                pq.add(ng);

                if(distance.get(ng) > distance.get(curr) + 1){
                    parents.get(ng).clear();
                    parents.get(ng).addAll(new ArrayList<>(parents.get(curr)));
                    parents.get(ng).add(curr);
                }
            }


        }

        return parents.get(to);
    }


    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);

        GraphTraining tree = new GraphTraining();

        tree.addVertex(n1);
        tree.addVertex(n2);
        tree.addVertex(n3);
        tree.addVertex(n4);
        tree.addVertex(n5);
        tree.addVertex(n6);
        tree.addVertex(n7);
        tree.addVertex(n8);
        tree.addVertex(n9);

        tree.addEdge(n1,n5);
        tree.addEdge(n1,n2);
        tree.addEdge(n1,n6);
        tree.addEdge(n1,n7);

        tree.addEdge(n5,n9);

        tree.addEdge(n2,n4);

        tree.addEdge(n6,n8);

        tree.addEdge(n7,n8);

        tree.addEdge(n8,n3);

        tree.addEdge(n3,n4);

        tree.addEdge(n9,n4);

        assert tree.getVertices().size() == 9 : "\n\n------ ERROR vertices count ---------\n\n";
        System.out.println("Node until " + n4 + ": " +tree.dijkstra(n1, n4));


    }

    /*
        Node class
    */
    public static final class Node implements Comparable<Node>{

        final Integer val;

        public Node(Integer val){
            this.val = val;
        }

        public boolean equals(Node o){
            return o != null &&  val == o.val;
        }

        public int hash(){
            return val.hashCode();
        }

        public String toString(){
            return String.valueOf(val);
        }

        public int compareTo(Node n){
            return this.val - n.val;
        }

    }

}
