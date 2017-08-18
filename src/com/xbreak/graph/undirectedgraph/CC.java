package com.xbreak.graph.undirectedgraph;

/**
 * ���� ���ѵ� ��ͨ����
 * @author XBreak
 */
public class CC {
	private boolean[] marked;
	private int[] id;	//��ʶ : id[v] = 1, ��ʶ v�����ڵ�һ����ͨ������
	private int count;	//�ܵ���ͨ������
	
	public CC(Graph g) {

		marked = new boolean[g.V()];
		id = new int[g.V()];
		for(int i = 0; i < g.V(); i++) {
			if(!marked[i]) {
				count++;
				dfs(g, i);
			}
		}
		
		
	}

	private void dfs(Graph g, int v) {

		marked[v] = true;
		id[v] = count;
		for(int w : g.adj(v))
			if(!marked[w])
				dfs(g, w);
			
	}
	
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}
	
	public int id(int v) {
		return id[v];
	}
	public int count() {
		return count;
	}
}
