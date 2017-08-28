package com.xbreak.bat.binaryTree;

/**
 * �������ڵ��������
 * 
 * ˼· : �������,����������������������l,�Լ��������ϵ�������lm,  �ͷ���������������������r,�Լ��������ϵ�������rm
 * 			ȡl+r+1,rl,rm�е����ֵ���з���
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
