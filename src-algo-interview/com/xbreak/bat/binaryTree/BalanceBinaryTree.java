package com.xbreak.bat.binaryTree;

/**
 * 判断 是否为平衡二叉树
 * 
 * 思路 : 平衡二叉树任意节点左右节点的高度差 <=1;
 * 		利用后序遍历, 获取左右两子树的高度,若高度差小于一,则该节点高度为-1,
 * 			若左右子树中右一个高度为-1 或 左右高度差大于1,则不平衡返回-1,
 * 			否则该节点的高度为max(左右子树高度)+1;
 *      若根节点高度 不为-1,则为平衡二叉树
 * 
 * @author XBreak
 */
public class BalanceBinaryTree {
	public  boolean isBalanceBinaryTree(TreeNode root) {
		
		if(getHeight(root) == -1)
			return false;
		else
			return true;
	}
	public int getHeight(TreeNode x) {
		if(x == null)
			return 0;
		int lh = getHeight(x.left);
		int rh = getHeight(x.right);
		if(lh == -1 || rh == -1)
			return -1;
		int res = lh - rh;
		if(Math.abs(res) > 1)
			return -1;
		else
			return (lh >= rh ? lh : rh) + 1;
			
	}
	
	public static void main(String[] args) {
		TreeNode r = new TreeNode(1); 
//		 r.left = new TreeNode(2);	
		 r.right = new TreeNode(3);
//		 r.left.left = new TreeNode(4); 
//		 r.left.right = new TreeNode(5);
//		 r.right.left = new TreeNode(6); 
		 r.right.right = new TreeNode(7);
		System.out.println(new BalanceBinaryTree().isBalanceBinaryTree(r));
	}
	
}
