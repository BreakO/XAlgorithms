package com.xbreak.bat.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 折纸问题   
 * 节点n为1： down
 * n 为2  ： down-down-up
   n为3   : down-down-up-down-down-up-up
   n为4   : down-down-up-down-down-up-up-down-down-down-up-up-down-up-up
    即根节点是down, 左节点为down,右节点为up的二叉树,使用二叉树的中序遍历,通过n设置遍历的层数,同down,up设定左右子树
 * @author XBreak
 */
public class FoldPaper {
	    public String[] foldPaper(int n) {
	        if(n <= 0)
	            return new String[]{};
	        inOrder(n, "down");
	        String [] ss = new String[list.size()];
	        list.toArray(ss);
	        ss[ss.length/2] = "down";	//root node is down
	        return ss;
	    }
		List<String> list = new ArrayList<String>();
	    public void inOrder(int n, String str){
	        if(n == 0)
	            return ;
	        inOrder(n-1, "down");
	        list.add(str);
	        inOrder(n-1, "up");
	    }
	public static void main(String[] args) {
		String[] foldPaper = new FoldPaper().foldPaper(2);
		for(int i =0; i<foldPaper.length; i++)
			System.out.print(foldPaper[i] + "-");
		System.out.println();
		 foldPaper = new FoldPaper().foldPaper(3);
		for(int i =0; i<foldPaper.length; i++)
			System.out.print(foldPaper[i] + "-");
		System.out.println();
		foldPaper = new FoldPaper().foldPaper(4);
		for(int i =0; i<foldPaper.length; i++)
			System.out.print(foldPaper[i] + "-");
		System.out.println();
	}
}
