package com.xbreak.graph.undirectedgraph;

/**
 * ˫ɫ���� : �ڽӵ����ɫ���ظ�,��ֻ������
 * 
 * @author XBreak
 */
public class TwoColor {
	private boolean [] marked;
	private boolean [] color;
	private boolean isTwoColor ;
	
	public TwoColor(Graph g) {
		
		marked= new boolean[g.V()];
		color = new boolean[g.V()];
		isTwoColor = true;
		
		for(int i = 0; i < g.V(); i++) {
			if(!marked[i] && isTwoColor)
				dfs(g, i);
		}
	}
	
	/**
	 * ���� �µ�˫ɫ����: ��ȡ���ڽӵ�,��δ����,����ɫ�뵱ǰ���෴,�ݹ����,  
	 * 						    ���Ѿ�����,�ж���ɫ�Ƿ��뵱ǰ����ͬ,��ͬ���˫ɫ
	 * @param g
	 * @param v
	 */
	public void dfs(Graph g, int v) {
		marked[v] = true;
		for(int w : g.adj(v)) {
			if(!marked[w]) {
				color[w] = !color[v];
				dfs(g, w);
			}else if(color[w] == color[v]) {
				isTwoColor = false;
				return ;
			}
		}
	}
	
	public boolean isTwoColor() {
		return isTwoColor;
	}
	
}
