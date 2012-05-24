package com.ovrevik.algorithms.sorting.merge;

/**
 * Implementation of top-down merge sort
 * @author ryanovrevik
 *
 * @param <T>
 */
public class BottomUpMergeSort<T extends Comparable<? super T>> extends MergeSort<T> {
	@Override
	public void sort(T[] a) {		
		T[] temp = a.clone();
		for (int chunkSize = 1; chunkSize <= a.length; chunkSize += chunkSize) {
			for (int start = 0; start < a.length; start += chunkSize) {
				int mid = start + (chunkSize / 2) - 1;
				int end = Math.min(start + chunkSize - 1, a.length - 1);
				merge(a, start, mid, end, temp);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Merge Sort");
		String[] a = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		new BottomUpMergeSort<String>().doSortInternal(a);
		//new BottomUpMergeSort().doSort(args);
	}
}
