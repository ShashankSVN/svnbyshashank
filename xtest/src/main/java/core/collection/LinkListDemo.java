package core.collection;

import java.util.Iterator;



interface MyList<E> {
	int size();

	boolean isEmpty();

	boolean contains(Object o);

	boolean add(E e);

	boolean remove(Object o);

	E get(int index);

	E set(int index, E element);

	boolean equals(Object o);

	int hashCode();

	void add(int index, E element);

	E remove(int index);

	int indexOf(Object o);

	int lastIndexOf(Object o);

}

class Node<E> {
	E element;
	Node<E> next;
	Node<E> previous;

	Node(E element, Node<E> next, Node<E> previous) {
		this.element = element;
		this.next = next;
		this.previous = previous;
	}
}

class MyIterator<T> implements Iterator<T> {

	public boolean hasNext() {

		return false;
	}

	public T next() {
		return null;
	}

	public void remove() {
	}
}

class MyLinkedList<E> implements MyList<E>, Iterable<E> {
	private  Node<E> header = new Node<E>(null, null, null);
	private  int size = 0;

	public MyLinkedList() {
		header.next = header.previous = header;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyIterator<E>();
	}

	@Override
	public boolean add(E e) {
		Node<E> newNode = new Node<E>(e, header , header.previous);
		newNode.previous.next = newNode;
		newNode.next.previous = newNode;
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public E get(int index) {
		return null;
	}

	@Override
	public E set(int index, E element) {
		return null;
	}

	@Override
	public void add(int index, E element) {

	}

	@Override
	public E remove(int index) {
		return null;
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}
}

public class LinkListDemo {

	public static void main(String[] args) {

		MyList<Integer> list = new MyLinkedList<Integer>();

		list.add(2);
		
		
	}

}
