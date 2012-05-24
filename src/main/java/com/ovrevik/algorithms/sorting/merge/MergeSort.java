package com.ovrevik.algorithms.sorting.merge;

import com.ovrevik.algorithms.sorting.Sort;

/**
 * Implementation of top-down merge sort
 * @author ryanovrevik
 *
 * @param <T>
 */
abstract public class MergeSort<T extends Comparable<? super T>> extends Sort<T> {
	protected static <T extends Comparable<? super T>> void merge(T[] a, int start, int mid, int end, T[] temp) {
		for (int i = start; i <= end; i++) {
			temp[i] = a[i];
		}
		System.out.print("merge temp: ");
		show(a);
		
		for (int i = start, j = start, k = mid + 1; i <= end; i++) {
			System.out.print(String.format("merge a[%d]=%s", i, a[i]));
			if (j > mid) {
				System.out.print(String.format(" right temp[%d]=%s", k, temp[k]));
				a[i] = temp[k++];
			}
			else if (k > end) {
				System.out.print(String.format(" left temp[%d]=%s", j, temp[j]));
				a[i] = temp[j++];
			}
			else if (less(temp[j], temp[k])) {
				System.out.print(String.format(" left temp[%d]=%s < temp[%d]=%s", j, temp[j], k, temp[k]));
				a[i] = temp[j++];
			}
			else {
				System.out.print(String.format(" right temp[%d]=%s >= temp[%d]=%s", j, temp[j], k, temp[k]));
				a[i] = temp[k++];
			}
			System.out.print(String.format(" a[%d]=%s a=", i, a[i]));
			show(a);
		}
	}
}
