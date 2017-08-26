package com.xbreak.bat.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * �ǵݹ�ǰ�к������������
 * 
 * ˼· : 
 * 	ǰ�� : ����ջ,�Ѹ�Ԫ����ջ,��ջ��Ԫ��,�鿴���������Ƿ�Ϊ�ղ�Ϊ�������������ѹջ,����ȡ��ջ��,��ӡջ��,������������Ϊ����ѹ��������,�Դ�����ֱ��ջ��
 * 	���� : ����ջ,�Ѹ�Ԫ����ջ,ȡ��ջ��,��ӡ,�鿴���������Ƿ�Ϊ�ղ�Ϊ�������������ѹջ,����������������Ϊ����ѹ��������,�Դ�����ֱ��ջ��
 * 	���� : ����ջ,�Ѹ�Ԫ����ջ,��ջ��Ԫ��,�鿴���������Ƿ�Ϊ�ղ�Ϊ�������������ѹջ,����������������Ϊ����ѹ��������,��������Ϊ����ȡ��ջ��,��ӡջ���Դ�����ֱ��ջ��
 * 
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
	
	private void preOrder(TreeNode root, List<Integer> list) {
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root); 
		TreeNode t = null;
		while( !stack.isEmpty()) {
			TreeNode treeNode = stack.peek();
			if(treeNode.left != null && t != treeNode.left)
				stack.push(treeNode.left);
			else {
				TreeNode p = stack.pop();
				
				t = p;
				list.add(p.val);
				if(p.right != null)
					stack.push(p.right);
			}
		}
		
	}
	private void inOrder(TreeNode root, List<Integer> list) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode p = stack.pop();
			list.add(p.val);
			if(p.left != null) {
				stack.push(p.left);
			}else {
				if(p.right != null)
					stack.push(p.right);
			}
		}
	}
	private void postOrder(TreeNode root, List<Integer> list) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode p = stack.peek();
			if(p.left != null) {
				stack.push(p.left);
			}else {
				if(p.right != null) {
					stack.push(p.right);
				}else {
					TreeNode treeNode = stack.pop();
					list.add(treeNode.val);
				}
					
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
		System.out.println(lists[0] + " *** " + listsII[1]);
		System.out.println(lists[0] + " *** " + listsII[2]);
	}
}
