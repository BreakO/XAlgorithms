package com.xbreak.searching.redblackbst;

/**
 * 3.3 ����� : 
 * 		�����ӽ�����2x�ڵ� ����һ��3x�ڵ�, �\������2-3���е���ͨ����
 * 	  - �����Ӿ�Ϊ ������
 * 	  - û��һ���ڵ�ͬʱ���������������� 
 * 	  - �Ǻ�ɫƽ���, �������ӵ����ڵ�ͨ�����\��������ͬ
 * @param <Key>
 * @param <Value>
 * @author XBreak
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
	
	public static final boolean RED = true;
	public static final boolean BLACK = false;
	
	private int N;
	private Node root;
	private class Node{
		Key key;
		Value val;
		Node left,right;
		boolean color;
		int N;
		public Node(Key key, Value val, int N, boolean color) {
			super();
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
	}
	public boolean isRed(Node x) {
		if(x == null)
			return false;
		return x.color;
	}
	public int size(Node x) {
		if(x == null)	return 0;
		return x.N;
	}
	/************ �����ص㺯�� : ����,����,��ɫ�任 ****************/
	/**
	 * ���� : ��һ����ɫ��������,ת��Ϊ������
	 * �����鱾�е�ͼ
	 * @param x
	 * @return
	 */
	private Node rotateLeft(Node x) {
		
		Node t = x.right;
		x.right = t.left;
		t.left = x;
		t.color = x.color;
		x.color = RED;
		t.N = x.N;
		x.N = size(x.left) + size(x.right) + 1;
		return t;
	}
	
	/**
	 * ����ת, ͬ��,����
	 * @param x
	 * @return
	 */
	private Node rotateRight(Node x) {
		
		Node t = x.left;
		x.left = t.right;
		t.right = x;
		t.color = x.color;
		x.color = RED;
		t.N = x.N;
		x.N = size(x.left) + size(x.right) + 1 ;
		return t;
	}
	private void flipColor(Node x) {
		x.color = RED;
		x.left.color = BLACK;
		x.right.color = BLACK;
	}
	
	
	/**
	 * ���� :
	 * 		���������,���������,�����������;
	 * 		Ȼ�����ƽ�����:  
	 * 			������Ϊ��,����Ϊ��,���������
	 * 			������Ϊ��,����������Ϊ��,���������ת
	 * 			���������ӽ�Ϊ��,�������ɫת��
	 *      �����½ڵ���
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val) {
		
	}
	
	private Node put(Node x, Key key, Value val) {
		if(x == null)	//�����������
			return new Node(key, val, 1, RED);
		int cmp = x.key.compareTo(key);
		if(cmp < 0)
			x.right = put(x.right, key, val);
		else if(cmp > 0)
			x.left = put(x.left, key, val);
		else
			x.val = val;
		
		//����ƽ��ת��
		if(!isRed(x.left) && isRed(x.right))
			rotateLeft(x);
		if(isRed(x.left) && isRed(x.left.left))
			rotateRight(x);
		if(isRed(x.left) && isRed(x.right))
			flipColor(x);
		
		x.N = 1 + size(x.left) + size(x.right);
		
		return x;
	}
	
}
