package com.parallelcomputing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelVsSeqStreamJava8 {

	public static void main(String[] args) {

		List<Integer> a = new ArrayList<>(100000000);
		List<Integer> b = new ArrayList<>(100000000);

		Random random = new Random();

		for (int i = 0; i < 100000000; i++) {
			int r = random.nextInt(10000000);
			a.add(r);
			b.add(r);
		}

		long start = System.currentTimeMillis();

		a.stream().sorted();

		long finish = System.currentTimeMillis();

		System.out.println("Sequential sort" + (finish - start) / 1000);

		start = System.currentTimeMillis();

		b.stream().sorted();

		finish = System.currentTimeMillis();

		System.out.println("Parallel sort" + (finish - start) / 1000);
	}

}
