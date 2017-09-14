package com.xbreak.bat.dp.leetcode;

import org.junit.Test;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * 
 * ��������ռ�
 * ��һ������, ȷ����������ռ�
 * Input: [7, 1, 5, 3, 6, 4]
	Output: 5  (6-1)
	
	Input: [7, 6, 4, 3, 1]
	Output: 0	(û������������)
	
	
	�ⷨ: �������ұ�������, min��¼��ǰ��Сֵ, max��¼ĿǰΪֹ����(��ǰԪ�ؼ�min,�;����ֵ ȡ�����)
	
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
