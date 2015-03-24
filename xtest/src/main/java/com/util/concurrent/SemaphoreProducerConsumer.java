package com.util.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreProducerConsumer {

	public static void main(String[] args) {

		// The counting semaphore is initialized with a given number of
		// "permits=N". For each call to acquire() a permit is taken by the
		// calling thread. For each call to release() a permit is returned to
		// the semaphore.

		// Semaphore uses:
		// 1. To guard a critical section against entry by more than N threads
		// at a time.
		// 2. To send signals between two threads.

		final Semaphore prod = new Semaphore(1);
		//Below has zero permit but if other thread call release to this thread this count increases to 1
		final Semaphore cons = new Semaphore(0);

		final Integer[] integers = new Integer[1];

		Thread t1 = new Thread() {
			@Override
			public void run() {

				for (int i = 0; i <= 10; i++)
					try {
						// Acquires a permit, if one is available and returns
						// immediately, reducing the number of available permits
						// by one.
						prod.acquire();
						integers[0] = i;
						System.out.println(i + " entered");
						cons.release();

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i <= 10; i++)
					try {
						Thread.sleep(0);
						cons.acquire();
						System.out.println(integers[0] + " removed");
						prod.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		};

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
