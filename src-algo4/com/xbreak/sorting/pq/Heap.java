package com.xbreak.sorting.pq;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.xbreak.sorting.BaseSort;
import com.xbreak.sorting.quick.Quick;
import com.xbreak.util.StdIn;

/**
 * 2.7堆排序
 * @author XBreak
 */
public class Heap extends BaseSort{

	//这边用到的是优先队列的下沉函数,进行初始化
	public static void down(Comparable [] a, int k , int N) {
		
		while(k*2 <= N) {
			int i  = k*2;
			if(i < N && less2(a,i,i+1))
				i++;
			if(less2(a,i,k))	//左右子节点都比当节点小
				break;
			exch2(a,i,k);
			k = i;
		}
		
	}
    /**
     * 更改过的比较函数, 因为数组从1开始
     * @param pq
     * @param i
     * @param j
     * @return
     */
    private static boolean less2(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    /**
     * 更改过的交换函数, 数组设定从1开始
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
	 * 堆排序 : 先构建初始堆,通过下沉1~N/2, 依次交换根节点与末尾的节点,然后再下沉根节点,保持堆的次序,直至堆元素个数为1
	 * @param a
	 */
	public static void sort(Comparable [] a) {
		int N = a.length;
		
		//构建堆 , 下沉N/2 .. 1 ,这些有子节点
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
