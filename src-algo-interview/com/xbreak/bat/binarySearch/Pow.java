package com.xbreak.bat.binarySearch;

/**
 * ����N�η�
 * 
 * 10^5 =  10^0101 = 10^4 * 10^1
 * 
 * ��n����λ��������Ʋ���, ���n�����Ϊ Ϊ1�� ���Ը�Ϊ�ϵ�x����
 * 
 * @author XBreak
 */
public class Pow {
	public double pow(double x, int n) {
		
        double res = 1, base = x, m = n;
        n = Math.abs(n);
        
        // û�ж�INteger.MIN_VALUE���д���
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
