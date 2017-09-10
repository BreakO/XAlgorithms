package com.xbreak.leetcode;

import org.junit.Test;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
     
    	if(nums == null || nums.length == 0) {
    		return 0;
    	}
    	int res = 0;
    	int [][] rem= new int [nums.length][nums.length];
    	for(int i=0; i<nums.length; i++) {
    		if(nums[i] <=0)
    			continue;
    		int m = nums[i];
    	
    		for(int j=i+1; j<nums.length; j++) {
    			m += nums[j];
    			if(m > res)
    				res = m;
    		}
    	}
    	return res;
    }
    
    @Test
    public void test1() {
    	System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
