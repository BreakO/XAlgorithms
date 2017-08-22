package com.xbreak.bat.string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 相同拓扑结构树
 * https://www.nowcoder.com/questionTerminal/37d745f3968c408cbff261434ffe7c42?pos=2&orderByHotValue=0&done=0
 * 
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
	给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
	
	思路; 对两颗树序列化为字符串,然后进行字符串包含问题求解
	
 * @author XBreak
 */
public class SameTopologicalTree {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	    public boolean chkIdentical(TreeNode A, TreeNode B) {
	        
	        String sa = treeToString(A);
	        String sb = treeToString(B);
	        
	        return  containStr(sa, sb);
	        
	        
	    }
	    
	    public boolean containStr(String a, String b){
	        
	        int[] next = getNext(b);
	        int i = 0, j = 0;
	        while(i < a.length()){
	            if(j == -1 || a.charAt(i) == b.charAt(j)){
	                i++;
	                j++;
	                if(j == b.length())
	                    return true;
	            }else
	                j = next[j];
	        }
	        return false;
	        
	    }
	    
	    public int[] getNext(String pat){
	        
	        int len = pat.length();
	        int [] next = new int[len];
	        
	        next[0] = -1;
	        int i=0, j=-1;
	        while(i < len - 1){
	            if(j == -1 || pat.charAt(i) == pat.charAt(j)){
	                i++;
	                j++;
	                next[i] = j;
	            }else{
	                j = next[j];
	            }
	        }
	        return next;
	    }
	    
//	    //binary tree level order 
//	    public String treeToString(TreeNode x){
//	        
//	        Queue<TreeNode> q = new LinkedList<TreeNode>();
//	        StringBuilder sb = new StringBuilder();
//	        if(x != null)
//	        	q.offer(x);
//	       	 
//	        while(!q.isEmpty()){
//	            TreeNode t = q.poll();
//	            if(t.left != null)
//	                q.offer(t.left);
//	            
//	            if(t.right != null)
//	                q.offer(t.right);
//	            sb.append(t.val);
//	            
//	        }
//	        return sb.toString();
//	    }
	    public StringBuilder sb ;
	    public String treeToString(TreeNode x){
	    	
	    	sb = new StringBuilder();
	    	printTree(x);
	    	return sb.toString();
	    }
	    
	    public void printTree(TreeNode x) {
	    	if(x == null)
	    		return ;
	    	
	    	sb.append(x.val);
	    	if(x.left != null)
	    		printTree(x.left);
	    	else
	    		sb.append("#");
	    	if(x.right != null)
	    		printTree(x.right);
	    	else
	    		sb.append("#");
	    		
	    }
	public static void main(String[] args) {
		TreeNode root = new SameTopologicalTree().new TreeNode(1);
		TreeNode t2 =  new SameTopologicalTree().new TreeNode(2);
		TreeNode t3 =  new SameTopologicalTree().new TreeNode(3);
		TreeNode t4 =  new SameTopologicalTree().new TreeNode(4);
		TreeNode t5 =  new SameTopologicalTree().new TreeNode(5);
		TreeNode t6 =  new SameTopologicalTree().new TreeNode(6);
		TreeNode t7 =  new SameTopologicalTree().new TreeNode(7);
		root.left = t2;
		root.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		TreeNode t =  new SameTopologicalTree().new TreeNode(2);
		TreeNode t51 =  new SameTopologicalTree().new TreeNode(4);
		TreeNode t61 =  new SameTopologicalTree().new TreeNode(5);
		t.left = t51;
		t.right = t61;
		System.out.println(new SameTopologicalTree().chkIdentical(root, t));
	}
}
