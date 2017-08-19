package com.xbreak.graph.shortestpath;

/**
 * 4.4.1 加权有向边
 * @author XBreak
 */
public class WeightDirectedEdge {
	private int v,w;
	private double weight;
	public WeightDirectedEdge(int v, int w, double weight) {
		super();
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int from() {
		return v;
	}
	public int to() {
		return w;
	}
	public double weight() {
		return weight;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%d -> %d : %.2f", v, w, weight);
	}
}
