package com.xbreak.sorting.pq;

/**
 * 基于堆的大值优先队列
 * @author XBreak
 */
public class MaxPQ<Key extends Comparable<Key>> {
	
	private Key[] pq;
	private int N;
	
	public MaxPQ() {
		this(10);
	}
	public MaxPQ(int max) {
		pq  = (Key[]) new Comparable[max];
		
	}
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0 ? true : false;
	}
	private void exch(int i, int j) {
		Key k = pq[i];
		pq[i] = pq[j];
		pq[j] = k;
	}
	
	/**
	 * 上浮 ( 大数上浮): 若当前节点 大于 父节点,交换两个节点, 并与此相仿,直至根节点
	 * @param k
	 */
	private void up(int k) {
		while(k > 1 && less(k/2, k)) {
			exch(k,k/2);
			k /= 2;
		}
	}
	
	/**
	 * 下沉 (小数下沉) : 若当前节点 小于其子节点, 则把当前节点与其最大子节点交换,  并与此相仿,直至叶节点
	 * @param k
	 */
	private void  down(int k) {
		
		
		while(k*2 <= N ) {
			
			int i = k*2;
			if(i < N && less(i, i+1))
				i++;
			
			if(less(i , k))
				break;
			
			exch(i,k);
			k = i;
		}
	}
	
	public void insert(Key k) {
		pq[N] = k;
		// 维护次序, 上浮
		up(N);
		N++;
	}
	
	public Key max() {
		return pq[1];
	}
	public Key delMax() {
		
		Key k = pq[1];
		exch(1, N);	//把最后节点设为根节点
		pq[N] = null;
		N--;
		down(1);
		return k;
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
}
