package com.xbreak.fundamentals.three;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

import com.xbreak.util.StdIn;

import edu.princeton.cs.algs4.StdOut;

/**
 * 动态调节的基于数组实现的栈
 * @author XBreak
 * @param <Item>
 */
public class XResizingArrayStack<Item> implements Iterable<Item> {

	private Item[] datas ;	//
	private int N;
	
	/**
	 * create an empty stack
	 */
	public XResizingArrayStack() {
		datas = (Item[]) new Object[1];
		N = 0;
	}
	
	/**
	 * resize the size of stack
	 * @param max
	 */
	public void resize(int max) {
		Item[] temp = (Item[])new Object[max];
		for(int i=0; i < N ; i++)
			temp[i] = datas[i];
		datas = temp;
	}
	
	/**
	 * add an item
	 * @param item
	 */
	public void push(Item item) {
		
		if(N == datas.length)		//increase the number if necessary
			resize(2 * N);
		
		datas[N++] = item;
	}
	
	public Item pop() {
		if(N == 0)
			return null;
		Item temp = datas[--N];
		datas[N] = null;
									//decrease the number if necessary
		if(N >= 0 && N <= datas.length / 4)
			resize(datas.length/2);
		return temp;
	}
	
	/**
	 * Is the datas is empty ? 
	 * @return
	 */
	public boolean isEmpty() {
		return N == 0;
	}
	
	/**
	 * number of items int the stack
	 * @return
	 */
	public int size() {
		return N;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterable();
	}
	
	public class ReverseArrayIterable implements Iterator<Item>{

		private int i = N;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i != 0;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return datas[--i];
		}
	}
    public static void main(String[] args) throws FileNotFoundException {
        XResizingArrayStack<String> stack = new XResizingArrayStack<String>();
        StdIn.setScanner(new Scanner(new File("tobe.txt")));
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
