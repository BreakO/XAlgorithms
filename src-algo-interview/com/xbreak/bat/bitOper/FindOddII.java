package com.xbreak.bat.bitOper;

/**
 * �ҵ������еĳ��������ε���,������
 * @author XBreak
 */
public class FindOddII {
	public int[] findOdd(int [] arr) {
		int num = 0;
		for(int i = 0; i<arr.length; i++) {
			num ^= arr[i];
		}
		// num = a ^ b   num��kΪ1,
		int temp = num;
		int k =0;
		while((num  & 1 )== 0) {  //��������,ֱ��1λ���ϵ���Ϊ1,��kλ��
			num >>= 1;
			k++;
		}
		//��������������kΪ1���� �� 0���
		int n = (int) Math.pow(2.0, (double)k);	// n ΪkΪ1����
		int num2 = 0;
		for(int i=0; i<arr.length; i++)
			if((arr[i] & n )== 1)	//kλ��Ϊ1
				num2 &= arr[i];
		num ^= num2;	//
		return new int[] {num, num2};
	}
	public static void main(String[] args) {
		System.out.println(new FindOddII().findOdd(new int[] {0,1,2,3,4,4,2,1,0}));
	}
}
