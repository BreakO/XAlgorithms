package com.xbreak.graph.minispannertree;

import com.xbreak.fundamentals.three.XBag;
import com.xbreak.fundamentals.three.XQueue;

import edu.princeton.cs.algs4.In;

/**
 * 4.3.2无向有权图
 * @author XBreak
 */
public class EdgeWeightGraph {
	private int V, E;
	private XBag<Edge> [] adj;
	
	public EdgeWeightGraph(int v) {
		V = v;
		E = 0;
		adj = new XBag[v];
		for(int i=0; i<v; i++)
			adj[i] = new XBag<>();
	}
	
	public EdgeWeightGraph(In in) {
		this(in.readInt());
		
		int e = in.readInt();
		
		for(int i=0; i < e; i++) {
			addEdge(new Edge(in.readInt(), in.readInt(), in.readDouble()));
		}
	}
	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	public Iterable<Edge> adj(int v){
		return adj[v];
	}
	public Iterable<Edge> edges(){
		XQueue<Edge> q = new XQueue<>();
		for(int i=0; i<V; i++) {
			for(Edge e : adj[i])
				if(e.other(i) > i)	//防止出现双倍的边数
					q.enqueue(e);
		}
		return q;
	}
} 
