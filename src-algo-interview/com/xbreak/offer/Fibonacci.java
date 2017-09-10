package com.xbreak.offer;

import org.junit.Test;

public class Fibonacci {
	public int fibonacci(int x) {
		if(x == 0)
			return 0;
		int [] dp = new int[x+1];
		dp[1] = 1;
		dp[2] = 1;
		for(int i=3; i<= x; i++)
			dp[i] = dp[i-1] + dp[i-2];
		return dp[x];
	}
	@Test
	public void test1() {
		//System.out.println(fibonacci(6));
	}
	
	// ÌøÌ¨½×¶þ
	public int goUpII(int n) {
		
		int [] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2; i<=n; i++) {
			int sum = 0;
			for(int j=0; j<i; j++)
				sum+=dp[j];
			dp[i] = sum;
		}
		return dp[n];
	}
	
	@Test
	public void test2() {
		System.out.println(goUpII(50));
	}
	
}
