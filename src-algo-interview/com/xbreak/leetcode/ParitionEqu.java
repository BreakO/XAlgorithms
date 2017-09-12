package com.xbreak.leetcode;

/**
 * @author XBreak
 * �з����������
 * 	��һ������, �з�Ϊ��������ȵ�������, �ж��Ƿ����з�
 * 
 * �ⷨ: 0/1 ��������
 *   dp[i][j] ʹ��ǰi���ܷ�ճ�j
 *   dp[0][0] = true ʹ��ǰ0���ܴճ�0 , ���� dp[i][0] =true
 *   dp[0][1~i]= false, ʹ��ǰ0��ɶҲ�ղ���
 *   
 *   ״̬ת��:  ����ܹ�ʹ��ǰi-1���ճ�j, ��ǰj��Ҳ��(��ʹ�õ�ǰ��), ����ʹ��ǰi-1���ܴճ�j-numg[i](���ϵ�ǰ���պôճ�),
 *   dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1](��ǰ��)); 
 */
public class ParitionEqu {
    public boolean canPartition(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return false;
        
        int sum = 0;
        int n = nums.length;
        for(int x : nums)
            sum+=x;
        
        if((sum & 1) == 1)
            return false;
        sum /= 2;
        // dp[i][j] ; ʹ��ǰi��,�Ƿ��ܴճ�dp
        boolean [][] dp = new boolean [n+1][sum+1];
        
        dp[0][0] = true;    //ʹ��ǰ0����0  Ϊ��
        for(int i=0; i<=sum; i++)
            dp[0][i] = false;  //ʹ��0�����κν�Ϊ0
        for(int j=1; j<=n;j++)
            dp[j][0] = true;    //0���ܴ�0, ����1~N���ܴ�0
        for(int i=1; i<= n; i++)
            for(int j=1; j<=sum; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i-1])
                    dp[i][j] = (dp[i-1][j] || dp[i-1][j-nums[i-1]]);
            }
                
        return dp[n][sum];
    }
}
