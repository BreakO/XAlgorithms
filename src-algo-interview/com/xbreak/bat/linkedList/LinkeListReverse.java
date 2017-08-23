package com.xbreak.bat.linkedList;

/**
 * 链表反转     https://leetcode.com/problems/reverse-linked-list/description/
 * 
 * 思路  : 需要三个指针   pre,cur,next  (初始从cur = head开始,  当next为空结束)  
 * 		把cur.next 指向pre,然后三个指针都前进一位, pre=cur, cur=next, next=next.next
 * 	当跳出循环时  next为空,cur.next也为空,需要把  cur.next指向pre  完成最后一步
 * 
 * @author XBreak
 */
public class LinkeListReverse {
	public Node reverse(Node head) {
		Node cur = head, pre , next;
	
		if(head == null || head.next == null)
			return head;
		
		
		// 1->2->3   
		pre = null;
		next = cur.next;
		while(next != null) {
			cur.next = pre;	    //2->1 ,  3->2
			pre = cur;			
			cur = next;		
			next = next.next;
		}
		cur.next = pre;
		return cur;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		 head.next= new Node(2);
		 head.next.next = new Node(3);
		
		Node res = new LinkeListReverse().reverse(head);
		System.out.println(res);
	}
}
