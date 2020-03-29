package com.codingpractice;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class PrintPrimeBetween1And100 {

	static int numOfComp1stStyle = 0;
	static int numOfComp2ndStyle = 0;

	public static void main(String[] args) {

		Set<Integer> integers = new LinkedHashSet<>(200);

		System.out.println("Adding element to set");
		for (int i = 1; i <= 100; i++) {
			integers.add(i);
		}

		for (Iterator<Integer> iterator = integers.iterator(); iterator.hasNext();) {
			Integer integer = iterator.next();

			System.out.print(integer + " ");
		}
		System.out.println();
		for (int i = 2; i <= 100; i++) {
			if (!integers.contains(i)) {
				numOfComp1stStyle++;
				continue;
			}
			boolean skipFirstElement = true;
			for (Iterator<Integer> iterator = integers.iterator(); iterator.hasNext();) {

				numOfComp1stStyle++;

				Integer integer = iterator.next();
				if (integer % i == 0) {
					if (skipFirstElement) {
						skipFirstElement = false;
					} else {
						iterator.remove();
					}
				}
			}
		}

		System.out.println("After logic print element");

		for (Iterator<Integer> iterator = integers.iterator(); iterator.hasNext();) {
			Integer integer = iterator.next();

			System.out.print(integer + " ");
		}
		System.out.println();
		System.out.println("numOfComp1stStyle: " + numOfComp1stStyle);
		printPrimeNumbers();
		System.out.println("numOfComp2ndStyle: " + numOfComp2ndStyle);

	}

	static void printPrimeNumbers() {

		int i, j;
		for (i = 2; i <= 100; i++) {
			for (j = 2; j <= i; j++) {
				numOfComp2ndStyle++;
				if (i % j == 0) {
					break;
				}
			}
			if (i == j)
				System.out.println(j);
		}
	}

}
