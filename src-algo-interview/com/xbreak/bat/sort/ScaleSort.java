package com.xbreak.bat.sort;

/**
 * 2.1 С��Χ����
 * 	��֪һ��������������飬����������ָ������������ź�˳��Ļ���ÿ��Ԫ���ƶ��ľ�����Բ�����k��
	����k�����������˵�Ƚ�С����ѡ��һ�����ʵ������㷨���������ݽ����������һ��int����A��
	ͬʱ����A�Ĵ�Сn�������е�k���뷵�����������顣
	
 * �����ֽ���취 : 
 * 		�򵥵ķ���ʹ�� ��������   O(N*K)
 * 		����:	������   O(N * logK)
 * 				��1 ~ K����һ��С���� , ���󵯳��Ѷ�(��Сֵ),�ٲ��� ��K+1,Ȼ������͵���,ֱ���������
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
		//��r == n; 0 ~ k-1 ��δ����
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
	 * �ѵ��³�
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
		   //����x, tλ���ϵ���
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
