package com.xbreak.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XBreak
 *
 * ������������
 * ��һ�����������Ķ��㵽��ײ�, ����С·��
 * dp[i][j] = arr[i][j] + min(dp[i-1][j-1] , dp[i-1][j]) // �ӿɴ����һ������·���ҳ���̵�
 * ���������һ��·��dp[N-1][i], ��ȡ���·��
 *
 */
public class Tripple {
    public int minimumTotal(List<ArrayList<Integer>> list) {
        if(list == null || list.size() == 0)
			return 0;
		int N = list.size();
		int [][]dp = new int[N][N];
		dp[0][0] =list.get(0).get(0);
		for(int i = 1; i<N; i++){
			for(int j =0; j<= i; j++){
				
				dp[i][j] = list.get(i).get(j);
				int t1, t2 ;
				t1 = j-1>=0 ? dp[i-1][j-1] : Integer.MAX_VALUE;
				t2 = j < i ? dp[i-1][j] : Integer.MAX_VALUE;
				dp[i][j] +=Math.min(t1, t2);
			}
		
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++)
			if(min > dp[N-1][i])
				min= dp[N-1][i];
		return min;
    }
    
    public static void main(String[] args) {
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		list.add(arrayList);
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(2);
		a.add(3);
		list.add(a);
		System.out.println(new Tripple().minimumTotal(list));
	}
    
}
