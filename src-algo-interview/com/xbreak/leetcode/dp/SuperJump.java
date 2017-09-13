package com.xbreak.leetcode.dp;

import java.util.Scanner;

public class SuperJump {

		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			while(scanner.hasNext()){
				int t = scanner.nextInt();
				int [] arr = new int[t];
				for(int i=0; i<t; i++){
					arr[i] = scanner.nextInt();
				}
				System.out.println(getRes(arr));
			}
		}

		public static int getRes(int[] arr) {
			// TODO Auto-generated method stub
			
			int dp = 0, max = 0 , last = 0;
			for(int i=0; i<arr.length; i++) {
				if(arr[i] > last) {
					dp+=arr[i];
					last = arr[i];
				}
//				if(dp > max)
//					max = dp;
				
			}
			
			
			return dp;
		}
}
