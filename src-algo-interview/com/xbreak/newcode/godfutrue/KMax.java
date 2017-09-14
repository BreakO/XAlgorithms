package com.xbreak.newcode.godfutrue;

import java.util.Arrays;
import java.util.Scanner;

public class KMax {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String str = scanner.nextLine();
			String[] split = str.split(" ");
			int [] arr = new int[split.length];
			for(int i=0; i<split.length; i++)
				arr[i] = Integer.valueOf(split[i]);
			getRes(arr);
		}
	}

	private static void getRes(int [] arr) {
		// TODO Auto-generated method stub
		int N = arr.length;
		int k = arr[N-1];
//		Arrays.sort(arr, 0,arr.length-1);
//		for(int i=0; i<k; i++)
//			System.out.print(arr[i]+" ");
		new KMax().quickSort(arr, 0, arr.length-1,k);
		System.out.println(arr);
	}
	
	private int partation(int [] arr, int lo, int hi) {
		
		int base = arr[lo];
		int l = lo+1, r = hi;
		while(true) {
			while(arr[l] < base) { l++; if(l >= hi) break; };
			while(arr[r] > base) { r--; };
			
			if(l>= r)
				break;
			
			int t = arr[l];
			arr[l] = arr[r];
			arr[r] = t;
			
		}
		int t = arr[lo];
		arr[lo] = arr[r];
		arr[r] = t;
		return r;
	}
	public void quickSort(int [] arr,  int lo, int hi, int k) {
		
		if(lo >= hi)
			return ;
		int i = partation(arr, lo, hi);
		
		quickSort(arr, lo, i-1, k);
		if(i<k)
			quickSort(arr, i+1, hi, k);
		
	}
	
}
