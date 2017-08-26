package com.xbreak.bat.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归遍历前中后序遍历二叉树,并装入二维数组
 * @author XBreak
 */
public class PrintBinaryTree {
	public List<Integer>[] print(TreeNode root){
		List<Integer>[] list = new List[3];
		for(int i=0; i < 3; i++)
			list[i] = new ArrayList<>();
		preOrderPrint(root, list[0]);
		inOrderPrint(root, list[1]);
		postOrderPrint(root, list[2]);
		return list;
	}
	public void preOrderPrint(TreeNode root, List<Integer> list) {
		
		if(root == null)
			return ;
		preOrderPrint(root.left, list);
		list.add(root.val);
		preOrderPrint(root.right, list);
	}
	public void inOrderPrint(TreeNode root, List<Integer> list) {
		
		if(root == null)
			return ;
		list.add(root.val);
		inOrderPrint(root.left, list);
		inOrderPrint(root.right, list);
	}
	public void postOrderPrint(TreeNode root, List<Integer> list) {
		
		if(root == null)
			return ;
		postOrderPrint(root.left, list);
		postOrderPrint(root.right, list);
		list.add(root.val);
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
		System.out.println(lists[0]);
		System.out.println(lists[1]);
		System.out.println(lists[2]);
	}
	
}
