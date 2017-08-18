package com.xbreak.graph.minispannertree;

import com.xbreak.fundamentals.three.XQueue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * �ӳ�ʵ�ֵ� ���� Prim �㷨����С������
 * 	��ѡ����ĳ�㿪ʼ,��ȡ�ڽӱ߼�����С����,Ȼ���ȡ��С��,�ж��Ƿ������,����,������С����������ȡ�ڽӱ�,��������,ֱ������Ϊ��.
 * @author XBreak
 */
public class LazyPrimMST {
	private XQueue<Edge> mst ;
	private MinPQ<Edge> q;
	private boolean [] marked;
	private double weight;
	
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
			weight += e.weight();
			if(!marked[v]) {
				visit(g, v);
			}
			if(!marked[w]) {
				visit(g, w);
			}
		}
	
	}

	/**
	 * ��v����ڽӵ���й�����Ӳ���
	 * @param g
	 * @param v
	 */
	private void visit(EdgeWeightGraph g, int v) {
		marked[v] = true;
		for(Edge e : g.adj(v))
			if(!marked[e.other(v)])
				q.insert(e);
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
	
	public double weight() {
		return weight;
	}
	
    public static void main(String[] args) {
        In in = new In("ewg.txt");
        EdgeWeightGraph G = new EdgeWeightGraph(in);
        LazyPrimMST mst = new LazyPrimMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }
}
