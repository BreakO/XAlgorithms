package com.xbreak.leetcode;

/**
 * @author XBreak
 *	�����ָ� : 
 */
public class ArithParition {
    public int numberOfArithmeticSlices(int[] arr) {
		if(arr == null || arr.length <=2)
			return 0;
		int sum = 0;
		
		int dp = 0;   //����ǰ�������������еĸ��� ,12340246  ��i=2  dp->1(1,2,3)->2(2,3,4 ; 1,2,3,4)->0->0->1(0,2,4)->2(0,2,4,6; 2,4,6)
		
		for(int i=2; i<arr.length; i++){        // arr[0~2] �Զ�һ��, 
			
			if(arr[i]-arr[i-1] == arr[i-1]-arr[i-2]){
				dp++;
			}else
				dp = 0;
			sum+=dp;
				
		}
		return sum;
            
    }
}
