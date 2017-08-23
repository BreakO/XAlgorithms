package com.xbreak.bat.linkedList;

import com.xbreak.bat.linkedList.CopyRandomList.RandomListNode;

/**
 * �������ж������ָ�������    https://leetcode.com/submissions/detail/115128992/
 * 
 * ˼·  : ���ȸ���ԭ�����ÿ���ڵ㵽���¸��ڵ�,
 * 		 Ȼ�����ԭ��������ָ��ѿ����ڵ�ڵ����ָ��ָ��ԭ��������ָ�����һ�ڵ�(���ָ��ָ��Ľڵ�Ŀ���)
 * 		 ������ԭ����Ϳ�������
 * 
 * @author XBreak
 */
public class CopyRandomList {
	  class RandomListNode {
		      int label;
		      RandomListNode next, random;
		      RandomListNode(int x) { this.label = x; }
	  }
		 
    public RandomListNode copyRandomList(RandomListNode head) {
        
        if(head == null)
            return null;
        RandomListNode x = head;
        
        // copy to next
        RandomListNode t;
        while(x != null){
            t = new RandomListNode(x.label);
            t.next = x.next;
            x.next = t;
            x = t.next;
        }
        // copy random pointer
        x = head;
        while(x != null){
            t  = x.next;
            if(x.random != null)
            t.random = x.random.next;
            x = t.next;
        }
        // bypass
        x = head;
        t = null;
        RandomListNode tHead = null;
        while(x != null){
            RandomListNode cur = x.next;
            if(tHead == null){
              tHead = cur;
              t = tHead;
            }else{
              t.next = cur;
              t = t.next;
            }
            if(cur.next != null)
                 x.next = cur.next;
            else
                break;
            x = x.next;
        }
        x.next = null;
        return tHead;
    }
    
    public static void main(String[] args) {
    	RandomListNode n = new CopyRandomList().new RandomListNode(-1);
    	RandomListNode n2 = new CopyRandomList().new RandomListNode(1);
    	n.next = n2;
    	n2.random = null;
    	n2.next = null;
    	n.random = null;
    			
		RandomListNode copyRandomList = new CopyRandomList().copyRandomList(n);
		System.out.println(copyRandomList);
	}
}
