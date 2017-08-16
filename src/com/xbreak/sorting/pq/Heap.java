package com.xbreak.sorting.pq;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.xbreak.sorting.BaseSort;
import com.xbreak.sorting.quick.Quick;
import com.xbreak.util.StdIn;

/**
 * 2.7������
 * @author XBreak
 */
public class Heap extends BaseSort{

	//����õ��������ȶ��е��³�����,���г�ʼ��
	public static void down(Comparable [] a, int k , int N) {
		
		while(k*2 <= N) {
			int i  = k*2;
			if(i < N && less2(a,i,i+1))
				i++;
			if(less2(a,i,k))	//�����ӽڵ㶼�ȵ��ڵ�С
				break;
			exch2(a,i,k);
			k = i;
		}
		
	}
    /**
     * ���Ĺ��ıȽϺ���, ��Ϊ�����1��ʼ
     * @param pq
     * @param i
     * @param j
     * @return
     */
    private static boolean less2(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    /**
     * ���Ĺ��Ľ�������, �����趨��1��ʼ
     * @param pq
     * @param i
     * @param j
     */
    private static void exch2(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }
	/**
	 * ������ : �ȹ�����ʼ��,ͨ���³�1~N/2, ���ν������ڵ���ĩβ�Ľڵ�,Ȼ�����³����ڵ�,���ֶѵĴ���,ֱ����Ԫ�ظ���Ϊ1
	 * @param a
	 */
	public static void sort(Comparable [] a) {
		int N = a.length;
		
		//������ , �³�N/2 .. 1 ,��Щ���ӽڵ�
		for(int i = N/2; i >= 1; i--) {
			down(a,i,N);
		}
		while(N > 1) {
			exch2(a,1,N--);
			down(a,1,N);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
	    StdIn.setScanner(new Scanner(new File("sort.txt")));
        String[] a = StdIn.readAllStrings();
         Heap.sort(a);
        show(a);
	}
	
}
