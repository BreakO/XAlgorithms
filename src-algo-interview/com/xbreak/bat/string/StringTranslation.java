package com.xbreak.bat.string;

/**
 * ×Ö·û´®ÒÆÎ»
 * ABCDE  ÒÆÎ»3 => DEABC
 * @author XBreak
 */
public class StringTranslation {
	public String translation(String str, int p) {
		char [] a = str.toCharArray();
		int n = a.length;
		int j=0;
		for(int i = p; i<n; i++, j++) {
			a[j] = str.charAt(i);
		}
		for(int i=0; i<p; i++, j++)
			a[j] = str.charAt(i);
		return String.valueOf(a);
	}
	public static void main(String[] args) {
		System.out.println(new StringTranslation().translation("ABCDE", 3));
	}
}
