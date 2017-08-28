package com.xbreak.bat.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ֽ����   
 * �ڵ�nΪ1�� down
 * n Ϊ2  �� down-down-up
   nΪ3   : down-down-up-down-down-up-up
   nΪ4   : down-down-up-down-down-up-up-down-down-down-up-up-down-up-up
    �����ڵ���down, ��ڵ�Ϊdown,�ҽڵ�Ϊup�Ķ�����,ʹ�ö��������������,ͨ��n���ñ����Ĳ���,ͬdown,up�趨��������
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
