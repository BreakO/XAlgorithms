package com.xbreak.bat.linkedList;

/**
 * ɾ�����   : ���ܷ��ʸýڵ�ɾ���ýڵ�(���ýڵ���β���ڵ�,����false)
 * 			
 * ˼· : 
 * 		���Ǵ��м俪ʼ�Ѻ���Ľڵ�ֵ������ǰ��,���ǵ��м��Ǹ��ڵ��ֵ,���ɾ��ĩβ�Ǹ��ڵ�
 * ���ýڵ�Ϊ�շ���false, ���� ��������ָ��ǰָ��һǰһ��,ǰָ���p.next��ʼ,��ָ���p�ڵ㿪ʼ,���ǰ�ƶ�,
 * 			ֱ��ǰָ���nextΪ��,��ǰָ�뵱ǰΪβ��,��ǰָ���ֵ����ָ��,��ָ���nextΪ��,�������ڸ������м��Ǹ�Ҫɾ���Ľڵ�
 * @author XBreak
 */
public class RemoveNode {

	class Node{
		int val;
		Node next;
		public Node(int v) { val = v; }
	}
	
	public boolean removeNode(Node x) {
		if(x == null || x.next == null)	//Ϊβ���ڵ�
			return false;
		
		Node pre = x.next, back = x;	//ǰ��ָ��
		while(pre.next != null) {			//ֱ��ǰָ��Ϊĩ�ڵ�
			back.val = pre.val;
			back = pre;
			pre = pre.next;
		}
		back.val = pre.val;
		back.next = null;
		return true;
	}
	
}
