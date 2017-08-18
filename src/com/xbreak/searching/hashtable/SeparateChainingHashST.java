package com.xbreak.searching.hashtable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.xbreak.fundamentals.three.XQueue;
import com.xbreak.searching.st.SequentialSearchST;
import com.xbreak.util.StdIn;

import edu.princeton.cs.algs4.StdOut;

/**
 *  基于 拉链法 的 散列表
 * @param <Key>
 * @param <Value>
 * @author XBreak
 */
public class SeparateChainingHashST<Key, Value> {
	
	private int M; 				    //散列表大小
	private SequentialSearchST<Key, Value>[] st;	//相当于二维数组
	
	public SeparateChainingHashST() {
		this(997);
	}
	
	public SeparateChainingHashST(int M) {

		this.M = M;
		st =(SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for(int i = 0; i < M; i++)
			st[i] = new SequentialSearchST<>();
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	private void put(Key key, Value val) {
		st[hash(key)].put(key, val);
	}
	
	private Value get(Key key) {
		return st[hash(key)].get(key);
	}
	
	public Iterable<Key> keys(){
		XQueue<Key> q = new XQueue<>();
		for(int i=0; i < M; i++)
			for(Key k : st[i].keys())
				q.enqueue(k);
		return q;
	}
    public static void main(String[] args) throws FileNotFoundException { 
    	StdIn.setScanner(new Scanner(new File("search.txt")));
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        // print keys
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s)); 

    }
}
