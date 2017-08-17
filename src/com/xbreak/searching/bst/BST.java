package com.xbreak.searching.bst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.xbreak.fundamentals.three.XQueue;
import com.xbreak.util.StdIn;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * 3.2 二叉搜索树
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
	 * 小于等于 Key 的最大值
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
	 * 先在左子树中找,直至找到不大于key的节点,然后往当前节点的右树找出小于key的节点,若有则为它,若无则为当前节点
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
		if(t != null)				//若右树中没有比key小的值,则为null
			return t;
		else
			return x;
		
	}
	
	/**
	 * 排名第k位置的键
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
	 *  小于key 的个数
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
	 * 递归遍历左子树,直至遇到空,返回其右子树     即遇到最小,把指向它的指针,指向其右子树, 更新遍历过的节点的size
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
	 * 任意删除 : 
	 * 		1. 先遍历子树查找是否含有该节点
	 * 		2. 找到该节点: 
	 * 				2.1只有一个子节点:若该节点无左节点(右节点) 则把指向节点的指针替换为其右节点(左节点)
	 * 				2.2有两个子节点: 找到其右子树中最小的节点,把指向该节点的指向指向最小节点,
	 * 							  2.2.1  最小节点左节点设为其左节点,最下节点的右节点设为其删除最下节点后的最右节点
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
			//2.1 只有一个子节点
			if(x.right == null)	return x.left;
			if(x.left == null)	return x.right;
			//2.2 有两个子节点
			Node t = x;					//保持指向当前节点的指针
			x = min(x.right);			//获取当前节点右子树最小值
			//2.2.1  最小节点左节点设为其左节点,最下节点的右节点设为其删除最下节点后的最右节点
			x.left = t.left;			
			x.right = deleteMin(t.right);
		}
		//更新size
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
	 * 范围查找 : 获取当前节点与 大小节点的比较结果,若大于最小进入左子树,若在大小节点间,该节点入队,若小于于大节点则在左子树中查找,
	 * 			即先遍历左子树,遍历该节点,遍历右子树
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
