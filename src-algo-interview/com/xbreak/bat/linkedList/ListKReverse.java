package com.xbreak.bat.linkedList;

import com.xbreak.bat.linkedList.ListKReverse.ListNode;

/**
 * K组逆序    https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 * 将链表以K个一组进行逆序,不足k个的不逆序, 
 * 
 * 思路 : 单独逆序每一组,然后拼接起来
 * @author XBreak
 */
public class ListKReverse {
	   public class ListNode {
		    int val;
		    ListNode next;
		    ListNode(int x) { val = x; }
		}
		
		    public ListNode reverseKGroup(ListNode head, int k) {
		        if(k <= 1 || head == null || head.next == null)
		            return head;
		        int f = 0;
		        ListNode cur = head,pre =null, first = head ;
		        while(cur!= null){
		            if(++f == k){
		            	ListNode t = cur.next;  //断点  待续
		            	
		               ListNode r =  reverse(first, cur.next);
		                if(pre == null)
		                    pre = head = r;
		                else
		                    pre.next = r;
		                while(r.next != null)	r = r.next;	//移到队尾
		                pre = r;
		                first = t;
		                cur = t;
		                f = 0;
		            }else {
		            	cur = cur.next;
		            }
		        }
		        if(pre != null)    //避免不满足一组时的空指针
		        pre.next = first;
		        return head;
		        
		    }
		    public ListNode reverse(ListNode h, ListNode last){
		        
		        ListNode pre = null, cur = h, next = h.next;
		        while(next != last){
		            cur.next = pre;
		            pre = cur;
		            cur = next;
		            next = next.next;
		        }
		        cur.next = pre;
		        return cur;
		    }
		    
		    public static void main(String[] args) {
				 ListNode head =new ListKReverse(). new ListNode(1);
				 head.next = new ListKReverse().new ListNode(2);
				 head.next.next =new ListKReverse(). new ListNode(3);
				 ListNode kGroup = new ListKReverse().reverseKGroup(head, 2);
				 System.out.println(kGroup);
			}
		    
}
