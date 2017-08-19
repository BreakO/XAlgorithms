package com.xbreak.searching.hashtable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.xbreak.fundamentals.three.XQueue;
import com.xbreak.util.StdIn;

import edu.princeton.cs.algs4.StdOut;

/**
 * 3.4 ��������̽���ɢ�б�
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
	 * ���� : ͨ��hashֵ�ҵ�һ��λ��,
	 * 			����ò�Ϊ��,��key��ͬ,�����ֵ; ����ͬ����ת���¸�λ�� ��(1+i)%M,�ٴ��ж�
	 * 			���Ϊ�������
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
	 * ���� : ͬ put,������ײ̽��
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
	 * ɾ�� : ɾ����Ӧ�öԺ�����ؽ������²���
	 * @param key
	 */
	public void delete(Key key) {
		if(get(key) == null)
			return ;
		int i = hash(key);
		while(!key.equals(keys[i]))
			i = (1 + i) % M;
		//����ʱ λ��i ��ΪҪɾ���ĵ�
		keys[i] = null;
		values[i] = null;
		
		//���²���������
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
	 * �����С : ����һ���µĶ���, �Ե�ǰ�����ڶ���������²���, Ȼ���Ƹ���ǰ����
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
