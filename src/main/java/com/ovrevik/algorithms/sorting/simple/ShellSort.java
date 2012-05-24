package com.ovrevik.algorithms.sorting.simple;

import com.ovrevik.algorithms.sorting.Sort;

public class ShellSort<T extends Comparable<? super T>> extends Sort<T> {
	
	private static final int GAP = 3;

	@Override
	public void sort(T[] a) {
		//determine the largest index for the gap and the given array length
		//the next increment above the gap quotient
		int hSort = 1;
		while (hSort < a.length/GAP) {
			hSort = 3 * hSort + 1;
		}
		//iterate over the increment sequence
		while (hSort >= 1) {
			System.out.print(String.format("hSort: %d ", hSort));
			show(a);
			//perform an h-sort
			//iterate over indexes from the current hSort to the end of the array (hSort to the right)
			for (int i = hSort; i < a.length; i++) {
				System.out.println(String.format("- i: %d->%d hSort: %d", i, a.length, hSort));
				//(i to the left)
				for (int j = i; j >= hSort; j -= hSort) {
					int before_j = j-hSort;
					System.out.print(String.format("-- j: %d->%d j-hSort: %d ", j, hSort, before_j));
					if (less(a[j], a[before_j])) {
						System.out.print(String.format("exchanging %d with %d ", j, before_j));	
						exch(a, j, before_j);
						show(a);
					}
					else {
						System.out.println(String.format("sorted %d-%d", i, j));
						break;
					}
				}
			}
			
			//calculate the next increment in the sequence
			hSort /= 3;
		}
	}

	public static void main(String[] args) {
		System.out.println("Shell Sort");
		new ShellSort<String>().doSort(args);
	}
}
