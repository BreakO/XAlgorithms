package com.xbreak.leetcode;

/**
 * @author XBreak
 * 切分相等子序列
 * 	给一个数组, 切分为两个和相等的子数组, 判断是否能切分
 * 
 * 解法: 0/1 背包问题
 *   dp[i][j] 使用前i件能否凑成j
 *   dp[0][0] = true 使用前0件能凑成0 , 所以 dp[i][0] =true
 *   dp[0][1~i]= false, 使用前0件啥也凑不成
 *   
 *   状态转移:  如果能够使用前i-1件凑成j, 则前j件也能(不使用当前件), 或者使用前i-1件能凑成j-numg[i](加上当前件刚好凑成),
 *   dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1](当前件)); 
 */
public class ParitionEqu {
    public boolean canPartition(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return false;
        
        int sum = 0;
        int n = nums.length;
        for(int x : nums)
            sum+=x;
        
        if((sum & 1) == 1)
            return false;
        sum /= 2;
        // dp[i][j] ; 使用前i个,是否能凑成dp
        boolean [][] dp = new boolean [n+1][sum+1];
        
        dp[0][0] = true;    //使用前0件凑0  为真
        for(int i=0; i<=sum; i++)
            dp[0][i] = false;  //使用0件凑任何金额都为0
        for(int j=1; j<=n;j++)
            dp[j][0] = true;    //0件能凑0, 所有1~N都能凑0
        for(int i=1; i<= n; i++)
            for(int j=1; j<=sum; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i-1])
                    dp[i][j] = (dp[i-1][j] || dp[i-1][j-nums[i-1]]);
            }
                
        return dp[n][sum];
    }
}
