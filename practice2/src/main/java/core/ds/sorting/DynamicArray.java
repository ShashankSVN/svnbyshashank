package core.ds.sorting;

import java.util.ArrayList;
import java.util.List;

class MyArray {

}

public class DynamicArray {

	static int[] arr = null;

	static int size = 0;

	static int[] insert(int val) {

		if (size == arr.length) {
			System.out.println("Size doubled");
			int[] tempArr = new int[2 * size];
			for (int i = 0; i < size; i++) {
				tempArr[i] = arr[i];
			}
			arr = tempArr;
		}
		arr[size] = val;
		size++;
		return arr;
	}

	public static void main(String[] args) {

		arr = new int[10];

		for (int i = 0; i < 100; i++) {

			insert(89);
		}

		System.out.println(size);

		System.out.println(arr.length);


	}

}
