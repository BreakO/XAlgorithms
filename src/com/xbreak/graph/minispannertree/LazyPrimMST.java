package com.xbreak.graph.minispannertree;

import com.xbreak.fundamentals.three.XQueue;

import edu.princeton.cs.algs4.MinPQ;

/**
 * �ӳ�ʵ�ֵ� ���� Prim �㷨����С������
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
		
		//��ʼ�� ��С���ȶ���
		visit(g, 0);
		
		while(!q.isEmpty()) {
			Edge e = q.delMin();
			int v = e.either();
			int w = e.other(v);
			if(marked[v] && marked[w])		//���ñ������˵㶼�����ʹ���
				continue;
			//������С������
			mst.enqueue(e);
			if(!marked[v])
				visit(g, v);
			if(!marked[w])
				visit(g, w);
			
		}
	
	}

	/**
	 * ��v����ڽӵ���й�����Ӳ���
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
