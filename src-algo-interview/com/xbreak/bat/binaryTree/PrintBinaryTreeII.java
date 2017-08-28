package com.xbreak.bat.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * �ǵݹ�ǰ�к������������
 * 
 * ˼· : 
 * @author XBreak
 */
public class PrintBinaryTreeII {
	
	public List<Integer>[] print(TreeNode root){
		
		List<Integer> [] arr = new ArrayList[3];
		for(int i=0; i<3; i++) {
			arr[i] = new ArrayList<>();
		}
		preOrder(root, arr[0]);
		inOrder(root, arr[1]);
		postOrder(root, arr[2]);
		return arr;
	}
	
	/**
	 * ˼· : ����һ��ջ, �ȰѸ��ڵ���ջ,��ջ��Ϊ��ȡ��ջ������ӡ,������������Ϊ��,��������ջ,������������Ϊ��,��������ջ, �Դ�����,ֱ��ջ��
	 * @param root
	 */
	private void preOrder(TreeNode root, List<Integer> list){
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while(!stack.isEmpty()) {
			TreeNode top = stack.pop();
			list.add(top.val);
			if(top.right != null)
				stack.push(top.right);
			if(top.left != null)
				stack.push(top.left);
			
		}
	}
	
	/**
	 * 
	 * ˼· : ά��һ��ջ��һ��curָ��, ��ʼʱcurΪroot, 	(
	 * 				����cur��Ϊ�հ�cur = cur.left,����cur��Ϊ��ʱcurѹջ,
	 * 				ֱ��curΪ��,ȡ��ջ��Ԫ��x,��cur��Ϊx.right,�ظ�ѹ��cur,
	 * 		��������,ֱ��ջ��,����curΪ��
	 * 
	 * @param root
	 * @param list
	 */
	public void inOrder(TreeNode root, List<Integer> list) {
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur= root;
		stack.push(cur);
		while(!stack.isEmpty() || cur != null) {
			
			if(cur != null ) {
				cur = cur.left;
				if(cur != null)
					stack.push(cur);
			}else {
				TreeNode t = stack.pop();
				list.add(t.val);
				cur = t.right;
				if(cur != null)
					stack.push(cur);
			}
		}
		
	}
	/**
	 * 
	 * ˼· : ά��һ��ջ,����outΪ��������Ľڵ�,topΪ��ǰջ���ڵ�(��������), 
	 * 		��ʼʱ���ڵ�ѹջ,outΪroot,�ж�top�ļ������:
	 * 			��top.left��Ϊ����out��Ϊtop�����Һ���,��top.left��ջ
	 * 			����, ��top.right��Ϊ��, out��Ϊtop���Һ���, ��top.right��ջ
	 * 			����, ��ջ��Ԫ�س�ջ,��ӡ������out;
	 * 
	 * @param root
	 * @param list
	 */
	public void postOrder(TreeNode root, List<Integer> list) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode cur, out = root;
		while(!stack.isEmpty()) {
			cur = stack.peek();
			if(cur.left != null && cur.left != out && cur.right != out) {
				stack.push(cur.left);
			}else if(cur.right != null && cur.right != out) {
				stack.push(cur.right);
			}else {
				out = stack.pop();
				list.add(out.val);
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode r = new TreeNode(1);
		 r.left = new TreeNode(2);
		 r.right = new TreeNode(3);
		 r.left.left = new TreeNode(4);
		 r.left.right = new TreeNode(5);
		 r.right.left = new TreeNode(6);
		 r.right.right = new TreeNode(7);
		 List<Integer>[] lists = new PrintBinaryTree().print(r);
		List<Integer>[] listsII = new PrintBinaryTreeII().print(r);
		System.out.println(lists[0] + " *** " + listsII[0]);
		System.out.println(lists[1] + " *** " + listsII[1]);
		System.out.println(lists[2] + " *** " + listsII[2]);
	}
}
