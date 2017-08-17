package com.xbreak.searching.bst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.xbreak.fundamentals.three.XQueue;
import com.xbreak.util.StdIn;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * 3.2 ����������
 * @param <Key>
 * @param <Value>
 * @author XBreak
 */
public class BST<Key extends Comparable<Key>, Value> {
	
	private Node root;
	class Node{
		private Key key;
		private Value value;
		private Node right,left;
		private int size;			//the number of the subtree
		public Node(Key key, Value value, int size) {
			super();
			this.key = key;
			this.value = value;
			this.size = size;
		}
		
	}
	
	public int size() {
		return size(root);
	}

	public int size(Node node) {
		if(node == null)
			return 0;
		return node.size;
	}
	
	public void put(Key key, Value val) {
		root = put(root,key,val);
	}
	public Node put(Node node , Key key, Value val) {
		if(node == null)
			return new Node(key,val,1);
		int cmp = node.key.compareTo(key);
		if(cmp < 0)
			node.right = put(node.right,key,val);
		else if(cmp > 0)
			node.left = put(node.left, key, val);
		else
			node.value = val;
		node.size = size(node.left) + size(node.right) + 1;
		return node;
	}
	
	public Value get(Key key) {
		return get(root,key);
	}
	
	public Value get(Node x, Key key) {
		if(x == null) 
			return null;
		int cmp = x.key.compareTo(key);
		if(cmp < 0)
			return get(x.right, key);
		else if(cmp >0)
			return get(x.left, key);
		else
			return x.value;
	}
	
	public Key min() {
		Node n = min(root);
		if(n == null)
			return null;
		else
			return n.key;
	}
	
	public Node min(Node x) {
		if(x == null)
			return null;
		if(x.left != null)
			return min(x.left);
		return x;
			
	}
	
	public Key max() {
		Node x = max(root);
		if(x == null)
			return null;
		else
			return x.key;
	}
	public Node max(Node x) {
		if(x == null)
			return null;
		if(x.right != null)
			return max(x.right);
		else
			return x;
	}
	
	/**
	 * С�ڵ��� Key �����ֵ
	 * @param key
	 * @return
	 */
	public Key floor(Key key) {
		Node n = floor(root, key);
		if(n == null)	
			return null;
		else			
			return n.key;
	}
	/**
	 * ��������������,ֱ���ҵ�������key�Ľڵ�,Ȼ������ǰ�ڵ�������ҳ�С��key�Ľڵ�,������Ϊ��,������Ϊ��ǰ�ڵ�
	 * @param x
	 * @param key
	 * @return
	 */
	public Node floor(Node x, Key key) {
		if(x == null)
			return null;
		int cmp = x.key.compareTo(key);
		if(cmp == 0)
			return x;
		else if(cmp > 0)
			return floor(x.left,key);
		
		Node t = floor(x.right,key);
		if(t != null)				//��������û�б�keyС��ֵ,��Ϊnull
			return t;
		else
			return x;
		
	}
	
	/**
	 * ������kλ�õļ�
	 * @param k
	 * @return
	 */
	public Key select(int k) {
		Node n = select(root,k);
		if(n == null)
			return null;
		else
			return n.key;
	}
	
	private Node select(Node x, int k) {
		if(x == null)
			return null;
		int s = size(x.left);
		if(s == k)
			return x;
		else if(s < k)
			return select(x.right,k-s-1);
		else 
			return select(x.left,k);
	}
	
	public int rank(Key key) {
		return rank(root, key);
		
	}
	/**
	 *  С��key �ĸ���
	 * @param x
	 * @param key
	 * @return
	 */
	private int rank(Node x, Key key) {
		if(x == null)
			return 0;
		int cmp = x.key.compareTo(key);
		if(cmp < 0)
			return size(x.left) + 1 + rank(x.right,key);
		else if(cmp > 0)
			return rank(x.left,key);
		else
			return size(x.left) ;
	}
	public void deleteMin() {
		root = deleteMin(root);
	}
	/**
	 * �ݹ����������,ֱ��������,������������     ��������С,��ָ������ָ��,ָ����������, ���±������Ľڵ��size
	 * @param x
	 * @return
	 */
	private Node deleteMin(Node x) {
		if(x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void delete(Key key) {
		root = delete(root, key);
	}
	/**
	 * ����ɾ�� : 
	 * 		1. �ȱ������������Ƿ��иýڵ�
	 * 		2. �ҵ��ýڵ�: 
	 * 				2.1ֻ��һ���ӽڵ�:���ýڵ�����ڵ�(�ҽڵ�) ���ָ��ڵ��ָ���滻Ϊ���ҽڵ�(��ڵ�)
	 * 				2.2�������ӽڵ�: �ҵ�������������С�Ľڵ�,��ָ��ýڵ��ָ��ָ����С�ڵ�,
	 * 							  2.2.1  ��С�ڵ���ڵ���Ϊ����ڵ�,���½ڵ���ҽڵ���Ϊ��ɾ�����½ڵ������ҽڵ�
	 * @param x
	 * @param key
	 * @return
	 */
	private Node delete(Node x, Key key) {
		if(x == null)
			return null;
		// 1. 
		int cmp = x.key.compareTo(key);
		if(cmp > 0)
			x.left = delete(x.left,key);
		else if(cmp < 0)
			x.right = delete(x.right,key);
		else {
			//2.
			//2.1 ֻ��һ���ӽڵ�
			if(x.right == null)	return x.left;
			if(x.left == null)	return x.right;
			//2.2 �������ӽڵ�
			Node t = x;					//����ָ��ǰ�ڵ��ָ��
			x = min(x.right);			//��ȡ��ǰ�ڵ���������Сֵ
			//2.2.1  ��С�ڵ���ڵ���Ϊ����ڵ�,���½ڵ���ҽڵ���Ϊ��ɾ�����½ڵ������ҽڵ�
			x.left = t.left;			
			x.right = deleteMin(t.right);
		}
		//����size
		x.size = size(x.left) + size(x.right) + 1;
		return x;
		
	}
	public Iterable<Key> keys() {
		
		return keys(min(),max());
	}
	
	public Iterable<Key> keys(Key lo, Key hi) {
		XQueue<Key> q = new XQueue<>();
		keys(root,q,lo,hi);
		
		return q;
	}
	
	/**
	 * ��Χ���� : ��ȡ��ǰ�ڵ��� ��С�ڵ�ıȽϽ��,��������С����������,���ڴ�С�ڵ��,�ýڵ����,��С���ڴ�ڵ������������в���,
	 * 			���ȱ���������,�����ýڵ�,����������
	 * @param x
	 * @param q
	 * @param lo
	 * @param hi
	 */
	private void keys(Node x, XQueue<Key> q,Key lo, Key hi){
		
		if(x == null)
			return ;
		int cmplo = x.key.compareTo(lo);
		int cmphi = x.key.compareTo(hi);
		if(cmplo > 0)
			keys(x.left,q,lo,hi);
		if(cmplo >= 0 && cmphi <= 0)
			q.enqueue(x.key);
		if(cmphi < 0)
			keys(x.right,q,lo,hi);
			
		
	}
    public static void main(String[] args) throws FileNotFoundException { 
    	
    	StdIn.setScanner(new Scanner(new File("search.txt")));
    	
        BST<String, Integer> st = new BST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
