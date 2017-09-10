package com.xbreak.leetcode;

import org.junit.Test;

public class StrangePointer {
public int strangePrinter(String s) {
        
        if(s == null || s.length() == 0)
            return 0;
        int N =s.length();
        int [] letter = new int[26];
        int [] dp = new int[N];
        int cur = 1;
        letter[s.charAt(0)-'a'] = 1;
        dp[0] = 1;
        for(int i=1; i<N; i++){
            char a = s.charAt(i);
            if(a == s.charAt(i-1)){
                  dp[i] = dp[i-1];
            }   
            else{
                
                dp[i] = Math.min(letter[a-'a'] != 0 ? letter[a-'a']+1 : Integer.MAX_VALUE, dp[i-1]+1);
                
            }
            
             letter[a - 'a'] = dp[i];
        }

        return dp[N-1];    
                
        
    }

//	@Test
//	public void test1() {
//		System.out.println(strangePrinter("aaabab"));
//	}
	@Test
	public void test2() {
		System.out.println(strangePrinter2("tbgtbg"));
	}
	public int strangePrinter2(String s) {
		
		violence(new char[s.length()] , 0, s);
		return cur;
	}
	int cur = 0;
	public void violence(char[] arr, int j, String s) {
		if(new String(arr).equals(s))
			return ;
		char c = s.charAt(j);
		
		cur++;
		while(j < s.length() && s.charAt(j) == c) {
			arr[j] = c;
			j++;
		}
		int l = s.indexOf(c, j+1);
		if(l != -1)
			for(int i = j; i<=l; i++)
				arr[i] = c;
		
		 violence(arr, j++, s);
			
//		int i = ++j;
//		cur++;
//		while(i<s.length()) {
//			if(s.charAt(i) == c)
//				break;
//			arr[i++] = c;
//			if(s.equals(new String(arr)))
//				break;
//		}
//		if(j >= s.length())
//			return ;
//		else
//			violence(arr, j, s);
	}
	

}
