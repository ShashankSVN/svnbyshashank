package core.ds.sorting;

public class HeapSort {

	static int insert(int[] heap, int n, int size) {
		heap[size] = n;
		int index = size;
		int parent = getParIndex(index);
		while (parent > 0 && heap[parent] > heap[index]) {
			int temp = heap[parent];
			heap[parent] = heap[index];
			heap[index] = temp;
			index = parent;
			parent = getParIndex(parent);
		}
		size++;
		return size;

	}

	static int getParIndex(int chIndex) {

		return (chIndex - 1) / 2;
	}

	static int getLeftChIndex(int parIndex) {

		return (2 * parIndex) + 1;
	}

	static int getRightChIndex(int parIndex) {

		return (2 * parIndex) + 2;
	}

	public static void main(String[] args) {

		int[] heap = new int[20];

		int size = 12;

		heap[0] = 11;
		heap[1] = 17;
		heap[2] = 13;
		heap[3] = 18;
		heap[4] = 21;
		heap[5] = 19;
		heap[6] = 17;
		heap[7] = 43;
		heap[8] = 23;
		heap[9] = 26;
		heap[10] = 29;
		heap[11] = 31;

		System.out.println(getParIndex(2));

		System.out.println(getParIndex(8)); // 23 --> 18

		System.out.println(getParIndex(9)); //

		System.out.println(getParIndex(11));

		System.out.println(getLeftChIndex(5));

		size = insert(heap, 12, size);
		
		

	}

}
