package com.xbreak.other;

import java.util.Scanner;

public class ZhiShuSUm {
    private static int [] arr= new int[1001];
    public static void main(String [] args){
        
        Scanner scanner = new Scanner(System.in);
        
        
        init();
        
        while(scanner.hasNext()){
            int x = scanner.nextInt();
            if(x <= 1)
                System.out.println("0");
            if(x == 2)
                System.out.println("1");
            System.out.println(getRes(x));
        }
        
    }
    
    private static int getRes(int x){
        int sum = 0;
        for(int i=2; i<=x/2; i++)
            if(arr[i] == 0 && arr[x-i] == 0)
                sum++;
        return sum;
    }
    
    private static void init(){
        for(int i=3; i<=1000; i++)
            for(int j=2; j <= i/2  ; j++)
                if(arr[j] != 1 && i % j ==0){
                    arr[i] = 1;
                    break;
                }
                    
    }
    public static boolean isZhi(int num){
        return arr[num] == 0 ? true : false;
    }
}
