package com.xbreak.searching.st;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

import com.xbreak.fundamentals.three.XQueue;
import com.xbreak.util.StdIn;

import edu.princeton.cs.algs4.StdOut;

/**
 * 3.1 基于 链表 的顺序查找符号表
 * @author XBreak
 */
public class SequentialSearchST<Key,Value> {
	private Node frist;
	class Node {
		Key k;
		Value v;
		Node n;
		public Node(Key k, Value v, SequentialSearchST<Key, Value>.Node n) {
			super();
			this.k = k;
			this.v = v;
			this.n = n;
		}
		
	}
	
	/**
	 * 顺序查找
	 * @param k
	 * @return
	 */
	public Value get(Key k) {
		Node t = frist;
		while(t != null) {
			if(t.k.equals(k))
				return t.v;
			t = t.n;
		}
		return null;
			
	}
	/**
	 * 插入到表头
	 * @param k
	 * @param v
	 */
	public void put(Key k, Value v) {
		for(Node t=frist; t != null; t = t.n) {
			if(t.k.equals(k)) {
				t.v = v;
				return ;
			}
		}
		//如果找不到, 插入到表头
		frist = new Node(k,v,frist);
	}
	
	public  Iterable<Key> keys() {
		XQueue<Key> q = new XQueue<Key>();
		for(Node t = frist; t!=null; t = t.n)
			q.enqueue(t.k);

		return q;
	}
	
    public static void main(String[] args) throws FileNotFoundException {
    	StdIn.setScanner(new Scanner(new File("search.txt")));
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
        	System.out.println(s + " " + st.get(s));
    }
	
}
