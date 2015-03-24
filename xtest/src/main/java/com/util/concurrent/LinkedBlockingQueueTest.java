package com.util.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer2 implements Runnable {
	BlockingQueue<String> blockingQueue;

	public Producer2(BlockingQueue<String> blockingQueue) {
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
	//			Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class Consumer2 implements Runnable {
	BlockingQueue<String> blockingQueue;

	public Consumer2(BlockingQueue<String> blockingQueue) {
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

public class LinkedBlockingQueueTest {

	public static void main(String[] args) {

		// The LinkedBlockingQueue keeps the elements internally in a linked
		// structure (linked nodes). This linked structure can optionally have
		// an upper bound if desired. If no upper bound is specified,
		// Integer.MAX_VALUE is used as the upper bound.

		// The LinkedBlockingQueue stores the elements internally in FIFO (First
		// In, First Out) order. The head of the queue is the element which has
		// been in queue the longest time, and the tail of the queue is the
		// element which has been in the queue the shortest time.

		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>();
		Thread t1 = new Thread(new Producer2(blockingQueue));
		Thread t2 = new Thread(new Consumer2(blockingQueue));
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
