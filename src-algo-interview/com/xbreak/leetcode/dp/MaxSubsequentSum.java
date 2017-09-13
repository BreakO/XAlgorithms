package com.xbreak.leetcode.dp;

/**
 * @author XBreak	
 *	最大子序列和
 *
 *对于一个有正有负的整数数组，请找出总和最大的连续数列。
给定一个int数组A和数组大小n，请返回最大的连续数列的和。保证n的大小小于等于3000。
测试样例：
[1,2,3,-6,1]
返回：6
 *
 */
public class MaxSubsequentSum {
    public int getMaxSum(int[] A, int n) {
        // write code here
    	
    	if(A == null || A.length == 0)
    		return 0;
        int dp = 0, max = A[0];
        for(int i=0; i<A.length; i++){
            dp+=A[i];				//向右累加
            if(dp > max)			//更新最大值
                max = dp;
            if(dp < 0)				//若累加的和小于0, 则不可能为大值,扔掉,下一个索引重新累加
                dp = 0;
        
        }
        return max;
    }
}
