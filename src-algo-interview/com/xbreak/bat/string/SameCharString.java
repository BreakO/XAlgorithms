package com.xbreak.bat.string;

import java.util.Arrays;

/**
 * �жϱ��δ�,  �����ַ������г��ֵ��ַ������Լ�������ͬ��Ϊ���δ�    �� abbc abcb
 * 
 * ˼·   : hash��
 * @author XBreak
 */
public class SameCharString {
	public boolean isBianXingCi(String A, String B) {
		
		if(A == null && B== null)	return true;
		if((A == null && B!=null) || (A != null && B == null))  return false;
		if(A.length() != B.length())	return false;
		
		int [] a = new int[26];
		int [] b = new int[26];
		Arrays.fill(a, 0);
		Arrays.fill(b, 0);
		
		for(int i=0; i<A.length(); i++) {
			a[A.charAt(i)-'a']++;
			b[B.charAt(i)-'a']++;
		}
		for(int i=0; i<a.length ; i++) {
			if(a[i] != b[i])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new SameCharString().isBianXingCi("abcdaadc", "bacdcbad"));
	}
	
}
