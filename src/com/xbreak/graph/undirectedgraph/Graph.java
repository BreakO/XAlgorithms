package com.xbreak.graph.undirectedgraph;

import com.xbreak.fundamentals.three.XBag;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 4.1 无向图
 * @author XBreak
 */
public class Graph {
	private int V;				//顶点
	private int E;				//边
	private XBag<Integer>[] adj;	//邻接表
	
	public Graph(int V) {
		
		this.V = V;
		adj = new XBag[V];
		E = 0;
		for(int i = 0; i < V; i++) {
			adj[i] = new XBag<>();
		}
	}
	public Graph(In in) {
		this(in.readInt());
		int e = in.readInt();
		for(int i = 0; i < e; i++) {
			int v1 = in.readInt();
			int v2 = in.readInt();
			addEdge(v1,v2);
		}
		
	}
	/**
	 * 增加两条边
	 * @param v1
	 * @param v2
	 */
	public void addEdge(int v1, int v2) {
		adj[v1].add(v2);
		adj[v2].add(v1);
		E++;
	}
	
	/**
	 *	获取某顶点的邻接表
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public int V() {
		return V;
	}
	
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    public static void main(String[] args) {
        In in = new In("undigraph.txt");
        Graph G = new Graph(in);
        StdOut.println(G);
    }
}
