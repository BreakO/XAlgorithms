package com.xbreak.string.substringsearch;

import java.security.GeneralSecurityException;

/**
 * KMP算法 实现字符串匹配
 * 
 * 参照视频 : http://v.youku.com/v_show/id_XODYxNjExODQ=.html (第 34分钟开始 ) 
 * 		    + http://www.56.com/u28/v_NjAwMzA0ODA.html       
 * 
 * @author XBreak
 */
public class KMPSearch {
	
	private int [] next;
	private String pat;
	
	public KMPSearch(String pat) {
		this.pat = pat;
		next = new int[pat.length()];
		initNext();
	}
	
	/**
	 * 	next值 :   
	 * 			  i = 0, next = -1;
	 * 			  i = 1, next = 0;
	 * @return
	 */
	public void initNext() {
		next[0] = -1;			//设置一个标识值, 当匹配串遍历到该值时,说明: 拿前缀子串第一位,与后缀子串比较都不能匹配,说明没有公共子串,next取0
								
	
		int i = 0, j = -1;		//i不会回退,j会回退
		while(i < pat.length()-1) { //i < pat.length()-1没意义这一位就算是相等,也是next[pat.length()]的值为j,这个没意义
			/*
			 * j == -1 : 初始值以及0位置上的值,  j==-1的条件是 j=0,而j=0与当前pat[i],仍不相等,所以,j,i指针进位,next[i]=0;
			 * pat[i] == pat[j]     前缀子串==后缀子串,j,i进位,二者在原有next值上加一
			 * 
			 * 遇到不匹配,并且j != -1,  取next[j], 利用已求得的next值计算当前的next;
			 */
			if(j == -1 || pat.charAt(i)==pat.charAt(j) ) {   
				i++;
				j++;
				next[i] = j;
			}else
				j = next[j];
				
		}
	}
	
	public int search(String str) {
		int i=0, j=0;
		while(i < str.length()) {

			/*
			 * 进入的条件和next中一样:  
			 * 			  当两个串的当前值匹配时
			 * 			  或者 源串当前值,与目标串第一位不匹配时,源串当前值进位与目标串首位比较
			 * 当目标串与源串不匹配时,获取目标串的next, 即源串不回退,目标串回退
			 */
			
			if(j == -1 || str.charAt(i) == pat.charAt(j)) { 
				i++;
				j++;
				if(j == pat.length())
					return i - pat.length();
			}else {
				j = next[j];
			}
		}
		
		return -1;
	}
	
	public String getNext() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<next.length; i++)
			sb.append(next[i]+" ");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		KMPSearch kmp = new KMPSearch("ababcab");
		System.out.println(kmp.getNext());
		String src = "cabacababdababcdababcaababcabccc";
		int res = kmp.search(src);
		System.out.println(res);
		System.out.println(src.substring(res));
	}
	
}
