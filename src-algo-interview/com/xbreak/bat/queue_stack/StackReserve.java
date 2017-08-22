package com.xbreak.bat.queue_stack;

import java.util.Stack;

/**
 * 使用递归和pop操作实现栈的逆序
 * 
 * 思路 : 使用get实现删除并返回栈底元素, 而使用 reverse方法实现逆序
 * 	   get : 取出栈顶元素  若栈不为空 , 进入下一层递归, 直到栈为空,返回为空时的栈顶元素,而不把它压入栈中.
 *     reverse : 若栈不为空,通过get方法取出栈底元素,进入下一层递归,直到栈为空,把栈底元素重新压人栈中.
 * 
 * @author XBreak
 */
public class StackReserve {
	public Stack<Integer> reserveStack(Stack<Integer> stack){
		if(stack == null || stack.isEmpty())
			return stack;
		reverse(stack);
		return stack;
	}
	
	public void reverse(Stack<Integer> stack) {
		if(stack.isEmpty())
			return ;
		int t = get(stack);
		reverse(stack);		//递归取栈底
		stack.push(t);		//递归到栈空,依次将栈底压入栈中
	}
	
	public Integer get(Stack<Integer> stack) {
		
		Integer top = stack.pop();
		if(stack.isEmpty()) {
			return top;				//递归到栈空,直接返回,不压栈
		}else {
			int t = get(stack);		//递归取栈顶,并维护从递归到栈空时获取的栈底
			stack.push(top);		//递归到栈空重新压入栈顶
			return t;				//返回栈底
		}
			
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(new StackReserve().reserveStack(stack));
	}
}
