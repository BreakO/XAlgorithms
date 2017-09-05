package com.xbreak.bat.dp;

import org.junit.Test;

/**
 * ��������
 * ��M����Ʒȡ�����ɼ����ڿռ�ΪW�ı����ÿ����Ʒ�����ΪW1��W2����Wn��
 * ��֮���Ӧ�ļ�ֵΪP1,P2����Pn������������ֵ�ķ�����
 * 
 * �ⷨ: ����dp[x][y] ��ʾʹ��ǰx��,����������y, �����ֵ
 * 	��һ��: dp[0][0...y] ��y>v[0]ʱ dp[0][y]=p[0],�ұ�ҲȫΪp[0]
 *  ��һ��: dp[0...x][0] ȫΪ0
 *  dp[x][y] = max(dp[x-1][y], dp[x-1][y-v[x]]) ǰ���ǲ��õ�x��, ������Ҫ�õ�x�� ��������v[x]��ֵ��p[x];
 * @author XBreak
 *
 */
public class BagQuestion {
	public int findMax(int [] v, int [] p, int cap) {
	
		int N = v.length;
		int [][]dp = new int[N][cap+1];
		//��һ��  
		dp[0][0] = 0;
		for(int y=1; y<=cap; y++)
			if(v[0] <= y || dp[0][y-1] != 0)
				dp[0][y] = p[0];
		
		for(int x = 1; x < N; x++) {
			for(int y = 1; y <=cap; y++ ) {
				int t = dp[x-1][y];						//ѡ���õ�x��
				if(y >= v[x] && dp[x-1][y-v[x]]+p[x] > t) //��ѡ���õ�x��,��������,�벻��x��ʱ���
					t = dp[x-1][y-v[x]]+p[x];
				dp[x][y] = t;
				
			}
		}
		
		return dp[N-1][cap];
	}
	@Test
	public void test() {
		System.out.println(findMax(new int[] {1,2,4}, new int[] {1,2,2}, 4));
	}
}
