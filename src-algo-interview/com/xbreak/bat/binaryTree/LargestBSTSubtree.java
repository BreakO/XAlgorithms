package com.xbreak.bat.binaryTree;

/**
 * 最大二叉搜索子树 X
 *
 * 思路 : 根据二叉搜索树的定义,每个节点的左节点都小于该节点,并且所有右节点都大于该节点
 * 		后序遍历 + 维护最大节点数,以及该节点,  
 * 			若左右节点为null, 或者左节点
 * 
 * @author XBreak
 */
public class LargestBSTSubtree {

	public TreeNode findLargestBST(TreeNode root) {
		
		postOrder(root);
		
		return temp;
	}
	TreeNode temp = null;		//最大的二叉搜索树
	int count = 0;				//最大节点数
	public Integer[] postOrder(TreeNode x) {
		if(x == null)
			return new Integer[] {null,0};
		Integer[] la = postOrder(x.left);
		Integer[] ra = postOrder(x.right);
		Integer lv = la[0], rv = ra[0];
		int lc = la[1], rc = ra[1];
		if((lv == null && rv == null) || ( rv == null && lv < x.val)) {	//若 左右为null,或 右节点为空,左子树最大小于根节点,符合搜索树
			if(temp == null )
				temp = x;
				
			return new Integer[] {x.val,lc+1+rc};
		}else if((lv == null && rv > x.val) || ((lv != null && rv != null) && (lv < x.val && rv > x.val))) {
			if(temp == null )
				temp = x;
			if(lc + 1 + rc > count || (lc+1+rc == count && x.val > temp.val)) {
				temp = x;
				count = lc + rc + 1;
			}
			return new Integer[] {rv, lc+1+rc};
		}else {
			
			if(la != null && lc >= count &&  (temp == null || lv > temp.val)) {
				temp = x.left;
				count = lc;
			}else if(ra != null && rc >= count &&  (temp == null || rv > temp.val)) {
				temp = x.right;
				count = rc;
			}
			int max = x.val;
			if(lv > max)
				max = lv;
			if(rv > max)
				max = rv;
			return new Integer[] {null, max};
		}
	}
	public static void main(String[] args) {
		TreeNode r = new TreeNode(4);
		 r.left = new TreeNode(2);
		 r.right = new TreeNode(6);
		 r.left.left = new TreeNode(9);
		 r.left.right = new TreeNode(3);
		 r.right.left = new TreeNode(5);
		 r.right.right = new TreeNode(7);
		 TreeNode treeNode = new LargestBSTSubtree().findLargestBST(r);
		 System.out.println(treeNode);
	}
}
