package com.xbreak.fundamentals.three;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

import com.xbreak.util.StdIn;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1.2	基于链表的栈
 * @author XBreak
 */
public class XStack<Item> implements Iterable<Item> {
	private int N;
	private Node frist;
	private  class Node{
		Item item;
		Node next;
	}
	
	public XStack() {
		frist = null;
		N = 0;
	}
	
	public void push(Item item) {
		Node oldNode = frist;
		frist = new Node();
		frist.item = item;
		frist.next = oldNode;
		N++;
	}
	
	public Item pop() {
		if(frist == null)
			return null;
		Item item = frist.item;
		frist = frist.next;
		N--;
		return item;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverseIterator();
	}
	
	private class ReverseIterator implements Iterator<Item>{

		private Node n = frist;
		@Override
		public boolean hasNext() {
			
			return n != null;
		}

		@Override
		public Item next() {
			Item t = n.item;
			n = n.next;
			
			return t;
		}
		
	}
    public static void main(String[] args) throws FileNotFoundException {
        XStack<String> stack = new XStack<String>();
        StdIn.setScanner(new Scanner(new File("tobe.txt")));
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
	
}
