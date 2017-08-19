package com.xbreak.bat.intro;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * bat 1
 * leetcode    https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * 二叉树层级遍历
 * 
 * 思路 : 创建一个队列, 保存即将遍历的节点, 
 * 		设置三个个指针, last指针指向当前队列中最新添加的节点,end指针指向树最右的节点,cur为当前遍历的指针
 * 		初始时,根节点为end指针,加入队列, 若遇到end指针,则创建新的list,把原有的list加到大list中,更新end指针为last指针
 * 		直至队列为空;
 * 
 * @author XBreak
 */
public class BinaryTreeLevelOrder {
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	 class Solution {
		    public List<List<Integer>> levelOrder(TreeNode root) {
		       
		        List<List<Integer>> all = new LinkedList<List<Integer>>();
		        
		        Queue<TreeNode> q = new LinkedList<TreeNode>();
		        if(root != null)
		            q.offer(root);
		        LinkedList<Integer> list = new LinkedList<>();
		        TreeNode end = root, last = null;
		        while(!q.isEmpty()){
		            TreeNode cur = q.poll();
		            
		            list.add(cur.val);
		            if(cur.left != null){
		                q.offer(cur.left);
		                last = cur.left;
		            }
		            if(cur.right != null){
		                q.offer(cur.right);
		                last = cur.right;
		            }
		            if(end == cur){
		              all.add(list);
		              list  = new LinkedList<>();
		              end = last;
		            }
		        }
		        return all;  
		    }
	 }
}
