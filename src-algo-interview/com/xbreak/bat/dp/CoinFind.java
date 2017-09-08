package com.xbreak.bat.dp;

import java.util.Arrays;

import org.junit.Test;

/**
 * 
 * ��̬�滮,  �������� : ��һ�����ϱ�ʾ��Ǯ����, ��һ��������ʾҪ�ҵ�Ǯ��,��������ķ�����
 * https://www.nowcoder.com/practice/185dc37412de446bbfff6bd21e4356ec?tpId=49&&tqId=29346&rp=2&ru=/activity/oj&qru=/ta/2016test/question-ranking
 *
 * @author XBreak
 *
 */
public class CoinFind {
	private int [] [] table ;
	/**
	 * �����ݹ鷽��
	 * @param arr
	 * @param x
	 * @return
	 */
	public int findCoin1(int [] arr, int x) {
		if(arr == null || arr.length == 0 || x < 0)
			return 0;
		return violence(arr, 0, x);
	}
	
	/**
	 * ������������, ������ݹ�����ķ���ֵ
	 * 	  volinceSearch(int[] arr,int start, int x), ��start,x�ɱ�,
	 * 							���Դ���һ����ά�����¼arr[start][i]�Ƿ��Ѿ�ִ�й�,����ֱ�ӷ��ؽ��
	 *    
	 * @param arr
	 * @param x
	 * @return
	 */
	public int findCoin2(int [] arr, int x) {
		if(arr == null || arr.length == 0 || x < 0)
			return 0;
		
		table = new int[arr.length][x+1];
		return remenberSearch(arr, 0, x);
	}
	
	public int findCoin3(int[] arr, int x) {
		if(arr == null || arr.length == 0 || x < 0)
			return 0;
		int n = arr.length;
		int [][] dp = new int[n][x+1];
		//��һ��ȫ��Ϊ1, ��ʾ ʹ�� arr[0~i]�ֻ���,���0Ԫ������,Ϊ1
		for(int i=0; i < n; i++)
			dp[i][0] = 1;
		//��һ��Ϊarr[0]������ǮΪ1, ��ʾʹ��arr[0]��һ�ֻ������aimǮ�ķ���,ֻ��Ϊarr[0]������Ǯ����1�ַ���,����Ϊ0
		for(int j = 1; j <= x; j++)
			if(j % arr[0] == 0)
				dp[0][j] = 1;
			else
				dp[0][j] = 0;
		//��dp[i][j] = dp[i-1][j-arr[i]*0] + dp[i-1][j-arr[i]*1] + ... + dp[i-1][0]
		for(int i=1; i<n; i++)
			for(int j=1; j <= x; j++) {
				int t = 0;
				
				for(int k=0; arr[i]*k <= j; k++) {
						t += dp[i-1][j-arr[i]*k];
				}
				dp[i][j] = t;
			}
		
		return dp[n-1][x];
	}
	/**
	 * ��: dp[i][j] = dp[i-1][j-0*arr[i]]+dp[i-1][j-1*arr[i]]+...dp[i-1][0]
	 * 		�� : dp[i][j-arr[i]]= dp[i-1][(j-arr[i])-0*arr[i]]+dp[i-1][(j-arr[i])-1*arr[i]]+...dp[i-1][0]
	 * 		�� : dp[i][j] = dp[i][j-arr[i]] + dp[i-1][j-arr[i]]
	 * @param arr
	 * @param x
	 * @return
	 */
	public int findCoin4(int[] arr, int x) {
		if(arr == null || arr.length == 0 || x < 0)
			return 0;
		int n = arr.length;
		int [][] dp = new int[n][x+1];
		//��һ��ȫ��Ϊ1, ��ʾ ʹ�� arr[0~i]�ֻ���,���0Ԫ������,Ϊ1
		for(int i=0; i < n; i++)
			dp[i][0] = 1;
		//��һ��Ϊarr[0]������ǮΪ1, ��ʾʹ��arr[0]��һ�ֻ������aimǮ�ķ���,ֻ��Ϊarr[0]������Ǯ����1�ַ���,����Ϊ0
		for(int j = 1; j <= x; j++)
			if(j % arr[0] == 0)
				dp[0][j] = 1;
			else
				dp[0][j] = 0;
		//��dp[i][j] = dp[i-1][j-arr[i]*0] + dp[i-1][j-arr[i]*1] + ... + dp[i-1][0]
		for(int i=1; i<n; i++)
			for(int j=1; j <= x; j++) {
				if(j >= arr[i])
					dp[i][j] = dp[i][j-arr[i]] + dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j];	//��ǰarr[i]���Ż��ҵ�ֵ��Ҫ�յ�Ǯ��,ֱ��Ϊ�������Ż��ҵ��ж�,ֵ��i-1����ͬ
			}
		
		return dp[n-1][x];
	}
	/**
	 * ���������ݹ鷽�� [5,10,4] 1000
	 * ����Ϊ : ��0��5Ԫ+[10,4]���1000 �ķ�����
	 * 			1��5Ԫ+[10,4]���995�ķ�����
	 * 			2��5Ԫ+[10,4]���990�ķ�����
	 * 		......
	 * 			200��5Ԫ+[10,4]���0�ķ�����
	 * 		֮��;
	 * 
	 * 	
	 * 
	 * @param start Ҫʹ�õ�������ʼ����ֵ
	 * @return
	 */
	public int violence(int[] arr,int start, int x) {
		int res = 0;
		if(start == arr.length)	//��Ǯ��ֻ��һ��ʱ,��Ǯ��ΪĿ��Ǯ��,����1,���򷵻�0;
			res = x==0 ? 1 : 0;
		else {
			for(int i =0 ;  arr[start]*i <= x ; i++)
				res += violence(arr, start+1, x - arr[start]*i );	
		}
		return res;
	}
	
	/**
	 * 
	 * @param arr
	 * @param start
	 * @param x
	 * @return
	 */
	public int remenberSearch(int[] arr,int start, int x) {
		int res = 0;
		if(start == arr.length)	//��Ǯ��ֻ��һ��ʱ,��Ǯ��ΪĿ��Ǯ��,����1,���򷵻�0;
			return x == 0 ? 1 : 0;
		if(table[start][x] != 0)
			return table[start][x];
		for(int i =0 ; arr[start]*i <= x; i++)
			res += remenberSearch(arr, start+1, x - arr[start]*i );	
		table[start][x] = res;
		return res;
	}
	
	@Test
	public void test1() {
		System.out.println(findCoin1(new int[] {5,10,25,1}, 15));
	}
	@Test
	public void test2() {
		System.out.println(findCoin2(new int[] {5,10,25,1}, 15));
	}
	@Test
	public void test3() {
		System.out.println(findCoin3(new int[] {5,10,25,1}, 15));
	}
	@Test
	public void test4() {
		System.out.println(findCoin1(new int[] {1,5,10,20,50,100}, 8845));
	}
}
