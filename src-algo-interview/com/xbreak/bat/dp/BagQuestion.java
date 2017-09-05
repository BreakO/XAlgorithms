package com.xbreak.bat.dp;

import org.junit.Test;

/**
 * 背包问题
 * 在M件物品取出若干件放在空间为W的背包里，每件物品的体积为W1，W2……Wn，
 * 与之相对应的价值为P1,P2……Pn。求出获得最大价值的方案。
 * 
 * 解法: 创建dp[x][y] 表示使用前x件,重量不超过y, 的最大值
 * 	第一列: dp[0][0...y] 当y>v[0]时 dp[0][y]=p[0],右边也全为p[0]
 *  第一行: dp[0...x][0] 全为0
 *  dp[x][y] = max(dp[x-1][y], dp[x-1][y-v[x]]) 前者是不拿第x件, 后者是要拿第x件 总重量减v[x]价值加p[x];
 * @author XBreak
 *
 */
public class BagQuestion {
	public int findMax(int [] v, int [] p, int cap) {
	
		int N = v.length;
		int [][]dp = new int[N][cap+1];
		//第一列  
		dp[0][0] = 0;
		for(int y=1; y<=cap; y++)
			if(v[0] <= y || dp[0][y-1] != 0)
				dp[0][y] = p[0];
		
		for(int x = 1; x < N; x++) {
			for(int y = 1; y <=cap; y++ ) {
				int t = dp[x-1][y];						//选择不拿第x件
				if(y >= v[x] && dp[x-1][y-v[x]]+p[x] > t) //若选择拿第x件,不超过重,与不拿x件时相比
					t = dp[x-1][y-v[x]]+p[x];
				dp[x][y] = t;
				
			}
		}
		
		return dp[N-1][cap];
	}
	@Test
	public void test() {
		System.out.println(findMax(new int[] {1,2,4}, new int[] {1,2,2}, 4));
	}
}
