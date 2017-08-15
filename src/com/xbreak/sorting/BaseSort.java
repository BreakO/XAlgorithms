package com.xbreak.sorting;

import edu.princeton.cs.algs4.StdOut;

public class BaseSort {
	protected static boolean less(Comparable v, Comparable w) {
	   return (v.compareTo(w) < 0);
	}

	protected static void exch(Comparable[] a, int i, int j) {
	   Comparable swap = a[i];
	   a[i] = a[j];
	   a[j] = swap;
	} 
    public static boolean isSorted(Comparable[] a) {
  
        for (int i = 0 + 1; i < a.length; i++)
            if (less(a[i], a[i-1])) 
            	return false;
        return true;
    }
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
        	if(i%7 == 0)
        		StdOut.println();
            StdOut.print("  "+a[i]);
        }
    }
}
