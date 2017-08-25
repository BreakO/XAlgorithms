package com.xbreak.bat.binarySearch;

/**
 * �������ظ�����Ѱ�������ԭλ	(arr[i] == i)
 * 	
 * 	˼·: ��������	,����ָ�벻�ཻ,���м�ָ��Ϊԭλʱ��������������,�м�㲻��ԭλʱ���arr[m]<m ������, arr[m]>m������
 * 
 * @author XBreak
 */
public class FindOriginIndex {
	public int findOrigin(int [] arr) {
		if(arr == null)
			return -1;
		int l = 0, r = arr.length-1, mid, pos = -1; 
		while(l <= r) {
			mid = l + (r - l)/2;
			if(mid == arr[mid]) {
				pos = mid;
				r = mid - 1;
			}else if(mid > arr[mid]) {
				l = mid + 1;
			}else {
				r = mid - 1;
			}
		}
		return pos;
		
	}
	
	public static void main(String[] args) {
		int i = new FindOriginIndex().findOrigin(new int[] {0});
		System.out.println(i);
	}
	
}
