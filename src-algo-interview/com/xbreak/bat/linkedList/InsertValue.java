package com.xbreak.bat.linkedList;

import java.util.Arrays;
import java.util.List;

/**
 * 在有序链表中插入值
 * @author XBreak
 */
public class InsertValue {
	class Node{
		int val;
		Node next;
		public Node(int v) { val = v; next = null; }
	}
	/**
	 * 给出两个数组,第一数组为有序链表值,第二个数组为链表的next坐标, 给定一个值value , 构造该链表 插入指定值,返回头部
	 * 
	 * @param list
	 * @param indexs
	 * @param value
	 * @return
	 */
	public Node insert(List<Integer> list, List<Integer> indexs, int k) {
		
		Node head = null, cur;
		if(list.isEmpty() || list == null)
			return null;
		int v = list.get(0);
		int n = indexs.get(0);
		head = new Node(v);
		head.next = head;
		cur = head;
		while(n != 0) {
			v = list.get(n);
			n = indexs.get(n);
			Node node = new Node(v);
			cur.next = node;
			cur = node;
		}
		cur.next = head;
		Node old = head;
		if(old != null)
			cur = old.next;
		while(cur !=head && cur != null) {
			if(old.val <= k && cur.val >= k) {
				Node t = new Node(k);
				old.next = t;
				t.next = cur;
				return head;
			}else {
				old = cur;
				cur = cur.next;
			}
			
		}
		// 当old指针与 cur都大于  或者都小于 k值时, 则插入到头结点与尾结点间,  若比头结点大,返回头结点,   否则返回新建结点,以维持有序
		Node a;
		a = new Node(k);
		a.next = head;
		old.next = a;
		if(head.val > k) 
			head = a;
			
		return head;
	}
	
	public static void main(String[] args) {
		InsertValue iv = new InsertValue();
		List l1 = Arrays.asList(1,2,3);
		List l2 = Arrays.asList(1,2,0);
		System.out.println(iv.insert(l1, l2, 0));
	}
	
	
}
