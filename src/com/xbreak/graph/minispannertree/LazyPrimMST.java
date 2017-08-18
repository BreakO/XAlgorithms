package com.xbreak.graph.minispannertree;

import com.xbreak.fundamentals.three.XQueue;

import edu.princeton.cs.algs4.MinPQ;

/**
 * 延迟实现的 基于 Prim 算法的最小生成树
 * @author XBreak
 */
public class LazyPrimMST {
	private XQueue<Edge> mst ;
	private MinPQ<Edge> q;
	private boolean [] marked;
	
	public LazyPrimMST(EdgeWeightGraph g) {

		mst = new XQueue<>();
		q = new MinPQ<>();
		marked = new boolean[g.V()];
		
		//初始化 最小优先队列
		visit(g, 0);
		
		while(!q.isEmpty()) {
			Edge e = q.delMin();
			int v = e.either();
			int w = e.other(v);
			if(marked[v] && marked[w])		//若该边两个端点都被访问过了
				continue;
			//加入最小生成树
			mst.enqueue(e);
			if(!marked[v])
				visit(g, v);
			if(!marked[w])
				visit(g, w);
			
		}
	
	}

	/**
	 * 对v点的邻接点进行过滤入队操作
	 * @param g
	 * @param v
	 */
	private void visit(EdgeWeightGraph g, int v) {
		for(Edge e : g.adj(v))
			if(!marked[e.other(v)])
				q.insert(e);
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
	
}
