package com.xbreak.graph.shortestpath;

import com.xbreak.fundamentals.three.XBag;
import com.xbreak.fundamentals.three.XQueue;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author XBreak
 */
public class WeightDirectedGraph {
	private int V,E;
	private XBag<WeightDirectedEdge> [] adj;
	
	public WeightDirectedGraph(int V) {
		
		this.V = V;
		E = 0;
		adj = new XBag[V];
		for(int i=0; i<V; i++)
			adj[i] = new XBag<>();
		
	}
	
	public WeightDirectedGraph(In in) {
		this(in.readInt());
		
		int e = in.readInt();
		for(int i = 0; i < e; i++) {
			addEdge(new WeightDirectedEdge(in.readInt(), in.readInt(), in.readDouble()));
		}
		
	}
	
	public int V() {
		return V;
	}
	
	public void addEdge(WeightDirectedEdge e) {
		adj[e.from()].add(e);
		E++;
	}
	
	public Iterable<WeightDirectedEdge> adj(int v){
		return adj[v];
	}
	
	public Iterable<WeightDirectedEdge> edges(){
		XQueue<WeightDirectedEdge> q = new XQueue<>();
		
		for(int i=0; i<V; i++) {
			for(WeightDirectedEdge e : adj[i])
				q.enqueue(e);
		}
		
		return q;
	}
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + "\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (WeightDirectedEdge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    public static void main(String[] args) {
        In in = new In("ewd.txt");
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        StdOut.println(G);
    }
}
