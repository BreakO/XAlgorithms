package com.xbreak.leetcode;
import java.util.Scanner;

public class NumberTa {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int t = scanner.nextInt();
			for(int i=0; i<t; i++){
				int n = scanner.nextInt();
				int [][] arr = new int[n][n];
				for(int j=0; j<n; j++)
					for(int k=0; k<=j; k++)
						arr[j][k] = scanner.nextInt();
				System.out.println(getRes(arr));
			}
		}
	}
/*
1
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
 */
	private static int getRes(int[][] arr) {
		if(arr == null || arr.length == 0)
			return 0;
		int N = arr.length;
		int [][]dp = new int[N][N];
		dp[0][0] = arr[0][0];
		for(int i = 1; i<N; i++){
			for(int j =0; j<= i; j++){
				
				dp[i][j] = arr[i][j];
				int t1, t2 ;
				t1 = j-1>=0 ? dp[i-1][j-1] : -1;
				t2 = j < i ? dp[i-1][j] : -1;
				dp[i][j] +=Math.max(t1, t2);
			}
		
		}
		int max = dp[0][0];
		for(int i=1; i<N; i++)
			if(max < dp[N-1][i])
				max= dp[N-1][i];
		return max;
	}
	
	
}
