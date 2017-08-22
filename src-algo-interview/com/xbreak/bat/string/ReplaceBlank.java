package com.xbreak.bat.string;

/**
 * 把字符串中的空格全部替换为 %20
 * 
 * 思路先计算空格数.然后从右到左替换
 * @author XBreak
 */
public class ReplaceBlank {
	public String replace(String str) {
		
		
		int sum = 0;
		for(int i=0; i<str.length(); i++)
			if(str.charAt(i) == ' ')
				sum++;
		char [] arr = new char[str.length() + sum*2];
		for(int i = str.length()-1, j=arr.length; i >=0; i--) {
			if(str.charAt(i) == ' ') {
				arr[--j] = '0';
				arr[--j] = '2';
				arr[--j] = '%';
			}else
				arr[--j] = str.charAt(i);
				
		}
		return new String(arr);
	}
	
	public static void main(String[] args) {
		System.out.println(new ReplaceBlank().replace("i am you"));
		System.out.println(new ReplaceBlank().replace("Hello  world"));
	}
}
