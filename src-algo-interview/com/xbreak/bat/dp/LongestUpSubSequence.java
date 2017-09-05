package com.xbreak.bat.dp;

import java.util.Scanner;

import org.junit.Test;

public class LongestUpSubSequence {
	
    public  int sequence(int [] arr, int n){
        int[] dp = new int[n];	// dp[i] : 以i为最大值得最长子序列
        dp[0] = 1;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && dp[i] < dp[j])
                    dp[i] = dp[j];
       	    }
            dp[i] = dp[i]+1;
        }
        int max = 0;
        for(int i =0; i< n; i++)
            if(dp[i] > max)
                max = dp[i];
        return max;
    }
    @Test
    public void test1() {
    	System.out.println(sequence(new int[] {1, 7, 3, 5, 9, 4, 8}, 7));
    }

}
