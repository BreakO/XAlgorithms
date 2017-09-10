package com.xbreak.bat.dp.leetcode;

import org.junit.Test;


public class Robber {
	/*
	 * 抢劫问题 : 一个盗贼抢劫一个排屋子,每个屋子有价值数,相邻的的屋子不能都被抢, 求最大价值
	 * 
	 * 解法: dp[i] 在第0~i间屋子能够抢到的最大价值: 
	 * 		dp[0]=A[0]
	 * 		dp[1]=max(A[0],A[1])
	 * 		dp[i]=max(dp[i-2]+A[i] , dp[i]) 抢第i间房子和不抢第i间房子中取最大
	 */
    public int rob(int[] nums, int N) {
        if(nums == null || nums.length ==0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int [] dp =new int[N];
        dp[0] = nums[0]; // the max num while end with i
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for(int i=2; i<N; i++)
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        return dp[N-1];
    }
    @Test
    public void test1() {
    	System.out.println(rob(new int[] {1,1,2,1}, 4));
    }

    /**
     * 抢劫问题 II: 一个盗贼抢劫一个圆形排列的屋子,每个屋子有价值数,相邻的的屋子不能都被抢, 求最大价值
     * 
     * 解法: 0->1->2->0  可以两遍rob解决, 分别求抢第N-1间房(rob(A,1~N-1) , 不抢第N-1间房rob(A,0~N-2); 
     * 									然后选择最大
     * 
     */
    public int robII(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        if(nums.length == 1)
            return nums[0];
         return Math.max(rob2(nums,1, nums.length), rob2(nums,0,nums.length-1));
    }
    public int rob2(int[] nums, int lo, int N) {
        if(nums == null || nums.length ==0)
            return 0;
        if(N-lo == 1)
            return nums[lo];
        int [] dp =new int[N];
        
        dp[lo] = nums[lo]; // the max num while end with i
        dp[lo+1] = nums[lo] > nums[lo+1] ? nums[lo] : nums[lo+1];
        for(int i=lo+2; i<N; i++)
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        return dp[N-1];
    }
    @Test
    public void test1I() {
    	System.out.println(robII(new int[] {1,1,1}));
    }
}
