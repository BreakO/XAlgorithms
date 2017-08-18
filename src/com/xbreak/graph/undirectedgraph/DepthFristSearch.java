package com.xbreak.graph.undirectedgraph;

/**
 * ����ͼ������������� : ����ͼ
 * @author XBreak
 */
public class DepthFristSearch {
	private boolean [] marked;
	private int count;
	
	/**
	 * @param g	Ҫ�����ͼ
	 * @param s	��ʼ����
	 */
	public DepthFristSearch(Graph g, int s) {

		marked = new boolean[g.V()];
		dfs(g, s);
	
	}
	/**
	 * ���ѱ���ͼ
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
