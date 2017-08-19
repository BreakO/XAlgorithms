package com.xbreak.bat.intro;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * bat 1
 * leetcode    https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * �������㼶����
 * 
 * ˼· : ����һ������, ���漴�������Ľڵ�, 
 * 		����������ָ��, lastָ��ָ��ǰ������������ӵĽڵ�,endָ��ָ�������ҵĽڵ�,curΪ��ǰ������ָ��
 * 		��ʼʱ,���ڵ�Ϊendָ��,�������, ������endָ��,�򴴽��µ�list,��ԭ�е�list�ӵ���list��,����endָ��Ϊlastָ��
 * 		ֱ������Ϊ��;
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
