package core.ds.practice;

import java.util.LinkedList;

class Node {
	int data;
	Node next;

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

interface MyList {
	void addFirst(int data);

	void addLast(int data);

	void add(int data);

	void add(int index, int data);
	
	int size();

	void print();
}

class MyLinkedList implements MyList

{
	private Node header;
	private int size;

	public MyLinkedList() {
		this.header = null;
	}

	@Override
	public void addFirst(int data) {

		Node temp = new Node(data, header);
		header = temp;
		size++;
	}

	@Override
	public void addLast(int data) {
		
		Node temp = header;
		if (temp == null) {
			addFirst(data);
			size++;
			return;
		}
		while (temp.next != null) {
			temp = temp.next;
		}
		System.out.println();
		
		temp.next=new Node(data,null);
		size++;

	}

	@Override
	public void add(int data) {
		addFirst(data);

	}

	@Override
	public void add(int index, int data) {

		if(index==1)
		{
			addFirst(data);
			return;
		}
		if(index>size+1)
		{
			System.out.println("size is less please enter valid one");
			return;
		}
		Node temp1 = header;
		int i=1;
		while (i++< index-1) {
			temp1 = temp1.next;
		}
		Node temp2=temp1.next;
		temp1.next=new Node(data,temp2);
		size++;
		
	}

	@Override
	public void print() {

		Node temp = header;
		if (temp == null) {
			System.out.println("empty list");
			return;
		}
		while (temp != null) {
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
		System.out.println();

	}

	@Override
	public int size() {
		
		return size;
	}

}

public class InsertionLinkedList {

	public static void main(String[] args) {

		MyList list = new MyLinkedList();
		list.addLast(890);
		list.add(34);
		list.addFirst(45);
		list.add(78);
		list.addLast(456);
		list.addLast(2134);
		list.add(67);
		
		System.out.println("size" + list.size());
		list.print();
		 
		list.add(4,999);
		list.add(8,566);
		list.print();
		list.add(12,679);
		
		
		
		System.out.println("size" + list.size());
		list.print();
	}

}
