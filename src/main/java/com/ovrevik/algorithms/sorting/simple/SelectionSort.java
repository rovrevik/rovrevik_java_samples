package com.ovrevik.algorithms.sorting.simple;

import com.ovrevik.algorithms.sorting.Sort;

public class SelectionSort<T extends Comparable<? super T>> extends Sort<T> {
	@Override
	public void sort(T[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				int min = i;
				if (less(a[j], a[i])) {
					min = j;
				}
				exch(a, i, min);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Selection Sort");
		new SelectionSort<String>().doSort(args);
	}
}
