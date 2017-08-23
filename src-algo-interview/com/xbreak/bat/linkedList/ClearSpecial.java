package com.xbreak.bat.linkedList;

/**
 *  清除链表中的特定值   https://leetcode.com/problems/remove-linked-list-elements/description/
 * @author XBreak
 */
public class ClearSpecial {
	
	public Node clear(Node head, int k) {
		if(head == null)
			return null;
		Node x = head;
		Node pre = x;
		while(x != null) {
			if(x.val == k) {
				if(x == head) {
					head = x.next;
					x = x.next;
					pre = x;
				}else {
					pre.next = x.next;
					x = x.next;
				}
				
			}else {
				pre = x;
				x = x.next;
			}
			
		}
		
		return head;
	}
	
}
