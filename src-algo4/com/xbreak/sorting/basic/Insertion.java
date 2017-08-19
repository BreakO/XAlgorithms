package com.xbreak.sorting.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.xbreak.sorting.BaseSort;
import com.xbreak.util.StdIn;

/**
 * 2.2 插入排序
 * 
 * @author XBreak
 *
 */
public class Insertion extends BaseSort {

	/**
	 * 插入排序: 从第二元素开始, 前面的元素已经排序, 把当前元素插入到前面元素集合中,
	 * 			   可以采用当前元素与前面元素一一比较交换,  或者,找到当前元素正确位置,再进行统一移位,这里使用前者
	 * 
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		
		for(int i=1 ; i< a.length  ; i++) {	 
			
			for(int j = i ; j > 0 ; j--) {
				
				if(less(a[j],a[j-1]))
					exch(a , j , j-1);
			}
		}
	}
	
	   public static void main(String[] args) throws FileNotFoundException {
		    StdIn.setScanner(new Scanner(new File("sort.txt")));
	        String[] a = StdIn.readAllStrings();
	        Insertion.sort(a);
	        show(a);
	    }
	
}
