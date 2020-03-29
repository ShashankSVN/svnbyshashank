package core.ds.practice;

class MyArrayList implements MyList {

	private int[] array;
	private int size;
	private int capacity;

	public MyArrayList() {
		this.capacity = 10;
		this.array = new int[capacity];
	}

	public MyArrayList(int capacity) {
		this.capacity = capacity;
		this.array = new int[capacity];
	}

	@Override
	public void addFirst(int data) {
		add(0, data);
	}

	@Override
	public void addLast(int data) {
		if (size < array.length) {
			array[size++] = data;
		} else {
			System.out.println("array is full");
		}
	}

	@Override
	public void add(int data) {
		add(0, data);
	}

	@Override
	public void add(int index, int data) {
		if (size < array.length) {
			int i = size - 1;
			while (i >= index) {
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = data;
			size++;
		} else {
			System.out.println("array is full");
		}

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void print() {
		for (int i = 0; i < size; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

}

public class InsertionArrayList {

	public static void main(String[] args) {

		MyList list = new MyArrayList();
		list.addLast(890);
		list.print();
		list.add(34);
		list.print();
		list.addFirst(45);
		list.print();
		list.add(78);
		list.print();
		list.addLast(456);
		list.print();
		list.addLast(2134);
		list.print();
		list.add(67);
		System.out.println("size " + list.size());
		list.print();
		list.add(4, 999);
		list.print();
		list.add(8, 566);
		list.print();
		list.add(12, 679);
		list.print();
		System.out.println("size " + list.size());

	}

}
