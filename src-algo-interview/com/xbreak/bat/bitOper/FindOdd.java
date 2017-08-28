package com.xbreak.bat.bitOper;

/**
 *  寻找奇数出现
 *  如果一个数组中只有一个数出现奇数次找出这个数
 * @author XBreak
 */
public class FindOdd {
	public int findOdd(int [] arr) {
		int num = 0;
		for(int i = 0; i<arr.length; i++) {
			num ^= arr[i];
		}
		return num;
	}
	public static void main(String[] args) {
		System.out.println(new FindOdd().findOdd(new int[] {0,1,2,3,4,4,2,1,0}));
	}
}
