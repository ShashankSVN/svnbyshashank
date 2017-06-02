package com.threading;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

class A {

	// ketset and entryset both backed by ConcurrentHashMap and any changes
	// happen may or may not be visible while iterating

	// In Node called bin value and next both are Volatile

	// at one index if bin count greater than 8 - and when 9th came its first
	// changes to tree and enter new element

	// complexity varies from O(1) , O(logn), O(n)

	// concurrency level is used only in serialization and de serialization

	// if bin is empty at index no locking required

	// read operation not blocked

	// lock happen at index level

	String a;

	static int i = 1;

	static int val = 1;

	public A(String a) {
		super();
		this.a = a;
	}

	@Override
	public String toString() {
		return "A [a=" + a + "]";
	}

	@Override
	public int hashCode() {

		if (i <= 7) {
			i++;
			return val;
		} else if (i <= 14) {
			i++;
			return val + 1;
		} else if (i <= 21) {
			i++;
			return val + 2;
		}
		return 0;
	}

}

public class FailSafeNatureConcurrentHashMap {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		
		ForkJoinPool forkJoinPool = new ForkJoinPool(2);
		
		Map<A, A> map = new ConcurrentHashMap<>();

		for (int i = 0; i < 15; i++) {
			System.out.println(map.hashCode());
			A a = new A(i + "");
			map.put(a, a);
		}

		Set<A> keys = map.keySet();

	/*	for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
			A a = (A) iterator.next();
			System.out.println(a);

		}*/

	}

}
