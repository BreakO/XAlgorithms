package com.xbreak.bat.binarySearch;

/**
 * 有序无重复数组寻找最左的原位	(arr[i] == i)
 * 	
 * 	思路: 二分搜索	,左右指针不相交,当中间指针为原位时保留继续向下找,中间点不是原位时如果arr[m]<m 向右找, arr[m]>m向左找
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
