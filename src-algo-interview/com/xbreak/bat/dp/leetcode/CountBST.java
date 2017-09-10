package com.xbreak.bat.dp.leetcode;

/*
 *  ��һ����, [1~n]���Թ���Ķ�������������
 *  
 *  �ⷨ : dp[i]  n=iʱ ���Թ����BST����
 *  
 *  dp[1] = 1;
 *  dp[i] = ��1Ϊ��, ������Ϊ�� (dp[0] =1, ) * ��������������([2~i] ͬdp[i-1]) = dp[0]*dp[n-01]
 *  		+ ��2Ϊ��, ��������������(1, dp[1]=1) * ��������������(3~n, ͬdp[i-2]) = dp[1]*dp[n-2]
 * 			+ ��iΪ��, ����������(1~i-1, dp[i-1]) * ����������(��, dp[0])=dp[i-1] *dp[0];
 */

public class CountBST {
    public int numTrees(int n) {
        int [] dp = new int[n+1]; //
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j = 1; j<=i; j++)
                dp[i] +=dp[i-j]*dp[j-1];
        }
        return dp[n];
    }
}
