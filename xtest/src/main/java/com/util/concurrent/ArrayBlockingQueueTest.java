package com.util.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
	BlockingQueue<String> blockingQueue;

	public Producer(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 9; i++) {

				blockingQueue.put(String.valueOf(i));
				System.out.println("Thread Name: "
						+ Thread.currentThread().getName()
						+ " Element inserted: " + String.valueOf(i));
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class Consumer implements Runnable {
	BlockingQueue<String> blockingQueue;

	public Consumer(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 9; i++) {

				System.out.println("Thread Name: "
						+ Thread.currentThread().getName() + " Element taken: "
						+ blockingQueue.take());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

public class ArrayBlockingQueueTest {

	public static void main(String[] args) {

		// ArrayBlockingQueue is a bounded, blocking queue that stores the
		// elements internally in an array. That it is bounded means that it
		// cannot store unlimited amounts of elements. There is an upper bound
		// on the number of elements it can store at the same time. You set the
		// upper bound at instantiation time, and after that it cannot be
		// changed.

		// The ArrayBlockingQueue stores the elements internally in FIFO (First
		// In, First Out) order. The head of the queue is the element which has
		// been in queue the longest time, and the tail of the queue is the
		// element which has been in the queue the shortest time.

		// By default fairness is false
		BlockingQueue<String> blockingQueue1 = new ArrayBlockingQueue<String>(3);

		// fair if true then queue accesses for threads blocked on insertion or
		// removal, are processed in FIFO order; if false the access order is
		// unspecified
		Boolean fair = Boolean.TRUE;
		BlockingQueue<String> blockingQueue2 = new ArrayBlockingQueue<String>(
				3, fair);
		Thread t1 = new Thread(new Producer(blockingQueue1));
		Thread t2 = new Thread(new Consumer(blockingQueue1));
		Thread t3 = new Thread(new Producer(blockingQueue1));
		Thread t4 = new Thread(new Consumer(blockingQueue1));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Output of this program may look like below one:
	// Thread Name: Thread-3 Element taken: 5
	// Thread Name: Thread-2 Element inserted: 5
	// Thread Name: Thread-0 Element inserted: 5
	// Thread Name: Thread-1 Element taken: 5
	// its just because System.out.println() in not synchronized may print
	// in unexpected order but internally its work fine

}
