package com.xbreak.leetcode;
import java.util.Scanner;


/**
 * @author XBreak
 *  ĸţ����
 *	��һͷĸţ����ÿ�������һͷСĸţ��ÿͷСĸţ�ӵ��ĸ���ͷ��ʼ��ÿ�����Ҳ��һͷСĸţ������ʵ���ڵ�n���ʱ�򣬹��ж���ͷĸţ��
 
 * 1 2 3 4 6
 * dp[i] = dp[i-1]+dp[i-3]  // ��i���ţ���� Ϊ ��i-1�����ţ��,���ϵ�i-3���������ţ��(i-3���ţ���ܶ���һͷţ��);
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
