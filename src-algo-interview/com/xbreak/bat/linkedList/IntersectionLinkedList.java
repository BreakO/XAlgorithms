package com.xbreak.bat.linkedList;

/**
 * �ж������ཻ
 * @author XBreak
 */
public class IntersectionLinkedList {
    /**
     * �����ڵ������޻�
     * �� һ  ��a,b������������,�ж��Ƿ��л�
     * 	
     * @param headA
     * @param headB
     * @return
     */
    public Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null)
            return null;
        Node a = headA, b = headB;
        while(a != b){		//��������a == b,  ab�ཻ,����ab��Ϊnull
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        
       return a;
    }
    
    /**
     * �����ڵ������л������޻��Կ�
     * ���� ��ȡ��������ĳ���,Ȼ��ȷ����ͬ���ȵ����, ͬ���ݽ�,���鿴�Ƿ����,
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
