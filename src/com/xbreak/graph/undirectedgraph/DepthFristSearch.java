package com.xbreak.graph.undirectedgraph;

/**
 * 无向图的深度优先搜索 : 遍历图
 * @author XBreak
 */
public class DepthFristSearch {
	private boolean [] marked;
	private int count;
	
	/**
	 * @param g	要处理的图
	 * @param s	起始顶点
	 */
	public DepthFristSearch(Graph g, int s) {

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
	
}
