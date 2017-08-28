package com.xbreak.bat.bitOper;

/**
 * 找到数组中的出现奇数次的数,有两个
 * @author XBreak
 */
public class FindOddII {
	public int[] findOdd(int [] arr) {
		int num = 0;
		for(int i = 0; i<arr.length; i++) {
			num ^= arr[i];
		}
		// num = a ^ b   num中k为1,
		int temp = num;
		int k =0;
		while((num  & 1 )== 0) {  //从左往右,直到1位置上的数为1,即k位置
			num >>= 1;
			k++;
		}
		//把数组中所有数k为1的数 与 0异或
		int n = (int) Math.pow(2.0, (double)k);	// n 为k为1的数
		int num2 = 0;
		for(int i=0; i<arr.length; i++)
			if((arr[i] & n )== 1)	//k位上为1
				num2 &= arr[i];
		num ^= num2;	//
		return new int[] {num, num2};
	}
	public static void main(String[] args) {
		System.out.println(new FindOddII().findOdd(new int[] {0,1,2,3,4,4,2,1,0}));
	}
}
