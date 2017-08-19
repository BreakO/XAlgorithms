package com.xbreak.graph.shortestpath;

import com.xbreak.fundamentals.three.XStack;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * Dijkstra算法 求加权有向图的最短路径
 * @author XBreak
 */
public class DijkstraSP {
	private double [] distTo;				// 最短距离   distTo[v] = 1.0 表示 s->v最短距离为1.0
	private WeightDirectedEdge [] edgeTo;	
	private IndexMinPQ<Double> pq;		    //小值优先队列, pq[v] = 0.5  表示 当前最短点为v,权值为0.5
	
	public DijkstraSP(WeightDirectedGraph g, int s) {

		distTo = new double[g.V()];
		edgeTo = new WeightDirectedEdge[g.V()];
		pq = new IndexMinPQ<>(g.V());
		
		for(int i = 0; i < g.V(); i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0.0;
		pq.insert(s, 0.0);
		while(!pq.isEmpty()) {
			
			relax(g, pq.delMin());
		}
		
		
	}
	
	/**
	 * 重点函数 : 顶点放松函数,
	 * 		 即: 遍历当前点的邻接边, 若 邻接点w 有 dist[w] > dist[v] + e.weight 则进行放松,插入或者更新
	 * @param g
	 * @param s
	 */
	public void relax(WeightDirectedGraph g, int s) {
		for(WeightDirectedEdge e : g.adj(s)) {
			int w = e.to();
			if(distTo[w] > distTo[s] + e.weight()) {
				edgeTo[w] = e;
				distTo[w] = distTo[s] + e.weight();
				if(pq.contains(w))
					pq.change(w, distTo[s] + e.weight());
				else
					pq.insert(w, distTo[s] + e.weight());
			}
		}
	}
	
	public double distTo(int v) {
		return distTo[v];
	}
	
	public boolean hasPathTo(int v) {
		return distTo(v) != Double.POSITIVE_INFINITY;
	}
	
	public Iterable<WeightDirectedEdge> pathTo(int s){
		
		if(!hasPathTo(s))
			return null;
		
		XStack<WeightDirectedEdge> stack = new XStack<>();
		for(WeightDirectedEdge e = edgeTo[s]; e != null; e = edgeTo[e.from()])
			stack.push(e);
		return stack;
	}
    public static void main(String[] args) {
        In in = new In("ewd.txt");
        WeightDirectedGraph G = new WeightDirectedGraph(in);
        int s = Integer.parseInt("0");

        // compute shortest paths
        DijkstraSP sp = new DijkstraSP(G, s);


        // print shortest path
        for (int t = 0; t < G.V(); t++) {
            if (sp.hasPathTo(t)) {
                StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
                for (WeightDirectedEdge e : sp.pathTo(t)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", s, t);
            }
        }
    }
}
