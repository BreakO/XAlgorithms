package com.xbreak.bat.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  对于一个二叉搜索树在其中寻找错误节点
 *  一个二叉搜索树两个节点调换了位置,找出这两个节点,
 *  
 *  思路 : 使用中序遍历二叉搜索树时,其值有序(从小到大),所以先中序遍历,然后查找出现降序的点
 *  		若降序有两处(12'74'5'63'8),被调换的点为第一处降序的第一个值, 和第二处降序的第二个值
 *  		若降序有一处(123'54'678),	则被调换点为相邻的点,交换降序的左右两值
 *  
 * @author XBreak
 */
public class FindFaultInBST {
	public int[] findFault(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		
		TreeNode x= null, v1 = null, v2=null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode cur = root;
		
		while(!stack.isEmpty() || cur != null) {
			if(cur != null) {
				cur = cur.left;
				if(cur != null)
					stack.push(cur);
			} else {
				cur = stack.pop();
				
				if(x == null)
					x = cur;
				else if(x.val > cur.val) {
					if(v1 == null) {
						v1 = x;
						v2 = cur;
					}else{
						v2 = cur;
						break;
					}
					x = cur;
				}else {
					x = cur;
				}
				
				list.add(cur.val);
				cur = cur.right;
				if(cur != null)
					stack.push(cur);
			}
		}
		
		return new int[] {v2.val, v1.val};
	}
	public int[] findFaultII(TreeNode root) {
		inOrder(root);
		
		return new int[] {v2, v1};
	}
	public Integer v1 = null,v2,pre = null;
	public void inOrder(TreeNode x) {
		if(x == null)
			return ;
		inOrder(x.left);
		Integer v = x.val;
		
		if(pre != null)
			if(pre > v)				//降序
				if(v1 == null) {	//第一处降序
					v1 = pre;
					v2 = v;
				}else
					v2 = v;
		
		pre = v;
		
		inOrder(x.right);
		
	}
	public static void main(String[] args) {
		TreeNode r = new TreeNode(4); //4
		 r.left = new TreeNode(2);	//2
		 r.right = new TreeNode(6);
		 r.left.left = new TreeNode(7); //1
		 r.left.right = new TreeNode(3);
		 r.right.left = new TreeNode(5); //5
		 r.right.right = new TreeNode(1);//7
		 int [] arr = new FindFaultInBST().findFaultII(r);
		System.out.println(arr[0]+"***"+arr[1]);
	}
}
