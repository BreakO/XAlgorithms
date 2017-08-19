package com.xbreak.graph.undirectedgraph;

import com.xbreak.fundamentals.three.XQueue;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BreadthFirstPaths {
	
	private boolean [] marked;
	private int [] edgeTo;
	private int s;
	
	public BreadthFirstPaths(Graph g, int s) {
		this.s = s;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		bfs(g, s);
	}

	private void bfs(Graph g, int v) {

		marked[v] = true;
		XQueue<Integer> q = new XQueue<>();
		q.enqueue(v);
		while(!q.isEmpty()) {
			v = q.dequeue();
			for(int w : g.adj(v)) {
				if(!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					q.enqueue(w);
				}
			}
			
		}
		
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v))
			return null;
		XQueue<Integer> q = new XQueue<>();
		for( ; v != s ; v = edgeTo[v]) {
			q.enqueue(v);
		}
		return q;
	}
	
    public static void main(String[] args) {
        In in = new In("undigraph.txt");
        Graph G = new Graph(in);

        int s = Integer.parseInt("0");
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (bfs.hasPathTo(v)) {
                for (int x : bfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else        StdOut.print("-" + x);
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d (-):  not connected\n", s, v);
            }

        }
    }
	
}
