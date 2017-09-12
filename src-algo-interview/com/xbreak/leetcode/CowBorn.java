package com.xbreak.leetcode;
import java.util.Scanner;


/**
 * @author XBreak
 *  母牛问题
 *	有一头母牛，它每年年初生一头小母牛。每头小母牛从第四个年头开始，每年年初也生一头小母牛。请编程实现在第n年的时候，共有多少头母牛？
 
 * 1 2 3 4 6
 * dp[i] = dp[i-1]+dp[i-3]  // 第i年的牛总数 为 第i-1年的总牛数,加上第i-3年出生的总牛数(i-3年的牛都能多生一头牛了);
 *
 */
public class CowBorn {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int t = scanner.nextInt();
			if(t == 0)
				break;
			System.out.println(getRes(t));
		}
	}

	private static int getRes(int n) {

		if(n <= 4)
			return n;
		
		int [] dp = new int[n+1];
		
		dp[1] = 1;

		for(int i =2; i<=n; i++){
			if(i <= 4)
				dp[i] = dp[i-1]+1;
			else
				dp[i] = dp[i-1]+dp[i-3];
		}
		return dp[n];
	}
}
