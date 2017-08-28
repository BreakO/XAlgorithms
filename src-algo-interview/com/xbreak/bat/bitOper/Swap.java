package com.xbreak.bat.bitOper;

/**
 * 不使用额外空间交换整数
 * 使用异或
 * @author XBreak
 */
public class Swap {
	public void swap(int a, int b) {
		a = a ^ b;	
		b = a ^ b;    //b = (a ^ b) ^ b = a ^ (b ^ b) = a ^ 0 = a
		a = a ^ b;	  //a = (a ^ b) ^ a = b ^ (a ^ a) = b ^ 0 = b
	}
}
