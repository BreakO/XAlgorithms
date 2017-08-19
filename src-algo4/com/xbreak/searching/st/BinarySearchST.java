package com.xbreak.searching.st;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.xbreak.fundamentals.three.XQueue;
import com.xbreak.util.StdIn;

import edu.princeton.cs.algs4.StdOut;

/**
 * 基于数组 的二分搜索树
 * @param <Key>
 * @param <Value>
 * @author XBreak
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] values;
	int N;
	
	public BinarySearchST() {
		this(100);
	}

	public BinarySearchST(int max) {

		keys = (Key[]) new Comparable[max];
		values = (Value[])new Object[max];
		N = 0;
	}
	
	/**
	 *  重点方法 : 求小于k的个数
	 * @param k
	 * @return 若存在k,则为k的为位置,即小于k的个数, 若不存在,则返回小于k的个数
	 */
	public int rank(Key k) {
		
		return rank(k,0,N-1);
		
	}
	public int rank(Key k,int lo, int hi) {
		if(lo > hi)		 //lo大于hi值,lo为小于k的个数
			return lo;
		int mid = lo + (hi - lo)/2;
		int cmp = k.compareTo(keys[mid]);
		if(cmp < 0)
			return rank(k,lo,mid-1);
		else if(cmp > 0)
			return  rank(k,mid+1, hi);
		else
			return mid;
	}
	
	public int size() {
		return N;
	}
	
	public void put(Key k, Value v) {
		int i = rank(k);
		//存在,更新
		if(i < N && keys[i].compareTo(k) == 0) {
			values[i] = v;
			return ;
		}
		//不存在,插入
		//把 不小于 k的值后移
		for(int j = N; j > i; j--) {
			keys[j] = keys[j-1];
			values[j] = values[j-1];
		}
		keys[i] = k;
		values[i] = v;
		N++;
	}
	
	public Value get(Key k) {
		int i = rank(k);
		if( i < N && keys[i].compareTo(k) == 0)
			return values[i];
		return null;
	}
	
	public Iterable<Key> keys() {
		XQueue<Key> q = new XQueue<>();
		for(int i= 0; i < N; i++)
			q.enqueue(keys[i]);
		return q;
	}
	
    public static void main(String[] args) throws FileNotFoundException { 
    	StdIn.setScanner(new Scanner(new File("search.txt")));
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
