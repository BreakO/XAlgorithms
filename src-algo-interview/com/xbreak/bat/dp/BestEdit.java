package com.xbreak.bat.dp;

import org.junit.Test;

/**
 * ��С�༭����	https://www.nowcoder.com/practice/04f1731f32e246b4a19688972d5e2600?tpId=49&&tqId=29350&rp=1&ru=/activity/oj&qru=/ta/2016test/question-ranking
 * 
 * ���������ַ���A��B��������Ҫ���в��롢ɾ�����޸Ĳ�����A����ΪB��������c0��c1��c2�ֱ�Ϊ���ֲ����Ĵ��ۣ�
 * �����һ����Ч�㷨�������A����ΪB������Ҫ�����ٴ��ۡ�
���������ַ���A��B�������ǵĳ��Ⱥ����ֲ������ۣ��뷵�ؽ�A����ΪB������Ҫ����С���ۡ�
��֤�������Ⱦ�С�ڵ���300�������ִ���ֵ��С�ڵ���100��
����������
"abc",3,"adc",3,5,3,100
���أ�8
 * 
 * ˼· : ����dp[i][j] (i=N+1, j=M+1) ��ʾ s1ǰi���ַ� �༭�� s2ǰj���ַ� ����Ҫ����С����
 *  ��һ�� : s1Ϊ���ַ��༭Ϊs2[0~j]�Ĵ���Ϊ�������
 *  ��һ�� : s1[0~i]�༭Ϊs2Ϊ���ַ��Ĵ���Ϊɾ������
 *  	dp[i][j] = min( dp[i-1][j]+ɾ������     : ��s1[0~i] ɾ�� s1[i]�Ĵ��� �� s1[0~i-1]��Ϊs2[j]�Ĵ���
 *  					dp[i][j-1]+�������     : ��s2[0~j-1] ����s2[j]�Ĵ��ۼ� s1[0~i]��Ϊs2[0~j-1]�Ĵ���
 *  					��s1[i] != s2[j] ʱ, Ϊdp[i-1][j-1]+�滻����,���滻s1[i]Ϊs2[j]�Ĵ���
 *  					��s1[i] == s2[j] ʱ, Ϊdp[i-1][j-1]  
 *  					)
 *  
 * @author XBreak
 *
 */
public class BestEdit {
	public int getBest(String s1, String s2, int ci, int cd, int cr) {
		int N = s1.length() , M = s2.length();
		int [][]dp = new int[N+1][M+1];
		//�����һ��
		dp[0][0] = 0;
		for(int i=1; i<= M; i++) {
			dp[0][i] = ci*i;    //�ɿմ�����Ϊs2�Ĵ���
		}
		for(int i=1; i<=N; i++)
			dp[i][0] = cd * i;	//s1ɾ��Ϊ�մ��Ĵ���
		for(int i=1; i<= N; i++) {
			for(int j=1; j<=M; j++) {
				int t =Math.min(dp[i-1][j] + cd, dp[i][j-1] + ci);
				if(s1.charAt(i-1) == s2.charAt(j-1) && dp[i-1][j-1] < t)
					t= dp[i-1][j-1];
				else if(s1.charAt(i-1) != s2.charAt(j-1) && dp[i-1][j-1]+cr < t)
					t = dp[i-1][j-1]+cr;
				dp[i][j] = t;
			}
		}
		return dp[N][M];
	}
	@Test
	public void test() {
		System.out.println(getBest("bbca","cabacab",1,2,7));
	}
}
