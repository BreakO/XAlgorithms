package com.xbreak.bat.queue_stack;

import java.util.Stack;

/**
 * 使用两个栈对栈中的数排序
 * 
 * 思路 : 创建一个临时栈t, 遍历原始栈,取出栈顶元素,若t为空,或者t的栈顶小于原始栈的栈顶,加入t中, 
 * 							否则取出t的栈顶加入原始栈,依次循环至t的大小为原来原始栈的大小
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
