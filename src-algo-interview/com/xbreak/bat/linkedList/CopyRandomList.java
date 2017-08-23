package com.xbreak.bat.linkedList;

import com.xbreak.bat.linkedList.CopyRandomList.RandomListNode;

/**
 * 拷贝含有额外随机指针的数组    https://leetcode.com/submissions/detail/115128992/
 * 
 * 思路  : 首先复制原链表的每个节点到其下个节点,
 * 		 然后根据原链表的随机指针把拷贝节点节的随机指针指向原链表的随机指针的下一节点(随机指针指向的节点的拷贝)
 * 		 最后分离原链表和拷贝链表
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
