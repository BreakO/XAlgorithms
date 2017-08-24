package com.xbreak.bat.linkedList;

/**
 * �����ж��Ƿ��л�, �л������뻷��,�޻�����null
 * 		https://leetcode.com/submissions/detail/115266801/
 * ˼·:  ��������ָ��,��ָ��ÿ���߶���,��ָ��ÿ����һ��, ����ָ��Ϊnull����ʱ�޻�,  ���ָ������ָ������,���л�;
 * 			�뻷���ж�: ����һ��ָ���head��ʼ,��һ������ײ�㿪ʼ,����ͬʱÿ����һ��,����ʱ�����뻷��
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
