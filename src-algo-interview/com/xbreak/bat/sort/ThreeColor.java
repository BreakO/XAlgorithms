package com.xbreak.bat.sort;

import java.util.Arrays;

/**
 * 三色问题
 * 问题：有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
 * 给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
 * {0,1,1,0,2,2}, 6
 * 
 * 思路: 跟三切分的快排一样, 前指针l指向1序列首位, 后指针r指向末尾未遍历的数,i当前遍历指针
 * 		i指针前移,当遇到0,交换i,与l的值,i与l后移(i与l上的值依旧为1)
 * 				当遇到1, i与l后移
 * 				当遇到2,交换r,与i的值, r前移(此时r上的值为2),而i不后移(因为i上的值刚交换,不确定)
 * 
 * @author XBreak
 */
public class ThreeColor {
	/*
	{0,1,1,0,2,2}, 6
	*/
	public int[] sortThreeColor(int [] arr, int n){
		
		int l = 0,r = n-1,i = 0;      //i指向l序列首位
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
