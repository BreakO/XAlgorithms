package com.xbreak.bat.queue_stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 	ʹ������ջʵ�ֶ���,֧��pop(),�Լ�push����
 * 
 * ˼·  ��ջ1 ȫ������ջ2,��ջ2�ĳ�ջ˳��Ϊ����
 * @author XBreak
 */
public class Stack4Queue {
	
	private Stack<Integer> stack1, stack2;
	private boolean flag = true;		//��� �Ƿ���Ҫ�ڽ���put all ����  true�Ѿ�putTo1,  false �Ѿ�putTo2
	public Stack4Queue() {
		
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
		
	}
	public void push(Integer item) {
		putTo1();
		stack1.push(item);
	}
	public Integer pop() {
		putTo2();
		return stack2.pop();
	}
	public void putTo2() {
		if(!flag)
			return ;
		stack2.clear();
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		flag = false;
		System.out.println("do put 2");
	}
	public void putTo1() {
		if(flag)
			return ;
		stack1.clear();
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		flag = true;
		System.out.println("do put 1");
	}
	public boolean isEmpty() {
		return stack2.isEmpty();
	}
	
    public List<Integer> twoStack(int[] list){
    	List<Integer> res = new ArrayList<Integer>();
    	Stack4Queue q = new Stack4Queue();
    	for(int i : list) {
    		if(i != 0)
    			q.push(i);
    		else
    			q.pop();
    	}
    	while(!q.isEmpty())
    		res.add(q.pop());
    	return res;
    }
	
	public static void main(String[] args) {
		
		List<Integer> stack = new Stack4Queue().twoStack(new int[] {1,2,3,0,4,0});
		System.out.println(stack);
	}
}
