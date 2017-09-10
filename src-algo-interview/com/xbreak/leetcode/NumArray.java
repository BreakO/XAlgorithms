package com.xbreak.leetcode;

import org.junit.Test;

public class NumArray {
    public void update(int i, int val) {
        
    	int x = val - arr[i];
    	arr[i] = x;
        for(int j=i; j<arr.length; j++)
            dp[j] += x;
        
        
    }
    

    
    public NumArray(int[] nums) {
        if(nums == null)
            return ;
        arr = nums;
        int N = arr.length;
        if(N != 0){
          dp = new int[N];
          dp[0] = arr[0];
            
          for(int t =1; t< N; t++)
                dp[t] = dp[t-1]+arr[t];
        }

    }
    private int[] arr , dp;
    public int sumRange(int i, int j) {
        if(dp == null )
            return 0;
        if(i == 0)
            return dp[j];
        return dp[j] - dp[i-1];   
    }
    
    public   static void main(String [] args) {
    	  NumArray obj = new NumArray(new int[] {7,2,7,2,0});
    	  obj.update(4,6);
    	  obj.update(0,2);
    	  obj.update(0,9);
    	  System.out.println(obj.sumRange(4, 4));
    	  obj.update(3,8);
    	  System.out.println(obj.sumRange(0, 4));
    	  
    }
    
}
