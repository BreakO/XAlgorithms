package com.xbreak.newcode;

import java.text.DecimalFormat;
import java.util.Scanner;

public class StringChip {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			
			String x = scanner.next();
			DecimalFormat format = new DecimalFormat("##0.00");
			String str = format.format(getRes(x));
			System.out.println(str);
			
		}
	}
	public static float  getRes(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		int N = str.length();
		int t = 0;
		char c = '*';
		for(char x : str.toCharArray()) {
			if( x != c) {
				c = x;
				t++;
			}
		}
		float f = (float)N/t;
		return f;
	}
}
