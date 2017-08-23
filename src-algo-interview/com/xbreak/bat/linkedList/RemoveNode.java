package com.xbreak.bat.linkedList;

/**
 * 删除结点   : 仅能访问该节点删除该节点(若该节点是尾部节点,返回false)
 * 			
 * 思路 : 
 * 		就是从中间开始把后面的节点值拷贝给前面,覆盖掉中间那个节点的值,最后删除末尾那个节点
 * 若该节点为空返回false, 否则 创建两个指针前指针一前一后,前指针从p.next开始,后指针从p节点开始,向后前移动,
 * 			直至前指针的next为空,即前指针当前为尾部,把前指针的值给后指针,后指针的next为空,这样等于覆盖了中间那个要删除的节点
 * @author XBreak
 */
public class RemoveNode {

	class Node{
		int val;
		Node next;
		public Node(int v) { val = v; }
	}
	
	public boolean removeNode(Node x) {
		if(x == null || x.next == null)	//为尾部节点
			return false;
		
		Node pre = x.next, back = x;	//前后指针
		while(pre.next != null) {			//直至前指针为末节点
			back.val = pre.val;
			back = pre;
			pre = pre.next;
		}
		back.val = pre.val;
		back.next = null;
		return true;
	}
	
}
