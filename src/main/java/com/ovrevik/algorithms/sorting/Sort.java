package com.ovrevik.algorithms.sorting;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;


/**
 * This is a rip off of the testing and experiment approach used by sedgewick.
 */
abstract public class Sort<T extends Comparable<? super T>> {
	abstract protected void sort(T[] a);

	protected static <T extends Comparable<? super T>> boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}

	protected static <T extends Comparable<? super T>> void exch(T[] a, int i, int j) {
		T t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	protected static <T extends Comparable<? super T>> void show(T[] a) {
		// Print the array, on a single line.
		System.out.print(String.format("show: (%d elements): ", a.length));
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static <T extends Comparable<? super T>> boolean isSorted(T[] a) {
		// Test whether the array entries are in order.
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	//@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	public void doSort(String[] args) { 
		// Read strings from standard input, sort them, and print.
		T[] a = (T[]) new String[0];
		try {
			System.out.println(String.format("loading file %s", args[0]));
			a = (T[]) new Scanner(new BufferedInputStream(new FileInputStream(args[0]))).useDelimiter("\\A").next().trim().split("\\s+");
		} catch (Exception e) { System.err.println(e); }
		doSortInternal(a);
	}

	public void doSortInternal(T[] a) { 
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
