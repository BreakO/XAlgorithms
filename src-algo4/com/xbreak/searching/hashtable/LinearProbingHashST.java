package com.xbreak.searching.hashtable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.xbreak.fundamentals.three.XQueue;
import com.xbreak.util.StdIn;

import edu.princeton.cs.algs4.StdOut;

/**
 * 3.4 基于线性探测的散列表
 * @author XBreak
 */
public class LinearProbingHashST<Key, Value> {
	private int M;
	private int N;
	private Key [] keys;
	private Value [] values;
	
	public LinearProbingHashST() {
		this(16);
	}
	
	public LinearProbingHashST(int cap) {
		M = cap;
		N = 0;
		keys = (Key [])new Object[cap];
		values = (Value [])new Object[cap];
	}
	
	public int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	/**
	 * 插入 : 通过hash值找到一个位置,
	 * 			如果该不为空,若key相同,则更新值; 若不同则跳转到下个位置 即(1+i)%M,再次判断
	 * 			如果为空则插入
	 * @param key
	 * @param val
	 */
	private void put(Key key, Value val) {
		
		if(N >= M/2)
			resize(2*M);
		int i ;
		for( i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if(keys[i].equals(key)) {
				values[i] = val;
				return ;
			}
				
		}
		keys[i] = key;
		values[i] = val;
		N++;
	}
	
	/**
	 * 查找 : 同 put,线性碰撞探测
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		for(int i = hash(key); keys[i] != null ; i = (i+1) % M) {
			if(keys[i].equals(key))
				return values[i];
		}
		return null;
	}
	
	/**
	 * 删除 : 删除后应该对后续族簇进行重新插入
	 * @param key
	 */
	public void delete(Key key) {
		if(get(key) == null)
			return ;
		int i = hash(key);
		while(!key.equals(keys[i]))
			i = (1 + i) % M;
		//跳出时 位置i 即为要删除的点
		keys[i] = null;
		values[i] = null;
		
		//重新插入后续族簇
		for(i = (i + 1) % M; keys[i] != null; i = (i + 1) % M) {
			Key k = keys[i]; 
			Value v = values[i];
			keys[i] = null;
			values[i] = null;
			put(k, v);
		}
		N--;
		if( N > 0 && N == M/8)
			resize(M/2);
		
	}
	
	public Iterable<Key> keys(){
		XQueue<Key> q =new XQueue<Key>();
		for(int i=0; i < M; i++) {
			if(keys[i] != null)
				q.enqueue(keys[i]);
		}
		return q;
	}
	
	/**
	 * 重设大小 : 创建一个新的对象, 对当前集合内对象进行重新插入, 然后复制给当前对象
	 * @param s
	 */
	private void resize(int s) {
		LinearProbingHashST<Key, Value> st = new LinearProbingHashST<>(s);
		for(int i = 0; i < M; i++) {
			if(keys[i] != null)
			st.put(keys[i], values[i]);
		}
		keys = st.keys;
		values = st.values;
		M  = st.M; 
	}
    public static void main(String[] args) throws FileNotFoundException { 
    	StdIn.setScanner(new Scanner(new File("search.txt")));
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        System.out.println(" size : "+st.N);
        
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s)); 
    }
}
