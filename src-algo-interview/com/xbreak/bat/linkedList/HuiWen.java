package com.xbreak.bat.linkedList;

/**
 * 判断链表是否回文
 * 
 * 	思路  : 预处理:先两个指针进行遍历链表,一个每次进一步,另一个每次进两步, 当快指针数组越界时,慢指针不走,这时慢指针就在数组中间
 * 		当链表节点数为偶数,则慢指针指向size/2-1, 为奇数时指向正中间
 *    然后把慢节点后面的节点全部逆序,最后从两头开始遍历链表
 * 
 * @author XBreak
 */
public class HuiWen {
	public boolean isHuiWen(Node head) {
		if(head == null || head.next == null)
			return false;
		Node one , two;
		one = two = head;
		while(two.next != null && two.next.next != null) {
			two = two.next.next;
			one = one.next;
		}
		
		//反转从one到末尾			链表反转参照@LinkeListReverse 类
		Node pre = null, cur = one, next = one.next;
		while(next != null) {
			cur.next = pre;
			pre = cur;
			cur = next;
			next = next.next;
		}
		cur.next = pre;			//原来是末尾的头结点
		//从两头开始一一比对
		Node h = head;
		while(cur != one) {
			if(h.val != cur.val)
				return false;
			h = h.next;
			cur = cur.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		 Node head = new Node(1);
		 head.next = new Node(2);
		 head.next.next = new Node(2);
		 head.next.next.next = new Node(1);
//		 head.next.next.next.next = new Node(2);
		 System.out.println(new HuiWen().isHuiWen(head));
	}
	
}
