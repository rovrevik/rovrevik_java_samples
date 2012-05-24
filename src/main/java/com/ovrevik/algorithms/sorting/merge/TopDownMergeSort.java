package com.ovrevik.algorithms.sorting.merge;

/**
 * Implementation of top-down merge sort or simply merge sort.
 * @author ryanovrevik
 *
 * @param <T>
 */
public class TopDownMergeSort<T extends Comparable<? super T>> extends MergeSort<T> {
	@Override
	public void sort(T[] a) {		
		T[] temp = a.clone();
		sort(a, 0, a.length - 1, temp);
	}
	
	public static <T extends Comparable<? super T>> void sort(T[] a, int start, int end, T[] temp) {
		int mid = start + (end - start) / 2;
		System.out.print(String.format("mergeSort [%d - %d - %d] a: ", start, mid, end)); show(a);		
		if (end > start) {
			sort(a, start, mid, temp); //sort the left half
			sort(a, mid + 1, end, temp); //sort the right half
			merge(a, start, mid, end, temp);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Merge Sort");
		String[] a = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		new TopDownMergeSort<String>().doSortInternal(a);
		//new TopDownMergeSort().doSort(args);
	}
}
