package com.xbreak.bat.linkedList;

/**
 * 判断链表相交
 * @author XBreak
 */
public class IntersectionLinkedList {
    /**
     * 适用于单链表无环
     * 法 一  把a,b两个链表相连,判断是否有环
     * 	
     * @param headA
     * @param headB
     * @return
     */
    public Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null)
            return null;
        Node a = headA, b = headB;
        while(a != b){		//弹出条件a == b,  ab相交,或者ab都为null
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        
       return a;
    }
    
    /**
     * 适用于单链表有环或者无环皆可
     * 法二 获取两个链表的长度,然后确定相同长度的起点, 同步递进,若查看是否相等,
     * @param headA
     * @param headB
     * @return
     */
    public Node getIntersectionNode2(Node headA, Node headB) {
    	 
    	Node a = headA, b = headB;
        
        
        int d = getLen(a) - getLen(b);
        if(d > 0){
            a = headA;
            b= headB;
        }else{
             a = headB;
             b = headA;
         }
        d = Math.abs(d);
        while(d-- != 0)
           a = a.next;
        
       while(a!=null || b!=null){
           if(a == b)
               return a;
           a = a.next;
           b = b.next;
       }
       return null;
    }
    public int getLen(Node n){
        int sum = 0;
        while(n!= null){
            sum++;
            n = n.next;
        }
        return sum;
    }
    
}
