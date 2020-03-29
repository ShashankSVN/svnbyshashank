package com.util.lock;

class PC {

	static int i = 0;

	// implicit monitor lock
	synchronized void produce() throws InterruptedException {

		while (i == 1) {
			wait();
		}
		System.out.println("before production value of i = " + i);
		i++;
		notifyAll();
	}

	// implicit monitor lock
	synchronized void consume() throws InterruptedException {

		while (i == 0) {
			wait();
		}

		System.out.println("before consumption value of i = " + i);
		i--;
		notifyAll();

	}
}

public class LockTest {

	public static void main(String[] args) throws InterruptedException {

		PC pc = new PC();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					while (true) {
						pc.produce();
						Thread.sleep(1000);
					}

				} catch (InterruptedException e) {
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						pc.consume();
						Thread.sleep(1000);
					}

				} catch (InterruptedException e) {
				}
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

}
