package com.xbreak.bat.sort;

/**
 * 有序数组合并    https://leetcode.com/problems/merge-sorted-array/description/
 * @author XBreak
 */
public class Merge {
	/**
	 * 合并A,B两个有序数组,结果放在A数组
	 * 
	 * 思路 : 确定两个指针,分别从大到小遍历A,B数组, 比较两个指针,从后往前插入A数组中
	 * 
	 * @param n,m  A数组真实大小
	 * @return
	 */
	public int[] mergeAB(int[] nums1, int[] nums2, int m, int n) {
		
		int i = m+n , pa = m-1, pb = n-1;
		while(--i >= 0 ) {
			if(pa < 0)
				nums1[i] = nums2[pb--];
			else if(pb < 0)
				nums1[i] = nums1[pa--];
			else if(nums1[pa] < nums2[pb])
				nums1[i] = nums2[pb--];
			else
				nums1[i] = nums1[pa--];
		}
		return nums1;
	}
	
	public static void main(String[] args) {
		new Merge().mergeAB(new int [] {1}, new int [] {}, 1, 0);
		System.out.println();
	}
}
