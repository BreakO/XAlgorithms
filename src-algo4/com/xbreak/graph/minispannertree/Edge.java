package com.xbreak.graph.minispannertree;

/**
 * 4.3.1 ÓÐÈ¨±ß
 * @author XBreak
 */
public class Edge implements Comparable<Edge>{

	private int v, w;
	private double weight;
	
	public Edge(int v, int w, double weight) {
		super();
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public double weight() {
		return weight;
	}
	
	public int either() {
		return v;
	}

	public int other(int s) {
		if(s == w)
			return v;
		else if(s == v)
			return w;
		else
			throw new RuntimeException(" unknow dot ");
	}
	
	@Override
	public int compareTo(Edge that) {
		// TODO Auto-generated method stub
		if(this.weight > that.weight)			return 1;
		else if(this.weight < that.weight)	 	return -1;
		else									return 0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%d - %d  %.2f", v, w, weight);
	}

}
