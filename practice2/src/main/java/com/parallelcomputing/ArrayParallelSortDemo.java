package com.parallelcomputing;

import java.util.Arrays;
import java.util.Random;

public class ArrayParallelSortDemo {

	public static void main(String[] args) {

		int[] a = new int[100000000];
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
		Arrays.parallelSort(b);
		finish = System.currentTimeMillis();

		System.out.println("Parallel sort" + (finish - start) / 1000);
		
		
		
	}

}
