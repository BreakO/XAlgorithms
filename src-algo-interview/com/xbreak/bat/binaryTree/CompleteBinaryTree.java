package com.xbreak.bat.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否为完全二叉树
 * 
 * 思路 : 利用广度优先遍历,当找到一个不含子节点,或者只含一个左子节点的节点时,其后序节点必须为叶子节点
 * 
 * @author XBreak
 */
public class CompleteBinaryTree {
	public boolean completeBinaryTree(TreeNode root) {
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		boolean flag = false;
		while(!q.isEmpty()) {
			TreeNode t = q.poll();
			if(t.left == null && t.right != null) 
				return false;
			else if((t.left != null && t.right == null ) || (t.left == null && t.right == null))
				flag = true;
			else if(flag && (t.left != null || t.right != null))
				return false;
			if(t.left != null)
				q.offer(t.left);
			if(t.right != null)
				q.offer(t.right);
		}
		
		return true;
	}
public boolean completeBinaryTreeII(TreeNode root) {
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
//		boolean flag = false;
		while(!q.isEmpty()) {
			TreeNode t = q.poll();
			if(t.left == null && t.right != null) 
				return false;
//			else if((t.left != null && t.right == null ) || (t.left == null && t.right == null))
//				flag = true;
//			else if(flag && (t.left != null || t.right != null))
//				return false;
			if(t.left != null)
				q.offer(t.left);
			if(t.right != null)
				q.offer(t.right);
			//当只有左子节点 或者 没有子节点时跳出, 判断后序节点是否为叶子节点
			if((t.left != null && t.right == null ) || (t.left == null && t.right == null))
				break;
		}
		while(!q.isEmpty()) {
			TreeNode t = q.poll();
			if(t.left != null || t.right != null)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		 TreeNode r = new TreeNode(1);
		 r.left = new TreeNode(2);
		 r.right = new TreeNode(3);
		 r.left.left = new TreeNode(4);
		 r.left.right = new TreeNode(5);
		 r.right.left = new TreeNode(6);
		 r.right.right = new TreeNode(7);
		 CompleteBinaryTree cb = new CompleteBinaryTree();
		System.out.println(cb.completeBinaryTree(r));
		System.out.println(cb.completeBinaryTreeII(r));
	}
	
}
