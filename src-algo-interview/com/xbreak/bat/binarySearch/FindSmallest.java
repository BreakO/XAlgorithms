package com.xbreak.bat.binarySearch;

/**
 * Ѱ�Ҿֲ���С
 * ��һ������,����Ԫ�����ظ��������в��Ҿֲ���С��Ԫ��
 * 
 * ˼·	: �ж������Ƿ���С,�����ж��м��Ƿ���С,
 * 			���м�-1 < �м����������,	���м�+1<�м������ұ���,  ���м��������,�����һ�߶�����, 
 * 			ֱ���м���С�����м�,������߽���ڵ����ұ߽�
 * 
 * @author XBreak
 */
public class FindSmallest {
	public int findSmall(int [] arr) {
		if(arr == null || arr.length == 0)
			return -1;
		
		int l = 0, r = arr.length-1;
		//�ų�������С
		if(arr.length == 1)
			return arr[0];
		else if(arr[0] < arr[1])
			return arr[0];
		else if(arr[r] < arr[r-1])
			return arr[r];
		
		int m;
		l++;
		r--;
		while(l <= r) {
			m = l + (r - l)/2;
			if(arr[m] < arr[m-1] && arr[m] < arr[m+1])
				return m;
			else if(arr[m] > arr[m-1])
				r = m;
			else if(arr[m] > arr[m+1])
				l = m;
		}
		return -1;
		
	}
	
	public static void main(String[] args) {
		int [] a={10,5,10,5,0,1,2,4,7,3,2,9,5,4,6,5,10,6,7,10,9,4,3,7,2,9,5,4,6,10};
		int res = new FindSmallest().findSmall(a);
		System.out.println(res);
	}
	
}
