package com.xbreak.bat.binarySearch;

/**
 * 寻找局部最小
 * 在一个无序,相邻元素无重复的数组中查找局部最小的元素
 * 
 * 思路	: 判断两边是否最小,否则判断中间是否最小,
 * 			若中间-1 < 中间则在左边找,	若中间+1<中间则在右边找,  若中间大于两边,则随便一边都可以, 
 * 			直到中间最小返回中间,或者左边界大于等于右边界
 * 
 * @author XBreak
 */
public class FindSmallest {
	public int findSmall(int [] arr) {
		if(arr == null || arr.length == 0)
			return -1;
		
		int l = 0, r = arr.length-1;
		//排除两边最小
		if(arr.length == 1)
			return arr[0];
		else if(arr[0] < arr[1])
			return arr[0];
		else if(arr[r] < arr[r-1])
			return arr[r];
		
		int m;
		l++;
		r--;
		while(l <= r) {
			m = l + (r - l)/2;
			if(arr[m] < arr[m-1] && arr[m] < arr[m+1])
				return m;
			else if(arr[m] > arr[m-1])
				r = m;
			else if(arr[m] > arr[m+1])
				l = m;
		}
		return -1;
		
	}
	
	public static void main(String[] args) {
		int [] a={10,5,10,5,0,1,2,4,7,3,2,9,5,4,6,5,10,6,7,10,9,4,3,7,2,9,5,4,6,10};
		int res = new FindSmallest().findSmall(a);
		System.out.println(res);
	}
	
}
