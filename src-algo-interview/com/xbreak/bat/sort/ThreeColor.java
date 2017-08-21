package com.xbreak.bat.sort;

import java.util.Arrays;

/**
 * ��ɫ����
 * ���⣺��һ��ֻ��0��1��2����Ԫ�ع��ɵ��������飬��ʹ�ý�����ԭ�����������ʹ�ü�����������
 * ����һ��ֻ��0��1��2����������A�����Ĵ�С���뷵�����������顣��֤�����СС�ڵ���500��
 * {0,1,1,0,2,2}, 6
 * 
 * ˼·: �����зֵĿ���һ��, ǰָ��lָ��1������λ, ��ָ��rָ��ĩβδ��������,i��ǰ����ָ��
 * 		iָ��ǰ��,������0,����i,��l��ֵ,i��l����(i��l�ϵ�ֵ����Ϊ1)
 * 				������1, i��l����
 * 				������2,����r,��i��ֵ, rǰ��(��ʱr�ϵ�ֵΪ2),��i������(��Ϊi�ϵ�ֵ�ս���,��ȷ��)
 * 
 * @author XBreak
 */
public class ThreeColor {
	/*
	{0,1,1,0,2,2}, 6
	*/
	public int[] sortThreeColor(int [] arr, int n){
		
		int l = 0,r = n-1,i = 0;      //iָ��l������λ
		while(i < r){
		
			if(arr[i] == 0){
			    exch(arr, l++, i++);
			}
			else if(arr[i] == 2)
				exch(arr, i, r--);
			else
			    i++;
		
		}
		return arr;
		
	}
	public void exch(int [] arr, int i, int j){
	    if(arr[i] == arr[j])
			return ;
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	public static void main(String[] args) {
		int[] res = new ThreeColor().sortThreeColor(new int[] {0,1,1,0,2,2}, 6);
		System.out.println(Arrays.toString(res));
	}
}
