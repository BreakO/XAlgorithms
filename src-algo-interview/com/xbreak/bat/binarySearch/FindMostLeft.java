package com.xbreak.bat.binarySearch;

/**
 * 给定有序数组和一个数,找出出现这个数最左的位置, 若无返回-1
 * 
 * 思路	: 使用二分搜索, 若中间大于查找值则在左边,中间值小于查找值则在右边,否则中间值为查找值,保留其索引,在左边继续找,直到左边界大于右边界
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
