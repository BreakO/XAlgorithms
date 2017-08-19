package com.xbreak.sorting.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.xbreak.sorting.BaseSort;
import com.xbreak.util.StdIn;


/**
 * 	2.1 选择排序
 * 
 * @author XBreak
 */
public class Selection extends BaseSort{
	
	
	
	/**
	 * 排序思路: 每次循环选出一个最小值(最大),置于当前遍历的最左边(最右),直至遍历的元素个数小于等于1
	 * 
	 * @param a
	 */
	public static void sort(Comparable [] a) {
		
		for(int i=0 ; i < a.length ; i++) {
			int min = i;
			for(int j = i; j < a.length ; j++) {
				
				if(less(a[j],a[min]))
					min = j;
			}
			exch(a,min,i);
		}
		
	}
    public static void main(String[] args) throws FileNotFoundException {
    	StdIn.setScanner(new Scanner(new File("sort.txt")));
        String[] a = StdIn.readAllStrings();
        Selection.sort(a);
        show(a);
    }
}
