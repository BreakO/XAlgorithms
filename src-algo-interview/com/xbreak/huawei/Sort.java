package com.xbreak.huawei;

import java.util.Scanner;

public class Sort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String x = scanner.next();
            x = x.substring(2);
             
            int N = x.length();
            int sum = 0;
            for(int i=0; i<N; i++){
                int v = 0;
                char c = x.charAt(i);
                if(Character.isDigit(c))
                    v = c - '0';
                else
                    v = c - 'A' + 10;
                int r = (int) Math.pow(16,N-1-i);
                sum =sum +  v * r;
            }
            System.out.println(sum);
        }
	}
}
