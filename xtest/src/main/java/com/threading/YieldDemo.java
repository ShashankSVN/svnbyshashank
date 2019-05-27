package com.threading;

public class YieldDemo {

	// A hint to the scheduler that the current thread is willing to yield its
	// current use of a processor. The scheduler is free to ignore this hint.
	
	void produce() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Producer: " + i);
			Thread.yield();
		}

	}

	void consume() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Consumer: " + i);
		    Thread.yield();
		}

	}

	public static void main(String[] args) {

		YieldDemo demo = new YieldDemo();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				demo.produce();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				demo.consume();
			}
		});

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
