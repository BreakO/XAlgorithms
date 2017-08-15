package com.xbreak.fundamentals.three;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

import com.xbreak.util.StdIn;
import com.xbreak.util.StdOut;

/**
 * @author XBreak
 *	基于 链表 的队列
 * @param <Item>
 */
public class XQueue<Item> implements Iterable<Item> {

	private Node frist;
	private Node last;
	private int N;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public XQueue() {
		frist = null;
		last = null;
		N = 0;
	}
	
	public boolean isEmpty() {
		return frist == null;
	}
	public int size() {
		return N;
	}
	
	/**
	 * add an item on tail
	 * @param item
	 */
	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		if(isEmpty())		// at that time, oldLast is null;
			frist = last;
		else
			oldLast.next = last;
		N++;
	}
	
	public Item dequeue() {
		if(isEmpty())
			return null;
		
		Item item = frist.item;
		frist = frist.next;
		
		N--;
		
		if(isEmpty())	  //at that time , last still maintain the item that was deleting
			last = null;
		
		return item;
	}
	
	@Override
	public Iterator<Item> iterator() {

		
		
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<Item>{

		Node f = last;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return f == null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			
			if(!hasNext())
				return null;
			Item item = f.item;
			f = f.next;
			
			return item;
		}
		
	}

    public static void main(String[] args) throws FileNotFoundException {
    	
    	StdIn.setScanner(new Scanner(new File("tobe.txt")));
    	
        XQueue<String> queue = new XQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                queue.enqueue(item);
            else if (!queue.isEmpty())
                StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }
	
}
