package com.xbreak.bat.queue_stack;

import java.util.Stack;

/**
 * ʹ�õݹ��pop����ʵ��ջ������
 * 
 * ˼· : ʹ��getʵ��ɾ��������ջ��Ԫ��, ��ʹ�� reverse����ʵ������
 * 	   get : ȡ��ջ��Ԫ��  ��ջ��Ϊ�� , ������һ��ݹ�, ֱ��ջΪ��,����Ϊ��ʱ��ջ��Ԫ��,��������ѹ��ջ��.
 *     reverse : ��ջ��Ϊ��,ͨ��get����ȡ��ջ��Ԫ��,������һ��ݹ�,ֱ��ջΪ��,��ջ��Ԫ������ѹ��ջ��.
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
		reverse(stack);		//�ݹ�ȡջ��
		stack.push(t);		//�ݹ鵽ջ��,���ν�ջ��ѹ��ջ��
	}
	
	public Integer get(Stack<Integer> stack) {
		
		Integer top = stack.pop();
		if(stack.isEmpty()) {
			return top;				//�ݹ鵽ջ��,ֱ�ӷ���,��ѹջ
		}else {
			int t = get(stack);		//�ݹ�ȡջ��,��ά���ӵݹ鵽ջ��ʱ��ȡ��ջ��
			stack.push(top);		//�ݹ鵽ջ������ѹ��ջ��
			return t;				//����ջ��
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
