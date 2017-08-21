package com.xbreak.bat.sort;

/**
 * 最短子数组
 * 
 * 对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。(原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
测试样例：
[1,4,6,5,9,10],6
返回：2
思路，从头遍历，一直记录最大值，记录最大值不变之前最后一个位置，测试用例中max先是1，然后4，然后6，然后5这里不变max依旧是6，然后变成9，最后变成10，那记录的是5的位置。
同理再从尾遍历，一直记录最小值，记录最小值不变之前的的最后一个位置，先是min=10，然后9，然后5，然后6这里不变min依旧是5，然后是4，然后是1，记录的是6的位置，计算这两个位置的长度就可以了。如果是有序数组，则两个位置的长度就是整个数组的长度，特别声明为0即可
 * 
 * @author XBreak
 */
public class SubSequent {
	public int shortestSubSequent(int [] A, int n) {
		
        int max = A[0];  
        int min = A[n-1];  
        int sindex = 0;  
        int bindex = n-1;  
        for(int i=1;i<n;i++)  
        {  
            if(A[i]<max)  
                sindex = i;  
            else  
                max = A[i];  
        }  
        for(int j=n-2;j>=0;j--)  
        {  
            if(A[j]>min)  
                bindex = j;  
            else  
                min = A[j];  
        }  
        if(bindex-sindex+1==n)  
            return 0;  
        return sindex-bindex+1;  
		
	}
}
