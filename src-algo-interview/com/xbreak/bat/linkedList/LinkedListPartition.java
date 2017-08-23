package com.xbreak.bat.linkedList;

import com.xbreak.bat.linkedList.ListKReverse.ListNode;

/**
 * 链表的分化
 * 
 * 比如  1-4-2-5   3   ==>   1-2-4-5
 * 
 * @author XBreak
 */
public class LinkedListPartition {
	public Node partition(Node head, int k) {
        if(head == null || head.next == null)
			return head;
		
		Node cur = head, small = null, big = null, h = null;
		while(cur != null) {
			if(cur.val < k) {
				if(small == null)
					head = small = cur;
				else{
                    small.next = cur;
                    small = cur;
                }
					
			}else {
				if(big == null)
					h = big = cur;
				else{
					big.next = cur;
                    big = cur;
                }
			}
			cur = cur.next;	
		}
		if(small != null)
			small.next = h;
		else
			head = h;
		return head;
	}
	
	public static void main(String[] args) {
		 Node head = new Node(2);
		 head.next = new Node(1);
//		 head.next.next =new ListKReverse(). new ListNode(3);
		new LinkedListPartition().partition(head, 2);
	}
}
