package com.xbreak.bat.binarySearch;

/**
 * 快速N次方
 * 
 * 10^5 =  10^0101 = 10^4 * 10^1
 * 
 * 对n进行位运算的右移操作, 如果n的最低为 为1则 乘以该为上的x次幂
 * 
 * @author XBreak
 */
public class Pow {
	public double pow(double x, int n) {
		
        double res = 1, base = x, m = n;
        n = Math.abs(n);
        
        // 没有对INteger.MIN_VALUE进行处理
		if(x == 1)         return 1;
        else if(x == -1)  return n % 2 == 0 ? 1 : -1;
        
       
        while(n != 0){
            
            if((n&1) == 1)
                res *= base;
            base *= base;
            n >>= 1;
        }
        if(m < 0)
            res = 1 / res;
        return res;
	}
	
	public static void main(String[] args) {
		double pow = new Pow().pow(-1, Integer.MIN_VALUE);
		
		System.out.println(pow);
		
//		System.out.println(Integer.MIN_VALUE);
//		System.out.println(Integer.MAX_VALUE);
		
	}
	
}
