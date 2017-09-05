package com.xbreak.bat.dp;

import org.junit.Test;

public class LongestCommonSubSequence {
	
	/**
	 * 
	 * �����������
	 * 
	 * ��̬�滮����:  ����dp[i][j]; ��ʾs1 (0~i) �� s2 (0~j) �����������
	 * 	���һ��dp[i][0] : s2ֻ��һ��ֵ,s1[i]==s2[0]ʱdp[i][0]=1,�����ֵ��Ϊ1,��dp[i~N][0]=1
	 * 	���һ��dp[0][j] : s1ֻ��һ��ֵ,s1[0]==s2[j]ʱdp[0][j]=1,�ұߵ�ֵ��Ϊ1,��dp[0][j~M]=1
	 *   �������dp[i][j] = max(dp[i-1][j], dp[i][j-1], s1[i]==s[j]ʱdp[i-1][j-1]+1);
	 *   	������Ϊs1[i]δ����s1[i]ʱ s1[0...i-1]��s2[0...j]������������� 
	 *   	    ����Ϊs2[j]δ����s2[j]ʱ s1[0...i]��s2[0...j-1]������������� 
	 *   	    ����Ϊ: ��s1[i]==s2[j]ʱ,dp[i-1][j-1]+1
	 * @param s1
	 * @param s2
	 * @return
	 */
	public int findlcs(String s1, String s2) {
		int N = s1.length();
		int M = s2.length();
		int[][] dp = new int[N][M];
		dp[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
		//��һ��
		for(int i=1; i<N; i++) {
			if(dp[i-1][0] == 1 || s1.charAt(i) == s2.charAt(0))
				dp[i][0] = 1;
			else
				dp[i][0] = 0;
		}
		//��һ��
		for(int j = 1; j < M; j++) {
			if(dp[0][j-1] == 1 || s1.charAt(0) == s2.charAt(j))
				dp[0][j] = 1;
			else
				dp[0][j] = 0;
		}
		//�������
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
