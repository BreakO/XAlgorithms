package com.xbreak.bat.queue_stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 	使用两个栈实现队列,支持pop(),以及push操作
 * 
 * 思路  把栈1 全部倒入栈2,则栈2的出栈顺序即为队列
 * @author XBreak
 */
public class Stack4Queue {
	
	private Stack<Integer> stack1, stack2;
	private boolean flag = true;		//标记 是否需要在进行put all 操作  true已经putTo1,  false 已经putTo2
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
