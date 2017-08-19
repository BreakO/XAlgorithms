package com.xbreak.sorting.merge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import com.xbreak.sorting.BaseSort;
import com.xbreak.sorting.basic.Shell;
import com.xbreak.util.StdIn;

/**
 * 2.4 �鲢����
 * @author XBreak
 */
public class Merge extends BaseSort{
	
	private static Comparable [] aux;
	
	public static void sort(Comparable [] a) {
		aux = new Comparable[a.length];		//��merge���Ƴ�,�����ظ������ڴ����
		
		sort(a,0,a.length-1);
	}
	
	/**
	 * ��ʼ��Merge �����İ����ϲ�����
	 * @param a
	 */
	public static void initAux(Comparable [] a) {
		for(int i=0; i < a.length; i++ ) {
			aux[i] = a[i];
		}
	}
	
	/**
	 * �ϲ� ���� a[lo ... mid] , a[mid+1, hi];
	 * @param a
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public static void merge(Comparable [] a, int lo, int mid, int hi) {
		initAux(a);
		int i = lo;
		int x = mid +1;
		while( i <= hi) {
			if(lo > mid)
				a[i++] = aux[x++];
			else if(x > hi)
				a[i++] = aux[lo++];
			else if(less(aux[lo], aux[x]))
				a[i++] = aux[lo++];
			else 
				a[i++] = aux[x++];
		}
		
	}

	
	/**
	 * �鲢���� : ���ֵݹ�,ֱ��Ԫ�ظ���Ϊ1,Ȼ�������ϲ�
	 * @param a
	 * @param lo
	 * @param hi
	 */
	public static void sort(Comparable[] a, int lo, int hi) {
		if(lo >= hi)
			return ;
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a,lo,mid,hi);
	}
	
	/**
	 * �ϲ�����
	 */
	@Test
	public void testMerge() {
		Comparable[] a = new Comparable[] {2,4,6,8,1,3,5,8,9};
		Merge.sort(a);
		show(a);
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		    StdIn.setScanner(new Scanner(new File("sort.txt")));
	        String[] a = StdIn.readAllStrings();
	        Merge.sort(a);
	        show(a);
	}
	
}
