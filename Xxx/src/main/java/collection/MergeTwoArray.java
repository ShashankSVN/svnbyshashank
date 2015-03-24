package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class DoNotPassZero extends Exception {
	public DoNotPassZero(String message) {
		super(message);
	}
}

public class MergeTwoArray {

	public static void main(String[] args) {
		int result[] = merge(new int[] { 1, 23, 4, 5, 5 }, new int[] { 10, 2,
				1, 3, 4, 5 });
		for (int p : result) {
			System.out.println(p);
		}
		int x = 0;
		try {
			x = divide1(-4, -2);
		} catch (DoNotPassZero e) {
			e.printStackTrace();
		}
		System.out.println(x);

		int aaa=-3%-2;
		System.out.println(aaa);
	}

	//
	static int divide1(int a, int b) throws DoNotPassZero {
		int t = 1;
		if (b == 0) {
			DoNotPassZero doNotPassZero = new DoNotPassZero(
					"a/0 is not defined");
			throw doNotPassZero;
		}
		boolean negative = false;
		if (b < 0 && a < 0) {
			b = -b;
			a = -a;

		} else {
			if (a < 0) {
				//a =- a;
				a=Math.abs(a);
				negative = true;
			}
			if (b < 0) {
				b = -b;
				negative = true;
			}
		}
		while (b * t <= a) { // 5 10 15 , m/n =55/5 = 11 ==O(m/n)
			t++;
		}

		if (negative) {
			return -(t - 1);
		} else {
			return t - 1;
		}
	}

	/**
	 * 
	 * @param arr1
	 *            =size =m
	 * @param arr2
	 *            size =n
	 * @return
	 */
	private static int[] merge(int[] arr1, int arr2[]) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Set<Integer> integers = new HashSet<Integer>();
		for (int x : arr1) { // O(m)
			integers.add(x); // O(1)
			// O(m)*O(1) = O(m)
		}

		for (int x : arr2) { // O(n)
			boolean b = integers.contains(x);// O(1)
			if (b) {
				arrayList.add(x); // //O(1)
			}
		}

		int a[] = new int[arrayList.size()];
		int p = 0;
		for (int x : arrayList) { // O(m) m=20 ,n =10
			a[p++] = x;
		}
		// O(m)+O(m)+O(m) =O(3m) =O(m)
		return a; // total = O(m)+O(n) = O(m+n) = >>>> =log(n) >> O(1)
	}

}
