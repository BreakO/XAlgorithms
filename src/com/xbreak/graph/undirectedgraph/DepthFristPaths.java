package com.xbreak.graph.undirectedgraph;

import com.xbreak.fundamentals.three.XStack;

/**
 * ����������� : ��ȡ·��
 * @author XBreak
 */
public class DepthFristPaths {
	
	private int s;
	private boolean[] marked;
	private int [] edgeTo;		//����õ����һ������
	
	public DepthFristPaths(Graph g, int v) {

		s = v;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		dfs(g, s);
	}
	
	public void dfs(Graph g, int v) {
		marked[v] = true;
		
		for(int w : g.adj(v))
			if(!marked[w]) {
				edgeTo[w] = v;
				dfs(g, w);
			}
	}
	
	public boolean marked(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> path(int v){
		XStack<Integer> stack = new XStack<>();
		for(; v != s ; v = edgeTo[v])
			stack.push(v);
		stack.push(s);
		return stack;
	}
	
	
}
