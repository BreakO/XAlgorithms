package com.xbreak.sorting.quick;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.xbreak.sorting.BaseSort;
import com.xbreak.sorting.merge.Merge;
import com.xbreak.util.StdIn;


/**
 *  2.5 �������� 
 * @author XBreak
 */
public class Quick extends BaseSort{
	
	/**
	 * ȷ����׼,�����з�, Ȼ����ж��ֵݹ�
	 * @param a
	 */
	public static void sort(Comparable [] a) {
		
		sort(a,0,a.length-1);
		
	}
	
	/**
	 * �зֺ���
	 * @param a
	 * @param lo
	 * @param hi
	 * @return ��׼����λ��
	 */
	public static int partition(Comparable [] a, int lo, int hi) {
		int b = lo;			//ȷ����׼��Ϊ ��͵�
		int i = lo,  j = hi+1;//�����һ�� --hi ʱ ©��hi
		while(true) {
			
			while(less( a[++i], a[b])) if(i == hi) break;		//��������,�Ҵ��ڻ�׼����( i > b ʱ����)
			while(less( a[b], a[--j])) if(j == lo) break;		//��������,��С�ڻ�׼����( j < b ʱ����)
			
			if( i >= j)
				break;
			
			exch(a,i,j);		//��������
			
			
		}
		//����ʱ, j <= i ,hiλ���ϵ���С�ڻ�׼, ������׼��j ,��Ϊ��׼�����,������С�ڻ�׼��������
		exch(a,b,j);
		return j; 
	}
	
	public static void sort(Comparable[] a, int lo, int hi) {
		if(lo >= hi)
			return ;
		int mid = partition(a, lo, hi);
		sort(a,lo,mid-1);	//��׼λ���Ѿ�ȷ��˳��
		sort(a,mid+1,hi);	
	}
	
	/**
	 * 3·�зֵĿ��� : ȷ����׼Ϊ�����, ������,�� ��,3��ָ��,��ʹ����ָ������� ��������,
	 * 				��ǰ��С�ڻ�׼ʱ����ָ�뽻��,
	 * 					 ���ڻ�׼ʱ����ָ�뽻��,
	 * 
	 * @param a
	 * @param lo
	 */
	public static void sort3Way(Comparable [] a, int lo, int hi) {
		
		if(lo >= hi)
			return ;
		Comparable v = a[lo];
		int l = lo, i = lo +1, h = hi;		//l ָ�����һֱ�ǵ��ڼ�����λ
		while( i <= h) {
			int cmp = a[i].compareTo(v);
			if(cmp < 0)
				exch(a, l++, i++); 	//iλ���ϵ����ص��ڻ�׼(l==��׼)
			else if(cmp > 0)
				exch(a, h--, i);	//i������,����Ϊ��ǰiλ���ϵ�������ȷ��
			else 
				i++;
		}
		//����ʱ h �պ�Ϊ�ȼ�������, lһֱΪ�ȼ�������
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
