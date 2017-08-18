package com.xbreak.graph.undirectedgraph;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * ���� ���ѵ� ��ͨ����
 * @author XBreak
 */
public class CC {
	private boolean[] marked;
	private int[] id;	//��ʶ : id[v] = 1, ��ʶ v�����ڵ�һ����ͨ������
	private int count;	//�ܵ���ͨ������
	
	public CC(Graph g) {

		marked = new boolean[g.V()];
		id = new int[g.V()];
		for(int i = 0; i < g.V(); i++) {
			if(!marked[i]) {
				count++;
				dfs(g, i);
			}
		}
		
		
	}

	private void dfs(Graph g, int v) {

		marked[v] = true;
		id[v] = count;
		for(int w : g.adj(v))
			if(!marked[w])
				dfs(g, w);
			
	}
	
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}
	
	public int id(int v) {
		return id[v];
	}
	public int count() {
		return count;
	}
	
    public static void main(String[] args) {
        In in = new In("undigraph.txt");
        Graph G = new Graph(in);
        CC cc = new CC(G);

        // number of connected components
        int m = cc.count();
        StdOut.println(m + " components");

        // compute list of vertices in each connected component
        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
        for (int i = 0; i < m; i++) {
            components[i] = new Queue<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)-1].enqueue(v);
        }

        // print results
        for (int i = 0; i < m; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
    }
	
}
