package com.xbreak.bat.bitOper;

/**
 * ��ʹ�ö���ռ佻������
 * ʹ�����
 * @author XBreak
 */
public class Swap {
	public void swap(int a, int b) {
		a = a ^ b;	
		b = a ^ b;    //b = (a ^ b) ^ b = a ^ (b ^ b) = a ^ 0 = a
		a = a ^ b;	  //a = (a ^ b) ^ a = b ^ (a ^ a) = b ^ 0 = b
	}
}
