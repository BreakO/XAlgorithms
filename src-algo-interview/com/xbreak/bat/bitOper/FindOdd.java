package com.xbreak.bat.bitOper;

/**
 *  Ѱ����������
 *  ���һ��������ֻ��һ���������������ҳ������
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
