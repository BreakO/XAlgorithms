package com.xbreak.graph.minispannertree;

import com.xbreak.fundamentals.three.XQueue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * 延迟实现的 基于 Prim 算法的最小生成树
 * 	从选定的某点开始,获取邻接边加入最小队列,然后获取最小边,判断是否遍历过,若否,加入最小树并遍历获取邻接边,依次类推,直至队列为空.
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
	 * 对v点的邻接点进行过滤入队操作
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
