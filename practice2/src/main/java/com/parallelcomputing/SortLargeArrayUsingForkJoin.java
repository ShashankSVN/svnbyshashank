package com.parallelcomputing;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class ForkArray extends RecursiveAction {

	private static final long serialVersionUID = 6974408087498258555L;
	int[] a;
	int l;
	int r;

	public ForkArray(int[] a, int l, int r) {
		this.a = a;
		this.l = l;
		this.r = r;
	}

	protected static int sThreshold = 10;

	@Override
	protected void compute() {
		if ((r - l) < sThreshold) {
			computeDirectly(a, this.l, this.r);
			return;
		}

		int m = (l + r) / 2;

		ForkArray f1 = new ForkArray(a, l, m);
		ForkArray f2 = new ForkArray(a, m + 1, l);

		invokeAll(f1, f2);

		merge(a, l, m, r);

	}

	protected static void computeDirectly(int[] a, int start, int end) {
		Arrays.sort(a, start, end);
	}

	protected static void merge(int arr[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
}

public class SortLargeArrayUsingForkJoin {

	public static void main(String[] args) {
		
		
		int[] a = new int[10];

		for (int i = 0, j = 100; i < a.length; i++, j--) {

			a[i] = j;

		}
		
		System.out.println(a);
		
		parallelSort(a);
		
		System.out.println(a);
		
		
		

		/*int[] a = new int[100000000];
		int[] b = new int[100000000];
		Random random = new Random();

		for (int i = 0; i < 100000000; i++) {
			int r = random.nextInt(10000000);
			a[i] = r;
			b[i] = r;
		}

		long start = System.currentTimeMillis();
		Arrays.sort(a);
		long finish = System.currentTimeMillis();

		System.out.println("Sequential sort" + (finish - start) / 1000);

		start = System.currentTimeMillis();
		parallelSort(b);
		finish = System.currentTimeMillis();

		System.out.println("Parallel sort" + (finish - start) / 1000);*/

	}

	private static void parallelSort(int[] b) {

		ForkArray forkArray = new ForkArray(b, 0, b.length - 1);

		ForkJoinPool forkJoinPool = new ForkJoinPool();

		forkJoinPool.invoke(forkArray);

	}

}
