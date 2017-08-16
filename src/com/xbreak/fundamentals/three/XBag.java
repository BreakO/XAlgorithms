package com.xbreak.fundamentals.three;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

import com.xbreak.util.StdIn;

import edu.princeton.cs.algs4.StdOut;

/**
 *	
 *	1.4	基于 链表 的背包
 *
 * @author XBreak
 * @param <Item>
 */
public class XBag<Item> implements Iterable<Item> {

	private Node frist;
	private int N;
	
	private class Node{
		Item item;
		Node next;
	}
	
	/**
	 *  create  an empty stack
	 */
	public XBag() {		

		N = 0;
		frist = null;
	}
	
	/**
	 * add an item
	 */
	public void add(Item item) {
		Node oldFrist = frist;
		frist = new Node();
		frist.item = item;
		frist.next = oldFrist;
		N++;
	}
	
	/**
	 * Is the bag empty?
	 */
	public boolean isEmply() {
		return N == 0;
	}
	
	/**
	 * number of items in the bag
	 */
	public int size() {
		return N;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		
		Node f = frist;
		
		@Override
		public boolean hasNext() {
			return f != null;
		}

		@Override
		public Item next() {
			Item item = f.item;
			f = f.next;
			return item;
		}
		
	}
    public static void main(String[] args) throws FileNotFoundException {
        XBag<String> bag = new XBag<String>();
        StdIn.setScanner(new Scanner(new File("tobe.txt")));
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            bag.add(item);
        }

        StdOut.println("size of bag = " + bag.size());
        for (String s : bag) {
            StdOut.println(s);
        }
    }
}
