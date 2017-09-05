package com.xbreak.bat.dp;

import org.junit.Test;

/**
 * 上台阶
 * 有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或者二级，要走上m级，共有多少走法？注：规定从一级到一级有0种走法。
给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100。为了防止溢出，请返回结果Mod 1000000007的值。
测试样例：
	3
返回：3
 * 
 * @author XBreak
 *
 */
public class GoUpStair {
    public int countWays1(int n) {
        return violence(n);
    }
    /**
     * 
     * 第n级台阶的走法 = 第n-1级台阶走法+第n-2级台阶的走法
     * 且当f(1) = 1
     * 	  f(2) = 2
     * @param n
     * @return
     */
    public int violence(int n) {
    	if(n < 1)
    		return 0;
    	if(n == 1 || n == 2)
    		return n;
    	return violence(n-1)+violence(n-2);
    }
    
    int [] table ;
    public int countWays2(int n) {
    	
    	table = new int[n+1];
    	
        return remenber(n);
    }
    /**
     * 动态规划
     * @param n
     * @return
     */
    public int countWays3(int n) {
        
    	int [] dp = new int[n+1];
    	dp[2] = 1;
    	dp[3] = 2;
    	for(int i=4 ; i <= n; i++) {
    		dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
    	}
    	
        return dp[n] ;
    }
    /**
     * 记忆搜索方法
     * @param n
     * @return
     */
    public int remenber(int n) {
    	if(n < 1)
    		return 0;
    	if(n == 1 || n == 2)
    		return n;
    	if(table[n] != 0)
    		return table[n];
    	return remenber(n-1) + remenber(n-2);
    }
    
    
    
    @Test
    public void test1() {
    	System.out.println(countWays1(3));
    }
    @Test
    public void test2() {
    	System.out.println(countWays2(3));
    }
    @Test
    public void test3() {
    	System.out.println(countWays3(3));
    }
}
