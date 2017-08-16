package com.xbreak.sorting.quick;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.xbreak.sorting.BaseSort;
import com.xbreak.sorting.merge.Merge;
import com.xbreak.util.StdIn;


/**
 *  2.5 快速排序 
 * @author XBreak
 */
public class Quick extends BaseSort{
	
	/**
	 * 确定基准,进行切分, 然后进行二分递归
	 * @param a
	 */
	public static void sort(Comparable [] a) {
		
		sort(a,0,a.length-1);
		
	}
	
	/**
	 * 切分函数
	 * @param a
	 * @param lo
	 * @param hi
	 * @return 基准数的位置
	 */
	public static int partition(Comparable [] a, int lo, int hi) {
		int b = lo;			//确定基准数为 最低点
		int i = lo,  j = hi+1;//避免第一次 --hi 时 漏掉hi
		while(true) {
			
			while(less( a[++i], a[b])) if(i == hi) break;		//从左往右,找大于基准的数( i > b 时跳出)
			while(less( a[b], a[--j])) if(j == lo) break;		//从右往左,找小于基准的数( j < b 时跳出)
			
			if( i >= j)
				break;
			
			exch(a,i,j);		//交换两数
			
			
		}
		//跳出时, j <= i ,hi位置上的数小于基准, 交换基准与j ,因为基准在左边,所以与小于基准的数交换
		exch(a,b,j);
		return j; 
	}
	
	public static void sort(Comparable[] a, int lo, int hi) {
		if(lo >= hi)
			return ;
		int mid = partition(a, lo, hi);
		sort(a,lo,mid-1);	//基准位置已经确定顺序
		sort(a,mid+1,hi);	
	}
	
	/**
	 * 3路切分的快排 : 确定基准为最左边, 设置左,中 右,3个指针,再使用中指针从左到右 遍历数组,
	 * 				当前数小于基准时与左指针交换,
	 * 					 大于基准时与右指针交换,
	 * 
	 * @param a
	 * @param lo
	 */
	public static void sort3Way(Comparable [] a, int lo, int hi) {
		
		if(lo >= hi)
			return ;
		Comparable v = a[lo];
		int l = lo, i = lo +1, h = hi;		//l 指向的数一直是等于集的首位
		while( i <= h) {
			int cmp = a[i].compareTo(v);
			if(cmp < 0)
				exch(a, l++, i++); 	//i位置上的数必等于基准(l==基准)
			else if(cmp > 0)
				exch(a, h--, i);	//i不自增,是因为当前i位置上的数还不确定
			else 
				i++;
		}
		//跳出时 h 刚好为等集的最右, l一直为等集的最左
		sort(a, lo, l-1);
		sort(a, h+1, hi);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
	    StdIn.setScanner(new Scanner(new File("sort.txt")));
        String[] a = StdIn.readAllStrings();
//        Quick.sort(a);
        Quick.sort3Way(a, 0, a.length-1);
        show(a);
	}
}
