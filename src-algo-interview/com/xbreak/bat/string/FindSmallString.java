package com.xbreak.bat.string;

/**
 * 
 * 拼接最小字典序
 对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。

给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
	
测试样例：
["abc","de"],2
"abcde"


思路 : 使用快排进行排序,排序时比较的str1,str2不是单独比较,而是 比较str1+str2 与 str2+str1 顺序

 * @author XBreak
 */
public class FindSmallString {
	
	
	public String findSmallString(String [] arr) {
		quickSort(arr, 0, arr.length-1);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++)
			sb.append(arr[i]);
		return sb.toString();
	}
	
	public void quickSort(String [] arr, int lo, int hi) {
		if(lo >= hi)
			return ;
		int mid = partition(arr, lo, hi);
		
		quickSort(arr, lo, mid-1);
		quickSort(arr, mid+1, hi);
		
	}
	public int partition(String [] arr, int lo, int hi) {
		String v = arr[lo];
		int i=lo+1, j = hi;
		while(i < j) {
			
			while(less(arr[i]+v, v+arr[i])) { i++; if(i>=hi) break;	}  //循环直到 arr[i]+v > v+str[i]
			while(less(v+arr[j], arr[j]+v)) { j--;} ;				  //直到arr[j]+v < v+str[i]
			if(i >= j)
				break;
			exch(arr, i, j);
		}
		exch(arr, lo, j);
		return j;
	}
	/**
	 * @param s1
	 * @param s2
	 * @return true when s1<s2, or false when s1>=s2
	 */
	public boolean less(String s1, String s2) {
		
		return s1.compareTo(s2) < 0 ?true : false;
	}
	public void exch(String [] a, int i, int j) {
		String t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	public static void main(String[] args) {
		System.out.println(new FindSmallString().findSmallString(new String[] {"ab","a","ba","b","c","ca"}));
	}
}
