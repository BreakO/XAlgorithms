package com.xbreak.bat.dp.leetcode;

import org.junit.Test;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * 
 * 最大上升空间
 * 给一个数组, 确定最大上升空间
 * Input: [7, 1, 5, 3, 6, 4]
	Output: 5  (6-1)
	
	Input: [7, 6, 4, 3, 1]
	Output: 0	(没有上升的区间)
	
	
	解法: 从左往右遍历数组, min记录当前最小值, max记录目前为止最大和(当前元素减min,和旧最大值 取其最大)
	
 * 
 */
public class MaxAscendSum {
        
        public int maxSubArray(int[] nums) {
            if(nums == null || nums.length == 0) {
        		return 0;
        	}

            int [] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = dp[0];
            for(int i=1; i<nums.length; i++){
                dp[i] =nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
                if(max < dp[i])
                    max = dp[i];
            }
                
            
        	return max;
        }
    	
    @Test
    public void test1() {
    	int maxProfit = maxSubArray(new int[] {7, 1, 5, 3, 6, 4});
    	System.out.println(maxProfit);
    }
 
}
