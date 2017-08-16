package com.xbreak.sorting.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.xbreak.sorting.BaseSort;
import com.xbreak.util.StdIn;

/**
 * 2.2 ��������
 * 
 * @author XBreak
 *
 */
public class Insertion extends BaseSort {

	/**
	 * ��������: �ӵڶ�Ԫ�ؿ�ʼ, ǰ���Ԫ���Ѿ�����, �ѵ�ǰԪ�ز��뵽ǰ��Ԫ�ؼ�����,
	 * 			   ���Բ��õ�ǰԪ����ǰ��Ԫ��һһ�ȽϽ���,  ����,�ҵ���ǰԪ����ȷλ��,�ٽ���ͳһ��λ,����ʹ��ǰ��
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
