package com.xbreak.bat.binarySearch;


/**
 * 获取完全二叉树的节点数
 * 		https://leetcode.com/problems/count-complete-tree-nodes/description/
 * 思路: 找到二叉树高度(最左叶子到根)h,和右子树高度(右子树最左叶子到右子树的根)r, 
 * 		若两个高度不相等,则右子树为高度r的满二叉树,计算其高度
 * 		若高度相等,则左子树为高度h的满二叉树,计算其高度
 * 		以此类推,获取所有节点数
 * 		
 * 
 * @author XBreak
 */
public class GetTreeNodeCount {
	public class TreeNode {
		public int val;
		public TreeNode left, right;
		public TreeNode(int val) {
			this.val = val;
		}
		
	}
	   public int countNodes(TreeNode root) {
	        int nodes = 0, height = countHeight(root);
	        while(root != null){
	            if(countHeight(root.right) == height - 1){
	                nodes += 1 << height;
	                root= root.right;
	            }
	            else{
	                nodes += 1 << height-1;
	                root = root.left;
	            }
	            height--;
	        }
	        return nodes;
	    }
	    
	    private int countHeight(TreeNode root){
	        if(root == null){
	            return -1;
	        }
	        else{
	            int height = -1;
	            while(root != null){
	                height++;
	                root = root.left;
	            }
	            return height;
	        }
	    }
}
