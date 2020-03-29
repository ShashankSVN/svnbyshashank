package corefinal.ds.linklist;

class Node {
	int data;
	Node next;

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

class ListDemo {
	private int size;

	private Node header;

	public ListDemo() {
		this.header = null;
	}

	void insert(int data) {
		// constant time
		Node temp = new Node(data, header);
		size++;
		header = temp;
	}

	void delete() {
		Node temp = header;
		header = temp.next;
		temp = null;
		size--;
	}

	void delete(int n) {
		if (n == 1) {
			header = header.next;
			size--;
		}
		Node temp = header;
		for (int i = 0; i < n - 2; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
		size--;
	}

	void insert(int data, int n) {
		if (n == 1) {
			Node temp = new Node(data, header);
			size++;
			header = temp;
			return;
		}
		Node temp1 = header;
		for (int i = 0; i < n - 2; i++) {
			temp1 = temp1.next;
		}
		Node temp2 = new Node(data, temp1.next);
		temp1.next = temp2;
		size++;

	}

	void reverse() {
		Node prev = null;
		Node current = header;
		while (current != null) {
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		header = prev;
	}

	void reverseByRecusion() {
		reverseByRecusion(header);
	}

	private void reverseByRecusion(Node p) {
		if (p.next == null) {
			header = p;
			return;
		}
		reverseByRecusion(p.next);
		Node q = p.next;
		q.next = p;
		p.next=null;

	}

	void print() {
		System.out.println("Print list by iteration");
		Node temp = header;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	void printRecusion() {
		System.out.println("Print list by recursion");
		printByRecusion(header);
		System.out.println();
	}

	private void printByRecusion(Node header) {
		if (header == null)
			return;
		System.out.print(header.data + " ");
		printByRecusion(header.next);
	}

	void reversePrintRecusion() {
		System.out.println("Print reverse list by recursion");
		reversePrintByRecusion(header);
		System.out.println();
	}

	private void reversePrintByRecusion(Node header) {
		if (header == null)
			return;
		reversePrintByRecusion(header.next);
		System.out.print(header.data + " ");
	}

}

public class ReverseLinklist {

	public static void main(String[] args) {
		ListDemo list = new ListDemo();
		list.insert(13);
		list.insert(15);
		list.insert(17);
		list.insert(18);
		list.print();
		list.insert(34, 3);
		list.print();
		list.insert(67, 1);
		list.print();
		list.reverse();
		System.out.println("after reverse");
		list.print();
		list.delete();
		list.delete();
		list.print();
		list.delete(3);
		list.delete(2);
		list.print();
		list.insert(12);
		list.insert(98);
		list.printRecusion();
		list.reversePrintRecusion();
		list.reverseByRecusion();
		list.print();
		

	}

}
