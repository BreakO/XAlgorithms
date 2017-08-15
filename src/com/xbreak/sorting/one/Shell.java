package com.xbreak.sorting.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.xbreak.sorting.BaseSort;
import com.xbreak.util.StdIn;

/**
 * 2.3 希尔排序
 * 
 * @author XBreak
 */
public class Shell extends BaseSort{
	
	/**
	 * 希尔排序 : 缩小增量 的插入排序
	 * 		选择一个步长序列 , 序列最后一个为1, 根据当前步长,进行插入排序,然后递减步长,直至步长为1, 进行普通的插入排序
	 * 
	 * @param a
	 */
	public static void sort(Comparable [] a) {
		
		int d = a.length;	//选择步长
		
		while(d >= 1) {		
			
			for(int i = d ; i < a.length ; i++) {
				
				for(int j = i; j >= d ; j-=d) {
					
					if(less(a[j] , a[j-d]))
						exch(a,j, j-d);
				}
			}
			
			//递减步长
			d /=2;
			
		}
		
	}
	
	   public static void main(String[] args) throws FileNotFoundException {
		    StdIn.setScanner(new Scanner(new File("sort.txt")));
	        String[] a = StdIn.readAllStrings();
	        Shell.sort(a);
	        show(a);
	    }
	
	
}
