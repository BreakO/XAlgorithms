package com.xbreak.bat.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归前中后序遍历二叉树
 * 
 * 思路 : 
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
	 * 思路 : 利用一个栈, 先把根节点入栈,若栈不为空取出栈顶并打印,若其右子树不为空,右子树入栈,若其左子树不为空,左子树入栈, 以此类推,直至栈空
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
	 * 思路 : 维护一个栈和一个cur指针, 初始时cur为root, 	(
	 * 				则若cur不为空把cur = cur.left,并当cur不为空时cur压栈,
	 * 				直至cur为空,取出栈顶元素x,把cur设为x.right,重复压入cur,
	 * 		依次类推,直至栈空,并且cur为空
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
	 * 思路 : 维护一个栈,创建out为最近弹出的节点,top为当前栈顶节点(但不弹出), 
	 * 		初始时根节点压栈,out为root,判断top的几种情况:
	 * 			若top.left不为空且out不为top的左右孩子,把top.left入栈
	 * 			否则, 若top.right不为空, out不为top的右孩子, 把top.right入栈
	 * 			否则, 把栈顶元素出栈,打印并赋予out;
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
