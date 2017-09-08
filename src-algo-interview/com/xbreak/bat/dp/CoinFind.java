package com.xbreak.bat.dp;

import java.util.Arrays;

import org.junit.Test;

/**
 * 
 * 动态规划,  找零问题 : 给一个集合表示零钱种类, 给一个整数表示要找的钱数,返回找零的方案数
 * https://www.nowcoder.com/practice/185dc37412de446bbfff6bd21e4356ec?tpId=49&&tqId=29346&rp=2&ru=/activity/oj&qru=/ta/2016test/question-ranking
 *
 * @author XBreak
 *
 */
public class CoinFind {
	private int [] [] table ;
	/**
	 * 暴力递归方法
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
	 * 记忆搜索方法, 即记忆递归参数的返回值
	 * 	  volinceSearch(int[] arr,int start, int x), 中start,x可变,
	 * 							所以创建一个二维数组记录arr[start][i]是否已经执行过,若是直接返回结果
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
		//第一列全部为1, 表示 使用 arr[0~i]种货币,组成0元方案数,为1
		for(int i=0; i < n; i++)
			dp[i][0] = 1;
		//第一行为arr[0]倍数的钱为1, 表示使用arr[0]这一种货币组成aim钱的方案,只有为arr[0]倍数的钱才有1种方案,其余为0
		for(int j = 1; j <= x; j++)
			if(j % arr[0] == 0)
				dp[0][j] = 1;
			else
				dp[0][j] = 0;
		//求dp[i][j] = dp[i-1][j-arr[i]*0] + dp[i-1][j-arr[i]*1] + ... + dp[i-1][0]
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
	 * 简化: dp[i][j] = dp[i-1][j-0*arr[i]]+dp[i-1][j-1*arr[i]]+...dp[i-1][0]
	 * 		又 : dp[i][j-arr[i]]= dp[i-1][(j-arr[i])-0*arr[i]]+dp[i-1][(j-arr[i])-1*arr[i]]+...dp[i-1][0]
	 * 		故 : dp[i][j] = dp[i][j-arr[i]] + dp[i-1][j-arr[i]]
	 * @param arr
	 * @param x
	 * @return
	 */
	public int findCoin4(int[] arr, int x) {
		if(arr == null || arr.length == 0 || x < 0)
			return 0;
		int n = arr.length;
		int [][] dp = new int[n][x+1];
		//第一列全部为1, 表示 使用 arr[0~i]种货币,组成0元方案数,为1
		for(int i=0; i < n; i++)
			dp[i][0] = 1;
		//第一行为arr[0]倍数的钱为1, 表示使用arr[0]这一种货币组成aim钱的方案,只有为arr[0]倍数的钱才有1种方案,其余为0
		for(int j = 1; j <= x; j++)
			if(j % arr[0] == 0)
				dp[0][j] = 1;
			else
				dp[0][j] = 0;
		//求dp[i][j] = dp[i-1][j-arr[i]*0] + dp[i-1][j-arr[i]*1] + ... + dp[i-1][0]
		for(int i=1; i<n; i++)
			for(int j=1; j <= x; j++) {
				if(j >= arr[i])
					dp[i][j] = dp[i][j-arr[i]] + dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j];	//当前arr[i]这张货币的值比要凑的钱多,直接为跳过这张货币的判断,值与i-1种相同
			}
		
		return dp[n-1][x];
	}
	/**
	 * 暴力搜索递归方法 [5,10,4] 1000
	 * 其结果为 : 用0张5元+[10,4]组成1000 的方法数
	 * 			1张5元+[10,4]组成995的方法数
	 * 			2张5元+[10,4]组成990的方法数
	 * 		......
	 * 			200张5元+[10,4]组成0的方法数
	 * 		之和;
	 * 
	 * 	
	 * 
	 * @param start 要使用的数组起始索引值
	 * @return
	 */
	public int violence(int[] arr,int start, int x) {
		int res = 0;
		if(start == arr.length)	//当钱数只有一种时,若钱数为目标钱数,返回1,否则返回0;
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
		if(start == arr.length)	//当钱数只有一种时,若钱数为目标钱数,返回1,否则返回0;
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
