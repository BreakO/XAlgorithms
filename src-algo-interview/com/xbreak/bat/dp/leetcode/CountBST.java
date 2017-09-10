package com.xbreak.bat.dp.leetcode;

/*
 *  给一个数, [1~n]可以构造的二叉搜索树种类
 *  
 *  解法 : dp[i]  n=i时 可以构造的BST个数
 *  
 *  dp[1] = 1;
 *  dp[i] = 以1为根, 左子树为空 (dp[0] =1, ) * 右子树构造总数([2~i] 同dp[i-1]) = dp[0]*dp[n-01]
 *  		+ 以2为根, 左子树构造总数(1, dp[1]=1) * 右子树构造总数(3~n, 同dp[i-2]) = dp[1]*dp[n-2]
 * 			+ 以i为根, 左子树总数(1~i-1, dp[i-1]) * 右子树总数(空, dp[0])=dp[i-1] *dp[0];
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
