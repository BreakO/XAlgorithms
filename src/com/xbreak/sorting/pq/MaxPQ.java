package com.xbreak.sorting.pq;

/**
 * ���ڶѵĴ�ֵ���ȶ���
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
	 * �ϸ� ( �����ϸ�): ����ǰ�ڵ� ���� ���ڵ�,���������ڵ�, ��������,ֱ�����ڵ�
	 * @param k
	 */
	private void up(int k) {
		while(k > 1 && less(k/2, k)) {
			exch(k,k/2);
			k /= 2;
		}
	}
	
	/**
	 * �³� (С���³�) : ����ǰ�ڵ� С�����ӽڵ�, ��ѵ�ǰ�ڵ���������ӽڵ㽻��,  ��������,ֱ��Ҷ�ڵ�
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
		// ά������, �ϸ�
		up(N);
		N++;
	}
	
	public Key max() {
		return pq[1];
	}
	public Key delMax() {
		
		Key k = pq[1];
		exch(1, N);	//�����ڵ���Ϊ���ڵ�
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
