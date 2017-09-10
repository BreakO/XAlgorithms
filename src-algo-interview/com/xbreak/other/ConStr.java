package com.xbreak.other;

import java.util.Scanner;

public class ConStr {
    public static boolean isPossible(int[] nums) {
    	if(nums.length<3)
    		return false;
        //return violence(nums, 0, nums.length-1);
    	int vis[] = new int[nums.length];
    	int ans[] = new int[nums.length];
    	int n = nums.length;
    	int size=1;
    	int k=0;
    	//for(int)
    	

    	for(int i=0;i<n-1;++i) {
    		if(nums[i]!=nums[i+1]) {
    			ans[k] = nums[i];
    			vis[k++]=size;
    			
    			size=1;
    			if(i==n-2) {
    				ans[k] = nums[i];
    				vis[k++]=1;
    			}
    		}else {
    			size++;
    			if(i==n-2) {
    				ans[k] = nums[i];
    				vis[k++]=size;
    			}
    		}
    	
    	}
    	//System.out.println(k);
    	ans[k-1]=nums[n-1];
    	for(int i=0;i<k;++i)
    		System.out.print(ans[i]+" ");
    	
    	System.out.println();
     	/*for(int i=0;i<k;++i)
    		System.out.print(vis[i]+" ");
     	System.out.println();*/
    	while(true) {
    		
    		int index=0;
    		int max=vis[0];
    		for(int i=1;i<k;++i) {
    			if(vis[i]>max) {
    				max=vis[i];
    				index=i;
    			}
    		}
    		
    		int mZ = 1;
    		//System.out.println(index);
    		int mk=ans[index];
    		//System.out.println(mk);
    		for(int i=index+1;i<k;++i) {
    			//System.out.println(nums[i]);
    		//	System.out.println("vis"+vis[i]+" "+k);
    			if(vis[i]>=1&&mk+1==ans[i]) {
    				mk= ans[i];
    				mZ++;
    			}
    			else
    				break;
    		}
    	//	System.out.println(mZ);
    	
    		if(mZ>=3) {
    			for(int i=index;i<k&&vis[i]>=1;++i)
    				vis[i]--;
    		}else {
    			return false;
    		}
    		
    		boolean flag=true;
    		for(int i=0;i<k;++i) {
    			if(vis[i]>=1) {
    				flag=false;
    			}
    		}
    		
    		if(flag)
    		return true;
    	}
    	//return false;
    	
    }
    
    public static void main(String[] args) {
    	int nums[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,22,23,23,24,24,25,25,26,26,27,27,28,28,29,29,30,30,31,31,32,32,33,33,34,34,35,35,36,36,37,37,38,38,39,39,39,40,40,40,41,41,41,42,42,42,43,43,43,44,44,44,44,45,45,45,45,46,46,46,46,46,47,47,47,47,47,48,48,48,48,48,49,49,49,49,49,50,50,50,50,51,51,51,51,52,52,52,52,53,53,53,53,54,54,54,54,55,55,55,55,56,56,56,56,57,57,57,57,58,58,58,58,59,59,59,59,59,60,60,60,60,61,61,61,61,62,62,62,63,63,64,64,65,65,66,66,67,67,68,68,68,69,69,69,70,70,70,71,71,71,71,72,72,72,72,72,73,73,73,73,73,74,74,74,74,74,75,75,75,75,75,76,76,76,76,76,77,77,77,77,77,78,78,78,78,78,79,79,79,79,79,80,80,80,80,80,80,81,81,81,81,81,81,82,82,82,82,82,82,83,83,83,83,83,83,84,84,84,84,84,84,85,85,85,85,85,85,86,86,86,86,86,86,87,87,87,87,87,87,88,88,88,88,88,88,89,89,89,89,89,89,90,90,90,90,90,90,91,91,91,91,91,91,92,92,92,92,92,92,93,93,93,93,93,93,94,94,94,94,94,94,95,95,95,95,95,95,96,96,96,96,96,96,97,97,97,97,97,97,98,98,98,98,98,98,99,99,99,99,99,99,100,100,100,100,100,100,101,101,101,101,101,101,102,102,102,102,102,102,103,103,103,103,103,103,104,104,104,104,104,104,105,105,105,105,105,105,106,106,106,106,106,106,107,107,107,107,107,108,108,108,108,108,109,109,109,109,109,110,110,110,110,111,111,111,111,112,112,112,112,113,113,113,113,114,114,114,114,115,115,115,115,116,116,116,116,117,117,117,117,118,118,118,118,119,119,119,119,120,120,120,120,121,121,121,121,122,122,122,122,123,123,123,123,124,124,124,124,125,125,125,125,126,126,126,126,127,127,127,127,128,128,128,128,129,129,129,129,130,130,130,130,131,131,131,131,132,132,132,132,133,133,133,133,134,134,134,135,135,135,136,136,136,137,137,137,138,138,138,139,139,139,140,140,140,141,141,141,142,142,142,143,143,143,144,144,145,146,147,148};
    	//int nums[]= {1,2,3,3,4,4,5,5};
    	//int nums[]= {1,2,4,4,7,7,7,8,8,9};
    	System.out.println(isPossible(nums));
		Scanner scanner= new Scanner(System.in);
		while(scanner.hasNext()) {
			
		}
	}
    
    public boolean violence(int[] arr, int l, int r){
        if(r - l < 0)
            return false;
        boolean ok =false;
        int i = l;
        int len = 3;
        while(len <= r-l){
            
            for(int j = i; j<len-1; j++)
                if(arr[j] == arr[j+1]-1)
                    if(violence(arr, j+2, r))
                        return true;
                    
            len++;
        }
        return false;
    }
}
