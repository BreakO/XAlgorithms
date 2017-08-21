package com.xbreak.sorting.pq;

/**
 * 堆排序 索引从0开始
 * @author XBreak
 */
public class HeapII {
	//////堆排序
	public void exch(int [] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	/**
	 * 小值下调
	 * @param a
	 * @param i
	 */
	public void down(int [] a, int i, int n) {
		while(i*2+1 < n) {
			int t = i*2+1;
			if(t+1 < n && a[t+1] > a[t])
				t++;
			if(a[i] >= a[t])
				break;
			exch(a, i, t);
			i = t;
		}
	}
	/**
	 * 堆排序
	 * @param a
	 * @param n
	 */
	public void heapSort(int [] a, int n) {
		//初始化堆
		for(int i = n/2 - 1; i >= 0; i--) {
			down(a, i, a.length);
		}
		
		for(int i = n-1; i > 0; i--) {
			exch(a, i, 0);
			down(a, 0, --n);
		}
	}
}
