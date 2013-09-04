package com.ovrevik.algorithms.sorting;

public class QuickSort<T extends Comparable<? super T>> extends Sort<T> {
	@Override
	public void sort(T[] a) {
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
		System.out.println("Quick Sort");
		new QuickSort<String>().doSort(args);
	}
}
