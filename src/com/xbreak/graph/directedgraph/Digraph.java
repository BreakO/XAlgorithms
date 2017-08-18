package com.xbreak.graph.directedgraph;

import com.xbreak.fundamentals.three.XBag;

import edu.princeton.cs.algs4.In;

/**
 * 4.2 ÓĞÏòÍ¼
 * @author XBreak
 */
public class Digraph {
	private int V;
	private int E;
	private XBag<Integer> [] adj;
	
	public Digraph(int V) {

		this.V = V;
		E = 0;
		adj = new XBag[V];
		for(int i = V; i < V; i++) {
			adj[i] = new XBag<>();
		}
	}
	public Digraph(In in) {
		this(in.readInt());
		int e = in.readInt();
		for(int i = 0; i < e; i++)
			addEdge(in.readInt(), in.readInt());
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}
	
	public Digraph reserve(){
		Digraph r = new Digraph(V);
		for(int i=0; i<V; i++) {
			for(Integer w : adj[i])
				r.addEdge(w, i);
		}
		return r;
	}
	
}
