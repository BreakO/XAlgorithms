package com.xbreak.newcode.godfutrue;

import java.util.Scanner;

public class FindLongNumber {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String str = scanner.next();
			System.out.println(getRes(str));
		}
		
	}

	private static String getRes(String str) {
		
		if(str == null || str.length() == 0)
			return "";
		int N = str.length();
		StringBuilder sb = new StringBuilder();
		StringBuilder ms = new StringBuilder();
		int max=0;
		for(int i=0; i<N; i++) {
			if(Character.isDigit(str.charAt(i))) {
				sb.append(str.charAt(i));
			}else {
				if(sb.length() > ms.length())
					ms = sb;
				sb = new StringBuilder();
			}
		}
		
		return ms.toString();
	}
}
