package com.xbreak.extra.greedy;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author XBreak
 *	
 */
public class TasksScheduler {
	  public int leastInterval(char[] tasks, int n) {
	        if(tasks == null || tasks.length == 0)
	            return 0;
	        int sum=0;
	        int[] ts = new int[26];
	        int N= tasks.length;
	        for(int i=0; i<N; i++)
	            ts[tasks[i]-'A']++;
	      
	        Arrays.sort(ts);
	        
	        while(ts[25]>0){
	            
	            int i = 0;
	            while(i <= n){
	                if(ts[25] == 0)
	                    break;
	                if(i<26 && ts[25-i] != 0 )
	                    ts[25-i]--;
	                i++;
	                sum++; 
	            }
	            Arrays.sort(ts);
	            
	        }
	 
	        return sum;   
	    }
    @Test
    public void test() {
    	int res = leastInterval(new char[] {'A','A','A','B','B','B'}, 2);
    	System.out.println(res);
    }
}
