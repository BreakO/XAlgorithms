package com.xbreak.bat.queue_stack;

import java.util.Stack;

/**
 * �ܹ�ά����ֵ��ջ
 * 
 * ˼· : ����ֻά��һ����ֵmin,����ά��ÿһ������ֵ,�������Ա�֤��pop����Ѹ�ٵõ���ֵ
 * 
 * @author XBreak
 */
public class MinStack {
	Stack<Integer> stack_src, stack_min;
	
	public MinStack() {
		stack_min = new Stack<>();
		stack_src = new Stack<>();
	
	}
	
	public Integer pop() {
		stack_min.pop();
		return stack_src.pop();
	}
	
	public void push(Integer item) {
		stack_src.push(item);
		if(stack_min.isEmpty() || stack_min.peek() > item)
			stack_min.push(item);
		else
			stack_min.push(stack_min.peek());
	}
	public Integer min() {
		return stack_min.peek();
	}
	public static void main(String[] args) {
		MinStack minS = new MinStack();
		minS.push(4);
		minS.push(6);
		minS.push(3);
		minS.push(5);
		minS.pop();
		minS.push(9);
		minS.push(2);
		minS.push(8);
		System.out.println(minS.min());
		minS.pop();
		minS.pop();
		minS.pop();
		minS.pop();
		System.out.println(minS.min());
	}
}
