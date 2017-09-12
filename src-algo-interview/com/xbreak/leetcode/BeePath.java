package com.xbreak.leetcode;
import java.util.Scanner;


/**
 * @author XBreak
 *
 *	蜜蜂寻路
 *如你所见，蜜蜂的蜂房是正六边形，假设蜜蜂只会从左往右爬，即从1号蜂房能爬到2号和3号；从6号蜂房能爬到7号和8号……
现给出两个蜂房的编号a和b，要求计算蜂房a的蜜蜂爬到蜂房b有几条不同路线。

 * 1 1 2 3 5 8 
 * 斐波那契
 * dp[i]=dp[i-1]+dp[i-2]
 */
public class BeePath {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			
			int t = scanner.nextInt();
			for(int k = 0; k<t; k++){
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				System.out.println(getRes(x, y));
				
			}
		}
	}

	private static int getRes(int x, int y) {
		
		int N = y-x+1;
		if(N<=2)
			return 1;
		int [] dp = new int[N+1];
		dp[1] = 1;
		dp[2] = 1;
		for(int i = 3; i<=N; i++)
			dp[i] = dp[i-2]+dp[i-1];
		return dp[N];
	}
	
	
}
