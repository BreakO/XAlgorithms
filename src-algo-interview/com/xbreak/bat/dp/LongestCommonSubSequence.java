package com.xbreak.bat.dp;

import org.junit.Test;

public class LongestCommonSubSequence {
	
	/**
	 * 
	 * 最长公共子序列
	 * 
	 * 动态规划方法:  创建dp[i][j]; 表示s1 (0~i) 和 s2 (0~j) 最长公共子序列
	 * 	算第一列dp[i][0] : s2只有一个值,s1[i]==s2[0]时dp[i][0]=1,下面的值都为1,即dp[i~N][0]=1
	 * 	算第一行dp[0][j] : s1只有一个值,s1[0]==s2[j]时dp[0][j]=1,右边的值都为1,即dp[0][j~M]=1
	 *   其他情况dp[i][j] = max(dp[i-1][j], dp[i][j-1], s1[i]==s[j]时dp[i-1][j-1]+1);
	 *   	即可能为s1[i]未加入s1[i]时 s1[0...i-1]与s2[0...j]的最长公共子序列 
	 *   	    可能为s2[j]未加入s2[j]时 s1[0...i]与s2[0...j-1]的最长公共子序列 
	 *   	    可能为: 当s1[i]==s2[j]时,dp[i-1][j-1]+1
	 * @param s1
	 * @param s2
	 * @return
	 */
	public int findlcs(String s1, String s2) {
		int N = s1.length();
		int M = s2.length();
		int[][] dp = new int[N][M];
		dp[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
		//第一列
		for(int i=1; i<N; i++) {
			if(dp[i-1][0] == 1 || s1.charAt(i) == s2.charAt(0))
				dp[i][0] = 1;
			else
				dp[i][0] = 0;
		}
		//第一行
		for(int j = 1; j < M; j++) {
			if(dp[0][j-1] == 1 || s1.charAt(0) == s2.charAt(j))
				dp[0][j] = 1;
			else
				dp[0][j] = 0;
		}
		//其他情况
		for(int i = 1; i<N; i++) {
			for(int j=1; j<M; j++) {
				int t = Math.max(dp[i-1][j], dp[i][j-1]);
				if(s1.charAt(i) == s2.charAt(j))
					t = Math.max(t, dp[i-1][j-1]+1);
				dp[i][j] = t;
			}
		}
		
		return dp[N-1][M-1];
	}
	@Test
	public void test1() {
		System.out.println(findlcs("abcfbc", "abfcab"));
		System.out.println(findlcs("programming", "contest"));
		System.out.println(findlcs("abcd", "mnp"));
	}
}
