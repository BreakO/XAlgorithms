package com.xbreak.bat.dp;

import org.junit.Test;

/**
 * 最小编辑代价	https://www.nowcoder.com/practice/04f1731f32e246b4a19688972d5e2600?tpId=49&&tqId=29350&rp=1&ru=/activity/oj&qru=/ta/2016test/question-ranking
 * 
 * 对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义c0，c1，c2分别为三种操作的代价，
 * 请设计一个高效算法，求出将A串变为B串所需要的最少代价。
给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。
保证两串长度均小于等于300，且三种代价值均小于等于100。
测试样例：
"abc",3,"adc",3,5,3,100
返回：8
 * 
 * 思路 : 创建dp[i][j] (i=N+1, j=M+1) 表示 s1前i个字符 编辑成 s2前j个字符 所需要的最小代价
 *  第一列 : s1为空字符编辑为s2[0~j]的代价为插入代价
 *  第一行 : s1[0~i]编辑为s2为空字符的代价为删除代价
 *  	dp[i][j] = min( dp[i-1][j]+删除代价     : 即s1[0~i] 删除 s1[i]的代价 加 s1[0~i-1]变为s2[j]的代价
 *  					dp[i][j-1]+插入代价     : 即s2[0~j-1] 插入s2[j]的代价加 s1[0~i]变为s2[0~j-1]的代价
 *  					当s1[i] != s2[j] 时, 为dp[i-1][j-1]+替换代价,即替换s1[i]为s2[j]的代价
 *  					当s1[i] == s2[j] 时, 为dp[i-1][j-1]  
 *  					)
 *  
 * @author XBreak
 *
 */
public class BestEdit {
	public int getBest(String s1, String s2, int ci, int cd, int cr) {
		int N = s1.length() , M = s2.length();
		int [][]dp = new int[N+1][M+1];
		//处理第一列
		dp[0][0] = 0;
		for(int i=1; i<= M; i++) {
			dp[0][i] = ci*i;    //由空串插入为s2的代价
		}
		for(int i=1; i<=N; i++)
			dp[i][0] = cd * i;	//s1删除为空串的代价
		for(int i=1; i<= N; i++) {
			for(int j=1; j<=M; j++) {
				int t =Math.min(dp[i-1][j] + cd, dp[i][j-1] + ci);
				if(s1.charAt(i-1) == s2.charAt(j-1) && dp[i-1][j-1] < t)
					t= dp[i-1][j-1];
				else if(s1.charAt(i-1) != s2.charAt(j-1) && dp[i-1][j-1]+cr < t)
					t = dp[i-1][j-1]+cr;
				dp[i][j] = t;
			}
		}
		return dp[N][M];
	}
	@Test
	public void test() {
		System.out.println(getBest("bbca","cabacab",1,2,7));
	}
}
