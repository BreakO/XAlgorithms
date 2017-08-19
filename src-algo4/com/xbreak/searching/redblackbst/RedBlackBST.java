package com.xbreak.searching.redblackbst;

/**
 * 3.3 红黑树 : 
 * 		红连接将两个2x节点 构成一个3x节点, 黒链接是2-3树中的普通连接
 * 	  - 红连接均为 左连接
 * 	  - 没有一个节点同时与两个红连接相连 
 * 	  - 是黑色平衡的, 即空连接到根节点通过的黒链接数相同
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
	/************ 三个重点函数 : 左旋,右旋,颜色变换 ****************/
	/**
	 * 左旋 : 将一条红色的右连接,转换为左连接
	 * 参照书本中的图
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
	 * 右旋转, 同上,左旋
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
	 * 插入 :
	 * 		遍历红黑树,存在则更新,不存在则插入;
	 * 		然后进行平衡操作:  
	 * 			若左链为黑,右链为红,则进行左旋
	 * 			若左链为红,左链的左链为红,则进行右旋转
	 * 			若左右链接皆为红,则进行颜色转换
	 *      最后更新节点数
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val) {
		
	}
	
	private Node put(Node x, Key key, Value val) {
		if(x == null)	//不存在则插入
			return new Node(key, val, 1, RED);
		int cmp = x.key.compareTo(key);
		if(cmp < 0)
			x.right = put(x.right, key, val);
		else if(cmp > 0)
			x.left = put(x.left, key, val);
		else
			x.val = val;
		
		//进行平衡转换
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
