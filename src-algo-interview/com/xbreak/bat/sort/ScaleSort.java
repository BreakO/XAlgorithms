package com.xbreak.bat.sort;

/**
 * 2.1 小范围排序
 * 	已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，
	并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序给定一个int数组A，
	同时给定A的大小n和题意中的k，请返回排序后的数组。
	
 * 有两种解决办法 : 
 * 		简单的方法使用 插入排序   O(N*K)
 * 		复杂:	堆排序   O(N * logK)
 * 				由1 ~ K创建一个小根堆 , 而后弹出堆顶(最小值),再插入 第K+1,然后调整和弹出,直至排序完成
 * 		
 * @author XBreak
 */
public class ScaleSort {
	int [] arr;
	public int[] sortElement(int[] A, int n, int k) {  
		arr = new int[n];
		len = k;
		initHeap(A, k);
		int r =  k;
		int i = 0;
		while(r < n ) {
			arr[i++] = A[0];
			A[0] = A[r++];
			down(A, 0);
		}
		//当r == n; 0 ~ k-1 上未排序
		r = k-1;
		while(r > 0) {
			arr[i++] = A[0];
			exch(A, 0, r--);
			len--;
			down(A, 0);
		}
		arr[i] = A[0];
		return arr;
	}
	int len;
	/**
	 * 堆的下沉
	 * @param A
	 * @param x
	 */
	private void down(int [] A, int x) {
		while(x*2+1 < len ) {
			int t = x*2+1;
			if(t < len-1 && A[t] > A[t+1])
				t++;
			if(A[x] < A[t])
				break;
		   //交换x, t位置上的数
			exch(A, x, t);
			x = t;
		}
	}
	private void exch(int [] A, int x, int t) {
		int h = A[x];
		A[x] = A[t];
		A[t] = h;
	}
	int j = 0;
	private void initHeap(int[] A, int k) {
		for(int i = k/2-1 ; i >= 0; i--) {
			down(A, i);
		}
	}
	
	public static void main(String[] args) {
		int[] A = {2,1,4,3,6,5,8,7,10,9};
		int[] res = new ScaleSort().sortElement(A, 10, 2);
		System.out.println(res);
	}
}
