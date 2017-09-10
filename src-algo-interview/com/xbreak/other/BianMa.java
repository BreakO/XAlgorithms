package com.xbreak.other;

import java.util.Scanner;

public class BianMa {
    private static int [] arr= new int[1001];
    public static void main(String [] args){
        
        Scanner scanner = new Scanner(System.in);
        
        
        while(scanner.hasNext()){
            int x = scanner.nextInt();
            int l = -90, r = 90;
            int i = 0;
            while(i < 6){
                
                int mid = (l+r)/2;
            //    if(mid == x)
              //      break;
                i++;
                if(x >= mid){
                    System.out.print("1");
                    l = mid;
                }else{
                    System.out.print("0");
            		r = mid-1;
                }
            }
        }
        
    }
}
