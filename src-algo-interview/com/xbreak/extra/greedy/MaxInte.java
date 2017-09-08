package com.xbreak.extra.greedy;

public class MaxInte {
//[2,7,9,4,1],5
	public static void main(String[] args) {
		System.out.println(countArea(new int[] {2,7,9,4,1}, 5));
	}
    public static int countArea(int[] A, int n) {
        // write code here
        int max = A[0];
        for(int i=1; i<n; i++){
            if(A[i] > max)
                max = A[i];
            for(int j=0; j< i; j++)
                if(A[i] >= A[j] && max < A[j]*(i-j+1))
                    max=A[j]*(i-j+1);
        }
        return max;
        
    }
}
