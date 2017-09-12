package com.xbreak.leetcode;
import java.util.Scanner;


/**
 * @author XBreak
 *
 *	�۷�Ѱ·
 *�����������۷�ķ䷿���������Σ������۷�ֻ�����������������1�ŷ䷿������2�ź�3�ţ���6�ŷ䷿������7�ź�8�š���
�ָ��������䷿�ı��a��b��Ҫ�����䷿a���۷������䷿b�м�����ͬ·�ߡ�

 * 1 1 2 3 5 8 
 * 쳲�����
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
