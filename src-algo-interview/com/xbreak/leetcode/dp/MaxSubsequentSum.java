package com.xbreak.leetcode.dp;

/**
 * @author XBreak	
 *	��������к�
 *
 *����һ�������и����������飬���ҳ��ܺ������������С�
����һ��int����A�������Сn���뷵�������������еĺ͡���֤n�Ĵ�СС�ڵ���3000��
����������
[1,2,3,-6,1]
���أ�6
 *
 */
public class MaxSubsequentSum {
    public int getMaxSum(int[] A, int n) {
        // write code here
    	
    	if(A == null || A.length == 0)
    		return 0;
        int dp = 0, max = A[0];
        for(int i=0; i<A.length; i++){
            dp+=A[i];				//�����ۼ�
            if(dp > max)			//�������ֵ
                max = dp;
            if(dp < 0)				//���ۼӵĺ�С��0, �򲻿���Ϊ��ֵ,�ӵ�,��һ�����������ۼ�
                dp = 0;
        
        }
        return max;
    }
}
