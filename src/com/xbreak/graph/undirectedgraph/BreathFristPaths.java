package com.xbreak.graph.undirectedgraph;

import com.xbreak.fundamentals.three.XQueue;

public class BreathFristPaths {
	
	private boolean [] marked;
	private int [] edgeTo;
	private int s;
	
	public BreathFristPaths(Graph g, int s) {
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
	
	public Iterable<Integer> path(int v){
		if(!hasPathTo(v))
			return null;
		XQueue<Integer> q = new XQueue<>();
		for( ; v != s ; v = edgeTo[v]) {
			q.enqueue(v);
		}
		return q;
	}
}
