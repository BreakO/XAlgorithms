package com.xbreak.graph.undirectedgraph;

import com.xbreak.fundamentals.three.XBag;

import edu.princeton.cs.algs4.In;

/**
 * 4.1 ����ͼ
 * @author XBreak
 */
public class Graph {
	private int V;				//����
	private int E;				//��
	private XBag<Integer>[] adj;	//�ڽӱ�
	
	public Graph(int V) {
		
		this.V = V;
		adj = new XBag[V];
		E = 0;
		for(int i = 0; i < V; i++) {
			adj[i] = new XBag<>();
		}
	}
	public Graph(In in) {
		this(in.readInt());
		int e = in.readInt();
		for(int i = 0; i < e; i++) {
			int v1 = in.readInt();
			int v2 = in.readInt();
			addEdge(v1,v2);
		}
		
	}
	/**
	 * ����������
	 * @param v1
	 * @param v2
	 */
	public void addEdge(int v1, int v2) {
		adj[v1].add(v2);
		adj[v2].add(v1);
		E++;
	}
	
	/**
	 *	��ȡĳ������ڽӱ�
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public int V() {
		return V;
	}
}
