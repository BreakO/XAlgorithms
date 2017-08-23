package com.xbreak.bat.linkedList;

import com.xbreak.bat.linkedList.ListKReverse.ListNode;

/**
 * K������    https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 * ��������K��һ���������,����k���Ĳ�����, 
 * 
 * ˼· : ��������ÿһ��,Ȼ��ƴ������
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
		            	ListNode t = cur.next;  //�ϵ�  ����
		            	
		               ListNode r =  reverse(first, cur.next);
		                if(pre == null)
		                    pre = head = r;
		                else
		                    pre.next = r;
		                while(r.next != null)	r = r.next;	//�Ƶ���β
		                pre = r;
		                first = t;
		                cur = t;
		                f = 0;
		            }else {
		            	cur = cur.next;
		            }
		        }
		        if(pre != null)    //���ⲻ����һ��ʱ�Ŀ�ָ��
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
