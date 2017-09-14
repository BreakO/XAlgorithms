package com.xbreak.newcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class DiviMusic {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			int [] arr = new int[n];
			for(int i=0; i<n; i++)
				arr[i] = scanner.nextInt();
			System.out.println(getRes(arr));
			
		}
	}
	
	private static int getRes(int[] arr) {
		// TODO Auto-generated method stub
		
		if(arr == null || arr.length == 0)
			return 0;
		
		int N = arr.length;

		Deque<Integer> q1 = new LinkedList<Integer>();
		Deque<Integer> q2 = new LinkedList<Integer>();
		int min, max;
		min = max = 0;
		for(int i=1; i < N; i++) {
			if(arr[i] > arr[min])
				min = i;
			if(arr[i] < arr[max])
				max = i;
		}
		q1.addFirst(arr[min]);
		q2.addFirst(arr[max]);
		for(int i=0; i<N; i++) {
			
			int t1,t2, p1, p2;
			if(i < min) {
				t1 = Math.abs(arr[i]-arr[min]);
				
			}
			
		}
		return max;
		
		
	}


}
