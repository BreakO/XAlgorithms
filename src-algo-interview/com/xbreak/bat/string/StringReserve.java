package com.xbreak.bat.string;

/**
 * ��������
 * i am you  ==> you am i
 * ˼· : �Ȱ�������������, ������ÿ������
 * @author XBreak
 */
public class StringReserve {
	public String reserve(String str) {
		char [] a = str.toCharArray();
		int n = a.length;
		reserveS(a, 0, n);
		int i = 0, j = 0;
		while(i < n) {
			if(a[i] != ' ')
				i++;
			else {
				reserveS(a, j, i);
				i++;
				j = i;
			}
				
		}
		return new String(a);
		
	}
	
	public void reserveS(char[] a, int l, int r) {
		int i = l , j =r-1;
		while( i < j) {
			reserveArr(a, i, j);
			i++;
			j--;
		}
	}
	
	public void reserveArr(char[] a, int i, int j) {
		char t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void main(String[] args) {
		System.out.println(new StringReserve().reserve("i am you"));
	}
	
}
