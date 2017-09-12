package com.xbreak.newcode;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ReOrderTo4 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			
			int time = scanner.nextInt();
			for(int t =0; t<time; t++) {
				
				int n = scanner.nextInt();
				int[] arr =new int[n];
				for(int i=0; i<n; i++)
					arr[i] = scanner.nextInt();
				
				System.out.println(canTo4(arr));
			}
			
			
			
		}
	}
	
	public static String canTo4(int[] arr) {
		int sum = 0;
		for(int x : arr) {
			if(x%4 == 0)
				sum++;
		}
		return arr.length > (sum*2)+1 ? "No": "Yes";
	}
	
}
