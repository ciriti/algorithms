package it.car.her_.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by carmeloiriti, 05/12/16.
 */

class Graph {

    List<Character> nodes;
    Map<Character, List<WgEdge<Character>>> edges;

    /** datastructure dijkstra */
    Map<Character, Integer> distances;
    Map<Character, List<Character>> parents;
    Set<Character> visited;
    PriorityQueue<Character> pq;

    public Graph() {
        nodes = new ArrayList<>();
        edges = new HashMap<>();
    }

    public void addVertex(Character c){
        nodes.add(c);
        edges.put(c, new ArrayList());
    }

    public void addEdge(Character a, Character b, int weigth){
        if(!nodes.contains(a) || !nodes.contains(b))
            throw new RuntimeException("Vertex doesn't exist!!!");
        edges.get(a).add(new WgEdge<>(b, weigth));
        edges.get(b).add(new WgEdge<>(a, weigth));
    }

    public List<WgEdge> dijkstra(Character start, Character end){

        distances = new HashMap<>();
        parents = new HashMap<>();
        visited = new HashSet<>();
        pq = new PriorityQueue<>(100, new Comparator<Character>() {
            @Override
            public int compare(Character lhs, Character rhs) {
                int distLhs = distances.get(lhs);
                int distRhs = distances.get(rhs);
                return distLhs - distRhs;
            }
        });

        /**
         * initialize the distance to inf
         * initialize the parent list
         */
        for(Character v : nodes){
            distances.put(v, Integer.MAX_VALUE);
            parents.put(v, new ArrayList<Character>());
        }

        /** set initial condition */
        distances.put(start, 0);
        visited.add(start);
        pq.add(start);


        while(!pq.isEmpty()){
            /** take the current node */
            Character current = pq.poll();
            /** take the neightbours */
            List<WgEdge<Character>> neighbours = edges.get(current);
            Iterator<WgEdge<Character>> i = neighbours.iterator();
            while(i.hasNext()){
                WgEdge<Character> n = i.next();
                if(!visited.contains(n)){

                }
            }

        }

        return null;
    }



}
