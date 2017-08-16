package com.xbreak.sorting.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.xbreak.sorting.BaseSort;
import com.xbreak.util.StdIn;


/**
 * 	2.1 ѡ������
 * 
 * @author XBreak
 */
public class Selection extends BaseSort{
	
	
	
	/**
	 * ����˼·: ÿ��ѭ��ѡ��һ����Сֵ(���),���ڵ�ǰ�����������(����),ֱ��������Ԫ�ظ���С�ڵ���1
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
