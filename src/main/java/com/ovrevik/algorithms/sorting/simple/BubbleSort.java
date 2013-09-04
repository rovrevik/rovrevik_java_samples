package com.ovrevik.algorithms.sorting.simple;

import com.ovrevik.algorithms.sorting.Sort;

/**
 */
public class BubbleSort<T extends Comparable<? super T>> extends Sort<T> {
	@Override
	public void sort(T[] a) {
		throw new UnsupportedOperationException("not impleemented yet");
	}

	public static void main(String[] args) {
		System.out.println("Bubble Sort");
		new BubbleSort<String>().doSort(args);
	}
}
