package com.xbreak.sorting.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.xbreak.sorting.BaseSort;
import com.xbreak.util.StdIn;

/**
 * 2.3 ϣ������
 * 
 * @author XBreak
 */
public class Shell extends BaseSort{
	
	/**
	 * ϣ������ : ��С���� �Ĳ�������
	 * 		ѡ��һ���������� , �������һ��Ϊ1, ���ݵ�ǰ����,���в�������,Ȼ��ݼ�����,ֱ������Ϊ1, ������ͨ�Ĳ�������
	 * 
	 * @param a
	 */
	public static void sort(Comparable [] a) {
		
		int d = a.length;	//ѡ�񲽳�
		
		while(d >= 1) {		
			
			for(int i = d ; i < a.length ; i++) {
				
				for(int j = i; j >= d ; j-=d) {
					
					if(less(a[j] , a[j-d]))
						exch(a,j, j-d);
				}
			}
			
			//�ݼ�����
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
