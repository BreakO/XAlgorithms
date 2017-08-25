package com.xbreak.bat.binarySearch;

/**
 * �������������һ����,�ҳ���������������λ��, ���޷���-1
 * 
 * ˼·	: ʹ�ö�������, ���м���ڲ���ֵ�������,�м�ֵС�ڲ���ֵ�����ұ�,�����м�ֵΪ����ֵ,����������,����߼�����,ֱ����߽�����ұ߽�
 * 
 * @author XBreak
 */
public class FindMostLeft {
	
	public int findPos(int [] arr, int k) {
		
		if(arr == null)
			return -1;
		
		int pos = -1;
		int l = 0, r = arr.length;
		while(l <= r) {
			
			int m= l + (r-l)/2;
			if(arr[m] < k) {
				l = m+1;
			}else if(arr[m] > k) {
				r = m-1;
			}else {
				pos = m;
				r = m - 1;
			}
		}
		
		return pos;
	}
	public static void main(String[] args) {
		int pos = new FindMostLeft().findPos(new int[] { 1,4}, 3);
		System.out.println(pos);
	}
}
