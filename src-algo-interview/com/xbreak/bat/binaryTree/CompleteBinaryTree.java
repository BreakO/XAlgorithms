package com.xbreak.bat.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �ж��Ƿ�Ϊ��ȫ������
 * 
 * ˼· : ���ù�����ȱ���,���ҵ�һ�������ӽڵ�,����ֻ��һ�����ӽڵ�Ľڵ�ʱ,�����ڵ����ΪҶ�ӽڵ�
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
			//��ֻ�����ӽڵ� ���� û���ӽڵ�ʱ����, �жϺ���ڵ��Ƿ�ΪҶ�ӽڵ�
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
