package com.xbreak.graph.undirectedgraph;

import com.xbreak.fundamentals.three.XStack;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 深度优先搜索 : 获取路径
 * @author XBreak
 */
public class DepthFirstPaths {
	
	private int s;
	private boolean[] marked;
	private int [] edgeTo;		//到达该点的上一个顶点
	
	public DepthFirstPaths(Graph g, int v) {

		s = v;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		dfs(g, s);
	}
	
	public void dfs(Graph g, int v) {
		marked[v] = true;
		
		for(int w : g.adj(v))
			if(!marked[w]) {
				edgeTo[w] = v;
				dfs(g, w);
			}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		XStack<Integer> stack = new XStack<>();
		for(; v != s ; v = edgeTo[v])
			stack.push(v);
		stack.push(s);
		return stack;
	}
    public static void main(String[] args) {
        In in = new In("undigraph.txt");
        Graph G = new Graph(in);
        int s = Integer.parseInt("0");
        DepthFirstPaths dfs = new DepthFirstPaths(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (dfs.hasPathTo(v)) {
                StdOut.printf("%d to %d:  ", s, v);
                for (int x : dfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else        StdOut.print("-" + x);
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d:  not connected\n", s, v);
            }

        }
    }
	
}
