package com.xbreak.bat.sort;

/**
 * ��������ϲ�    https://leetcode.com/problems/merge-sorted-array/description/
 * @author XBreak
 */
public class Merge {
	/**
	 * �ϲ�A,B������������,�������A����
	 * 
	 * ˼· : ȷ������ָ��,�ֱ�Ӵ�С����A,B����, �Ƚ�����ָ��,�Ӻ���ǰ����A������
	 * 
	 * @param n,m  A������ʵ��С
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
