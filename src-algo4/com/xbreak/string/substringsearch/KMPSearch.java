package com.xbreak.string.substringsearch;

import java.security.GeneralSecurityException;

/**
 * KMP�㷨 ʵ���ַ���ƥ��
 * 
 * ������Ƶ : http://v.youku.com/v_show/id_XODYxNjExODQ=.html (�� 34���ӿ�ʼ ) 
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
	 * 	nextֵ :   
	 * 			  i = 0, next = -1;
	 * 			  i = 1, next = 0;
	 * @return
	 */
	public void initNext() {
		next[0] = -1;			//����һ����ʶֵ, ��ƥ�䴮��������ֵʱ,˵��: ��ǰ׺�Ӵ���һλ,���׺�Ӵ��Ƚ϶�����ƥ��,˵��û�й����Ӵ�,nextȡ0
								
	
		int i = 0, j = -1;		//i�������,j�����
		while(i < pat.length()-1) { //i < pat.length()-1û������һλ���������,Ҳ��next[pat.length()]��ֵΪj,���û����
			/*
			 * j == -1 : ��ʼֵ�Լ�0λ���ϵ�ֵ,  j==-1�������� j=0,��j=0�뵱ǰpat[i],�Բ����,����,j,iָ���λ,next[i]=0;
			 * pat[i] == pat[j]     ǰ׺�Ӵ�==��׺�Ӵ�,j,i��λ,������ԭ��nextֵ�ϼ�һ
			 * 
			 * ������ƥ��,����j != -1,  ȡnext[j], ��������õ�nextֵ���㵱ǰ��next;
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
			 * �����������next��һ��:  
			 * 			  ���������ĵ�ǰֵƥ��ʱ
			 * 			  ���� Դ����ǰֵ,��Ŀ�괮��һλ��ƥ��ʱ,Դ����ǰֵ��λ��Ŀ�괮��λ�Ƚ�
			 * ��Ŀ�괮��Դ����ƥ��ʱ,��ȡĿ�괮��next, ��Դ��������,Ŀ�괮����
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
