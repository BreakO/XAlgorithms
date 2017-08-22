package com.xbreak.bat.string;

import java.util.Stack;

/**
 * 判断是否为合法的括号串
 * 
 * 栈的使用
 * @author XBreak
 */
public class VailBracket {
	public boolean checkStr(String str) {
		char [] a = str.toCharArray();
		int n = a.length;
		Stack<Character> s = new Stack<>();
		int b = 0;
		for(int i=0; i<n; i++) {
			if(a[i] == '(')
				b++;
			else if(a[i] == ')')
				b--;
			else 
				if(b <= 0)
					return false;
			if(b < 0)
				return false;
				
		}
		if(b == 0)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new VailBracket().checkStr("(()())"));
		System.out.println(new VailBracket().checkStr("()a()()"));
		System.out.println(new VailBracket().checkStr("()(()()"));
		System.out.println(new VailBracket().checkStr("())()()"));
	}
	
}
