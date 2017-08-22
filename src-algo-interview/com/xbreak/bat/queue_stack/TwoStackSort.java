package com.xbreak.bat.queue_stack;

import java.util.Stack;

/**
 * ʹ������ջ��ջ�е�������
 * 
 * ˼· : ����һ����ʱջt, ����ԭʼջ,ȡ��ջ��Ԫ��,��tΪ��,����t��ջ��С��ԭʼջ��ջ��,����t��, 
 * 							����ȡ��t��ջ������ԭʼջ,����ѭ����t�Ĵ�СΪԭ��ԭʼջ�Ĵ�С
 * 
 * @author XBreak
 */
public class TwoStackSort {
	public Stack<Integer> sort(Stack<Integer> stack) {
		Stack<Integer> temp = new Stack<Integer>();
		Integer t = 0;
		int size = stack.size();
		if(!stack.isEmpty())
		 t = stack.pop();
		while(temp.size() != size) {
			if(temp.isEmpty() || t >= temp.peek()) {
				temp.push(t);
				if(!stack.isEmpty())
				t = stack.pop();
			}else {
				
				stack.push(temp.pop());
				
			}
				
		}
		return temp;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(7);
		stack.push(2);
		stack.push(5);
		stack.push(4);
		
		Stack<Integer> t = new TwoStackSort().sort(stack);
		System.out.println(t);
	}
	
}
