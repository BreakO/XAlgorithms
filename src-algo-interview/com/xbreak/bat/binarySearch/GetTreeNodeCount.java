package com.xbreak.bat.binarySearch;


/**
 * ��ȡ��ȫ�������Ľڵ���
 * 		https://leetcode.com/problems/count-complete-tree-nodes/description/
 * ˼·: �ҵ��������߶�(����Ҷ�ӵ���)h,���������߶�(����������Ҷ�ӵ��������ĸ�)r, 
 * 		�������߶Ȳ����,��������Ϊ�߶�r����������,������߶�
 * 		���߶����,��������Ϊ�߶�h����������,������߶�
 * 		�Դ�����,��ȡ���нڵ���
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
