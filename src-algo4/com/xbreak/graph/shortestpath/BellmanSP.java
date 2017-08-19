package com.xbreak.graph.shortestpath;

import com.xbreak.fundamentals.three.XQueue;
import com.xbreak.fundamentals.three.XStack;

/**
 * bellman求加权有向边最短路径,可处理负权环
 * @author XBreak
 */
public class BellmanSP {
	private double[] distTo;
	private WeightDirectedEdge[] edgeTo;
	private boolean [] onQ;					//是否在队列中
	private XQueue<Integer> q;			//保存着当前将要relax 的顶点
	private int cost;					//relax的次数, 若cost%V == 0则有环
	private Iterable<WeightDirectedEdge> cycle; //环
	
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
