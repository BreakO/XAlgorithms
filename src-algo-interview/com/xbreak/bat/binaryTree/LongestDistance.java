package com.xbreak.bat.binaryTree;

/**
 * 二叉树节点的最大距离
 * 
 * 思路 : 后序遍历,返回左子树到根的最大距离l,以及左子树上的最大距离lm,  和返回右子树到根的最大距离r,以及右子树上的最大距离rm
 * 			取l+r+1,rl,rm中的最大值进行返回
 * 
 * @author XBreak
 */
public class LongestDistance {
	public int findLongest(TreeNode root) {
		int[] arr = postOrder(root);
		
		return arr[1];
	}
	public int[] postOrder(TreeNode x) {
		if(x == null)
			return new int[] {0,0};
		int[] larr = postOrder(x.left);
		int[] rarr = postOrder(x.right);
		
		int l = larr[0], r = rarr[0];
		int lm = larr[1], rm = rarr[1];
		int max = l+r+1;
		if(max < lm)
			max = lm;
		if(max < rm)
			max = rm;
		return new int[] {l > r ? l+1: r+1,max};
		
		
	}
}
