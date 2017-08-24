package com.xbreak.bat.linkedList;

/**
 * 链表判断是否有环, 有环返回入环点,无环返回null
 * 		https://leetcode.com/submissions/detail/115266801/
 * 思路:  创建快慢指针,快指针每次走二步,慢指针每次走一步, 当快指针为null跳出时无环,  或快指针与慢指针相遇,则有环;
 * 			入环点判定: 创建一个指针从head开始,另一个从碰撞点开始,两个同时每次走一步,相遇时便是入环点
 * 
 * @author XBreak
 */
public class LinkedListCycle {
    public Node detectCycle(Node head) {
        
        if(head == null || head.next == null)
            return null;
        Node quick = head, slow = head;
        while(quick.next !=null && quick.next.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow){
                
            	Node t = head;
                while(t != quick){
                    t = t.next;
                    quick = quick.next;
                }
                return t;
            }
        }
        
        return null;
    }
    

    
}
