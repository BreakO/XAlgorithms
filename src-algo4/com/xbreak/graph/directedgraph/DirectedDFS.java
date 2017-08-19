package com.xbreak.graph.directedgraph;

/**
 * 	有向图的可达性
 * @author XBreak
 */
public class DirectedDFS {
	private boolean [] marked;
	
	public DirectedDFS(Digraph g, int s) {

		marked = new boolean[g.V()];
		dfs(g, s);
	}

	private void dfs(Digraph g, int v) {

		marked[v] = true;
		for(int w : g.adj(v))
			if(!marked[w])
				dfs(g, w);
	}
	
	private boolean marked(int v) {
		return marked[v];
	}
	
}
