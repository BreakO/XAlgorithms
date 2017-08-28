package com.xbreak.bat.binaryTree;

/**
 * �ж� �Ƿ�Ϊƽ�������
 * 
 * ˼· : ƽ�����������ڵ����ҽڵ�ĸ߶Ȳ� <=1;
 * 		���ú������, ��ȡ�����������ĸ߶�,���߶Ȳ�С��һ,��ýڵ�߶�Ϊ-1,
 * 			��������������һ���߶�Ϊ-1 �� ���Ҹ߶Ȳ����1,��ƽ�ⷵ��-1,
 * 			����ýڵ�ĸ߶�Ϊmax(���������߶�)+1;
 *      �����ڵ�߶� ��Ϊ-1,��Ϊƽ�������
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
