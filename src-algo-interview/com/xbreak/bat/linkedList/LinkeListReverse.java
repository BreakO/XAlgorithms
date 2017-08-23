package com.xbreak.bat.linkedList;

/**
 * ����ת     https://leetcode.com/problems/reverse-linked-list/description/
 * 
 * ˼·  : ��Ҫ����ָ��   pre,cur,next  (��ʼ��cur = head��ʼ,  ��nextΪ�ս���)  
 * 		��cur.next ָ��pre,Ȼ������ָ�붼ǰ��һλ, pre=cur, cur=next, next=next.next
 * 	������ѭ��ʱ  nextΪ��,cur.nextҲΪ��,��Ҫ��  cur.nextָ��pre  ������һ��
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
