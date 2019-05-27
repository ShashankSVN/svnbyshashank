package core.ds.sorting;

public class QuickSortDemo {

	public static void main(String[] arg) {

		int[] arr = { 1, 34, 45, 5, 6, 9, 89 };

		// QuickSortDemo demo;

		// demo.printArray(arr); // it should not work

		printArray(arr);
		// printArray(null); we can pass null to array refernce that suggest array is
		// stored as object in java
		int len = arr.length;
		quickSort(0, len - 1, arr);

		printArray(arr);
	}

	static public void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	static public void quickSort(int start, int end, int[] arr) {

		if (start < end) {
			int pi = getPivot(start, end, arr);
			quickSort(start, pi - 1, arr);
			quickSort(pi + 1, end, arr);

		}

	}

	private static int getPivot(int start, int end, int[] arr) {
		int pi = start;
		int i = start;
		while (i < end) {
			if (arr[i] < arr[end]) {
				// swap arr[i] and arr[pi]
				int temp = arr[pi];
				arr[pi] = arr[i];
				arr[i] = temp;
				pi++;
			}
			i++;

		}
		return pi;
	}

}
