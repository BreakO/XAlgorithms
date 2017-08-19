package com.xbreak.graph.shortestpath;

import com.xbreak.fundamentals.three.XQueue;
import com.xbreak.fundamentals.three.XStack;

/**
 * bellman���Ȩ��������·��,�ɴ���Ȩ��
 * @author XBreak
 */
public class BellmanSP {
	private double[] distTo;
	private WeightDirectedEdge[] edgeTo;
	private boolean [] onQ;					//�Ƿ��ڶ�����
	private XQueue<Integer> q;			//�����ŵ�ǰ��Ҫrelax �Ķ���
	private int cost;					//relax�Ĵ���, ��cost%V == 0���л�
	private Iterable<WeightDirectedEdge> cycle; //��
	
	public BellmanSP(WeightDirectedGraph g, int s) {

		distTo = new double[g.V()];
		edgeTo = new WeightDirectedEdge[g.V()];
		q = new XQueue<>();
		onQ = new boolean[g.V()];
		cost = 0;
		
		for(int i=0; i<g.V(); i++)
			distTo[i] = Double.POSITIVE_INFINITY;
		q.enqueue(s);
		distTo[s] = 0;
		while(!q.isEmpty() && !hasNegativeCycle()) {
			int v  = q.dequeue();
			onQ[v] = false;
			relax(g, v);
		}
	
	}
	
	public void relax(WeightDirectedGraph g, int v) {
		for(WeightDirectedEdge e : g.adj(v)) {
			int w = e.to();
			if(distTo[w] > distTo[v] + e.weight()) {
				
				distTo[w] =  distTo[v] + e.weight();
				edgeTo[w] = e;
				
				if(!onQ[w]) {
					onQ[w] = true;
					q.enqueue(w);
				}
					
				
			}
			if(cost++ % g.V() == 0)
				findNegativeCycle();
			
		}
	}

	private void findNegativeCycle() {

		//no to do
		
	}

	private boolean hasNegativeCycle() {
		// TODO Auto-generated method stub
		return cycle == null;
	}
	
}
