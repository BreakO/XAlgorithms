package com.xbreak.bat.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 *  打印两个有序链表的公共部分
 * @author XBreak
 */
public class CommonOnList {
	class Node{
		int val;
		Node next;
		Node(int v) { val = v;}
	}
	List<Integer> getCommon(Node x, Node y){
		List<Integer> list  = new ArrayList<>();
		Node px  = x, py = y;
		while(px != null && py != null) {
			if(px.val < py.val)
				px = px.next;
			else if(px.val > py.val)
				py = py.next;
			else {
				list.add(px.val);
				px = px.next;
				py = py.next;
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		CommonOnList c = new CommonOnList();
		Node node1 = new CommonOnList().new Node(1);
		Node node2 = new CommonOnList().new Node(2);
		Node node3 = new CommonOnList().new Node(3);
		Node node4 = new CommonOnList().new Node(4);
		Node node22 = new CommonOnList().new Node(2);
		Node node23 = new CommonOnList().new Node(3);
		Node node24 = new CommonOnList().new Node(4);
		Node node25= new CommonOnList().new Node(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node22.next = node23;
		node23.next = node24;
		node24.next = node25;
		
		List<Integer> list = c.getCommon(node1, node22);
		System.out.println(list);
		
		
	}
}
