package it.car.graph;

import it.car.graph.util.In;
import it.car.graph.util.StdOut;

import java.io.File;
import java.util.Stack;



public class MyGraph {

	private final int V;
	private int E;
	private MyBag<Integer>[] adj;
	
	/**
     * Initializes an empty graph with <tt>V</tt> vertices and 0 edges.
     * param V the number of vertices
     * @throws java.lang.IllegalArgumentException if <tt>V</tt> < 0
     */
	public MyGraph(int v) {
		super();
		V = v;
		E = 0;
		adj = new MyBag[V];
		for(int i = 0; i<V; i++){
			adj[i] = new MyBag<>();
		}
	}
	
	 /**  
     * Initializes a graph from an input stream.
     * The format is the number of vertices <em>V</em>,
     * followed by the number of edges <em>E</em>,
     * followed by <em>E</em> pairs of vertices, with each entry separated by whitespace.
     * @param in the input stream
     * @throws java.lang.IndexOutOfBoundsException if the endpoints of any edge are not in prescribed range
     * @throws java.lang.IllegalArgumentException if the number of vertices or edges is negative
     */
	public MyGraph(In in) {
		this(in.readInt());
		int E = in.readInt();
		if(E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
		for(int e = 0; e < E ; e++){
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}
	
	public MyGraph(MyGraph G){
		this.V = G.V;
		this.E = G.E;
		for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}
	
	public Iterable<Integer> adj(int vertex){
		validateVertex(vertex);
		return adj[vertex];
	}
	
	private void validateVertex(int vertex){
		if ((vertex < 0) || (vertex >= V))
			throw new IndexOutOfBoundsException("vertex " + vertex + " is not between 0 and " + (V-1));
	}
	
	/**
	 * Adds the undirected edge v-w to the graph. 
	 * @param a
	 * @param b
	 * @throws java.lang.IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V 
	 */
	public void addEdge(int a, int b){
		validateVertex(a);
		validateVertex(b);
		adj[a].add(b);
		adj[b].add(a);
		E++;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder s = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		 s.append(V + " vertices, " + E + " edges " + NEWLINE);
	        for (int v = 0; v < V; v++) {
	            s.append(v + ": ");
	            for (int w : adj[v]) {
	                s.append(w + " ");
	            }
	            s.append(NEWLINE);
	        }
	        return s.toString();
	}
	
	public static void main(String args[]){
		
		In in = new In(new File("tinyG.txt"));
        MyGraph G = new MyGraph(in);
        StdOut.println(G);
		
	}
	
}
