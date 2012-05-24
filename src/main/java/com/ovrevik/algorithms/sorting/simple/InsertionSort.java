package com.ovrevik.algorithms.sorting.simple;

import com.ovrevik.algorithms.sorting.Sort;

public class InsertionSort<T extends Comparable<? super T>> extends Sort<T> {
	@Override
	public void sort(T[] a) {
		//iterate over the input from left to right
		for (int i = 1; i < a.length; i++) {
			//iterate from the current index back to one after the first index
			for (int j = i; j > 0; j--) {
				//is j out of order (is it less than the one to it's left)?
				if (less(a[j], a[j-1])) {
					//j was out of order so, shift it to the left
					exch(a, j, j-1);
				}
				else {
					//j is greater than the one to its left so (and thus sorted)
					//we know everything before j is sorted correctly.
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Insertion Sort");
		new InsertionSort<String>().doSort(args);
	}
}
