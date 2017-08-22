package com.xbreak.bat.string;

/**
 * 
 * ƴ����С�ֵ���
 ����һ���������ַ������飬���ҵ�һ��ƴ��˳��ʹ����С�ַ���ƴ�ӳɵĴ��ַ��������п��ܵ�ƴ�����ֵ�����С�ġ�

����һ���ַ�������strs��ͬʱ�������Ĵ�С���뷵��ƴ�ӳɵĴ���
	
����������
["abc","de"],2
"abcde"


˼· : ʹ�ÿ��Ž�������,����ʱ�Ƚϵ�str1,str2���ǵ����Ƚ�,���� �Ƚ�str1+str2 �� str2+str1 ˳��

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
			
			while(less(arr[i]+v, v+arr[i])) { i++; if(i>=hi) break;	}  //ѭ��ֱ�� arr[i]+v > v+str[i]
			while(less(v+arr[j], arr[j]+v)) { j--;} ;				  //ֱ��arr[j]+v < v+str[i]
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
