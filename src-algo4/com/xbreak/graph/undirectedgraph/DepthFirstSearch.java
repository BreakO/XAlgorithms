package com.xbreak.graph.undirectedgraph;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 无向图的深度优先搜索 : 遍历图
 * @author XBreak
 */
public class DepthFirstSearch {
	private boolean [] marked;
	private int count;
	
	/**
	 * @param g	要处理的图
	 * @param s	起始顶点
	 */
	public DepthFirstSearch(Graph g, int s) {

		marked = new boolean[g.V()];
		dfs(g, s);
	
	}
	/**
	 * 深搜遍历图
	 * @param g
	 * @param v
	 */
	public void dfs(Graph g, int v) {
		
		marked[v] = true; 
		count++;
		for(int w : g.adj(v))
			if(!marked[w])
				dfs(g,w);
	}
	
	public int count() {
		return count;
	}
	public boolean marked(int v) {
		return marked[v];
	}
    public static void main(String[] args) {
        In in = new In("undigraph.txt");
        Graph G = new Graph(in);
        int s = Integer.parseInt("0");
        DepthFirstSearch search = new DepthFirstSearch(G, s);
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v))
                StdOut.print(v + " ");
        }

        StdOut.println();
        if (search.count() != G.V()) StdOut.println("NOT connected");
        else                         StdOut.println("connected");
    }
}
