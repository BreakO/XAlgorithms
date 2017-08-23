package com.xbreak.bat.linkedList;

/**
 * �ж������Ƿ����
 * 
 * 	˼·  : Ԥ����:������ָ����б�������,һ��ÿ�ν�һ��,��һ��ÿ�ν�����, ����ָ������Խ��ʱ,��ָ�벻��,��ʱ��ָ����������м�
 * 		������ڵ���Ϊż��,����ָ��ָ��size/2-1, Ϊ����ʱָ�����м�
 *    Ȼ������ڵ����Ľڵ�ȫ������,������ͷ��ʼ��������
 * 
 * @author XBreak
 */
public class HuiWen {
	public boolean isHuiWen(Node head) {
		if(head == null || head.next == null)
			return false;
		Node one , two;
		one = two = head;
		while(two.next != null && two.next.next != null) {
			two = two.next.next;
			one = one.next;
		}
		
		//��ת��one��ĩβ			����ת����@LinkeListReverse ��
		Node pre = null, cur = one, next = one.next;
		while(next != null) {
			cur.next = pre;
			pre = cur;
			cur = next;
			next = next.next;
		}
		cur.next = pre;			//ԭ����ĩβ��ͷ���
		//����ͷ��ʼһһ�ȶ�
		Node h = head;
		while(cur != one) {
			if(h.val != cur.val)
				return false;
			h = h.next;
			cur = cur.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		 Node head = new Node(1);
		 head.next = new Node(2);
		 head.next.next = new Node(2);
		 head.next.next.next = new Node(1);
//		 head.next.next.next.next = new Node(2);
		 System.out.println(new HuiWen().isHuiWen(head));
	}
	
}
