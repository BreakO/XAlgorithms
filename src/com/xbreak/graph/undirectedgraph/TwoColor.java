package com.xbreak.graph.undirectedgraph;

/**
 * 双色问题 : 邻接点间颜色不重复,且只有两种
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
	 * 深搜 下的双色问题: 获取其邻接点,若未遍历,则颜色与当前点相反,递归遍历,  
	 * 						    若已经遍历,判断颜色是否与当前点相同,相同则非双色
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
