package com.xbreak.searching.bst;

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
	
	public Key select(int k) {
		return null;
		
	}
	
	public int rank(Key key) {
		return 0;
		
	}
	public void deleteMin() {
		
	}
	
	public void delete(Key key) {
		
	}
	
	public Iterable<Key> keys() {
		return null;
		
	}
	
	public Iterable<Key> keys(Node left, Node right) {
		return null;
		
	}
	
	
}
