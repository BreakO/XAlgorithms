package com.xbreak.bat.dp;

import org.junit.Test;

/**
 * ��̨��
 * ��һ¥�ݹ�m�����տ�ʼʱ���ڵ�һ������ÿ��ֻ�ܿ���һ�����߶�����Ҫ����m�������ж����߷���ע���涨��һ����һ����0���߷���
����һ��������int n���뷵��һ������������¥�ķ�ʽ������֤nС�ڵ���100��Ϊ�˷�ֹ������뷵�ؽ��Mod 1000000007��ֵ��
����������
	3
���أ�3
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
     * ��n��̨�׵��߷� = ��n-1��̨���߷�+��n-2��̨�׵��߷�
     * �ҵ�f(1) = 1
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
     * ��̬�滮
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
     * ������������
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
